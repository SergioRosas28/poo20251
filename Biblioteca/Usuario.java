package Biblioteca;

public class Usuario {
    private String id;
    private String nombre;
    private boolean socio;
    private double deuda = 0.0;

    public Usuario(String id, String nombre, boolean socio) {
        this.id = id; this.nombre = nombre; this.socio = socio;
    }
    // getters / setters
    public String getId(){ return id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String n){ this.nombre = n; }
    public boolean isSocio(){ return socio; }
    public double getDeuda(){ return deuda; }
    public void setDeuda(double d){ this.deuda = d; }

    @Override
    public String toString(){ return id + " | " + nombre + " | " + (socio ? "SOCIO" : "NORMAL") + " | Deuda: $" + deuda; }
}