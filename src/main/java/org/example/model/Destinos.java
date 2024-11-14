package org.example.model;

import org.example.Interfaces.ICrearListaDeDestinos;

import java.util.HashMap;
import java.util.Map;

public class Destinos implements ICrearListaDeDestinos {
    private Map<String, Map<String, Vuelo>> destinos = new HashMap<>();

    @Override
    public void agregarDestino(String nombre) {
        destinos.putIfAbsent(nombre, new HashMap<>());
    }

    @Override
    public void agregarVuelo(String origen, String destino, int precio) {
        Vuelo vuelo = new Vuelo(origen, destino, precio);
        destinos.get(origen).put(destino, vuelo);
    }

    @Override
    public Vuelo buscarVueloMasBarato(String origen, String destino) {
        return destinos.getOrDefault(origen, new HashMap<>()).get(destino);
    }
}

