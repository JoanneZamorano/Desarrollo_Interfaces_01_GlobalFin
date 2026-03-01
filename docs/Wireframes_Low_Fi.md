# Wireframes - GlobalFin Dashboard

## 📋 Propósito

Validar la arquitectura visual, flujos de navegación y jerarquía de información **ANTES** de invertir en diseño de alta fidelidad. Permite identificar:
- Problemas de usabilidad
- Redundancias de información
- Mejoras en accesibilidad

Estos wireframes son **Low-Fi** (baja fidelidad): texto y estructura, sin colores ni tipografía final.

---

## 1. Wireframe Principal: Overview (Tab activo)

```
╔═══════════════════════════════════════════════════════════════════════════════╗
║  🏢 GLOBALFIN DASHBOARD                    [🔍 Search...] [📤] [➕]          ║
╠═════════════════════╦═════════════════════════════════════════════════════════╣
║                     ║                                                         ║
║  NAVEGACIÓN         ║  OVERVIEW                                              ║
║  _______________    ║  ═════════════════════════════════════════             ║
║                     ║                                                         ║
║  [📊 Overview]      ║  ┌──────────────┬──────────────┬──────────────┐        ║
║  [📋 Reports]       ║  │   Reports    │   Revenue    │  Completion  │        ║
║  [📈 Performance]   ║  │   1,245      │   $2.4M      │    94.2%     │        ║
║                     ║  │  ↑ 12% ▲     │  ↓ 5% ▼      │  ↑ 2% ▲      │        ║
║  ───────────────    ║  └──────────────┴──────────────┴──────────────┘        ║
║                     ║                                                         ║
║  FILTROS            ║  DATA TABLE                                             ║
║  ───────────────    ║  ─────────────────────────────────────────────         ║
║  Cliente:           ║  ID      | Client         | Date       | Amount | ... ║
║  [▼ All Clients]    ║  ─────────────────────────────────────────────────     ║
║                     ║  RPT00001| Acme Corp      | 2025-03-01 | $10.5K │ ... ║
║  Fecha:             ║  RPT00002| Global Ind.    | 2025-02-28 | $11.0K │ ... ║
║  [📅 2026-03-01]    ║  RPT00003| Tech Solution  | 2025-02-27 | $11.5K │ ... ║
║                     ║  RPT00004| Finance Plus   | 2025-02-26 | $12.0K │ ... ║
║  Tipo:              ║  ...                                                   ║
║  [▼ All Types]      ║  [◀ Prev] Page 1 of 50 [Next ▶]  Rows: [▼ 25]        ║
║                     ║                                                         ║
║  [🔄 Reset]         ║                                                         ║
║                     ║                                                         ║
║  ⚙️ Settings        ║                                                         ║
║  ❓ Help            ║                                                         ║
╠═════════════════════╩═════════════════════════════════════════════════════════╣
║  ✅ Ready                 Rows: 25    [◀ Prev] Página 1 of 50 [Next ▶]      ║
╚═══════════════════════════════════════════════════════════════════════════════╝
```

### Componentes clave:

| Elemento | Descripción | Interacción |
|----------|-----------|---|
| **Top Bar** | Logo + Búsqueda global + Botones de acción | Click → Ejecutar acción |
| **Sidebar izq.** | Navegación (3 tabs) + Filtros + Links | Click → Cambiar vista |
| **Tarjetas métricas** | KPIs rápidos (Reports, Revenue, Completion) | Hover → Tooltip con detalles |
| **Tabla principal** | Listado de reportes con scroll/paginación | Click row → Detalles, Ctrl+E → Export |
| **Foot bar** | Status + Paginación + Rows per page | Combobox → Cambiar filas |

**Accesibilidad:**
- ✅ Tab: navega Sidebar → Búsqueda → Filtros → Tabla → Paginación
- ✅ Ctrl+F: foco en búsqueda
- ✅ Ctrl+N: abre "Add Report"
- ✅ Colores contrastado para daltónicos

---

## 2. Wireframe: Detailed Reports (Tab)

