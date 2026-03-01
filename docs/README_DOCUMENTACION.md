# 📚 Índice de Documentación - GlobalFin Dashboard

## 🎯 Busca tu Rol y Comienza Aquí

### 👔 Product Manager / Cliente
**Objetivo:** Entender la visión, validar flujos, aprobar diseño

📖 **Lectura recomendada (orden):**
1. **[QUICK_START_WIREFRAMES.md](QUICK_START_WIREFRAMES.md)** ⭐ (5 min)
   - Acceso rápido a wireframes
   - Atajos de teclado
   - Explicación visual simple
   
2. **[Wireframes_Interactivos.html](Wireframes_Interactivos.html)** (15 min)
   - Prototipo interactivo
   - 5 tabs clickeables
   - Anotaciones de UX
   
3. **[RESUMEN_ENTREGABLES.md](RESUMEN_ENTREGABLES.md)** (10 min)
   - Métrica de proyecto
   - Timeline
   - Status actual
   
4. **[Validacion_Post_Wireframes.md](Validacion_Post_Wireframes.md)** (20 min)
   - Plan de validación
   - Próximos pasos
   - Preguntas para usuarios

**Total tiempo:** ~50 minutos  
**Acción siguiente:** Agendar sesiones de feedback con usuarios

---

### 🎨 Diseñador UI/UX
**Objetivo:** Entender estructura, validar componentes, crear High-Fi

📖 **Lectura recomendada (orden):**
1. **[QUICK_START_WIREFRAMES.md](QUICK_START_WIREFRAMES.md)** (5 min)
   - Contexto rápido
   - Referencia de componentes
   
2. **[Wireframes_Low_Fi.md](Wireframes_Low_Fi.md)** ⭐ (45 min)
   - 4 wireframes de baja fidelidad
   - Matriz de accesibilidad
   - Estados de interacción
   - Principios de diseño
   
3. **[Dashboard_Principal_Design.md](Dashboard_Principal_Design.md)** (20 min)
   - Concepto visual
   - Jerarquía de contenido
   - Decisiones de UX
   
4. **[Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md)** (30 min)
   - Checklist WCAG 2.1 AA
   - Contrastes de color
   - Navegación por teclado
   
5. **[Arquitectura_Tecnica.md](Arquitectura_Tecnica.md)** (15 min - secciones de CSS/Estilos)
   - Estructura de estilos
   - Colores corporativos
   - Responsive design

**Total tiempo:** ~2 horas  
**Entregable:** Mockups de alta fidelidad en Figma + Guía de estilos

---

### 👨‍💻 Desarrollador Frontend (JavaFX)
**Objetivo:** Implementar wireframes, escribir código limpio, respetar especificaciones

📖 **Lectura recomendada (orden):**
1. **[QUICK_START_WIREFRAMES.md](QUICK_START_WIREFRAMES.md)** (5 min)
   - Atajos de teclado
   - Componentes principales
   
2. **[Wireframes_Low_Fi.md](Wireframes_Low_Fi.md)** (40 min)
   - Estructura visual (BorderPane)
   - GridPane para tarjetas
   - TableView con virtualización
   - Flujos de navegación
   
3. **[Arquitectura_Tecnica.md](Arquitectura_Tecnica.md)** ⭐ (60 min)
   - Visión general de capas
   - Patrón MVC con FXML
   - Gestión de hilos (Service/Task)
   - Inyección @FXML
   - Flujos principales
   
4. **Código existente:**
   - [DashboardController.java](../src/main/java/com/globalfin/controller/DashboardController.java)
   - [DashboardPrincipal.fxml](../src/main/resources/fxml/DashboardPrincipal.fxml)
   - [GlobalFinApp.java](../src/main/java/com/globalfin/app/GlobalFinApp.java)
   
5. **[Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md)** (30 min)
   - Tests de teclado
   - Virtualización de TableView
   - Indicadores de carga

**Total tiempo:** ~3 horas  
**Entregable:** Código JavaFX refactorizado + Tests

---

### 🧪 QA / Tester
**Objetivo:** Diseñar test cases, validar accesibilidad, medir rendimiento

📖 **Lectura recomendada (orden):**
1. **[QUICK_START_WIREFRAMES.md](QUICK_START_WIREFRAMES.md)** (5 min)
   - Atajos de teclado
   - Componentes a testear
   
