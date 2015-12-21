package com.example.java;

import java.awt.*;

/**
 * Created by Gary on 12/19/2015.
 */

public class FastEnemy extends GameObject {

        public FastEnemy(int x, int y, ID id, Handler handler) {
            super(x, y, id);

            velX = 8;
            velY = 8;

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
            g.setColor(Color.yellow);
            g.fillRect(x, y, 12, 12);
        }


}
