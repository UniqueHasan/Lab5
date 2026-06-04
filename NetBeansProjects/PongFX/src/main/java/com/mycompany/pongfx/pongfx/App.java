package com.mycompany.pongfx.pongfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group root = new Group(canvas);
        Scene scene = new Scene(root);

        Game game = new Game(WIDTH, HEIGHT);

        scene.setOnKeyPressed(e -> game.keyPressed(e.getCode().toString()));
        scene.setOnKeyReleased(e -> game.keyReleased(e.getCode().toString()));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                game.update();
                game.draw(gc);
            }
        };
        timer.start();

        stage.setTitle("Pong");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}