package br.com.boitata.connection

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Net
import com.badlogic.gdx.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import kotlin.math.roundToInt
import kotlin.math.sqrt


object ServerMatch : Thread() {
    val clients = mutableListOf<Socket>()
    const val serverConfig = "127.0.0.1:7777"
    private val serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, serverConfig.split(":").last().toInt(), null)

    override fun run() {
        println("Waiting for Clients on $serverConfig...")
        while (true) {
            val client = serverSocket.accept(null)
            clients.add(client)

            println("CLIENT RECEIVED: ${client.remoteAddress}")
        }
    }

    override fun interrupt() {
        sendPeersIp()
        super.interrupt()
    }

    private fun sendPeersIp() {
        val matrizSize = sqrt(clients.size.toFloat()).roundToInt()

        clients.forEachIndexed { i, socket ->
            val mapArrounds = mapArroundPeers(i, matrizSize, clients)

            val printWriter = PrintWriter(socket.outputStream)
            printWriter.write(mapArrounds.toString())
            printWriter.flush()
            printWriter.close()
        }
    }

    private fun mapArroundPeers(i: Int, matrizSize: Int, clients: MutableList<Socket>): Map<String, String> {
        val arroundsPeers = mutableMapOf<String, String>()

        when (clients.size) {
            1 -> {
                arroundsPeers["LEFT"] = clients[i - 1].remoteAddress
            }

            2 -> {
                arroundsPeers["RIGHT"] = clients[i + 1].remoteAddress
            }

            3 -> {
                arroundsPeers["UP"] = clients[i - matrizSize].remoteAddress
            }

            4 -> {
                arroundsPeers["BOTTOM"] = clients[i + matrizSize].remoteAddress
            }
        }

        return arroundsPeers
    }
}

fun main() {
    val socket = java.net.Socket("localhost", 7777)
    val bufferedReader = BufferedReader(InputStreamReader(socket.getInputStream()))
    println(bufferedReader.readLine())
    bufferedReader.close()
    socket.close()
}