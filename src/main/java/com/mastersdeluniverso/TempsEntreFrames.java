package com.mastersdeluniverso;

public class TempsEntreFrames {
    private double deltaTime;
    private double lastTime;
    private double currentTime;
    private final static double DIVISOR = 1000;

    public TempsEntreFrames() {
        lastTime = System.nanoTime()/DIVISOR;
        currentTime = lastTime;
    }

    public void update() {
        currentTime = System.nanoTime()/DIVISOR;
        deltaTime = currentTime - lastTime;
        lastTime = currentTime;
    }

    public double getDeltaTime() {
        return deltaTime;
    }
}
