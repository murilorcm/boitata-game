package br.com.boitata.screen.multiplayer

import br.com.boitata.BoitataGame
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField

class ConnectToServer(private val game: BoitataGame) : DefaultScreen(game) {

    companion object {

        private val font = BitmapFont().apply {
            data.setScale(2f)
            region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            color = Color.WHITE
        }

        private val textFieldStyle = TextField.TextFieldStyle().apply {
            this.font = ConnectToServer.font
            this.fontColor = Color.WHITE
        }

        private val labelStyle = Label.LabelStyle().apply {
            this.font = ConnectToServer.font
        }

        private val textButtonStyle = TextButton.TextButtonStyle().apply {
            this.font = ConnectToServer.font
        }

        private val txtFieldIpAddress = TextField("", textFieldStyle).apply {
            maxLength = 15
        }

        private val txtFieldPort = TextField("", textFieldStyle).apply {
            maxLength = 4
        }
    }

    override fun show() {
        super.show()

        game.stage.addActor(
                Table().apply {
                    width = Gdx.graphics.width.toFloat()
                    height = Gdx.graphics.height.toFloat()

                    add(
                            Table().apply {
                                add(Label("IP: ", labelStyle))
                                add(txtFieldIpAddress).width(240f)
                            }.center()
                    ).colspan(2)

                    row()
                    add(
                            Table().apply {
                                add(Label("Porta: ", labelStyle))
                                add(txtFieldPort).width(240f)
                            }.center()
                    ).colspan(2)

                    row()

                    add(TextButton("Cancelar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                                game.screen = Multiplayer(game)
                            }

                            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                                return true
                            }
                        })
                    })

                    add(TextButton("Conectar", textButtonStyle).apply {
                        addListener(object : InputListener() {
                            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
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