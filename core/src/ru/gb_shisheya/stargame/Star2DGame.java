package ru.gb_shisheya.stargame;

import com.badlogic.gdx.Game;

import ru.gb_shisheya.stargame.screen.MenuScreen;


public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
