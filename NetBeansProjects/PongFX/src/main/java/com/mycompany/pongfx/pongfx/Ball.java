/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pongfx.pongfx;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    private double x, y;
    private double speedX, speedY;
    private final double SIZE = 15;

    public Ball(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.speedX = 4;
        this.speedY = 4;
    }

    public void update(double canvasWidth, double canvasHeight) {
        x += speedX;
        y += speedY;

        // Bounce off top and bottom
        if (y <= 0 || y + SIZE >= canvasHeight) {
            speedY *= -1;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, SIZE, SIZE);
    }

    public void reverseX() {
        speedX *= -1;
    }

    public void reset(double canvasWidth, double canvasHeight) {
        x = canvasWidth / 2;
        y = canvasHeight / 2;
        speedX = 4;
        speedY = 4;
    }

    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getSize() { return SIZE; }
}