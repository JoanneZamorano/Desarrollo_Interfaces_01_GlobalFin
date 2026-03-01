package com.globalfin.controller;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Controlador principal del Dashboard de GlobalFin.
 * 
 * Responsabilidades:
 * - Gestión de inyección de controles FXML (@FXML)
 * - Manejadores de eventos de UI (botones, filtros, atajos)
 * - Coordinación de cargas de datos asincrónicas (Task/Service)
 * - Feedback inmediato (indicadores de carga, mensajes de estado)
 */
public class DashboardController implements Initializable {

    // ===== INYECCIÓN DE CONTROLES FXML =====
    
    // Top: Búsqueda y controles globales
    @FXML
    private BorderPane rootPane;
    @FXML
    private TextField searchField;
    @FXML
    private Button exportBtn;
    @FXML
    private Button addReportBtn;

    // Left: Navegación y filtros
    @FXML
    private Button overviewBtn;
    @FXML
    private Button reportsBtn;
    @FXML
    private Button performanceBtn;
    @FXML
    private ComboBox<String> clientFilter;
    @FXML
    private DatePicker dateFilter;
    @FXML
    private ComboBox<String> typeFilter;

    // Center: Contenido principal
    @FXML
    private Label sectionTitle;
    @FXML
    private ProgressIndicator loadingIndicator;
    @FXML
    private Label totalReportsLabel;
    @FXML
    private Label revenueLabel;
    @FXML
    private Label completionLabel;
    @FXML
    private TableView<Map<String, String>> dataTable;

    // Bottom: Status y paginación
    @FXML
    private Label statusLabel;
    @FXML
    private ComboBox<Integer> rowsPerPageCombo;

    // ===== VARIABLES INTERNAS =====
    private int currentPage = 1;
    private int rowsPerPage = 25;
    private String currentTab = "overview";
    private DataLoadService dataLoadService;

    /**
     * Inicialización del controlador tras cargar el FXML.
     * Se configura aquí:
     * - Atajos de teclado
     * - Listeners de eventos
     * - Datos iniciales
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupKeyboardShortcuts();
        setupEventListeners();
        setupFilterComboBoxes();
        setupDataLoadService();
        loadInitialData();
    }

    /**
     * Configura atajos de teclado globales para operaciones rápidas.
     * 
     * Atajos principales:
     * - Ctrl+F: Foco en búsqueda
     * - Ctrl+N: Añadir nuevo reporte
     * - Ctrl+E: Exportar datos
     * - Ctrl+O: Ir a Overview
     * - Ctrl+R: Ir a Detailed Reports
     * - Ctrl+P: Ir a Performance
     */
    private void setupKeyboardShortcuts() {
        rootPane.setOnKeyPressed(this::handleGlobalKeyPress);
        rootPane.requestFocus();
    }

    /**
     * Manejador de atajos de teclado global.
     */
    private void handleGlobalKeyPress(KeyEvent event) {
        if (event.isControlDown()) {
            switch (event.getCode()) {
                case F -> {
                    searchField.requestFocus();
                    event.consume();
                }
                case N -> {
                    handleAddReport(null);
                    event.consume();
                }
                case E -> {
                    handleExport(null);
                    event.consume();
                }
                case O -> {
                    handleOverviewTab(null);
                    event.consume();
                }
                case R -> {
                    handleReportsTab(null);
                    event.consume();
                }
                case P -> {
                    handlePerformanceTab(null);
                    event.consume();
                }
                default -> {}
            }
        }
    }

