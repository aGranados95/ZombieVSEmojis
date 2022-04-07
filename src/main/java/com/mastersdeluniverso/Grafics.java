package com.mastersdeluniverso;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.*;

import acm.program.GraphicsProgram;

public class Grafics extends GraphicsProgram implements KeyListener {
    public static final boolean DEBUG = false;
    // =============Atributs=================
    public static final Dimension MIDA_PANTALLA = new Dimension(800, 600);
    public static final String DIR_FONS_PANALLA = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg\\";
    public static final String DIR_IMATGES = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";
    public static final int NOMBRE_EMOJIS = 9;
    public static final Vector2d MIDA_EMOJI = new Vector2d(50, 50);

    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;
    private ArrayList<Emoji> arr_emoji_zombie;

    /** Jugador */
    Jugador j;

    /** Objecte del fons de l'apliació */
    private GImage img_fons;

    // ==============Funcions================
    /** Funció principal que executa el programa */
    public final void run() {
        t = new TempsEntreFrames();
        // Inicialització del programa.
        inicialitzarPantalla();
        inicialitzarFons();
        inicialitzarEmoji();

        // Execució. Bucle.
        while (true) {
            t.update(); // Actualització del delta time.
            j.moures(t.getDeltaTime()); // Mou el jugador.
            moureEmojis(t.getDeltaTime()); // Mou els emojis.
            detectarColisionsNormal();
            detetarColisionsNormalJugador();
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
        Random r = new Random();
        // Inicialització del array d'Emoji normal
        arr_emoji_normal = new ArrayList<Emoji>();
        for (int i = 1; i <= NOMBRE_EMOJIS; i++) {
            // Crear emoji normal
            Emoji e = new Emoji(DIR_IMATGES + "emoji" + i + ".png", DIR_IMATGES + "zoombie.png",
                    new Vector2d(i * r.nextInt(1) + i * 60, i * r.nextInt(1) + i * 60));
            e.getImatge().setSize(MIDA_EMOJI.x, MIDA_EMOJI.y); // Mida de l'emoji
            e.generarDireccioDeMoviment();
            arr_emoji_normal.add(e); // Afegir a l'array
            add(arr_emoji_normal.get(i - 1).getImatge()); // Afegir a la pantalla
        }

        // Inicialització del array d'Emoji zombie
        arr_emoji_zombie = new ArrayList<Emoji>();
        arr_emoji_zombie.add(
            new Emoji(DIR_IMATGES + "emoji1.png", DIR_IMATGES + "zoombie.png", new Vector2d(200, 220))
        );
        arr_emoji_zombie.get(0).getImatge().setSize(MIDA_EMOJI.x, MIDA_EMOJI.y);


        // Inicialització del jugador.
        j = new Jugador(DIR_IMATGES + "player.png", DIR_IMATGES + "zoombie.png", new Vector2d(50, 50));
        add(j.getImatge());
    }

    /** Mou els emojis */
    private void moureEmojis(double deltaTime) {
        // Moure normals
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            arr_emoji_normal.get(i).moures(deltaTime);
        }

        // Moure zoombies
        for (int i = 0; i < arr_emoji_zombie.size(); i++) {
            arr_emoji_zombie.get(i).moures(deltaTime);
        }
        
    }

    /** Detecta colisions entre emojis */
    private void detectarColisionsZombie() {

        for (int i = 0; i < arr_emoji_normal.size(); i++) { // Recorre array emojis
            for (int j = 0; j < arr_emoji_zombie.size(); j++) { // Recorre array emojis zombies
                if (arr_emoji_normal.get(i).getImatge().getBounds() // Si hi ha colisió
                        .intersects(arr_emoji_zombie.get(j).getImatge().getBounds())) {
                    // Eliminar imatge normal
                    remove(arr_emoji_normal.get(i).getImatge());
                    // Transformar a zombie
                    arr_emoji_normal.get(i).setZombificat();
                    // Afegir imatge zombie
                    add(arr_emoji_normal.get(i).getImatge());
                    // Afegir a l'array de zombies
                    arr_emoji_zombie.add(arr_emoji_normal.get(i));
                    // Eliminar de l'array d'emojis normals
                    arr_emoji_normal.remove(i);
                }
            }
        }
    }

    private void detectarColisionsNormal() {
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            for (int j = 0; j < arr_emoji_normal.size(); j++) {
                if (i != j) {
                    if (arr_emoji_normal.get(i).getImatge().getBounds() // Si hi ha colisió
                        .intersects(arr_emoji_normal.get(j).getImatge().getBounds())) {
                            arr_emoji_normal.get(i).generarDireccioDeMoviment();
                            arr_emoji_normal.get(j).generarDireccioDeMoviment();
                        }
                }
            }
        }
    }

    private void detetarColisionsNormalJugador() {
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            if (j.getImatge().getBounds()
                    .intersects(arr_emoji_normal.get(i).getImatge().getBounds())) {
                arr_emoji_normal.get(i).generarDireccioDeMoviment();
            }
        }
    }
    // Funcions per el moviment dels emojis
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        j.detectarMoviment(true, e);

        // debug
        if (DEBUG) {
            System.out.println("Position: " + j.getImatge().getX() + " " + j.getImatge().getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        j.detectarMoviment(false, e);

    }
}