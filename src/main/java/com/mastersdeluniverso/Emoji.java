package com.mastersdeluniverso;

import acm.graphics.GImage;
import java.lang.Math;

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

    /**
     * Indica si l'emoji està zombificat o no.
     */
    private boolean esZombie;

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
        normal = new GImage(dir_img_normal);
        zombificado = new GImage(dir_img_zombie);
        esZombie = false; // Per defecte l'emoji no està zombificat.
        this.pos = new Vector2d(pos);
    }

    // Mètodes
    /**
     * Realitza el moviment de l'emoji.
     * @param deltaTime
     */
    public void moures(Double deltaTime) {
        Vector2d nouMoviment = new Vector2d(velocitat.multiplicarNatural(deltaTime));

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