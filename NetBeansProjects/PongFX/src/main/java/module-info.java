module com.mycompany.pongfx.pongfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pongfx.pongfx to javafx.fxml;
    exports com.mycompany.pongfx.pongfx;
}
