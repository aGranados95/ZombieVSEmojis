package com.mastersdeluniverso;

import java.awt.event.KeyEvent;

import acm.graphics.GImage;

public class Jugador extends Emoji {
    // Atributs.
    // moviment
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    // Vector de moviment
    private Vector2d moviment = new Vector2d(0, 0);
    private final int velocitat = 4;

    Jugador(String dir_img_normal, String dir_img_zombie, Vector2d pos) {
        super(dir_img_normal, dir_img_zombie, pos);
        normal.setSize(50, 50);
    }

    /**
     * Funció que actualitza la posició del jugador.
     * 
     * @param esPremTecla si es true, el jugador es mou.
     *
     * @param e
     */
    public void detectarMoviment(boolean esPremTecla, KeyEvent e) {
        if (esPremTecla) {
            if (e.getKeyChar() == 'w') {
                up = true;
            }
            if (e.getKeyChar() == 's') {
                down = true;
            }
            if (e.getKeyChar() == 'a') {
                left = true;
            }
            if (e.getKeyChar() == 'd') {
                right = true;
            }
        } else {
            if (e.getKeyChar() == 'w') {
                up = false;
            }
            if (e.getKeyChar() == 's') {
                down = false;
            }
            if (e.getKeyChar() == 'a') {
                left = false;
            }
            if (e.getKeyChar() == 'd') {
                right = false;
            }
        }
    }

    public void moures(double deltaTime) {
        if (up) {
            moviment.y = -100;
        } else {
        }
        if (down) {
            moviment.y = 100;
        } else {
        }
        if (left) {
            moviment.x = -100;
        } else {
        }
        if (right) {
            moviment.x = 100;
        } else {
        }

        pos = new Vector2d(pos.x + moviment.x, pos.y + moviment.y);
        if (pos.x < 0) {
            pos.x = 0;
        }
        if (pos.y < 0) {
            pos.y = 0;
        }
        normal.setLocation(pos.x + moviment.x, pos.y + moviment.y);

    }
}