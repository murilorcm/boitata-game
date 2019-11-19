package br.com.boitata

import br.com.boitata.screen.MainPage
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Gdx.gl
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport

class BoitataGame : Game() {
    internal lateinit var stage: Stage

    override fun resize(width: Int, height: Int) {
        stage.viewport = ScreenViewport(OrthographicCamera(width.toFloat(), height.toFloat()))
        (stage.camera as OrthographicCamera).setToOrtho(false, width.toFloat(), height.toFloat())

        stage.viewport.update(width, height)
    }

    override fun create() {
        stage = Stage(ScreenViewport(), SpriteBatch())
        Gdx.input.inputProcessor = stage
        setScreen(MainPage(this))
    }

    override fun dispose() {
        clearScreen()
        screen.dispose()
        stage.dispose()
    }

    private fun clearScreen() {
        gl.glClearColor(0f, 0f, 0f, 1f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }
}