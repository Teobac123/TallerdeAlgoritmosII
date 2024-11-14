package org.example.Interfaces;

import org.example.model.Tripulante;

import java.util.List;

public interface ICargarTripulantes {
    void registrarTripulante(String nombre);
    List<Tripulante> obtenerTripulantes();
}
