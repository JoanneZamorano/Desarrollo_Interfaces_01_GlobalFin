# Arquitectura Técnica - GlobalFin Dashboard

## 📐 Visión General

GlobalFin Dashboard es una aplicación de escritorio JavaFX que implementa una arquitectura de capas profesional con separación clara entre presentación, lógica de eventos y servicios de datos.

```
┌─────────────────────────────────────────────┐
│        Interfaz de Usuario (FXML)           │
│  BorderPane + GridPane + TableView + Filters │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│      Controlador (DashboardController)      │
│  - Inyección @FXML                          │
│  - Manejadores de eventos                   │
│  - Gestión de hilos (Service/Task)          │
│  - Atajos de teclado                        │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│    Capa de Servicios (DataService)          │
│  - Lógica de negocio                        │
│  - Acceso a datos                           │
│  - Exportación                              │
│  - Validaciones                             │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│    Capa de Datos (Base de Datos)            │
│  - PostgreSQL / MySQL                       │
│  - Repositorios (futuro)                    │
└─────────────────────────────────────────────┘
```

## 🏗️ Componentes Principales

### 1. Capa de Presentación (FXML)

**Archivo:** `src/main/resources/fxml/DashboardPrincipal.fxml`

**Contenedores:**
- **BorderPane**: Estructura principal con 5 zonas (top, left, center, bottom, right)
- **GridPane**: Disposición de tarjetas y tablas en la zona central
- **VBox/HBox**: Flexibilidad en layout de componentes

**Componentes:**
- **TableView**: Tabla de reportes con virtualización automática
- **ComboBox**: Filtros dinámicos (cliente, tipo)
- **DatePicker**: Selector de fecha
- **TextField**: Búsqueda global
- **ProgressIndicator**: Indicador de carga asincrónica
- **Label**: Métricas y estados

