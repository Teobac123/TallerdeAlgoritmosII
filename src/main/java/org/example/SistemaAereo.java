package org.example;

import org.example.model.GrafoDestinos;
import org.example.model.Tripulante;
import org.example.model.Vuelo;

public class SistemaAereo {
    private GrafoDestinos grafo;

    public SistemaAereo() {
        this.grafo = new GrafoDestinos();
    }

    public void registrarVuelo(String origen, String destino, double precio) {
        grafo.agregarVuelo(origen, destino, precio);
    }

    public void registrarTripulante(String origen, String destino, String nombre, String documento, int asiento) {
        Vuelo vuelo = grafo.buscarVueloMasBarato(origen, destino);
        if (vuelo != null) {
            vuelo.registrarTripulante(new Tripulante(nombre, documento, asiento));
        }
    }

    public Vuelo buscarVueloMasBarato(String origen, String destino) {
        return grafo.buscarVueloMasBarato(origen, destino);
    }

    public void mostrarVuelos() {
        grafo.imprimirVuelos();
    }
}
