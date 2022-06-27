package birdwind.waterball.world.module.collisions;

import birdwind.waterball.world.module.Coordinate;
import birdwind.waterball.world.module.sprite.Fire;
import birdwind.waterball.world.module.sprite.Hero;
import birdwind.waterball.world.module.sprite.Sprite;

public class HeroFireSpriteCollision extends SpriteCollision<Hero, Fire> {
    public HeroFireSpriteCollision() {
        super();
    }

    public HeroFireSpriteCollision(SpriteCollision<? extends Sprite, ? extends Sprite> spriteCollision) {
        super(spriteCollision);
    }

    @Override
    protected Class<Hero> getSelfSpriteClass() {
        return Hero.class;
    }

    @Override
    protected Class<Fire> getTargetSpriteClass() {
        return Fire.class;
    }

    @Override
    protected void doCollision(Coordinate coordinate, Coordinate beCollidedCoordinate) {
        Hero hero = (Hero) coordinate.getSprite();
        Sprite fire = beCollidedCoordinate.getSprite();
        hero.subHp(10);
        if(hero.isDead()){
            System.out.println("Hero已被移除");
        }
        hero.removeIsDead(coordinate);
        fire.removeSelf(beCollidedCoordinate);
        System.out.printf("Hero hp: %d\n", hero.getHp());
        System.out.println("火已被移除");
    }
}
