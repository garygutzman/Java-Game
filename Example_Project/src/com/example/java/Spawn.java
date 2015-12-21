package com.example.java;

import java.util.Random;

/**
 * Created by Gary on 12/19/2015.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;
    private int fastEnemyTimer = 0;
    private int smartEnemyTimer = 0;
    private int basicEnemyTimer = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    // adding increased difficulty over time
    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            basicEnemyTimer++;
            fastEnemyTimer++;
            smartEnemyTimer++;

        }

        if (basicEnemyTimer >= 3) {
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            basicEnemyTimer = 0;
        }

        if (fastEnemyTimer >= 5) {
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            fastEnemyTimer = 0;
        }

        if (smartEnemyTimer >= 10) {
            handler.addObject(new SwervingEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            smartEnemyTimer = 0;
        }
    }
}