2. **[Wireframes_Interactivos.html](Wireframes_Interactivos.html)** (10 min)
   - Entender flujos visuales
   
3. **[Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md)** ⭐ (60 min)
   - 5 pruebas específicas de accesibilidad
   - 3 pruebas de rendimiento
   - Herramientas recomendadas
   - Matriz de TabOrder
   
4. **[Validacion_Post_Wireframes.md](Validacion_Post_Wireframes.md)** (20 min)
   - Plan de validación
   - Preguntas para usuarios
   
5. **[Dashboard_Principal_Design.md](Dashboard_Principal_Design.md)** (15 min)
   - Especificaciones de UX

**Total tiempo:** ~1.5 horas  
**Entregables:** Test Case document + A11y audit checklist

---

### 📊 Arquitecto / Tech Lead
**Objetivo:** Validar patrones, asegurar escalabilidad, revisar toda la arquitectura

📖 **Lectura recomendada (orden):**
1. **[Dashboard_Principal_Design.md](Dashboard_Principal_Design.md)** (15 min)
   - Justificación tecnológica
   - Selección de JavaFX vs otras opciones
   
2. **[Arquitectura_Tecnica.md](Arquitectura_Tecnica.md)** ⭐ (90 min)
   - Diagrama de capas completo
   - Patrones (MVC, Service Layer)
   - Gestión de hilos
   - Testing strategy
   - Roadmap de 5 fases
   
3. **[Wireframes_Low_Fi.md](Wireframes_Low_Fi.md)** (30 min)
   - Flujos complejos
   - Estados de interacción
   
4. **Código:**
   - [pom.xml](../pom.xml) - Dependencias y plugins
   - [DataService.java](../src/main/java/com/globalfin/service/DataService.java) - Patrón service
   - [DashboardController.java](../src/main/java/com/globalfin/controller/DashboardController.java) - Controlador delgado
   
5. **[Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md)** (45 min)
   - Optimizaciones
   - Testing plan

**Total tiempo:** ~3 horas  
**Acción:** Code review + Architecture approval

---

## 📋 Índice Completo de Documentos

| Documento | Resumen | Audiencia | Duración |
|-----------|---------|----------|----------|
| **QUICK_START_WIREFRAMES.md** | Guía rápida con acceso a wireframes | Todos | 5 min |
| **Wireframes_Interactivos.html** | Prototipo clickeable en navegador | PM, UX, Dev | 15 min |
| **Wireframes_Low_Fi.md** | Wireframes ASCII detallados + especificación | UX, Dev, QA | 45 min |
| **Dashboard_Principal_Design.md** | Concepto visual y justificación UX | PM, UX, Tech Lead | 20 min |
| **Arquitectura_Tecnica.md** | Diseño técnico, patrones, capas | Dev, Tech Lead, Arch | 60-90 min |
| **Accesibilidad_y_Rendimiento.md** | Tests A11y, performance, herramientas | UX, Dev, QA | 45-60 min |
| **Validacion_Post_Wireframes.md** | Plan de mejora, iteraciones, timeline | PM, UX, Dev | 20 min |
| **RESUMEN_ENTREGABLES.md** | Resumen ejecutivo, métricas, estado | PM, Exec, Tech Lead | 10-15 min |

---

## 🔍 Busca por Tema

### 📐 Diseño y UX
- [Wireframes_Low_Fi.md](Wireframes_Low_Fi.md) - Estructura visual
- [Dashboard_Principal_Design.md](Dashboard_Principal_Design.md) - Concepto UX
- [Wireframes_Interactivos.html](Wireframes_Interactivos.html) - Prototipo interactivo
- [Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md) - WCAG 2.1 AA

### 🏗️ Arquitectura Técnica
- [Arquitectura_Tecnica.md](Arquitectura_Tecnica.md) - Diseño completo
- [DashboardController.java](../src/main/java/com/globalfin/controller/DashboardController.java) - Código controlador
- [DataService.java](../src/main/java/com/globalfin/service/DataService.java) - Capa servicios
- [DashboardPrincipal.fxml](../src/main/resources/fxml/DashboardPrincipal.fxml) - Layout XML

