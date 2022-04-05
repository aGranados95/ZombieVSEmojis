package com.mastersdeluniverso;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;
import acm.graphics.*;
import acm.program.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram implements KeyListener {
    //-------------Atributs----------------
    public static final Dimension MIDA_PANTALLA = new Dimension(800, 600);
    public static final String DIR_FONS_PANALLA = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\fons.jpg\\";
    public static final String DIR_IMATGES = System.getProperty("user.dir") + "src\\main\\resources\\img\\";
    
    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;
    private ArrayList<Emoji> arr_emoji_zombie;

    /** Objecte del fons de l'apliació */
    private GImage img_fons;

    //------------Funcions-----------------

    /** Funció principal que executa el programa */
    public final void run() {

        inicialitzarFons();
        inicialitzarEmoji();
    }

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