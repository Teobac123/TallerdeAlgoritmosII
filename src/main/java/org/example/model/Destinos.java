package org.example.model;

import org.example.Interfaces.ICrearListaDeDestinos;

import java.util.HashMap;
import java.util.Map;

/*
public class Destinos implements ICrearListaDeDestinos {
    private Map<String, Map<String, Vuelo>> destinos = new HashMap<>();

    @Override
    public void agregarDestino(String nombre) {
        destinos.putIfAbsent(nombre, new HashMap<>());
    }

    @Override
    public void agregarVuelo(String origen, String destino, int precio) {
        destinos.putIfAbsent(origen, new HashMap<>());
        Map<String, Vuelo> vuelosDesdeOrigen = destinos.get(origen);

        if (vuelosDesdeOrigen.containsKey(destino)) {
            Vuelo vueloExistente = vuelosDesdeOrigen.get(destino);
            if (precio < vueloExistente.getPrecioConDescuento()) {
                vuelosDesdeOrigen.put(destino, new Vuelo(origen, destino, precio));
            }
        } else {
            vuelosDesdeOrigen.put(destino, new Vuelo(origen, destino, precio));
        }
    }

    @Override
    public Vuelo buscarVueloMasBarato(String origen, String destino) {
        return destinos.getOrDefault(origen, new HashMap<>()).get(destino);
    }


}
        */
