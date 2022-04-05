package com.mastersdeluniverso;

import java.awt.event.KeyEvent;

import acm.graphics.GImage;

public class Jugador extends Emoji {
    Jugador(String dir_img_normal, String dir_img_zombie, Vector2d pos) {
        super(dir_img_normal, dir_img_zombie, pos);
    }

    public void moures(Double deltaTime, KeyEvent e) {
        // Detectar tecles que s'han premut
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pos.x -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pos.x += 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pos.y -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pos.y += 10;
        }

        normal.setLocation(pos.x, pos.y);
    }
}
