package com.mastersdeluniverso;

import acm.graphics.GImage;
import java.lang.Math;
import java.util.Random;

/**
 * Classe emoji que actua com personatge no jugador del joc.
 * Es deplaça aleatòriament per la pantalla.
 * L'emoji pot ser normal o zombie. En cas de ser zombie,
 * contagiarà a la resta d'emojis que hi hagi a la pantalla
 * en el cas de que entri en contacte. Un emoji contagiat
 * actualitza el seu estat a zombie i actua com a tal.
 */
public class Emoji {
    // Atributs

    /**
     * Velocitat de moviment l'emoji. Pot variar
     * durant el joc.
     */
    private double velocitat = 0.25;

    /**
     * Imatges de l'emoji.
     */
    protected GImage normal;
    protected GImage zombificado;

    /** Directori de les imatges */
    protected String dir_img_normal;
    protected String dir_img_zombie;

    /**
     * Indica si l'emoji està zombificat o no.
     */
    private boolean esZombie;

    /**
     * Variables de direccio del moviment.
     */
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;

    /**
     * Posició de l'emoji.
     */
    protected Vector2d pos;

    // Constructores
    /**
     * Constructor amb paràmetres.
     * 
     * @param dir_img_normal directori de la imatge del emoji
     *                       normal.
     * @param dir_img_zombie directori de la imatge del emoji
     *                       zombificat.
     * @param v              posició del emoji.
     */
    Emoji(String dir_img_normal, String dir_img_zombie, Vector2d pos) {

        this.dir_img_normal = dir_img_normal;
        this.dir_img_zombie = dir_img_zombie;
        normal = new GImage(dir_img_normal);
        zombificado = new GImage(dir_img_zombie);
        esZombie = false; // Per defecte l'emoji no està zombificat.
        this.pos = new Vector2d(pos);
        normal.setLocation(pos.x, pos.y);
    }

    // Mètodes
    /**
     * Realitza el moviment de l'emoji.
     * 
     * @param deltaTime
     */
    public void moures(Double deltaTime) {
        if (up) {
            pos.y -= velocitat * deltaTime;
        }
        if (down) {
            pos.y += velocitat * deltaTime;
        }
        if (left) {
            pos.x -= velocitat * deltaTime;
        }
        if (right) {
            pos.x += velocitat * deltaTime;
        }

        detectarLimitPantalla();

        if (esZombie)
            zombificado.setLocation(pos.x, pos.y);
        else
            normal.setLocation(pos.x, pos.y);
    }

    public void generarDireccioDeMoviment() {
        Random r = new Random();
        int n = r.nextInt(8);
        switch (n) {
            case 0:
                // N
                up = true;
                left = false;
                down = false;
                right = false;
                break;
            case 1:
                // NW
                up = true;
                left = true;
                down = false;
                right = false;

                break;
            case 2:
                // W
                up = false;
                left = true;
                down = false;
                right = false;
                break;
            case 3:
                // SW
                up = false;
                left = true;
                down = true;
                right = false;
                break;
            case 4:
                // S
                up = false;
                left = false;
                down = true;
                right = false;
                break;
            case 5:
                // SE
                up = false;
                left = false;
                down = true;
                right = true;
                break;
            case 6:
                // E
                up = false;
                left = false;
                down = false;
                right = true;
                break;
            case 7:
                // NE
                up = true;
                left = false;
                down = false;
                right = true;
                break;

            default:
                break;
        }

    }

    private void detectarLimitPantalla() {
        Random r = new Random();
        if (pos.x <= 0) {
            pos.x = 0;
            left = false;
            right = true;

            up = r.nextInt(2) == 1;
            down = r.nextInt(2) == 1;

        }
        if (pos.x >= Grafics.MIDA_PANTALLA.getWidth() - normal.getWidth() - 15) {
            pos.x = Grafics.MIDA_PANTALLA.getWidth() - normal.getWidth() - 15;
            right = false;
            left = true;

            up = r.nextInt(2) == 1;
            down = r.nextInt(2) == 1;
        }
        if (pos.y <= 0) {
            pos.y = 0;
            down = true;
            up = false;

            left = r.nextInt(2) == 1;
            right = r.nextInt(2) == 1;
        }
        if (pos.y >= Grafics.MIDA_PANTALLA.getHeight() - normal.getHeight() - 60) {
            pos.y = Grafics.MIDA_PANTALLA.getHeight() - normal.getHeight() - 60;
            up = true;
            down = false;

            left = r.nextInt(2) == 1;
            right = r.nextInt(2) == 1;
        }
    }

    // Getters

    /**
     * Retorna la imatge de l'emoji, segons l'estat actual
     * 
     * @return imatge normal si esZombie es fals
     *         o imatge zombificat si esZombie es cert.
     */
    public GImage getImatge() {
        if (esZombie) {
            return zombificado;
        } else {
            return normal;
        }
    }

    /**
     * @return la posició de l'emoji com Vector2d.
     */
    public Vector2d getPos() {
        return pos;
    }

    /**
     * @return si l'emoji es zombie.
     */
    public boolean esZombie() {
        return esZombie;
    }

    // Setters
    /**
     * Transforma l'emoji en zombie.
     */
    public void setZombificat() {
        esZombie = true;
    }
}