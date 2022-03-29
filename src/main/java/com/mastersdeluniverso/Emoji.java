package com.mastersdeluniverso;

import acm.graphics.GImage;

public class Emoji {
    // Atributs
    private GImage normal;
    private GImage zombificado;

    protected Vector2d v;

    // Constructores
    Emoji(String dir_img_normal, String dir_img_zombie, Vector2d v) {
        normal = new GImage(dir_img_normal);
        zombificado = new GImage(dir_img_zombie);
        this.v = v;
    }
}
