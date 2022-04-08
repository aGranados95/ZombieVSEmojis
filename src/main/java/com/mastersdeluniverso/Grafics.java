package com.mastersdeluniverso;

import java.util.ArrayList;

import java.text.DecimalFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import acm.graphics.*;

import acm.program.GraphicsProgram;

// TODO: Mesclar arrays de zombie i normal en un sol, després consultar si es zoombie i transformar-lo.

public class Grafics extends GraphicsProgram implements KeyListener {
    /**
     * Enum per l'implementació de la màquina d'estats.
     * Iniciant: Inici del programa => Jugant
     * Jugant: Joc en marxa => Finalitzant
     * Finalitzant: Final del programa. => Iniciant | Sortida/
     * Sortida: Sortida del programa.
     */
    enum EstatDelPrograma {
        INICIANT,
        JUGANT,
        FINALITZANT,
        SORTIDA
    }

    private EstatDelPrograma stProg;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    /** Boolean que s'utilitza per fer debug, en release ha de ser false */
    public static final boolean DEBUG = false; // TODO: Està DEBUG en false?
    // =============Atributs=================
    public static final Dimension MIDA_PANTALLA = new Dimension(800, 600);
    public static final String DIR_FONS_PANALLA = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\fons.jpg\\";
    public static final String DIR_IMATGES = System.getProperty("user.dir")
            + "\\src\\main\\resources\\img\\";
    public static final int NOMBRE_EMOJIS = 8;
    public static final Vector2d MIDA_EMOJI = new Vector2d(50, 50);

    /** S'utilitza per obtenir delta time */
    private TempsEntreFrames t;

    /** Arrays dels emojis */
    private ArrayList<Emoji> arr_emoji_normal;

    /** Jugador, és el que es controla per l'usuari */
    Jugador j;

    /**
     * Objecte del fons de l'apliació, és necessari
     * per poder-lo eliminar més tard
     */
    private GImage img_fons;

    /**
     * Compta el temps total de joc
     */
    private double temps_total = 0;

    /**
     * Etiqueta per mostrar el temps del joc.
     */
    private GLabel label_temps;

    // ===============Funcions================
    /** Funció principal que executa el programa */
    public final void run() {
        stProg = EstatDelPrograma.INICIANT;

        do {
            switch (stProg) {
                case INICIANT:
                    inici_programa();
                    break;
                case JUGANT:
                    proces_joc();
                    break;
                case FINALITZANT:
                    finalització_del_programa();
                    break;
                default:
                    throw new IllegalStateException("Estat del programa desconegut");
            }
        } while (stProg != EstatDelPrograma.SORTIDA);
    }

    // ====FUNCIONS DE LA MÀQUINA D'ESTATS====
    private void inici_programa() {
        // Inicialització de la finestra i variables.
        inicialitzarPantalla();
        t = new TempsEntreFrames();

        // Canviar d'estat.
        stProg = EstatDelPrograma.JUGANT;
    }

    /** Executa el joc */
    private void proces_joc() {
        // Inicialització del joc.
        temps_total = 0;

        inicialitzarFons();
        inicialitzarEmoji();
        inicialitzarTexts();

        // Execució del joc.
        t.update();
        while (true) {
            t.update(); 
            j.moures(t.getDeltaTime());
            moureEmojis(t.getDeltaTime()); // Mou els emojis.
            detectarColisions();
            detetarColisionsNormalJugador();
            mostraTempsDeJoc();

            if (j.esZombie()) {
                animacioBlinkTemps();
                netejaDelJoc();
                stProg = EstatDelPrograma.FINALITZANT;
                break;
            }
        }
    }

    /** Mostra el final del joc */
    private void finalització_del_programa() {
        String msg1 = "Has durat " + df.format(temps_total) + " segons. ";
        String msg2 = "Prem R per tornar a jugar, X per sortir";
        GLabel missatgePerTornarAJugar = new GLabel(msg1 + msg2,
                MIDA_PANTALLA.width / 2 - 300,
                MIDA_PANTALLA.height / 2);

        // Posar font
        missatgePerTornarAJugar.setFont(new Font("Arial", Font.BOLD, 20));
        add(missatgePerTornarAJugar);
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
            Vector2d v = new Vector2d(i * 90, i * 60);
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

    /** Mou els emojis i zoombie */
    private void moureEmojis(double deltaTime) {
        // Moure normals
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            arr_emoji_normal.get(i).moures(deltaTime);
        }
    }

    /**
     * Detecta colisions entre emojis i zoombies,
     * en cas de que la colisió sigui entre un emoji
     * i un zoombie, l'emoji es zombifica.
     */
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

    /**
     * Detecta les colisions entre emojis i el jugador
     * en cas de que la colisió sigui entre un zoombie,
     * es para la partida
     */
    private void detetarColisionsNormalJugador() {
        for (int i = 0; i < arr_emoji_normal.size(); i++) {
            if (j.getImatge().getBounds()
                    .intersects(arr_emoji_normal.get(i).getImatge().getBounds())) {
                arr_emoji_normal.get(i).generarDireccioDeMoviment();
                if (arr_emoji_normal.get(i).esZombie()) {
                    remove(j.getImatge());
                    j.setZombificat();
                }
            }
        }
    }

    /**
     * Actualitza l'etiqueta de temps_total per mostra
     * el temps que s'ha estat jugant.
     */
    private void mostraTempsDeJoc() {
        temps_total = temps_total + t.getDeltaTime() / 1000; // Delta time està en milisegons
        // Mostrar el temps de joc.
        label_temps.setLabel("Temps: " + df.format(temps_total) + " segons");
    }

    /**
     * Crea el text i l'afegeix a la pantalla.
     */
    private void inicialitzarTexts() {
        label_temps = new GLabel("Temps: " + temps_total, 10, 20);
        label_temps.setFont(new Font("Arial", Font.BOLD, 20));
        add(label_temps);
    }

    /**
     * Fa parpadejar el temps de joc canviant de color.
     */
    private void animacioBlinkTemps() {
        double temps_blink = 8;

        int nombre_blinks = 10;

        for (int i = 0; i < nombre_blinks; i++) {
            double temps_blink_actual = 0;
            while (temps_blink_actual < temps_blink * 2) {
                temps_blink_actual = temps_blink_actual + t.getDeltaTime() / 1000;

                if (temps_blink_actual > temps_blink) {
                    label_temps.setColor(Color.WHITE);
                } else {
                    label_temps.setColor(Color.BLACK);
                }
            }
        }
    }

    private void netejaDelJoc() {
        removeAll();
        for (Emoji emoji : arr_emoji_normal) {
            emoji.getImatge().setLocation(0, 0);
            remove(emoji.getImatge());
        }
        arr_emoji_normal.clear();
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

        if (stProg == EstatDelPrograma.FINALITZANT) {
            if (e.getKeyChar() == 'r') {
                removeAll();
                stProg = EstatDelPrograma.JUGANT;
            } else if (e.getKeyChar() == 'x') {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        j.detectarMoviment(false, e);

    }
}