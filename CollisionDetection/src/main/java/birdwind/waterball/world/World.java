package birdwind.waterball.world;


import birdwind.waterball.world.module.Coordinate;
import birdwind.waterball.world.module.collisions.SpriteCollision;
import birdwind.waterball.world.module.sprite.Fire;
import birdwind.waterball.world.module.sprite.Hero;
import birdwind.waterball.world.module.sprite.Sprite;
import birdwind.waterball.world.module.sprite.Water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Objects.checkIndex;

public class World {

    public final static int NUMBER_OF_SPRITES = 30;
    public final static int MAX_OF_ORIGINAL_SPRITES = 10;

    private List<Coordinate> coordinateList;
    private SpriteCollision<? extends Sprite, ? extends Sprite> collision;

    public void initWorld() {
        generateCoordinate(generateSprite());
    }

    private void generateCoordinate(List<Sprite> spriteList) {
        coordinateList = new ArrayList<>();
        for (int i = 0; i < spriteList.size(); i++) {
            coordinateList.add(new Coordinate(spriteList.get(i), i));
        }

        coordinateList.forEach(System.out::println);
    }

    private List<Sprite> generateSprite() {
        List<Sprite> spriteList = new ArrayList<>();
        spriteList.addAll(randomSprite(MAX_OF_ORIGINAL_SPRITES - spriteList.size(), new Water()));
        spriteList.addAll(randomSprite(MAX_OF_ORIGINAL_SPRITES - spriteList.size(), new Hero()));
        spriteList.addAll(randomSprite(MAX_OF_ORIGINAL_SPRITES - spriteList.size(), new Fire()));
        int count = NUMBER_OF_SPRITES - spriteList.size();
        for (int i = 0; i < count; i++) {
            spriteList.add(new Sprite());
        }
        Collections.shuffle(spriteList);
        return spriteList;
    }

    private List<Sprite> randomSprite(int max, Sprite sprite) {
        List<Sprite> spriteList = new ArrayList<>();
        int count = new Random().nextInt(max + 1);
        System.out.println(sprite.getClass() + ": " + count);
        for (int i = 0; i < count; i++) {
            spriteList.add(sprite);
        }
        return spriteList;
    }

    public void moveSprite(int x1, int x2) {
        checkIndex(x1, NUMBER_OF_SPRITES);
        checkIndex(x2, NUMBER_OF_SPRITES);
        Coordinate selfCoordinate = coordinateList.get(x1);
        Coordinate targetCoordinate = coordinateList.get(x2);
        collision.collide(selfCoordinate, targetCoordinate);

        coordinateList.forEach(System.out::println);
    }

    public void setCollision(SpriteCollision<? extends Sprite, ? extends Sprite> collision) {
        this.collision = collision;
    }
}
