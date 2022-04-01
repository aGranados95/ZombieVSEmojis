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
    public final void run() {
        this.resize(MIDA_FINESTRA);
        inicialitzarFons();
        this.addKeyListeners();
    }

    private void inicialitzarFons() {
        fons = new GImage(RUTA_FONS_APP);
        add(fons, 0, 0);
    }

    private void inicialitzarEmoji() {
        emoji = new ArrayList<Emoji>(NOMBRE_DE_EMOJIS);
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji1.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji2.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji3.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji4.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji5.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji6.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji7.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji8.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji9.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "player.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "zoombie.png", FOTO_EMOJIS + "zoombie.png", faltaesto));
    }

    private static final String FOTO_EMOJIS = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img";
    private static final String RUTA_FONS_APP = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg";
    private static final int NOMBRE_DE_EMOJIS = 11;
    public static final Dimension MIDA_FINESTRA = new Dimension(1200, 800); // És estàtic per poder accedit des de fora.
    private GImage fons;
    private ArrayList<Emoji> emoji;

    ////////////////////// TEMPORAL/////////////////////
    private Vector2d faltaesto = new Vector2d(0, 0);////
    ///////////////////////////////////////////////////

    private static TempsEntreFrames t = new TempsEntreFrames();

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
