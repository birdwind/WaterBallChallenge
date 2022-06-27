package birdwind.waterball.world.module.collisions;

import birdwind.waterball.world.module.Coordinate;
import birdwind.waterball.world.module.sprite.Fire;
import birdwind.waterball.world.module.sprite.Sprite;
import birdwind.waterball.world.module.sprite.Water;

public class WaterFireSpriteCollision extends SpriteCollision<Fire, Water> {
    public WaterFireSpriteCollision() {
        super();
    }

    public WaterFireSpriteCollision(SpriteCollision<? extends Sprite, ? extends Sprite> spriteCollision) {
        super(spriteCollision);
    }

    @Override
    protected Class<Fire> getSelfSpriteClass() {
        return Fire.class;
    }

    @Override
    protected Class<Water> getTargetSpriteClass() {
        return Water.class;
    }

    @Override
    protected void doCollision(Coordinate coordinate, Coordinate beCollidedCoordinate) {
        Sprite fire = coordinate.getSprite();
        Sprite water = beCollidedCoordinate.getSprite();
        fire.removeSelf(coordinate);
        water.removeSelf(beCollidedCoordinate);
        System.out.println("水火皆被移除");
    }
}
