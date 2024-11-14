package org.example;

import org.example.model.Destinos;
import org.example.model.Vuelo;

public class Main {
    public static void main(String[] args) {
        Destinos grafo = new Destinos();
        grafo.agregarDestino("CORDOBA");
        grafo.agregarDestino("BUENOS AIRES");
        grafo.agregarDestino("JUJUY");
        grafo.agregarDestino("BARILOCHE");
        grafo.agregarDestino("MISIONES");
        grafo.agregarDestino("SALTA");
        grafo.agregarDestino("TUCUMAN");
        grafo.agregarDestino("SANTACRUZ");
        grafo.agregarVuelo("CORDOBA", "BUENOS AIRES", 120000);

        Vuelo vuelo = grafo.buscarVueloMasBarato("CORDOBA", "BUENOS AIRES");

        vuelo.registrarTripulante("Juan Perez");
        vuelo.registrarTripulante("Ana Gomez");
        vuelo.registrarTripulante("Carlos Ruiz");

        System.out.println("Precio con descuento: " + vuelo.getPrecioConDescuento());
        vuelo.imprimirTripulantes();
    }
}

