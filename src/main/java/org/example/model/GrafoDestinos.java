package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class GrafoDestinos {
    private Map<String, Map<String, Vuelo>> destinos;

    public GrafoDestinos() {
        this.destinos = new HashMap<>();
    }

    public void agregarVuelo(String origen, String destino, double precio) {
        // Asegurar que ambos destinos existen en el grafo
        destinos.putIfAbsent(origen, new HashMap<>());
        destinos.putIfAbsent(destino, new HashMap<>());

        // Agregar el vuelo entre origen y destino
        Vuelo vuelo = new Vuelo(origen, destino, precio);
        destinos.get(origen).put(destino, vuelo);
    }

    public Vuelo buscarVueloMasBarato(String origen, String destino) {
        // Verificar que ambos destinos existen en el grafo
        if (!destinos.containsKey(origen) || !destinos.containsKey(destino)) {
            System.out.println("Origen o destino no encontrado en el grafo.");
            return null;
        }

        // Buscar el vuelo más barato entre los destinos
        Map<String, Vuelo> vuelosDesdeOrigen = destinos.get(origen);
        Vuelo vueloMasBarato = null;
        double precioMinimo = Double.MAX_VALUE;

        for (Vuelo vuelo : vuelosDesdeOrigen.values()) {
            if (vuelo.getDestino().equals(destino) && vuelo.getPrecioBase() < precioMinimo) {
                precioMinimo = vuelo.getPrecioBase();
                vueloMasBarato = vuelo;
            }
        }

        return vueloMasBarato;
    }

    public void imprimirVuelos() {
        for (String origen : destinos.keySet()) {
            for (String destino : destinos.get(origen).keySet()) {
                Vuelo vuelo = destinos.get(origen).get(destino);
                System.out.println(origen + " -> " + destino + " Precio: " + vuelo.getPrecioBase());
                vuelo.imprimirTripulantes();
            }
        }
    }
}
