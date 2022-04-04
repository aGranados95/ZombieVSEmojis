package com.mastersdeluniverso;

import java.lang.Math;

public class Vector2d {
    public double x;
    public double y;

    Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Vector2d(){
        this.x = 0;
        this.y = 0;
    }

    Vector2d(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public double distancia(Vector2d v) {
        return Math.sqrt((v.x-this.x)*(v.x-this.x)+(v.y-this.y)*(v.y-this.y));
    }

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
