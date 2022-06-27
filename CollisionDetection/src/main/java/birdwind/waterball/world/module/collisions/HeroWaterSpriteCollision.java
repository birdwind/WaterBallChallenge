package birdwind.waterball.world.module.collisions;

import birdwind.waterball.world.module.Coordinate;
import birdwind.waterball.world.module.sprite.Hero;
import birdwind.waterball.world.module.sprite.Sprite;
import birdwind.waterball.world.module.sprite.Water;

public class HeroWaterSpriteCollision extends SpriteCollision<Hero, Water> {
    public HeroWaterSpriteCollision() {
        super();
    }

    public HeroWaterSpriteCollision(SpriteCollision<? extends Sprite, ? extends Sprite> spriteCollision) {
        super(spriteCollision);
    }

    @Override
    protected Class<Hero> getSelfSpriteClass() {
        return Hero.class;
    }

    @Override
    protected Class<Water> getTargetSpriteClass() {
        return Water.class;
    }

    @Override
    protected void doCollision(Coordinate coordinate, Coordinate beCollidedCoordinate) {
        Hero hero = (Hero) coordinate.getSprite();
        Sprite water = beCollidedCoordinate.getSprite();
        hero.addHp(10);
        water.removeSelf(beCollidedCoordinate);
        System.out.printf("Hero hp: %d\n", hero.getHp());
        System.out.println("水已被移除");
    }
}
