package org.example.model;

import org.example.Arbol.ArbolAVL;

import java.util.List;

public class Vuelo {
    private String origen, destino;
    private int precio;
    private ArbolAVL tripulantes = new ArbolAVL();

    public Vuelo(String origen, String destino, int precio) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
    }

    public void registrarTripulante(String nombre) {
        tripulantes.registrarTripulante(nombre);
        actualizarPrecio();
    }

    private void actualizarPrecio() {
        int ocupacion = tripulantes.obtenerTripulantes().size();
        if (ocupacion >= 7) precio *= 0.6;
        else if (ocupacion >= 5) precio *= 0.8;
        else if (ocupacion >= 3) precio *= 0.9;
    }

    public int getPrecioConDescuento() {
        return precio;
    }


    public void imprimirTripulantes() {
        List<Tripulante> listaTripulantes = tripulantes.obtenerTripulantes();
        System.out.println("Tripulantes del vuelo " + origen+ " a " + destino + ":");
        for (Tripulante t : listaTripulantes) {
            System.out.println("Asiento " + t.getAsiento() + ": " + t.getNombre());
        }
    }


        @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'';
    }
}

