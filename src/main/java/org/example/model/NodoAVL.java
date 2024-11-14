package org.example.model;

public class NodoAVL {
    public Tripulante tripulante;
    public NodoAVL izquierdo;
    public NodoAVL derecho;
    public int altura;

    public NodoAVL(Tripulante tripulante) {
        this.tripulante = tripulante;
        this.altura = 1;
    }
}
