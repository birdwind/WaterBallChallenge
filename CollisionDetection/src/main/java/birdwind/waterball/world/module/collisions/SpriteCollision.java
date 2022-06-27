package birdwind.waterball.world.module.collisions;

import birdwind.waterball.world.module.Coordinate;
import birdwind.waterball.world.module.sprite.Sprite;

public abstract class SpriteCollision<collideSprite extends Sprite, beCollidedSprite extends Sprite> {
    private SpriteCollision<? extends Sprite, ? extends Sprite> nextCollision;

    public SpriteCollision() {
    }

    public SpriteCollision(SpriteCollision<? extends Sprite, ? extends Sprite> spriteCollision) {
        setNextCollision(spriteCollision);
    }

    public void setNextCollision(SpriteCollision<? extends Sprite, ? extends Sprite> nextCollision) {
        this.nextCollision = nextCollision;
    }

    @SuppressWarnings("unchecked")
    public void collide(Coordinate coordinate, Coordinate beCollidedCoordinate) {
        Class<collideSprite> selfClass = getSelfSpriteClass();
        Class<beCollidedSprite> targetClass = getTargetSpriteClass();

        if (coordinate.getSprite().getClass().equals(beCollidedCoordinate.getSprite().getClass())) {
            System.out.println("[世界之聲] 移動失敗");
        } else if (selfClass.equals(coordinate.getSprite().getClass()) && targetClass.equals(beCollidedCoordinate.getSprite().getClass())) {
            doCollision(coordinate, beCollidedCoordinate);
            swapCoordinate(coordinate, beCollidedCoordinate);
        } else if (selfClass.equals(beCollidedCoordinate.getSprite().getClass()) && targetClass.equals(coordinate.getSprite().getClass())) {
            doCollision(beCollidedCoordinate, coordinate);
            swapCoordinate(beCollidedCoordinate, coordinate);
        } else {
            if (nextCollision != null) {
                nextCollision.collide(coordinate, beCollidedCoordinate);
            } else {
                swapCoordinate(beCollidedCoordinate, coordinate);
            }
        }
    }

    protected abstract Class<collideSprite> getSelfSpriteClass();

    protected abstract Class<beCollidedSprite> getTargetSpriteClass();

    protected abstract void doCollision(Coordinate coordinate, Coordinate beCollidedCoordinate);

    private void swapCoordinate(Coordinate coordinate, Coordinate beCollidedCoordinate) {
        Sprite sprite = beCollidedCoordinate.getSprite();
        beCollidedCoordinate.setSprite(coordinate.getSprite());
        coordinate.setSprite(sprite);
    }
}