```
╔═══════════════════════════════════════════════════════════════════════════════╗
║  🏢 GLOBALFIN DASHBOARD                    [🔍 Search...] [📤] [➕]          ║
╠═════════════════════╦═════════════════════════════════════════════════════════╣
║                     ║                                                         ║
║  NAVEGACIÓN         ║  DETAILED REPORTS                                      ║
║  _______________    ║  ═════════════════════════════════════════             ║
║                     ║                                                         ║
║  [📊 Overview]      ║  Filter by Report Type:                                ║
║  [📋 Reports] ◄─    ║  [▼ Monthly] [▼ Quarterly] [▼ Annual] [▼ Custom]      ║
║  [📈 Performance]   ║                                                         ║
║                     ║  REPORT GROUPS (Accordion)                             ║
║  ───────────────    ║  ─────────────────────────────────────────────         ║
║                     ║  ▼ February 2025 (15 reports)                          ║
║  FILTROS            ║    ├─ Acme Corp - Monthly (Feb)        [View] [Edit]  ║
║  ───────────────    ║    ├─ Global Ind. - Quarterly (Q1)     [View] [Edit]  ║
║  Cliente:           ║    └─ Tech Solutions - Annual (2025)   [View] [Edit]  ║
║  [▼ All Clients]    ║                                                         ║
║                     ║  ▼ January 2025 (12 reports)                           ║
║  Rango fechas:      ║    ├─ Finance Plus - Monthly (Jan)     [View] [Edit]  ║
║  [📅] - [📅]        ║    └─ Market Leaders - Quarterly (Q4)   [View] [Edit]  ║
║                     ║                                                         ║
║  Búsqueda avanzada: ║  ▼ December 2024 (8 reports)                           ║
║  [Cliente name...] ║    └─ Acme Corp - Custom Analysis      [View] [Edit]  ║
║  [Amount range: $] ║                                                         ║
║                     ║  [⏬ Load more...]                                       ║
║  [🔍 Apply]         ║                                                         ║
║  [🔄 Reset]         ║                                                         ║
║                     ║                                                         ║
║  ⚙️ Settings        ║                                                         ║
║  ❓ Help            ║                                                         ║
╠═════════════════════╩═════════════════════════════════════════════════════════╣
║  ✅ Showing 35 reports                                                         ║
╚═══════════════════════════════════════════════════════════════════════════════╝
```

### Componentes clave:

| Elemento | Descripción | Interacción |
|----------|-----------|---|
| **Filtros avanzados** | Tipo de reporte, cliente, rango de fecha | Combo/Text → Filtrar |
| **Accordion de reportes** | Agrupados por mes/año | Click ▼ → Expandir/Contraer |
| **Rows con acciones** | Cada reporte tiene [View] [Edit] [Delete] | Click → Abrir detalles |
| **Load more** | Carga progresiva de reportes antiguos | Click → Cargar más |

**Flujo de usuario:**
1. Selecciona filtros (cliente, tipo, rango fechas)
2. Sistema agrupa reportes por mes
3. Expande/contrae meses según necesidad
4. Click [View] → Abre modal con detalles completos

---

## 3. Wireframe: Performance (Tab)

```
╔═══════════════════════════════════════════════════════════════════════════════╗
║  🏢 GLOBALFIN DASHBOARD                    [🔍 Search...] [📤] [➕]          ║
╠═════════════════════╦═════════════════════════════════════════════════════════╣
║                     ║                                                         ║
║  NAVEGACIÓN         ║  PERFORMANCE METRICS                                   ║
║  _______________    ║  ═════════════════════════════════════════             ║
║                     ║                                                         ║
║  [📊 Overview]      ║  Time Range: [▼ Last 30 Days] [From 📅] [To 📅]      ║
║  [📋 Reports]       ║                                                         ║
║  [📈 Performance] ◄ ║  ┌─────────────────────────────────────────────────┐  ║
║                     ║  │ COMPLETION RATE (%)                             │  ║
║  ───────────────    ║  │                                 95% ◄────────    │  ║
║  FILTROS            ║  │  ┌────────────────────────────────────────────┐ │  ║
║  ───────────────    ║  │  │                                            │ │  ║
║  Período:           ║  │  │           [CHART PLACEHOLDER]             │ │  ║
║  [▼ Last 30 Days]   ║  │  │      (LineChart: Trend over time)        │ │  ║
║  [▼ Last 90 Days]   ║  │  │                                            │ │  ║
║  [▼ Last Year]      ║  │  └────────────────────────────────────────────┘ │  ║
║  [Custom range]     ║  └─────────────────────────────────────────────────┘  ║
║                     ║                                                         ║
║  Segmentar por:     ║  ┌─────────────────────────────────────────────────┐  ║
║  [▼ By Client]      ║  │ TOP PERFORMING CLIENTS                          │  ║
║  [▼ By Type]        ║  │  1. Acme Corp              - 98% completion    │  ║
║  [▼ By Month]       ║  │  2. Global Industries      - 95% completion    │  ║
║                     ║  │  3. Tech Solutions         - 92% completion    │  ║
║  [▼ Metrics]        ║  │  4. Finance Plus           - 88% completion    │  ║
║  [Completion Rate]  ║  │  5. Market Leaders         - 85% completion    │  ║
║  [Revenue vs Plan]  ║  └─────────────────────────────────────────────────┘  ║
║  [Avg Turn-Around]  ║                                                         ║
║                     ║  ┌─────────────────────────────────────────────────┐  ║
║  [🔄 Refresh]       ║  │ REVENUE PERFORMANCE vs TARGET                   │  ║
║  [📊 Compare]       ║  │  Target: $2.5M  |  Actual: $2.4M  |  -3.8%   │  ║
║                     ║  │  [████████████░░]  94.2% of target             │  ║
║  ⚙️ Settings        ║  └─────────────────────────────────────────────────┘  ║
║  ❓ Help            ║                                                         ║
╠═════════════════════╩═════════════════════════════════════════════════════════╣
║  ✅ Data updated 2 minutes ago   [📊 Export Charts] [🔄 Auto-refresh OFF]   ║
╚═══════════════════════════════════════════════════════════════════════════════╝
```

