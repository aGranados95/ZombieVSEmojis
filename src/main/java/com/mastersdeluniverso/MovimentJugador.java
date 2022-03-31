package com.mastersdeluniverso;

import acm.program.GraphicsProgram;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimentJugador extends GraphicsProgram {

    @Override
    public void run() {
        addKeyListeners(new MyKeyListener());
    }

    private class MyKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_W) {
                System.out.println("Key 'W' has been pressed!");
            }

            if (keyCode == KeyEvent.VK_A) {
                System.out.println("Key 'A' has been pressed!");
            }

            if (keyCode == KeyEvent.VK_S) {
                System.out.println("Key 'S' has been pressed!");
            }

            if (keyCode == KeyEvent.VK_D) {
                System.out.println("Key 'D' has been pressed!");
            }

        }

        @Override
        public void keyReleased(KeyEvent e) { /* Empty body */ }

        @Override
        public void keyTyped(KeyEvent e) { /* Empty body */ }

    }
}