package ru.gb_shisheya.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.gb_shisheya.stargame.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private Texture blImg;
    private Vector2 v, realPos, finalPos;

    public MenuScreen(Game game) {
        super(game);

    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("back512-512.jpg");
        blImg = new Texture("badlogic.jpg");
        v = Vector2.Zero;
        realPos = Vector2.Zero;
        finalPos = Vector2.Zero;
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        realPos = finalPos;

        if (v != Vector2.Zero) {
            if (realPos.cpy().dst(finalPos) < v.cpy().scl(2f,2f).len()) {
                realPos = finalPos;
                v = Vector2.Zero;
            } else {
                realPos.add(v);
            }
        }

        batch.draw(img, 0, 0);
        batch.draw(blImg, realPos.x, realPos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        finalPos = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
        v = finalPos.cpy().sub(realPos).nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {
        int step = 5;
        switch (keycode) {
            case Input.Keys.UP:
                finalPos = new Vector2(realPos.x, realPos.y + step);
                break;
            case Input.Keys.RIGHT:
                finalPos = new Vector2(realPos.x + step, realPos.y);
                break;
            case Input.Keys.DOWN:
                finalPos = new Vector2(realPos.x, realPos.y - step);
                break;
            case Input.Keys.LEFT:
                finalPos = new Vector2(realPos.x - step, realPos.y);
                break;
            default:
                break;
        }
        if (finalPos != realPos)
            v = finalPos.cpy().sub(realPos).nor();

        return super.keyDown(keycode);
    }
}
