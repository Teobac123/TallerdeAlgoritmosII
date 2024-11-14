package org.example.model;

import java.util.Random;

public class Tripulante {
    private String nombre;
    private int asiento;

    public Tripulante(String nombre) {
        this.nombre = nombre;
        this.asiento = new Random().nextInt(10) + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAsiento() {
        return asiento;
    }
}

