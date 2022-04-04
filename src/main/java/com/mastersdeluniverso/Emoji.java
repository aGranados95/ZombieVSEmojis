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
    private Vector2d velocitat = new Vector2d(0,0);

    /**
     * Imatges de l'emoji.
     */
    private GImage normal;
    private GImage zombificado;

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
     * @param dir_img_normal directori de la imatge del emoji
     * normal.
     * @param dir_img_zombie directori de la imatge del emoji
     * zombificat.
     * @param pos posició del emoji.
     */
    Emoji(String dir_img_normal, String dir_img_zombie, Vector2d pos) {
        normal = new GImage(dir_img_normal);
        zombificado = new GImage(dir_img_zombie);
        esZombie = false;   // Per defecte l'emoji no està zombificat.
        this.pos = new Vector2d(pos);
    }

    // Mètodes
    public void moures(Double deltaTime) {
        Vector2d nouMoviment = new Vector2d(velocitat.multiplicarNatural(deltaTime));
        
    }
}