    /**
     * Configura listeners para cambios en filtros y búsqueda.
     */
    private void setupEventListeners() {
        // Escucha cambios en búsqueda
        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            currentPage = 1;
            loadData();
        });

        // Cambios en filtros
        clientFilter.setOnAction(e -> {
            currentPage = 1;
            loadData();
        });
        dateFilter.setOnAction(e -> {
            currentPage = 1;
            loadData();
        });
        typeFilter.setOnAction(e -> {
            currentPage = 1;
            loadData();
        });

        // Cambio en filas por página
        rowsPerPageCombo.setOnAction(e -> {
            rowsPerPage = rowsPerPageCombo.getValue();
            currentPage = 1;
            loadData();
        });

        // Botones principales
        exportBtn.setOnAction(this::handleExport);
        addReportBtn.setOnAction(this::handleAddReport);
    }

    /**
     * Rellena los ComboBox de filtros con datos de ejemplo.
     */
    private void setupFilterComboBoxes() {
        clientFilter.getItems().addAll(
            "All Clients", "Acme Corp", "Global Industries", "Tech Solutions", "Finance Plus"
        );
        clientFilter.setValue("All Clients");

        typeFilter.getItems().addAll(
            "All Types", "Monthly", "Quarterly", "Annual", "Custom"
        );
        typeFilter.setValue("All Types");
    }

    /**
     * Configura el servicio de carga de datos asincrónica.
     * Esto garantiza que la UI no se bloquea durante cargas pesadas.
     */
    private void setupDataLoadService() {
        dataLoadService = new DataLoadService();
        dataLoadService.setOnSucceeded(e -> {
            loadingIndicator.setVisible(false);
            statusLabel.setText("Ready");
            updateMetrics();
        });
        dataLoadService.setOnFailed(e -> {
            loadingIndicator.setVisible(false);
            statusLabel.setText("Error loading data");
            showAlert("Error", "Failed to load data");
        });
    }

    /**
     * Carga datos iniciales (Overview).
     */
    private void loadInitialData() {
        currentTab = "overview";
        sectionTitle.setText("Overview");
        loadData();
    }

    /**
     * Carga datos desde el servicio asincrónico.
     */
    private void loadData() {
        if (dataLoadService.isRunning()) {
            dataLoadService.cancel();
        }
        loadingIndicator.setVisible(true);
        statusLabel.setText("Loading...");
        dataLoadService.restart();
    }

    /**
     * Actualiza las métricas mostradas en las tarjetas de resumen.
     */
    private void updateMetrics() {
        totalReportsLabel.setText(String.format("%,d", 1245));
        revenueLabel.setText("$2.4M");
        completionLabel.setText("94.2%");
        
        // Rellena la tabla con datos de ejemplo
        populateTable();
    }

    /**
     * Rellena la tabla con datos de demostración.
     */
    private void populateTable() {
        List<Map<String, String>> data = new ArrayList<>();
        
        String[] clients = {"Acme Corp", "Global Industries", "Tech Solutions", "Finance Plus"};
        String[] statuses = {"Completed", "Pending", "In Progress", "On Hold"};
        
        for (int i = 1; i <= rowsPerPage; i++) {
            Map<String, String> row = new LinkedHashMap<>();
            row.put("ID", String.format("RPT%05d", (currentPage - 1) * rowsPerPage + i));
            row.put("Client", clients[(i - 1) % clients.length]);
            row.put("Date", String.format("2025-%02d-%02d", 
                (i % 12) + 1, (i % 28) + 1));
            row.put("Amount", String.format("$%,d", 10000 + i * 500));
            row.put("Status", statuses[(i - 1) % statuses.length]);
            row.put("Actions", "View | Edit");
            data.add(row);
        }

        // Limpia y rellena la tabla
        dataTable.getItems().clear();
        dataTable.getItems().addAll(data);

        // Configura columnas dinámicamente si es necesario
        if (dataTable.getColumns().isEmpty()) {
            setupTableColumns();
        }
    }

    /**
     * Configura las columnas de la tabla dinámicamente.
     */
    private void setupTableColumns() {
        String[] columnNames = {"ID", "Client", "Date", "Amount", "Status", "Actions"};
        for (String columnName : columnNames) {
            TableColumn<Map<String, String>, String> col = new TableColumn<>(columnName);
            final String key = columnName;
            col.setCellValueFactory(cellData -> 
                new javafx.beans.property.SimpleStringProperty(
                    cellData.getValue().getOrDefault(key, "")
                )
            );
            dataTable.getColumns().add(col);
        }
    }

    // ===== MANEJADORES DE EVENTOS =====

    /**
     * Manejador: botón "Overview"
     */
    @FXML
    public void handleOverviewTab(ActionEvent event) {
        currentTab = "overview";
        sectionTitle.setText("Overview");
        overviewBtn.setStyle("-fx-background-color: #16a085;");
        reportsBtn.setStyle("-fx-background-color: #3498db;");
        performanceBtn.setStyle("-fx-background-color: #e74c3c;");
        loadData();
    }

    /**
     * Manejador: botón "Detailed Reports"
     */
    @FXML
    public void handleReportsTab(ActionEvent event) {
        currentTab = "reports";
        sectionTitle.setText("Detailed Reports");
        overviewBtn.setStyle("-fx-background-color: #3498db;");
        reportsBtn.setStyle("-fx-background-color: #16a085;");
        performanceBtn.setStyle("-fx-background-color: #e74c3c;");
        loadData();
    }

    /**
     * Manejador: botón "Performance"
     */
    @FXML
    public void handlePerformanceTab(ActionEvent event) {
        currentTab = "performance";
        sectionTitle.setText("Performance");
        overviewBtn.setStyle("-fx-background-color: #3498db;");
        reportsBtn.setStyle("-fx-background-color: #3498db;");
        performanceBtn.setStyle("-fx-background-color: #16a085;");
        loadData();
    }

    /**
     * Manejador: botón "Export"
     */
    @FXML
    public void handleExport(ActionEvent event) {
        statusLabel.setText("Exporting data...");
        // Simula exportación
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                Platform.runLater(() -> {
                    statusLabel.setText("Export completed");
                    showAlert("Success", "Data exported successfully!");
                });
            } catch (InterruptedException e) {
                Platform.runLater(() -> statusLabel.setText("Export canceled"));
            }
        }).start();
    }

    /**
     * Manejador: botón "Add Report"
     */
    @FXML
    public void handleAddReport(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add New Report");
        dialog.setHeaderText("Create a new financial report:");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField clientName = new TextField();
        clientName.setPromptText("Client name");
        ComboBox<String> reportType = new ComboBox<>();
        reportType.getItems().addAll("Monthly", "Quarterly", "Annual");
        
        grid.add(new Label("Client:"), 0, 0);
        grid.add(clientName, 1, 0);
        grid.add(new Label("Type:"), 0, 1);
        grid.add(reportType, 1, 1);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            statusLabel.setText("Report created successfully");
            loadData();
        }
    }

    /**
     * Manejador: Reset de filtros
     */
    @FXML
    public void handleFilterReset(ActionEvent event) {
        searchField.clear();
        clientFilter.setValue("All Clients");
        dateFilter.setValue(null);
        typeFilter.setValue("All Types");
        currentPage = 1;
        statusLabel.setText("Filters reset");
        loadData();
    }

    /**
     * Muestra un diálogo de alerta.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // ===== SERVICIO DE CARGA ASINCRÓNICA =====

    /**
     * Servicio personalizado para cargar datos en un hilo separado.
     * Evita bloquear el JavaFX Application Thread.
     */
    private class DataLoadService extends Service<Void> {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    // Simula carga pesada de datos
                    Thread.sleep(1500);
                    return null;
                }
            };
        }
    }
}
