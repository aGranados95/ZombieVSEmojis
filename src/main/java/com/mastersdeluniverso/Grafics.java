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
import scala.util.Random;

public class Grafics extends GraphicsProgram implements KeyListener {
    public final void run() {
        this.resize(MIDA_FINESTRA);
        inicialitzarFons();
        this.addKeyListeners();
        inicialitzarEmoji();
    }

    private void inicialitzarFons() {
        fons = new GImage(RUTA_FONS_APP);
        fons.setSize(1200, 800);
        add(fons, 0, 0);
    }

    private void inicialitzarEmoji() {
        emoji = new ArrayList<Emoji>(NOMBRE_DE_EMOJIS);
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji1.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(900, 600)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji2.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(900, 212)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji3.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(344, 700)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji4.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(600, 279)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji5.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(99, 457)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji6.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(700, 10)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji7.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(457, 500)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji8.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(300, 666)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji9.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(570, 45)));
        emoji.add(new Emoji(FOTO_EMOJIS + "zoombie.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(600, 400)));

        for (Emoji emoji2 : emoji) {
            add(emoji2.getImatge());
        }

    }

    private void generarMoviment() {
        Random r = new Random();
        for (Emoji mov : emoji) {
            int x = r.nextInt(50) - 25;
            int y = r.nextInt(50) - 25;
            TempsEntreFrames ara = new TempsEntreFrames();
            Emoji.moures(ara.getDeltaTime());
        }
    }

    private void generarRebotar() {
        for (Emoji emoji3 : emoji) {
            if (emoji3.getPos().x > 1200 - 25/* Radi dels Emojis */) {
                emoji3.getPos().x = 1200 - 25;
                emoji3.getPos().x = emoji3.getPos().x * (-1);
                

            }
            if (emoji3.getPos().x < 0 + 25/* Radi dels Emojis */) {
                emoji3.getPos().x = 25;
                emoji3.getPos().x = emoji3.getPos().x * (-1);

            }
            if (emoji3.getPos().y > 800 - 25/* Radi dels Emojis */) {
                emoji3.getPos().y = 800 - 25;
                emoji3.getPos().y = emoji3.getPos().y * (-1);
            }
            if (emoji3.getPos().y < 0 + 25/* Radi dels Emojis */) {
                emoji3.getPos().y = 25;
                emoji3.getPos().y = emoji3.getPos().y * (-1);

            }
        }
    }

    private static final String FOTO_EMOJIS = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";
    private static final String RUTA_FONS_APP = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg";
    private static final int NOMBRE_DE_EMOJIS = 10;
    private static final int TEMPS_ENTRE_FRAMES = 100; // En milisegons.
    public static final Dimension MIDA_FINESTRA = new Dimension(1200, 800); // És estàtic per poder accedit des de fora.
    private GImage fons;
    private ArrayList<Emoji> emoji;

    private static TempsEntreFrames t = new TempsEntreFrames();

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
