package com.mastersdeluniverso;

import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acm.graphics.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram implements KeyListener {
    public final void run() {
        this.resize(MIDA_FINESTRA);
        inicialitzarFons();
        inicialitzarEmoji();

        this.addKeyListeners();

        jugador = new GImage(FOTO_EMOJIS + "\\player.png");
        jugador.setSize(50, 50);
        jugador.setLocation(100, 100);
        add(jugador);

        while (true) {
            t.update();
            if (up) {
                System.out.println("W");
                jugador.setLocation(jugador.getX() + 0, jugador.getY() - 100 * t.getDeltaTime());
            }
            if (down) {
                System.out.println("S");
                jugador.setLocation(jugador.getX() + 0, jugador.getY() + 100 * t.getDeltaTime());
            }
            if (left) {
                System.out.println("A");
                jugador.setLocation(jugador.getX() - 100 * t.getDeltaTime(), jugador.getY() + 0);
            }
            if (right) {
                System.out.println("D");
                jugador.setLocation(jugador.getX() + 100 * t.getDeltaTime(), jugador.getY() + 0);
            }
        }
    }

    private void inicialitzarFons() {
        fons = new GImage(RUTA_FONS_APP);
        add(fons, 0, 0);
    }

    private void inicialitzarEmoji() {
        emoji = new ArrayList<>(NOMBRE_DE_EMOJIS);
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji1.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(1000, 600)));
        emoji.add(new Emoji(FOTO_EMOJIS + "emoji2.png", FOTO_EMOJIS + "zoombie.png", new Vector2d(1000, 212)));
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


    private static final String FOTO_EMOJIS = ".\\src\\main\\resources\\img\\";
    private static final String RUTA_FONS_APP = ".\\src\\main\\resources\\img\\fons.jpg";
    private static final int NOMBRE_DE_EMOJIS = 11;
    public static final Dimension MIDA_FINESTRA = new Dimension(1200, 800); // És estàtic per poder accedit des de fora.
    private GImage fons;
    private GImage jugador;
    private ArrayList<Emoji> emoji;

    private static final TempsEntreFrames t = new TempsEntreFrames();

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    // Funcions per el moviment dels emojis
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print("The key Pressed was: ");
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W W W W W W W W W");
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S S S S S S S S S");
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A A A A A A A A A");
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D D D D D D D D D");
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.print("The key Released was: ");
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W W W W W W W W W");
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S S S S S S S S S");
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A A A A A A A A A");
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D D D D D D D D D");
            right = false;
        }
    }
}
