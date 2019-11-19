package br.com.boitata;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//public class BoitataGame extends ApplicationAdapter {
//	SpriteBatch batch;
//	Texture img;
//
//	@Override
//	public void create () {
//		setBatch(new SpriteBatch());
//		setImg(new Texture("badlogic.jpg"));
//	}
//
//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		getBatch().begin();
//		getBatch().draw(getImg(), 0, 0);
//		getBatch().end();
//	}
//
//	@Override
//	public void dispose () {
//		getBatch().dispose();
//		getImg().dispose();
//	}
//}
//