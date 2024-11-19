package org.example.model;

import org.example.Arbol.ArbolAVL;
import org.example.model.Tripulante;

public class Vuelo {
    private String origen;
    private String destino;
    private double precioBase;
    private ArbolAVL tripulantes;
    private final int CAPACIDAD_MAXIMA = 10; // Máximo de 10 tripulantes

    public Vuelo(String origen, String destino, double precioBase) {
        this.origen = origen;
        this.destino = destino;
        this.precioBase = precioBase;
        this.tripulantes = new ArbolAVL();
    }

    public void registrarTripulante(Tripulante tripulante) {
        tripulantes.insertar(tripulante);
        ajustarPrecio();
    }

    private void ajustarPrecio() {
        int ocupacion = calcularOcupacion();
        if (ocupacion >= CAPACIDAD_MAXIMA) {
            precioBase *= 0.6;
        } else if (ocupacion >= CAPACIDAD_MAXIMA * 0.7) {
            precioBase *= 0.8;
        } else if (ocupacion >= CAPACIDAD_MAXIMA * 0.5) {
            precioBase *= 0.9;
        }
    }

    public void imprimirTripulantes() {
        tripulantes.imprimirInOrden();
    }

    public int calcularOcupacion() {
        return tripulantes.contarNodos();
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public ArbolAVL getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(ArbolAVL tripulantes) {
        this.tripulantes = tripulantes;
    }

    public int getCAPACIDAD_MAXIMA() {
        return CAPACIDAD_MAXIMA;
    }
}