### Componentes clave:

| Elemento | Descripción | Interacción |
|----------|-----------|---|
| **Time range selector** | Periodo de análisis (30/90/365 días, custom) | Combobox/DatePicker → Filtrar |
| **Gráficas principales** | LineChart (Completion), BarChart (Revenue vs Plan) | Hover → Tooltip con valores exactos |
| **Segmentación** | Filtrar métricas por cliente, tipo, mes | Checkbox/Combobox → Actualizar gráficas |
| **Top performers** | Rankings de clientes por performance | Click → Detalles del cliente |
| **Progress bars** | Visual de cumplimiento vs target | Color: verde (OK), rojo (alerta) |

**Datos de ejemplo:**
- Completion Rate: trending upward ↗ (88% → 95% últimos 30 días)
- Revenue: 94.2% of target (-3.8% gap)
- Top client: Acme Corp (98% completion)

---

## 4. Wireframe: Modal "Add Report"

```
╔────────────────────────────────┐
║  ➕ Create New Report           ║
╠────────────────────────────────╣
║                                ║
║  Client Name *                 ║
║  [Acme Corp________________] ▼ ║  ← Combobox con autocomplete
║                                ║
║  Report Type *                 ║
║  [▼ Monthly ]                  ║  ← Combobox: Monthly/Quarterly/Annual
║                                ║
║  Period (Start - End)          ║
║  [📅 2025-01-01] - [📅 2025-01-31]  ← DatePickers
║                                ║
║  Description (Optional)        ║
║  ┌──────────────────────────┐  ║
║  │ Enter report description │  ║
║  │                          │  ║
║  │                          │  ║
║  └──────────────────────────┘  ║
║                                ║
║  Attachments (Optional)        ║
║  [⬆️ Upload files...]          ║
║  • financial_data.xlsx (2.4MB) ║
║  • analysis.pdf (1.1MB)        ║
║                                ║
║  ┌─────────────────────────┐   ║
║  │ ✅ Create   ❌ Cancel   │   ║
║  └─────────────────────────┘   ║
╚────────────────────────────────╝
```

**Validaciones:**
- `Client Name`: Requerido, autocomplete desde lista
- `Report Type`: Requerido
- `Period`: Requerido, End > Start
- `Description`: Opcional, max 500 chars
- `Attachments`: Opcional, max 5 archivos, max 10MB c/u

---

## 5. Flujo de Navegación (User Journey)

```
┌─────────────────────────────────────────────────────────────────────┐
│                       INICIO DE SESIÓN                              │
└────────────────────┬────────────────────────────────────────────────┘
                     │ Credentials OK
                     ▼
┌─────────────────────────────────────────────────────────────────────┐
│                    DASHBOARD - OVERVIEW (HOME)                      │
│  - Visualiza KPIs rápidos                                           │
│  - Ve últimos reportes                                              │
│  - Filtra por cliente/fecha/tipo                                    │
│  └─ [Ctrl+N] ──────────────────────────────────────────┐            │
│  └─ [Ctrl+E] ───────────────────┐                      │            │
│  └─ [Ctrl+F] ──────┐            │                      │            │
└────────────────────┼────────────┼──────────────────────┼────────────┘
      Ctrl+R         │            │                      │
       Or Click      │            │                      │
   [Detailed Reports]│            │                      │
        │            │            │                      │
        ▼            │            │                      │
┌──────────────────────────────────────────────────────────────────┐
│           DETAILED REPORTS                                        │
│  - Agrupa reportes por mes/año                                   │
│  - Permite expandir/contraer grupos                              │
│  - Editar/Ver detalles de cada reporte                           │
│  - Búsqueda avanzada: by client, amount range, etc.             │
└──────────────────────────────────────────────────────────────────┘
             │ Ctrl+P Or Click [Performance]
             ▼
┌──────────────────────────────────────────────────────────────────┐
│           PERFORMANCE METRICS                                     │
│  - Gráficas de tendencias (LineChart)                            │
│  - Comparison vs targets (BarChart, Progress)                    │
│  - Rankings de clientes                                          │
│  - Segmentación por cliente, tipo, período                       │
└──────────────────────────────────────────────────────────────────┘

┌───────────────────────────┐  ┌──────────────────┐
│   [Ctrl+N] Add Report     │  │ [Ctrl+E] Export  │
│   Modal Form              │  │ CSV/Excel/PDF    │
│   - Client (autocomplete) │  │ - Select range   │
│   - Type (dropdown)       │  │ - Download file  │
│   - Period (date range)   │  │                  │
│   - Description           │  │                  │
│   - Attachments (optional)│  │                  │
└───────────────────────────┘  └──────────────────┘
```

