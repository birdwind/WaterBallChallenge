package birdwind.waterball.world.module.sprite;


import birdwind.waterball.world.module.Coordinate;

public class Sprite {
    private String symbol;

    public Sprite() {
        this("");
    }

    public Sprite(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void removeSelf(Coordinate coordinate){
        coordinate.setSprite(new Sprite());
    }
}
