package com.mastersdeluniverso;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Normalizer;
import java.awt.Frame;
import acm.graphics.*;
import acm.program.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram implements KeyListener {
    // =============Atributs=================
    public static final Dimension MIDA_PANTALLA = new Dimension(800, 600);
    public static final String DIR_FONS_PANALLA = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg\\";
    public static final String DIR_IMATGES = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";
    public static final int NOMBRE_EMOJIS = 9;
    public static final Vector2d MIDA_EMOJI = new Vector2d(20, 20);

    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;
    private ArrayList<Emoji> arr_emoji_zombie;

    /** Objecte del fons de l'apliació */
    private GImage img_fons;

    // ==============Funcions================
    /** Funció principal que executa el programa */
    public final void run() {

        // Inicialització del programa.
        inicialitzarPantalla();
        inicialitzarFons();
        inicialitzarEmoji();

        // Execució. Bucle.
        while (true) {
            t.update(); // Actualització del delta time.
        }
    }

    /**
     * Funció que posa la mida a la pantalla
     * i activa els listeners.
     */
    private void inicialitzarPantalla() {
        setSize(MIDA_PANTALLA);
        setBackground(Color.WHITE);
        addKeyListeners();
    }

    /** Inicialitza el fons de la finestra */
    private void inicialitzarFons() {
        img_fons = new GImage(DIR_FONS_PANALLA);
        add(img_fons);
    }

    /** Col·loca tots els emojis a la pantalla, el jugador inclós */
    private void inicialitzarEmoji() {
        // Inicialització del array d'Emoji normal
        arr_emoji_normal = new ArrayList<Emoji>();
        for (int i = 1; i <= NOMBRE_EMOJIS; i++) {
            // Crear emoji normal
            Emoji e = new Emoji(DIR_IMATGES + "emoji" + i + ".png", DIR_IMATGES + "zoombie.png", new Vector2d(0, 0));
            e.getImatge().setSize(MIDA_EMOJI.x, MIDA_EMOJI.y); // Mida de l'emoji
            arr_emoji_normal.add(e);                           // Afegir a l'array
            add(arr_emoji_normal.get(i - 1).getImatge());      // Afegir a la pantalla
        }

        // Inicialització del jugador.
    }

    /** Funció per provar el moviment */
    private void testMoviment() {
        for (int i = 0; i < 500; i++) {
            for (Emoji emoji : arr_emoji_normal) {
                emoji.getImatge().setLocation(emoji.getImatge().getX() + 1, emoji.getImatge().getY() + 1);
            }
            long t = 100;
            try {
                Thread.sleep(t);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    /** Detecta colisions entre emojis */

    // Funcions per el moviment dels emojis
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("The key Pressed was: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("The key Pressed was: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("The key Released was: " + e.getKeyChar());
    }
}