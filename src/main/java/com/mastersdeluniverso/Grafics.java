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
    
    private static final int NOMBRE_DE_EMOJIS = 11;
    private static final Dimension MIDA_FINESTRA = new Dimension(1200,800);
    private ArrayList<Emoji> emoji;
    
}
