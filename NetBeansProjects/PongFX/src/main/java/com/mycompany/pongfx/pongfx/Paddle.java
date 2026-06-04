/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pongfx.pongfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {

    private final double x;
    private double y;
    private final double WIDTH = 12;
    private final double HEIGHT = 80;
    private final double speed = 5;

    public Paddle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void clamp(double canvasHeight) {
        if (y < 0) y = 0;
        if (y + HEIGHT > canvasHeight) y = canvasHeight - HEIGHT;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, WIDTH, HEIGHT);
    }

    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return WIDTH; }
    public double getHeight() { return HEIGHT; }
}