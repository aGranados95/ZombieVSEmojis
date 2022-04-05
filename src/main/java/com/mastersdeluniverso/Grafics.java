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
    public static final String DIR_FONS_PANALLA = "\\src\\main\\resources\\fons.jpg\\";
    public static final String DIR_IMATGES = "src/main/resources/";
    
    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;
    private ArrayList<Emoji> arr_emoji_zombie;
    

    //------------Funcions-----------------

    /** Funció principal que executa el programa */
    public final void run() {
        add(new GImage(DIR_FONS_PANALLA));
    }

    /** Inicialitza el fons de la finestra */
    private void inicialitzarFons() {
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