package com.mastersdeluniverso;

import java.awt.event.KeyEvent;

public class Jugador extends Emoji {
    // Atributs.
    // moviment
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    // Vector de moviment
    private Vector2d moviment = new Vector2d(0, 0);
    private final double velocitat = .5;

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

    /** 
     * Funció que mou el jugador
     */
    public void moures(double deltaTime) {
        if (up) {
            moviment.y = -velocitat;
        }
        if (down) {
            moviment.y = velocitat;
        } else if (!down && !up) {
            moviment.y = 0;
        }
        if (left) {
            moviment.x = -velocitat;
        }
        if (right) {
            moviment.x = velocitat;
        } else if (!right && !left) {
            moviment.x = 0;
        }

        pos = new Vector2d(pos.x + moviment.x * deltaTime, pos.y + moviment.y * deltaTime);
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x > Grafics.MIDA_PANTALLA.getWidth() - normal.getWidth() - 15) {
            pos.x = Grafics.MIDA_PANTALLA.getWidth() - normal.getWidth() - 15;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y > Grafics.MIDA_PANTALLA.getHeight() - normal.getHeight() - 60) {
            pos.y = Grafics.MIDA_PANTALLA.getHeight() - normal.getHeight() -60;
        }
        normal.setLocation(pos.x, pos.y);
        System.out.println("Posició: " + pos.x + " " + pos.y);

    }
}