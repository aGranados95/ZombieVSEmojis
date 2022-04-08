package com.mastersdeluniverso;

public class TempsEntreFrames {
    private double deltaTime;
    private double lastTime;
    private double currentTime;
    private final static double DIVISOR = 1000000;

    public TempsEntreFrames() {
        lastTime = System.nanoTime()/DIVISOR;
        currentTime = lastTime;
    }

    /**
     * Actualitza el temps que ha pasat entre crides
     * de la funció.
     */
    public void update() {
        currentTime = System.nanoTime()/DIVISOR;
        deltaTime = currentTime - lastTime;
        lastTime = currentTime;
    }

    /**
     * @return retorna el temps que ha passat entre
     * les crides d'update.
     */
    public double getDeltaTime() {
        return deltaTime;
    }
}
