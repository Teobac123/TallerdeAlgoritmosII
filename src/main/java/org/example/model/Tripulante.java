package org.example.model;

public class Tripulante {
    private String nombre;
    private String documento;
    private int asiento;

    public Tripulante(String nombre, String documento, int asiento) {
        this.nombre = nombre;
        this.documento = documento;
        this.asiento = asiento;
    }

    // Implementación del método toString para imprimir detalles del tripulante
    @Override
    public String toString() {
        return "Tripulante{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", asiento=" + asiento +
                '}';
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
}
