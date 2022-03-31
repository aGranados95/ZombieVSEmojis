package com.mastersdeluniverso;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;

import acm.graphics.*;
import acm.program.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram {
    public final void run() {
        this.resize(MIDA_FINESTRA);
        inicialitzarFons();

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
<<<<<<< HEAD
    }
=======
    } 
    
>>>>>>> b7ee4d43c984aedd097af3370a9e745f870fee8e

    private static final String FOTO_EMOJIS = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img";
    private static final String RUTA_FONS_APP = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg";
    private static final int NOMBRE_DE_EMOJIS = 11;
    public static final Dimension MIDA_FINESTRA = new Dimension(1200, 800); // És estàtic per poder accedit des de fora.
    private GImage fons;
    private ArrayList<Emoji> emoji;

<<<<<<< HEAD
    ////////////////////// TEMPORAL/////////////////////
    private Vector2d faltaesto = new Vector2d(0, 0);////
    ///////////////////////////////////////////////////

    private static TempsEntreFrames t = new TempsEntreFrames();
}
=======
    //////////////////////TEMPORAL/////////////////////
    private Vector2d faltaesto = new Vector2d(0,0);
}   ///////////////////////////////////////////////////
>>>>>>> b7ee4d43c984aedd097af3370a9e745f870fee8e
