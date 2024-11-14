package org.example.Interfaces;

import org.example.model.Vuelo;

public interface ICrearListaDeDestinos {
    void agregarDestino(String nombre);
    void agregarVuelo(String origen, String destino, int precio);
    Vuelo buscarVueloMasBarato(String origen, String destino);
}
