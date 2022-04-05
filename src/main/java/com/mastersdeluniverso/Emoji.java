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
    private Vector2d velocitat = new Vector2d(0, 0);

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

    private double temps_total_en_moviment;
    private static final double TEMPS_MAX_EN_MOVIMENT = 5.0f;

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

    }

    public void generarDireccioDeMoviment() {
        Random r = new Random();
        int n = r.nextInt(8);
        switch (n) {
            case 0:
            //N
                up = true;
                left = false;
                down = false;
                right = false;
                break;
            case 1:
            //NW
                up = true;
                left = true;
                down = false;
                right = false;

                break;
            case 2:
            //W
                up = false;
                left = true;
                down = false;
                right = false;
                break;
            case 3:
            //SW
                up = false;
                left = true;
                down = true;
                right = false;
                break;
            case 4:
            //S
                up = false;
                left = false;
                down = true;
                right = false;
                break;
            case 5:
            //SE
                up = false;
                left = false;
                down = true;
                right = true;
                break;
            case 6:
            //E
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