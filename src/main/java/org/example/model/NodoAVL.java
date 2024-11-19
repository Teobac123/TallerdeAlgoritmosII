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

    public Tripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
