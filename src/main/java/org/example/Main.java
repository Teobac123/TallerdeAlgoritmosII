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

        //VUELO 1 CORDOBA -> BUENOS AIRES
        grafo.agregarVuelo("CORDOBA", "BUENOS AIRES", 105000);
        grafo.agregarVuelo("CORDOBA", "BUENOS AIRES", 120000);
        grafo.agregarVuelo("CORDOBA", "BUENOS AIRES", 115000);
        Vuelo vuelo = grafo.buscarVueloMasBarato("CORDOBA", "BUENOS AIRES");
        System.out.println("Vuelo más barato: " + vuelo.getPrecio());
        vuelo.registrarTripulante("Juancito");
        vuelo.registrarTripulante("Anita");
        vuelo.registrarTripulante("Carlito");
        System.out.println("Precio con descuento: " + vuelo.getPrecioConDescuento());
        vuelo.imprimirTripulantes();

        System.out.println("---------------------------------------------------");

        //VUELO 2 JUJUY -> BARILOCHE
        grafo.agregarVuelo("JUJUY", "BARILOCHE", 75000);
        grafo.agregarVuelo("JUJUY", "BARILOCHE", 95000);
        grafo.agregarVuelo("JUJUY", "BARILOCHE", 85000);
        Vuelo vuelo2 = grafo.buscarVueloMasBarato("JUJUY", "BARILOCHE");
        System.out.println("Vuelo más barato: " + vuelo2.getPrecio());
        vuelo2.registrarTripulante("Juan Perez");
        vuelo2.registrarTripulante("Ana Gomez");
        vuelo2.registrarTripulante("Carlos Ruiz");
        System.out.println("Precio con descuento: " + vuelo2.getPrecioConDescuento());
        vuelo2.imprimirTripulantes();
    }
}

