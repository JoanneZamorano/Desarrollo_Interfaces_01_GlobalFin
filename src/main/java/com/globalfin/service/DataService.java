package com.globalfin.service;

import java.time.LocalDate;
import java.util.*;

/**
 * Servicio de acceso a datos para reportes financieros.
 * 
 * Nota: Esta es una implementación stub. En producción, connected a:
 * - PostgreSQL/MySQL
 * - REST API
 * - MongoDB
 * 
 * Ventajas de esta capa:
 * - Desacoplamiento: Controller no conoce detalles de BD
 * - Testabilidad: Fácil de mockear en tests
 * - Mantenibilidad: Cambios en BD sin afectar UI
 */
public class DataService {

    /**
     * Obtiene todos los reportes con filtros opcionales.
     */
    public List<ReportDTO> getReports(
            String clientFilter,
            LocalDate dateFilter,
            String typeFilter,
            int page,
            int rowsPerPage) {
        
        // TODO: Implementar conexión a base de datos
        // return reportRepository.findAll(clientFilter, dateFilter, typeFilter)
        //    .stream()
        //    .skip((long) (page - 1) * rowsPerPage)
        //    .limit(rowsPerPage)
        //    .collect(Collectors.toList());
        
        return generateMockData(rowsPerPage);
    }

    /**
     * Obtiene métricas del dashboard.
     */
    public DashboardMetrics getMetrics(String tab) {
        // TODO: Calcular desde BD
        return new DashboardMetrics(
            1245,      // totalReports
            2_400_000, // revenue
            94.2,      // completionRate
            "Recent data loaded successfully"
        );
    }

    /**
     * Exporta datos a archivo (CSV, Excel, PDF).
     */
    public void exportData(String format, List<ReportDTO> reports) {
        // TODO: Implementar exportación
        switch (format.toUpperCase()) {
            case "CSV" -> System.out.println("Exporting to CSV...");
            case "XLSX" -> System.out.println("Exporting to Excel...");
            case "PDF" -> System.out.println("Exporting to PDF...");
            default -> throw new IllegalArgumentException("Format not supported: " + format);
        }
    }

    /**
     * Crea un nuevo reporte.
     */
    public void createReport(ReportDTO report) {
        // TODO: Guardar en BD
        System.out.println("Creating report: " + report.getClientName());
    }

    /**
     * Genera datos de prueba (mock).
     */
    private List<ReportDTO> generateMockData(int count) {
        List<ReportDTO> data = new ArrayList<>();
        String[] clients = {"Acme Corp", "Global Industries", "Tech Solutions", "Finance Plus", "Market Leaders"};
        String[] statuses = {"Completed", "Pending", "In Progress", "On Hold"};
        String[] types = {"Monthly", "Quarterly", "Annual", "Custom"};

        for (int i = 1; i <= count; i++) {
            ReportDTO report = new ReportDTO();
            report.setId("RPT" + String.format("%05d", i));
            report.setClientName(clients[(i - 1) % clients.length]);
            report.setCreatedDate(LocalDate.now().minusDays(i % 30));
            report.setAmount(10000 + i * 500);
            report.setStatus(statuses[(i - 1) % statuses.length]);
            report.setType(types[(i - 1) % types.length]);
            data.add(report);
        }
        return data;
    }

    /**
     * DTO para reportes financieros.
     */
    public static class ReportDTO {
        private String id;
        private String clientName;
        private LocalDate createdDate;
        private long amount;
        private String status;
        private String type;

        public ReportDTO() {}

        // Getters y Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getClientName() { return clientName; }
        public void setClientName(String clientName) { this.clientName = clientName; }

        public LocalDate getCreatedDate() { return createdDate; }
        public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

        public long getAmount() { return amount; }
        public void setAmount(long amount) { this.amount = amount; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        @Override
        public String toString() {
            return "ReportDTO{" +
                    "id='" + id + '\'' +
                    ", clientName='" + clientName + '\'' +
                    ", amount=" + amount +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    /**
     * DTO para métricas del dashboard.
     */
    public static class DashboardMetrics {
        private int totalReports;
        private long revenue;
        private double completionRate;
        private String lastUpdate;

        public DashboardMetrics(int totalReports, long revenue, double completionRate, String lastUpdate) {
            this.totalReports = totalReports;
            this.revenue = revenue;
            this.completionRate = completionRate;
            this.lastUpdate = lastUpdate;
        }

        public int getTotalReports() { return totalReports; }
        public long getRevenue() { return revenue; }
        public double getCompletionRate() { return completionRate; }
        public String getLastUpdate() { return lastUpdate; }
    }
}
