package com.mastersdeluniverso;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;

import acm.graphics.*;
import acm.program.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram implements KeyListener {
    public final void run() {
        this.resize(MIDA_FINESTRA);
        inicialitzarFons();
        jugador = new GImage(FOTO_EMOJIS + "\\player.png");
        jugador.setSize(50,50);
        jugador.setLocation(300, 300);
        add(jugador);
        addKeyListeners(new Grafics());

        while (true) {
            jugador.setLocation(mov.x,mov.y);
        }

    }

    private void inicialitzarFons() {
        fons = new GImage(RUTA_FONS_APP);
        add(fons, 0, 0);
    }

    private void inicialitzarEmoji() {
        emoji = new ArrayList<Emoji>(NOMBRE_DE_EMOJIS);
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji1.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji2.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji3.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji4.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji5.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji6.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji7.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji8.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\emoji9.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\player.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
        emoji.add(new Emoji(FOTO_EMOJIS + "\\zoombie.png", FOTO_EMOJIS + "\\zoombie.png", faltaesto));
    }


    private static final String FOTO_EMOJIS = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\";
    private static final String RUTA_FONS_APP = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg";
    private static final int NOMBRE_DE_EMOJIS = 11;
    public static final Dimension MIDA_FINESTRA = new Dimension(1200, 800); // És estàtic per poder accedit des de fora.
    private GImage fons;
    private GImage jugador;
    private ArrayList<Emoji> emoji;

    private Vector2d mov = new Vector2d();


    //////////////////////TEMPORAL/////////////////////
    private Vector2d faltaesto = new Vector2d(0, 0);
    ///////////////////////////////////////////////////


    @Override
    public void keyPressed(KeyEvent e) {

        char keyCode = e.getKeyChar();

        if (keyCode == 'w') {
            System.out.println("Key 'W' has been pressed!");
            System.out.println(mov.y);
            jugador.setLocation(jugador.getX(), jugador.getY()+50);
        }

        if (keyCode == 'a') {
            System.out.println("Key 'A' has been pressed!");
            System.out.println(mov.x);
            jugador.setLocation(jugador.getX()-50,jugador.getY());
        }

        if (keyCode == 's') {
            System.out.println("Key 'S' has been pressed!");
            System.out.println(mov.y);
            jugador.setLocation(jugador.getX(),jugador.getY()-50);
        }

        if (keyCode == 'd') {
            System.out.println("Key 'D' has been pressed!");
            System.out.println(mov.x);
            jugador.setLocation(jugador.getX()+50,jugador.getY());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S) {
            System.out.println(keyCode);
            System.out.println("-W -S");
            System.out.println(mov.y);
//            mov.y = 0;
        }

        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
            System.out.println(keyCode);
            System.out.println("-A -D");
            System.out.println(mov.x);
//            mov.x = 0;
        }
    }
}
