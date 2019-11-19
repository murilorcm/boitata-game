package br.com.boitata.screen.multiplayer

import br.com.boitata.BoitataGame
import br.com.boitata.screen.DefaultScreen
import br.com.boitata.screen.MainPage
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class Multiplayer(private val game: BoitataGame) : DefaultScreen(game) {
    override fun show() {
        super.show()

        game.stage.addActor(
                Table().apply {
                    width = Gdx.graphics.width.toFloat()
                    height = Gdx.graphics.height.toFloat()

                    val textButtonStyle = TextButton.TextButtonStyle().apply {
                        font = BitmapFont().apply {
                            data.setScale(2f)
                            region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
                        }
                    }

                    add(TextButton("Criar e Jogar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                game.screen = CreateServer(game)
                            }

                            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                                return true
                            }
                        })
                    })

                    row()

                    add(TextButton("Conectar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                game.screen = ConnectToServer(game)
                            }

                            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                                return true
                            }
                        })
                    })

                    row()

                    add(TextButton("Voltar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                game.screen = MainPage(game)
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
}