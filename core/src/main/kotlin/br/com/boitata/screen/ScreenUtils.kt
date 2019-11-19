package br.com.boitata.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite

object ScreenUtils {
    val dimensionTerrain = (if (Gdx.graphics.height < Gdx.graphics.width) Gdx.graphics.height else Gdx.graphics.width).toFloat()
    val terrain = Texture("terrain.png")

}