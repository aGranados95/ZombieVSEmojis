package com.mastersdeluniverso;

import java.util.ArrayList;

import javax.naming.InitialContext;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.*;

import acm.program.GraphicsProgram;

// TODO: Mesclar arrays de zombie i normal en un sol, després consultar si es zoombie i transformar-lo.

public class Grafics extends GraphicsProgram implements KeyListener {
    enum EstatDelPrograma {
        INICIANT,
        JUGANT,
        FINALITZANT,
        SORTIDA
    }

    public static final boolean DEBUG = false;
    // =============Atributs=================
    public static final Dimension MIDA_PANTALLA = new Dimension(800, 600);
    public static final String DIR_FONS_PANALLA = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg\\";
    public static final String DIR_IMATGES = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";
    public static final int NOMBRE_EMOJIS = 8;
    public static final Vector2d MIDA_EMOJI = new Vector2d(50, 50);

    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;

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
        EstatDelPrograma status = EstatDelPrograma.SORTIDA;  //TODO: Estat del programa
        t.update();
        do {
            switch (status) {
                case INICIANT:
                    break;
                case JUGANT:
                    break;
                case FINALITZANT:
                    break;
                default:
                    break;
            }
        }
        while(status != EstatDelPrograma.SORTIDA);

        while(true) {
            t.update();
            j.moures(t.getDeltaTime()); // Mou el jugador.
            moureEmojis(t.getDeltaTime()); // Mou els emojis.
            detectarColisions();
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
        // Inicialització del array d'Emoji normal
        arr_emoji_normal = new ArrayList<Emoji>();
        for (int i = 1; i <= NOMBRE_EMOJIS; i++) {
            // CREACIÓ DE L'EMOJI
            // Vector de posicio.
            Vector2d v = new Vector2d( i * 90, i * 60);
            // Crear emoji normal.
            Emoji e = new Emoji(DIR_IMATGES + "emoji" + i + ".png", DIR_IMATGES + "zoombie.png", v);
            // Posar mida a l'emoji.
            e.getImatge().setSize(MIDA_EMOJI.x, MIDA_EMOJI.y);
            // Generem una direcció aleatòria de moviment.
            e.generarDireccioDeMoviment();
            // Afegir l'emoji a l'array.
            arr_emoji_normal.add(e);
            // Mostrar per pantalla
            add(arr_emoji_normal.get(i - 1).getImatge());
        }
        Emoji emojiZoombie = new Emoji(DIR_IMATGES + "zoombie.png", DIR_IMATGES + "zoombie.png",
                new Vector2d(500, 500));
        emojiZoombie.setZombificat();
        add(emojiZoombie.getImatge());
        arr_emoji_normal.add(arr_emoji_normal.size() - 1, emojiZoombie);

        // Inicialització del array d'Emoji zombie

        // Inicialització del jugador.
        j = new Jugador(DIR_IMATGES + "player.png", DIR_IMATGES + "zoombie.png", new Vector2d(50, 500));
        add(j.getImatge());
    }

    /** Mou els emojis */
    private void moureEmojis(double deltaTime) {
        // Moure normals
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            arr_emoji_normal.get(i).moures(deltaTime);
        }
    }

    private void detectarColisions() {
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            for (int j = 0; j < arr_emoji_normal.size(); j++) {
                if (i == j)
                    continue;

                if (arr_emoji_normal.get(i).getImatge().getBounds() // Si hi ha colisió
                        .intersects(arr_emoji_normal.get(j).getImatge().getBounds())) {
                    // Canvien de direcció.
                    arr_emoji_normal.get(i).generarDireccioDeMoviment();
                    arr_emoji_normal.get(j).generarDireccioDeMoviment();
                    
                    // Si la colisió és amb un zoombie.
                    if (arr_emoji_normal.get(i).esZombie() && !arr_emoji_normal.get(j).esZombie()) {

                        // Eliminem l'imatge normal, el transformem en zoombie i el mostrem.
                        remove(arr_emoji_normal.get(j).getImatge());
                        arr_emoji_normal.get(j).setZombificat();
                        add(arr_emoji_normal.get(j).getImatge());
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