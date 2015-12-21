package com.example.java;

import java.awt.*;

/**
 * Created by Gary on 12/19/2015.
 */
public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        velX = 5;
        velY = 5;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        } else if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}
