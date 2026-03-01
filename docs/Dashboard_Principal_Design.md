# Diseño: Dashboard Principal

Resumen ejecutivo
- Objetivo: Rehacer el dashboard legacy para mejorar jerarquía visual, rendimiento y usabilidad para analistas financieros.

**1. Estructura de contenedores**
- Contenedor principal: `BorderPane`.
  - Zona izquierda: menú lateral (navegación y acciones rápidas).
  - Centro: contenido principal (tablas, gráficas, detalles).
- Razonamiento: `BorderPane` ofrece un layout profesional, fácilmente legible y escalable.

**2. Visualización de datos**
- Principal: `GridPane` para gestión de tablas y paneles de datos.
  - Permite organizar múltiples tablas y widgets en una cuadrícula responsiva.
  - Facilita alineación y redimensionado consistente.

**3. Interacción y navegación**
- Atajos de teclado: esenciales para operaciones rápidas (+2).
  - Ctrl+F: foco en búsqueda.
  - Ctrl+N: añadir nuevo reporte.
  - Ctrl+E: exportar datos.
- Navegación por secciones: pestañas o menú con: "Overview", "Detailed reports" y "Performance" (+2).
- Elementos de entrada: campo de búsqueda, filtros (fecha, cliente, tipo), botones de acción rápida: "Add report", "Export" (+2).

**4. Selección tecnológica (justificación)**
- Tecnología elegida: JavaFX.
  - Separación de capas (FXML): uso de archivos FXML para separar vista y lógica (+1).
  - Rendimiento en escritorio: JavaFX maneja grandes volúmenes de datos en tablas con fluidez (+1).
  - Mantenimiento: controladores delgados que validan y llaman a servicios de negocio (+1).

**5. Prototipado funcional y entorno**
- Herramienta de diseño: Scene Builder integrado con IDE (+1).
  - Maquetado visual (drag & drop) para iteración rápida.
- Configuración técnica clave:
  - Inyección de controles con `@FXML` y `fx:id` únicos.
  - Gestión de hilos: usar `Task`/`Service` para cargas de datos evitando bloquear el `JavaFX Application Thread`.
  - Identificación clara de nodos para pruebas y automatización.

**6. Enfoque en UX y usabilidad**
- Modelo mental y reducción de carga cognitiva: validar con bocetos Low-Fi y tests de usabilidad tempranos (+2).
- Accesibilidad y contraste (A11y): aplicar paleta corporativa con contraste suficiente; tipografía y tamaño adecuados (+1).
- Feedback inmediato: mensajes de carga, confirmaciones y errores claros para operaciones sensibles.

**7. Recomendaciones de implementación (próximos pasos)**
- Crear prototipo FXML con `BorderPane`, menú lateral y pestañas.
- Implementar un `TableView` demo con paginación y carga por demanda (virtualization).
- Añadir manejadores de atajos de teclado en el controlador principal.
- Esqueleto de controlador Java con separación a servicios de datos.
- Pruebas: carga de datos masiva y auditoría A11y (contraste y navegación por teclado).

**8. Notas y prioridades**
- Prioridad alta: experiencia de navegación (pestañas, atajos, búsqueda rápida).
- Prioridad media: optimización de renderizado de tablas y paginación.
- Prioridad baja: ajustes estéticos finales (tema corporativo) tras validar flujo funcional.

---
Documento generado a partir de la especificación proporcionada. Si deseas, puedo ahora:
- Generar el prototipo FXML inicial y el controlador Java esqueleto.
- Añadir los atajos de teclado implementados y ejemplos de `Task`/`Service` para carga asíncrona.