---

## 6. Estados de Interacción

### Loading State (Carga de datos)

```
┌──────────────────────────┐
│ 🔄 Loading data...       │
│  [████████░░░░░░░░░░] 40%│
│                          │
│ (Tabla deshabilitada)    │
└──────────────────────────┘
```

### Empty State (Sin datos)

```
┌──────────────────────────────────┐
│  📭 No data available            │
│                                  │
│  Use filters or create a new     │
│  report to get started.          │
│                                  │
│  [➕ Add Report]                   │
└──────────────────────────────────┘
```

### Error State

```
┌──────────────────────────────────┐
│ ❌ Error loading data             │
│                                  │
│ Unable to fetch reports.         │
│ Please check your connection.    │
│                                  │
│ [🔄 Retry]  [❌ Dismiss]         │
└──────────────────────────────────┘
```

### Success Feedback

```
┌──────────────────────────────────┐
│ ✅ Report created successfully!  │
│                                  │
│ ID: RPT00156                     │
│ [View Details]                   │
└──────────────────────────────────┘
```

---

## 7. Matriz de Accesibilidad

| Elemento | Navegación Tab | Atajo | Foco Visible | ARIA/Labels |
|----------|---|---|---|---|
| Búsqueda | 1️⃣ | Ctrl+F | ✅ | Label clara |
| Botón Add | 2️⃣ | Ctrl+N | ✅ | Label clara |
| Botón Export | 3️⃣ | Ctrl+E | ✅ | Label clara |
| Tab Overview | 4️⃣ | Ctrl+O | ✅ | `role=tab` |
| Tab Reports | 5️⃣ | Ctrl+R | ✅ | `role=tab` |
| Tab Performance | 6️⃣ | Ctrl+P | ✅ | `role=tab` |
| Combobox Cliente | 7️⃣ | N/A | ✅ | Label: "Cliente" |
| DatePicker | 8️⃣ | N/A | ✅ | Label: "Fecha" |
| Tabla | 9️⃣ | ↑↓←→ | ✅ | Headers visibles |
| Paginación | 🔟 | N/A | ✅ | Text descriptivo |

---

## 8. Principios de Diseño Aplicados

### ✅ Jerarquía Visual
- **Tamaño:** Headers > Subtítulos > Cuerpo
- **Color:** Azul (primario) > Gris (secundario)
- **Espacio:** Separación clara entre secciones

### ✅ Consistencia
- Botones siempre en esquinas (top-right, bottom-left)
- Atajo mostrado en tooltip
- Colores significativos: Verde = OK, Rojo = Error, Azul = Acción

### ✅ Feedback Inmediato
- Loading spinner durante operaciones
- Status messages confirmando acciones
- Errores específicos, no genéricos

### ✅ Reducción de Carga Cognitiva
- Métrica visuales grandes (KPIs)
- Búsqueda global siempre visible
- Filtros agrupados en sidebar (out of the way)

### ✅ Accesibilidad
- Navegación por teclado 100%
- Atajos mnemotécnicos (Ctrl+F, Ctrl+N, Ctrl+E)
- Contraste WCAG AA
- Indicadores no solo color

---

## 9. Recomendaciones Post-Wireframe

### ✅ Validación con usuarios
- [ ] Mostrar wireframes a 2-3 analistas financieros
- [ ] Pregunta: ¿Flujo lógico? ¿Faltan opciones?
- [ ] Solicitar feedback en 30 minutos

### ✅ Iteraciones
- [ ] Ajustar orden de filtros si es necesario
- [ ] Considerar agrupar reportes por cliente vs por fecha
- [ ] Validar columnas de tabla (¿Qué datos son críticos?)

### ✅ Siguiente fase (High-Fi)
- Color corporativo: Azul (#3498db) + Verde (#16a085)
- Tipografía: Segoe UI, 12px cuerpo, 16px títulos
- Espacios: 12px padding, 8px gap entre elementos
- Íconos: Usar FontAwesome o Material Icons

---

**Documento generado:** Marzo 2026  
**Versión:** 1.0  
**Estado:** Prêt para implementación en Scene Builder