**Estilos:** `src/main/resources/css/styles.css`
- Colores corporativos: azul (#3498db), verde (#16a085), rojo (#e74c3c)
- Accesibilidad A11y: contrastes WCAG AA, navegación por teclado
- Responsive: escalable a diferentes tamaños de ventana

### 2. Capa de Control (Java)

**Archivo:** `src/main/java/com/globalfin/controller/DashboardController.java`

**Responsabilidades:**
- **Inyección de controles**: `@FXML` vincula componentes FXML con variables Java
- **Manejadores de eventos**: Responde a clics, cambios en filtros, etc.
- **Gestión de hilos**: Usa `Service<Void>` para operaciones asincrónicas
- **Atajos de teclado**: `Ctrl+F`, `Ctrl+N`, `Ctrl+E`, `Ctrl+O`, etc.
- **Feedback de usuario**: Indicadores de carga, mensajes de estado

**Métodos clave:**
- `initialize()`: Configuración inicial, listeners, datos
- `setupKeyboardShortcuts()`: Mapeo de atajos
- `loadData()`: Invoca DataLoadService
- `handleOverviewTab()`: Cambia sección activa
- `populateTable()`: Rellena tabla con datos

**Patrón Service/Task:**
```java
private class DataLoadService extends Service<Void> {
    protected Task<Void> createTask() {
        return new Task<Void>() {
            protected Void call() throws Exception {
                // Operación pesada sin bloquear UI
                return null;
            }
        };
    }
}
```

### 3. Capa de Servicios (Próxima fase)

**Archivo:** `src/main/java/com/globalfin/service/DataService.java`

**Métodos disponibles:**
- `getReports(filters)`: Obtiene reportes con filtros
- `getMetrics(tab)`: Obtiene métricas del dashboard
- `exportData(format, reports)`: Exporta a CSV/Excel/PDF
- `createReport(report)`: Crea nuevo reporte

**DTOs:**
- `ReportDTO`: Encapsula datos de reportes
- `DashboardMetrics`: Métricas agregadas

**Futuro:**
- Conexión a PostgreSQL/MySQL
- REST API client
- Caché de datos
- Validaciones de negocio

### 4. Capa de Aplicación

**Archivo:** `src/main/java/com/globalfin/app/GlobalFinApp.java`

**Responsabilidades:**
- Extiende `Application` (punto de entrada JavaFX)
- Carga FXML desde recursos
- Configura ventana principal (Stage)
- Aplica estilos CSS
- Maneja excepciones de inicialización

## 📊 Flujos Principales

### Flujo 1: Inicio de Aplicación

```
1. JVM inicia → main() de GlobalFinApp
2. launch() invoca start(Stage primaryStage)
3. FXMLLoader carga DashboardPrincipal.fxml
4. DashboardController.initialize() se ejecuta
5. setupKeyboardShortcuts() registra atajos
6. loadInitialData() carga datos desde DataLoadService
7. Pantalla visible para usuario
```

### Flujo 2: Búsqueda de Datos

```
Usuario escribe en searchField
    ↓
listener textProperty() detecta cambio
    ↓
loadData() se invoca
    ↓
DataLoadService.restart() inicia Task en hilo separado
    ↓
ProgressIndicator se muestra (UI no bloquea)
    ↓
Task.call() simula carga de datos (1.5 seg)
    ↓
dataLoadService.setOnSucceeded() dispara callback
    ↓
populateTable() rellena TableView en JavaFX Application Thread
    ↓
ProgressIndicator desaparece, statusLabel = "Ready"
```

### Flujo 3: Atajo de Teclado

```
Usuario presiona Ctrl+N
    ↓
handleGlobalKeyPress(KeyEvent event) detecta
    ↓
Caso: event.getCode() == N && event.isControlDown()
    ↓
handleAddReport() se invoca
    ↓
Dialog<String> abre con formulario
    ↓
Usuario ingresa datos y presiona OK
    ↓
dataService.createReport() (futuro)
    ↓
loadData() recarga tabla
```

## 🧵 Gestión de Hilos

### Problema:
JavaFX no es thread-safe. Operaciones largas en el JavaFX Application Thread bloquean la UI.

### Solución:
```java
// ❌ INCORRECTO
loadData() {
    List<Report> data = database.selectAll();  // ← Bloquea UI
    dataTable.setItems(data);
}

// ✅ CORRECTO
loadData() {
    dataLoadService.restart();  // ← Inicia en hilo secundario
}

private class DataLoadService extends Service<Void> {
    protected Task<Void> createTask() {
        return new Task<Void>() {
            protected Void call() throws Exception {
                // Ejecuta en hilo separado
                List<Report> data = database.selectAll();
                
                // Actualizar UI solo en JavaFX Application Thread
                Platform.runLater(() -> {
                    dataTable.setItems(FXCollections.observableList(data));
                });
                return null;
            }
        };
    }
}
```

## 🔐 Inyección de Controles FXML

### Mecanismo:

1. En FXML: asignar `fx:id` a cada componente
```xml
<Button fx:id="addReportBtn" text="Add Report"/>
<TextField fx:id="searchField" promptText="Search..."/>
<TableView fx:id="dataTable"/>
```

2. En Controller: declarar variables con `@FXML`
```java
@FXML
private Button addReportBtn;

@FXML
private TextField searchField;

@FXML
private TableView<Map<String, String>> dataTable;
```

3. FXMLLoader automáticamente vincula por nombre (sin setter/getter)

### Ventajas:
- Separación clara vista/lógica
- Código más legible
- Facilita testing
- Scene Builder puede editar FXML gráficamente

## 🎨 Estilos y Temas

**Archivo:** `src/main/resources/css/styles.css`

**Clases CSS:**
- `.button`: Botones estándares
- `.text-field`: Campos de entrada
- `.table-view`: Tablas con virtualización
- `.combo-box`: Selectores
- `:focused`: Indicador de foco (naranja)

**Colores corporativos:**
```css
/* Primarios */
--color-primary-blue: #3498db;
--color-primary-green: #16a085;
--color-primary-red: #e74c3c;

/* Secundarios */
--color-bg-dark: #2c3e50;    /* Top bar */
--color-bg-sidebar: #34495e; /* Sidebar */
--color-bg-main: #ecf0f1;    /* Main area */

/* Accesibilidad */
--color-focus: #f39c12;      /* Indicador Tab/ESC */
```

## 📈 Rendimiento y Optimización

### 1. TableView Virtualización
```
TableView renderiza SOLO las filas visibles
Sin importar si hay 100, 1000 o 10,000 filas
→ O(1) rendimiento constante
```

### 2. Paginación
```java
rowsPerPage = 25;  // Cargar 25 filas por página
// En futuro: Lazy loading on scroll
```

### 3. Carga Asincrónica
```
Operación pesada → Task en hilo secundario → UI sigue responsiva
```

### 4. Caché (Futuro)
```java
// Cachear lista de clientes para no requeryar BD
private Map<String, Client> clientCache = new HashMap<>();
```

## 🧪 Testing

### Tests de Unidad (Futuro)
```java
@Test
void testDataServiceGetReports() {
    DataService service = new DataService();
    List<ReportDTO> reports = service.getReports(null, null, null, 1, 25);
    assertEquals(25, reports.size());
}
```

### Tests de UI (TestFX)
```java
@Test
void testAddReportButton() {
    FxRobot robot = new FxRobot();
    robot.clickOn("#addReportBtn");
    verifyThat("#reportDialog", isVisible());
}
```

### Tests de Accesibilidad
- Verificar navegación por Tab
- Confirmar atajos de teclado
- Validar contrastes de color
- Probar con lectores de pantalla

## 📦 Dependencias

**pom.xml:**
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21.0.1</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>21.0.1</version>
</dependency>
```

**Extras (Futuro):**
- JPA/Hibernate (ORM)
- PostgreSQL JDBC Driver
- Apache POI (Excel)
- JFreeChart (Gráficas)
- LogBack (Logging)

## 🚀 Próximas Fases

| Fase | Objetivo | Timeline |
|------|----------|----------|
| **1** | Prototipo funcional (✅ Completado) | Marzo 2026 |
| **2** | Integración Base de Datos | Abril 2026 |
| **3** | Gráficas y Reportes avanzados | Mayo 2026 |
| **4** | Autenticación y Permisos | Junio 2026 |
| **5** | Tests y Optimización | Julio 2026 |

---

**Documento generado:** Marzo 2026  
**Versión de diseño:** 1.0.0  
**Estándar:** JavaFX 21, WCAG 2.1 AA