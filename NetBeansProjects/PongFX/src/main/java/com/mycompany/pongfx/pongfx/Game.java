/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pongfx.pongfx;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    private int scoreLeft = 0;
    private int scoreRight = 0;

    private double canvasWidth;
    private double canvasHeight;

    private Set<String> keysPressed = new HashSet<>();

    public Game(double canvasWidth, double canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        ball = new Ball(canvasWidth / 2, canvasHeight / 2);
        leftPaddle = new Paddle(20, canvasHeight / 2 - 40);
        rightPaddle = new Paddle(canvasWidth - 32, canvasHeight / 2 - 40);
    }

    public void keyPressed(String key) {
        keysPressed.add(key);
    }

    public void keyReleased(String key) {
        keysPressed.remove(key);
    }

    public void update() {
        // Move left paddle (W / S)
        if (keysPressed.contains("W")) leftPaddle.moveUp();
        if (keysPressed.contains("S")) leftPaddle.moveDown();

        // Move right paddle (UP / DOWN arrows)
        if (keysPressed.contains("UP")) rightPaddle.moveUp();
        if (keysPressed.contains("DOWN")) rightPaddle.moveDown();

        // Clamp paddles inside canvas
        leftPaddle.clamp(canvasHeight);
        rightPaddle.clamp(canvasHeight);

        // Update ball
        ball.update(canvasWidth, canvasHeight);

        // Ball collision with left paddle
        if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()
                && ball.getY() + ball.getSize() >= leftPaddle.getY()
                && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()) {
            ball.reverseX();
        }

        // Ball collision with right paddle
        if (ball.getX() + ball.getSize() >= rightPaddle.getX()
                && ball.getY() + ball.getSize() >= rightPaddle.getY()
                && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()) {
            ball.reverseX();
        }

        // Scoring
        if (ball.getX() < 0) {
            scoreRight++;
            ball.reset(canvasWidth, canvasHeight);
        }
        if (ball.getX() > canvasWidth) {
            scoreLeft++;
            ball.reset(canvasWidth, canvasHeight);
        }
    }

    public void draw(GraphicsContext gc) {
        // Background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);

        // Dashed center line
        gc.setStroke(Color.GRAY);
        gc.setLineDashes(10);
        gc.strokeLine(canvasWidth / 2, 0, canvasWidth / 2, canvasHeight);
        gc.setLineDashes(0);

        // Scores
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Courier New", 36));
        gc.fillText(String.valueOf(scoreLeft), canvasWidth / 2 - 60, 50);
        gc.fillText(String.valueOf(scoreRight), canvasWidth / 2 + 30, 50);

        // Paddles and ball
        leftPaddle.draw(gc);
        rightPaddle.draw(gc);
        ball.draw(gc);
    }
}