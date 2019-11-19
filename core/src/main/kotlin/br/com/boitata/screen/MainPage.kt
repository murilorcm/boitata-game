package br.com.boitata.screen

import br.com.boitata.BoitataGame
import br.com.boitata.screen.multiplayer.Multiplayer
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import kotlin.system.exitProcess

class MainPage(private val game: BoitataGame) : DefaultScreen(game) {
    override fun show() {
        super.show()

        Gdx.input.inputProcessor = game.stage

        val title = Label("A Vida do Boitatá", Label.LabelStyle().apply {
            font = BitmapFont().apply {
                fontColor = Color.WHITE
                data.setScale(2f)
                region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            }
        }).apply {
            val colWidth = (Gdx.graphics.height / 12).toFloat()
            setPosition(colWidth * 7, Gdx.graphics.height - colWidth * 3)
        }

        game.stage.apply {
            addActor(mainPage())
            addActor(title)
        }
    }

    private fun mainPage(): Table {
        val textButtonStyle = TextButtonStyle().apply {
            font = BitmapFont().apply {
                data.setScale(2f)
                region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            }
        }
        val btPlay = TextButton("Jogar", textButtonStyle).apply {
            addListener(object : InputListener() {
                override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                    exitProcess(0)
                }

                override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    return true
                }
            })
        }
        val btMultiplayer = TextButton("Multijogador", textButtonStyle).apply {
            addListener(object : InputListener() {
                override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                    game.screen = Multiplayer(game)
                }

                override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    return true
                }
            })
        }
        val btGetOut = TextButton("Sair", textButtonStyle).apply {
            addListener(object : InputListener() {
                override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                    exitProcess(0)
                }

                override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    return true
                }
            })
        }

        return Table().apply {
            width = Gdx.graphics.width.toFloat()
            height = Gdx.graphics.height.toFloat()
            add(btPlay)
            row()
            add(btMultiplayer)
            row()
            add(btGetOut)
        }.center()
    }
}