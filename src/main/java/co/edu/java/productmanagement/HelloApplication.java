package co.edu.java.productmanagement;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.config.JDBCInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        H2Connection conexion = new H2Connection();
        conexion.GetConnectionDBH2();
        JDBCInitializer init = new JDBCInitializer(conexion);
        //init.resetear();
        init.inicializar();
        launch();
    }
}