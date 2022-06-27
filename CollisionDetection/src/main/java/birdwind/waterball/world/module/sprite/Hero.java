package birdwind.waterball.world.module.sprite;

import birdwind.waterball.world.module.Coordinate;

import static java.lang.Math.abs;

public class Hero extends Sprite {

    private int hp = 30;

    public Hero() {
        super("H");
    }

    public void addHp(int hp) {
        this.hp += abs(hp);
    }

    public void subHp(int hp) {
        this.hp -= abs(hp);
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public int getHp() {
        return hp;
    }

    public void removeIsDead(Coordinate coordinate) {
        if (isDead()) {
            removeSelf(coordinate);
        }
    }
}
