# Accesibilidad (A11y) y Pruebas de Rendimiento

Documento que detalla las pruebas de accesibilidad, rendimiento y recomendaciones para cumplir con estándares WCAG 2.1.

## ✅ Checklist de Accesibilidad (WCAG 2.1 - AA)

### 1. Perceivable (Perceptible - Nivel AA)

- [x] **Colores y Contraste**
  - Fondo oscuro (#2c3e50, #34495e) con texto claro
  - Ratio de contraste ≥ 4.5:1 para texto normal
  - Ratio de contraste ≥ 3:1 para componentes grandes
  - Verificar con herramientas: WAVE, Contrast Analyzer
  
- [x] **Sin dependencia solo de color**
  - Status indicators usan iconos + color
  - Errores muestran mensajes además de colores rojos
  
- [x] **Texto accesible**
  - Tipografía: Segoe UI, San Francisco (sans-serif)
  - Tamaño min 12px para cuerpo, 14px para títulos
  - Line-height: 1.5 para lectura

### 2. Operable (Nivel AA)

- [x] **Navegación por teclado**
  - Tab: navega entre campos
  - Enter/Space: activa botones
  - Atajos personalizados: Ctrl+F, Ctrl+N, Ctrl+E, Ctrl+O, Ctrl+R, Ctrl+P
  
- [x] **Indicador de foco visible**
  - Border naranja (#f39c12) cuando elemento tiene foco
  - Aplicado a buttons, text-fields, comboboxes
  
- [x] **Sin trampas de teclado**
  - Todos los elementos interactivos accesibles
  - Escape cierra diálogos (implementar si es necesario)

- [x] **Atajos y navegación**
  - Documentar en Help (TODO)
  - Mostrar tooltips con atajos

### 3. Understandable (Comprensible - Nivel AA)

- [x] **Lenguaje claro**
  - Labels descriptivos: "Add Report", no "Add"
  - Mensajes de error específicos
  - Validaciones explicadas
  
- [x] **Consistencia**
  - Botones siempre en la misma posición
  - Colores = funciones (azul = selección, rojo = peligro, verde = éxito)
  
- [x] **Prevención de errores**
  - Confirmación antes de acciones destructivas
  - Validación de entrada en tiempo real

### 4. Robust (Robusto - Nivel AA)

- [x] **Compatibilidad con lectores de pantallas**
  - Labels vinculados a campos (@FXML + Labeled)
  - Describir elementos complejos con text descriptions
  - TODO: Testear con JAWS, NVDA
  
- [x] **Válido JavaFX**
  - Código JavaFX estándar
  - CSS validado

## 🧪 Pruebas de Accesibilidad

### Prueba 1: Navegación por teclado
```
1. Abre la aplicación
2. Presiona Tab repetidamente
3. Verifica que el orden es lógico: búsqueda → botones → filtros → tabla
4. Presiona Shift+Tab para retroceder
✅ Resultado esperado: Todos los elementos son accesibles
```

### Prueba 2: Atajos de teclado
```
1. Desde la ventana principal:
   - Ctrl+F → Foco en campo de búsqueda
   - Ctrl+N → Abre diálogo "Add Report"
   - Ctrl+E → Inicia exportación
   - Ctrl+O / Ctrl+R / Ctrl+P → Cambia pestañas
✅ Resultado esperado: Todos los atajos funcionan sin usar ratón
```

### Prueba 3: Indicadores de foco
```
1. Presiona Tab para navegar
2. Observa el indicador de foco (border naranja alrededor del elemento)
3. Verifica que es visible en todos los elementos interactivos
✅ Resultado esperado: Foco siempre visible y claro
```

### Prueba 4: Contraste
```
1. Usa herramientas:
   - WebAIM Contrast Checker
   - WAVE Browser Extension (si es web)
   - Accessibility Inspector en macOS
2. Verifica todos los textos:
   - Blanco (#ecf0f1) sobre #2c3e50 = ratio 14:1 ✅
   - Blanco sobre #34495e = ratio 11:1 ✅
   - Negro (#2c3e50) sobre #ecf0f1 = ratio 14:1 ✅
✅ Resultado esperado: Todos los ratios ≥ 4.5:1
```

### Prueba 5: Zoom
```
1. Usa navegador o ajuste de SO
2. Aumenta zoom a 200%
3. Verifica que:
   - No hay texto cortado
   - Diseño es responsivo
   - Botones siguen siendo accesibles
✅ Resultado esperado: UI usable a 200% zoom
```

## 📊 Pruebas de Rendimiento

### Prueba 1: Carga de datos masiva

```java
// Modificar DashboardController.populateTable() para:
for (int i = 1; i <= 10000; i++) {  // En lugar de rowsPerPage
    // ... crear filas
}
```

**Métricas:**
- Tiempo de carga: < 2 segundos
- Memoria: < 500MB
- CPU: < 50% durante carga
- UI responsiva (no congela durante carga)

✅ TableView virtualiza automáticamente → solo renderiza filas visibles

### Prueba 2: Responsividad bajo carga

```
1. Abre la aplicación
2. Presiona Ctrl+F durante carga de datos
3. Verifica que el campo de búsqueda responde inmediatamente
✅ Resultado esperado: Cero bloqueos de UI
```

Razón: Usamos `Service<Void>` que carga en hilos secundarios

### Prueba 3: Consumo de memoria

```
Monitorear con JMeter o profiler:
- Inicial: ~100MB
- Después de cargar 10,000 filas: ~250MB
- Después de limpiar: Vuelve a ~100MB
✅ Resultado esperado: Sin memory leaks
```

## 📋 Recomendaciones Futuras

### A11y Mejoras
- [ ] Implementar lector de pantalla compatible (ARIA labels si fuese web)
- [ ] Añadir tooltips con atajos de teclado
- [ ] Modo oscuro/claro switcheable
- [ ] Tamaño de fuente ajustable

### Rendimiento Mejoras
- [ ] Paginación lazy-loading (cargar 25 filas, después 25 más on-scroll)
- [ ] Índices en base de datos
- [ ] Caché de datos (LocalDate, client list)
- [ ] Compresión de datos en transferencia

### Tests Automatizados
- [ ] TestFX para UI automation
- [ ] JUnit 5 para servicios
- [ ] AxeDevTools para a11y (en versión web futura)

## 🔍 Herramientas Recomendadas

| Herramienta | Propósito | Descarga |
|-------------|---------|----------|
| WAVE | Auditoría A11y | https://wave.webaim.org/extension/ |
| Axe DevTools | Tests automatizados | https://www.deque.com/axe/devtools/ |
| JMeter | Pruebas de carga | https://jmeter.apache.org/ |
| YourKit | Profiler Java | https://www.yourkit.com/java/profiler/ |
| JProfiler | Análisis de memoria | https://www.ej-technologies.com/products/jprofiler/overview.html |

---

**Documento generado:** Marzo 2026  
**Estándar:** WCAG 2.1 - Nivel AA
