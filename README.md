# GlobalFin Dashboard - Documentación Completa

## 📋 Descripción General

Dashboard corporativo para análisis financiero desarrollado en **JavaFX** con arquitectura profesional.

**Características principales:**
- ✅ Interfaz `BorderPane` con menú lateral y contenido principal
- ✅ Tabla `GridPane` optimizada para grandes volúmenes de datos
- ✅ Atajos de teclado (Ctrl+F, Ctrl+N, Ctrl+E, Ctrl+O, Ctrl+R, Ctrl+P)
- ✅ Gestión de hilos asincrónica (`Task`/`Service`) para cargas sin bloqueo
- ✅ Inyección de controles `@FXML` con `fx:id` únicos
- ✅ Navegación por pestañas (Overview, Detailed Reports, Performance)
- ✅ Filtros dinámicos (cliente, fecha, tipo)
- ✅ Feedback inmediato (indicadores de carga, mensajes de estado)
- ✅ Accesibilidad A11y (contrastes, navegación por teclado)
- ✅ **Wireframes Low-Fi validados** (ASCII + HTML interactivo)

## 🛠️ Requisitos Previos

- **Java 21+** (OpenJDK recomendado)
- **Maven 3.8+**

## 📦 Compilación y Ejecución

### Compilar
```bash
mvn clean compile
```

### Ejecutar
```bash
mvn javafx:run
```

## 🎯 Atajos de Teclado

| Atajo | Acción |
|-------|--------|
| Ctrl+F | Foco en búsqueda |
| Ctrl+N | Añadir nuevo reporte |
| Ctrl+E | Exportar datos |
| Ctrl+O | Ir a Overview |
| Ctrl+R | Ir a Detailed Reports |
| Ctrl+P | Ir a Performance |

## 📁 Estructura del Proyecto

```
src/main/java/com/globalfin/
├── app/GlobalFinApp.java           # Clase principal
├── controller/DashboardController.java    # Controlador con @FXML
└── service/DataService.java        # Servicios de datos (stub)

src/main/resources/
├── fxml/DashboardPrincipal.fxml    # Layout principal
└── css/styles.css                  # Estilos corporativos

docs/
├── Wireframes_Low_Fi.md           # Wireframes ASCII + especificación
├── Wireframes_Interactivos.html   # Versión clickeable
├── Validacion_Post_Wireframes.md  # Plan de mejora
├── Dashboard_Principal_Design.md  # Concepto de diseño
├── Arquitectura_Tecnica.md        # Diseño técnico detallado
└── Accesibilidad_y_Rendimiento.md # Tests y optimización
```

## 📚 Documentación Disponible

- **Wireframes:** [Versión ASCII](docs/Wireframes_Low_Fi.md) | [Versión Interactive HTML](docs/Wireframes_Interactivos.html)
- **Diseño:** [GUI Concept](docs/Dashboard_Principal_Design.md) | [Technical Architecture](docs/Arquitectura_Tecnica.md)
- **Validación:** [Post-Wireframes Analysis](docs/Validacion_Post_Wireframes.md) | [A11y & Performance](docs/Accesibilidad_y_Rendimiento.md)

## 🏗️ Decisiones Arquitectónicas

- **FXML + Java**: Separación vista/lógica
- **Service/Task**: Cargas asincrónicas sin bloqueo de UI
- **@FXML Injection**: Vinculación automática de controles
- **Accesibilidad A11y**: Colores WCAG AA + navegación por teclado
- **TableView Virtualizado**: Rendimiento con grandes volúmenes de datos

## 📝 Roadmap Futuro

1. Integración Base de Datos (PostgreSQL/MySQL)
2. Gráficas (Charts)
3. Autenticación y Control de Acceso
4. Tests Automatizados (TestFX)

---

**Versión:** 1.0.0-SNAPSHOT  
**Proyecto:** GlobalFin Financial Dashboard
