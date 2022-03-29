package com.mastersdeluniverso;

import java.lang.Math;

public class Vector2d {
    public int x;
    public int y;

    Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Vector2d(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public double distancia(Vector2d v) {
        return Math.sqrt((v.x-this.x)*(v.x-this.x)+(v.y-this.y)*(v.y-this.y));
    }
}
