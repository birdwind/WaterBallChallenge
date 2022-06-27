package birdwind.waterball.world.module;

import birdwind.waterball.world.module.sprite.Sprite;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private Sprite sprite;
    private int x;

    public Coordinate(Sprite sprite, int x) {
        this.sprite = sprite;
        this.x = x;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Coordinate: (Sprite:" + sprite.getClass() + ", x:" + x + ")";
    }

    public void removeSprite(){
        sprite = new Sprite();
    }
}