### ⌨️ Accesibilidad (A11y)
- [Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md) - Checklist WCAG AA
- [Wireframes_Low_Fi.md](Wireframes_Low_Fi.md#matriz-de-accesibilidad) - Matriz de navegación
- [QUICK_START_WIREFRAMES.md](QUICK_START_WIREFRAMES.md#-atajos-de-teclado-refcard) - Atajos rápidos

### 🚀 Rendimiento
- [Accesibilidad_y_Rendimiento.md](Accesibilidad_y_Rendimiento.md#-pruebas-de-rendimiento) - Tests de carga
- [Arquitectura_Tecnica.md](Arquitectura_Tecnica.md#-rendimiento-y-optimización) - Optimizaciones

### 📊 Navegación y Flujos
- [Wireframes_Low_Fi.md](Wireframes_Low_Fi.md#5-flujo-de-navegación-user-journey) - User journeys
- [Wireframes_Interactivos.html](Wireframes_Interactivos.html) - Flujos visuales (tab "User Flow")

### ✅ Validación
- [Validacion_Post_Wireframes.md](Validacion_Post_Wireframes.md) - Plan de mejora
- [RESUMEN_ENTREGABLES.md](RESUMEN_ENTREGABLES.md) - Checklist de entrega

---

## 🎬 Rutas de Lectura Rapida (Road Maps)

### 📍 Ruta "Entender rápido" (30 min)
```
1. QUICK_START_WIREFRAMES.md (5 min)
2. Wireframes_Interactivos.html (15 min)
3. RESUMEN_ENTREGABLES.md (10 min)
```

### 📍 Ruta "Implementar" (3-4 horas)
```
1. Arquitectura_Tecnica.md (90 min)
2. Wireframes_Low_Fi.md (30 min)
3. DashboardController.java (30 min)
4. Accesibilidad_y_Rendimiento.md (30 min)
```

### 📍 Ruta "Diseñar High-Fi" (2-3 horas)
```
1. Wireframes_Low_Fi.md (45 min)
2. Dashboard_Principal_Design.md (20 min)
3. Wireframes_Interactivos.html (15 min)
4. Accesibilidad_y_Rendimiento.md (30 min)
5. styles.css (15 min)
```

### 📍 Ruta "QA & Testing" (2 horas)
```
1. Accesibilidad_y_Rendimiento.md (60 min)
2. Wireframes_Low_Fi.md (30 min)
3. Validacion_Post_Wireframes.md (20 min)
```

---

## 🎨 Tree de Documentos (Visual)

```
docs/
├── 📖 QUICK_START_WIREFRAMES.md              ← Comienza aquí
├── 📖 RESUMEN_ENTREGABLES.md                 ← Métricas proyecto
│
├── 🎯 DISEÑO & UX
│   ├── Wireframes_Low_Fi.md
│   ├── Wireframes_Interactivos.html
│   ├── Dashboard_Principal_Design.md
│   └── Validacion_Post_Wireframes.md
│
├── 🏗️ ARQUITECTURA TÉCNICA
│   ├── Arquitectura_Tecnica.md
│   └── [Código fuente en src/]
│
├── ♿ ACCESIBILIDAD & RENDIMIENTO
│   └── Accesibilidad_y_Rendimiento.md
│
└── 📚 Este documento (índice)
```

---

## ⏱️ Tiempo Total de Lectura

| Perfil | Min Requerido | Max Recomendado |
|--------|---|---|
| **Product Manager** | 30 min | 60 min |
| **Designer UX** | 60 min | 120 min |
| **Developer Frontend** | 90 min | 180 min |
| **QA/Tester** | 45 min | 90 min |
| **Tech Lead** | 120 min | 200 min |

**Total para equipo completo:** ~15-20 horas repartidas según rol

---

## 🎯 Checklist de Orientación

Después de leer los documentos apropiados para tu rol:

- [ ] Entiendo la estructura general del dashboard
- [ ] Identifiqué qué tengo que hacer (mis responsabilidades)
- [ ] Tengo claro los atajos de teclado principales
- [ ] Conozco los 3 tabs y sus funciones
- [ ] Entiendo los principios de accesibilidad aplicados
- [ ] Puedo explicar la arquitectura / wireframes a otros

---

## 🚀 Próximo Paso

1. **Elige tu rol** (arriba)
2. **Sigue la ruta recomendada**
3. **Abre el primer documento**
4. **¡Comienza hoy!**

---

**Documento de Índice:** Marzo 2026  
**Versión:** 1.0 - Ready to Use  
**Mantenedor:** Team Desarrollo GlobalFin
