package birdwind.waterball;

import birdwind.waterball.world.World;
import birdwind.waterball.world.module.collisions.HeroFireSpriteCollision;
import birdwind.waterball.world.module.collisions.HeroWaterSpriteCollision;
import birdwind.waterball.world.module.collisions.SpriteCollision;
import birdwind.waterball.world.module.collisions.WaterFireSpriteCollision;
import birdwind.waterball.world.module.sprite.Sprite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpriteCollision<? extends Sprite, ? extends Sprite> collision = new HeroFireSpriteCollision(new HeroWaterSpriteCollision(new WaterFireSpriteCollision()));
        boolean isContinue = true;
        World world = new World();
        world.setCollision(collision);
        world.initWorld();
        System.out.println("世界已經初始化");
        while (isContinue) {
            System.out.println("[世界之聲]將a座標物移動到b座標");
            System.out.print("[世界之聲]請輸入a:");
            int a = scanner.nextInt();
            System.out.print("[世界之聲]請輸入b:");
            int b = scanner.nextInt();
            world.moveSprite(a, b);
            System.out.println();

            System.out.print("[世界之聲]還要繼續移動嗎?(Y)");
            isContinue = scanner.next().equalsIgnoreCase("Y");
            System.out.println();
        }
    }
}