package br.com.boitata.screen

import br.com.boitata.BoitataGame
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen

abstract class DefaultScreen(private val game: BoitataGame) : Screen {

    override fun show() {
        game.stage.clear()
    }

    override fun hide() {
        game.stage.clear()
    }

    override fun render(delta: Float) {
        game.stage.act(delta)
        game.stage.batch.begin()
        game.stage.batch.draw(ScreenUtils.terrain, (Gdx.graphics.width / 2) - (ScreenUtils.dimensionTerrain / 2), 0f, ScreenUtils.dimensionTerrain, ScreenUtils.dimensionTerrain)
        game.stage.batch.end()
        game.stage.draw()
    }

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {
        game.resize(width, height)
    }

    override fun dispose() {
        game.dispose()
    }
}