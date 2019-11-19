package br.com.boitata.screen.multiplayer

import br.com.boitata.BoitataGame
import br.com.boitata.connection.ServerMatch
import br.com.boitata.screen.DefaultScreen
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.sun.security.ntlm.Server

class CreateServer(private val game: BoitataGame) : DefaultScreen(game) {

    init {
        ServerMatch.start()
    }

    companion object {
        private val font = BitmapFont().apply {
            data.setScale(2f)
            region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            color = Color.WHITE
        }

        private val labelStyle = Label.LabelStyle().apply {
            this.font = CreateServer.font
        }

        private val textButtonStyle = TextButton.TextButtonStyle().apply {
            this.font = CreateServer.font
        }
    }

    private val lbServerSocket = Label("Servidor: ${ServerMatch.serverConfig}", labelStyle)
    private val lbPlayersConnected = Label("Jogadores Conectados: 0", labelStyle)

    override fun show() {
        super.show()

        game.stage.addActor(
                Table().apply {
                    width = Gdx.graphics.width.toFloat()
                    height = Gdx.graphics.height.toFloat()

                    add(lbPlayersConnected).colspan(2)

                    row ()

                    add(lbServerSocket).colspan(2)

                    row()

                    add(TextButton("Cancelar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                ServerMatch.interrupt()
                                game.screen = Multiplayer(game)
                            }

                            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                                return true
                            }
                        })
                    })

                    add(TextButton("Iniciar Jogo", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                ServerMatch.interrupt()
                                game.screen = Multiplayer(game)
                            }

                            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                                return true
                            }
                        })
                    })

                    center()
                }
        )
    }

    override fun render(delta: Float) {
        super.render(delta)

        lbServerSocket.setText("Servidor: ${ServerMatch.serverConfig}")

        lbPlayersConnected.setText("Jogadores Conectados: ${ServerMatch.clients.size}")
    }
}