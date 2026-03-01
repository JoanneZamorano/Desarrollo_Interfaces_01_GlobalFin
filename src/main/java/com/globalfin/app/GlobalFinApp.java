package com.globalfin.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase principal de la aplicación GlobalFin Dashboard.
 * 
 * Punto de entrada de la aplicación JavaFX que:
 * - Carga el FXML principal (DashboardPrincipal.fxml)
 * - Configura la ventana principal (Stage)
 * - Establece estilos y configuración de la UI
 */
public class GlobalFinApp extends Application {

    private static final String APPLICATION_TITLE = "GlobalFin Dashboard - Financial Analysis System";
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 750;
    private static final String FXML_RESOURCE = "/fxml/DashboardPrincipal.fxml";

    /**
     * Punto de entrada del ciclo de vida de JavaFX.
     * 
     * @param primaryStage la ventana principal de la aplicación
     * @throws IOException si hay error al cargar el FXML
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(FXML_RESOURCE));
        
        try {
            javafx.scene.Parent root = loader.load();
            
            // Crear Scene
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            
            // Aplicar hoja de estilos (si existe)
            try {
                String css = getClass().getResource("/css/styles.css").toExternalForm();
                scene.getStylesheets().add(css);
            } catch (NullPointerException e) {
                System.out.println("Stylesheet not found, using default styles");
            }

            // Configurar Stage
            primaryStage.setTitle(APPLICATION_TITLE);
            primaryStage.setScene(scene);
            primaryStage.setWidth(WINDOW_WIDTH);
            primaryStage.setHeight(WINDOW_HEIGHT);
            primaryStage.setMinWidth(900);
            primaryStage.setMinHeight(600);

            // Cargar ícono (opcional)
            try {
                Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
                primaryStage.getIcons().add(icon);
            } catch (NullPointerException e) {
                System.out.println("Application icon not found");
            }

            // Mostrar
            primaryStage.show();
            
            System.out.println("Application started successfully");
            
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Punto de entrada de la aplicación.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}
