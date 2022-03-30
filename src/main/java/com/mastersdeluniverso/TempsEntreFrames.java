package com.mastersdeluniverso;

public class TempsEntreFrames {
    private double deltaTime;
    private double lastTime;
    private double currentTime;

    public TempsEntreFrames() {
        lastTime = System.currentTimeMillis();
        currentTime = lastTime;
    }

    public void update() {
        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - lastTime;
        lastTime = currentTime;
    }

    public double getDeltaTime() {
        return deltaTime;
    }
    
}
