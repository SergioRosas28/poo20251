package Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private String id;
    private String libroId;
    private String usuarioId;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;
    private double costoInicial;
    private double multa;

    public Prestamo(String id, String libroId, String usuarioId, LocalDate inicio, LocalDate venc, double costo) {
        this.id = id; this.libroId = libroId; this.usuarioId = usuarioId;
        this.fechaInicio = inicio; this.fechaVencimiento = venc; this.costoInicial = costo;
    }

    // getters / setters
    public String getId(){ return id; }
    public String getLibroId(){ return libroId; }
    public String getUsuarioId(){ return usuarioId; }
    public LocalDate getFechaInicio(){ return fechaInicio; }
    public LocalDate getFechaVencimiento(){ return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate d){ this.fechaVencimiento = d; }
    public LocalDate getFechaDevolucion(){ return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate d){ this.fechaDevolucion = d; }
    public double getCostoInicial(){ return costoInicial; }
    public double getMulta(){ return multa; }
    public void setMulta(double m){ this.multa = m; }

    @Override
    public String toString() {
        return id + " | Libro:" + libroId + " | Usuario:" + usuarioId + " | Inicio:" + fechaInicio + " | Vence:" + fechaVencimiento + " | Dev:" + fechaDevolucion + " | Costo:$" + costoInicial + " | Multa:$" + multa;
    }
}
