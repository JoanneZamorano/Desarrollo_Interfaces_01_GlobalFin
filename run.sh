#!/bin/bash

# GlobalFin Dashboard - Script de Ejecución
# Este script facilita la compilación y ejecución de la aplicación

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

echo "═══════════════════════════════════════════════════════════"
echo "  GlobalFin Dashboard - Startup Script"
echo "═══════════════════════════════════════════════════════════"
echo ""

# Opciones
case "${1:-run}" in
    run)
        echo "🚀 Compilando e iniciando la aplicación..."
        mvn clean javafx:run
        ;;
    compile)
        echo "📦 Compilando el proyecto..."
        mvn clean compile
        echo "✅ Compilación exitosa"
        ;;
    test)
        echo "🧪 Ejecutando pruebas..."
        mvn test
        ;;
    package)
        echo "📦 Empaquetando JAR..."
        mvn clean package -DskipTests
        echo "✅ JAR generado: target/*.jar"
        ;;
    clean)
        echo "🧹 Limpiando archivos temporales..."
        mvn clean
        rm -rf target/
        echo "✅ Proyecto limpio"
        ;;
    help)
        echo "Uso: ./run.sh [comando]"
        echo ""
        echo "Comandos disponibles:"
        echo "  run       - Compilar e iniciar la aplicación (default)"
        echo "  compile   - Solo compilar"
        echo "  test      - Ejecutar pruebas"
        echo "  package   - Empaquetar en JAR"
        echo "  clean     - Limpiar archivos temporales"
        echo "  help      - Mostrar esta ayuda"
        ;;
    *)
        echo "❌ Comando desconocido: $1"
        echo "Usa './run.sh help' para ver opciones"
        exit 1
        ;;
esac

echo ""
echo "═══════════════════════════════════════════════════════════"
