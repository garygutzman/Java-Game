package com.example.java;

import java.awt.*;

/**
 * Created by Gary on 12/19/2015.
 */
public class SwervingEnemy extends GameObject {

    public SwervingEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        velX = 2;
        velY = 2;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 13, 13);
    }

    public void tick() {
        x += velX / 2;
        y += velY * 2;

        if(y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        } else if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, 13, 13);
    }
}
