package com.mastersdeluniverso;

public class Vector2d {
    public double x;
    public double y;

    /**
     * Constructor per parametres
     * @param x: posició en l'eix x.
     * @param y: posició en l'eix y.
     */
    Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor copia.
     * @param v: vector a copiar.
     */
    Vector2d(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * 
     * @param v
     */
    public void sumar(Vector2d v) {
        this.x += v.x;
        this.y += v.y;
    }

    public Vector2d multiplicarNatural(double d) {
        this.x *= d;
        this.y *= d;
        return this;
    }
}
