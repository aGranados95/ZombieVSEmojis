package com.mastersdeluniverso;

import java.awt.event.KeyEvent;

import acm.graphics.GImage;

public class Jugador extends Emoji {
    // Atributs.
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    Jugador(String dir_img_normal, String dir_img_zombie, Vector2d pos) {
        super(dir_img_normal, dir_img_zombie, pos);
    }

    /**
     * 
     * @param esMou
     * @param e
     */
    public void detectarMoviment(boolean esMou, KeyEvent e) {
        if (esMou) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                down = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = true;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                down = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = false;
            }
        }
    }
}
