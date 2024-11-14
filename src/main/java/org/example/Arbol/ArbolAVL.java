package org.example.Arbol;

import org.example.Interfaces.ICargarTripulantes;
import org.example.model.NodoAVL;
import org.example.model.Tripulante;

import java.util.ArrayList;
import java.util.List;

public class ArbolAVL implements ICargarTripulantes {
    private NodoAVL raiz;

    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    private int balance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        y.izquierdo = x.derecho;
        x.derecho = y;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        x.derecho = y.izquierdo;
        y.izquierdo = x;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        return y;
    }

    private NodoAVL insertar(NodoAVL nodo, Tripulante tripulante) {
        if (nodo == null) return new NodoAVL(tripulante);

        if (tripulante.getAsiento() < nodo.tripulante.getAsiento())
            nodo.izquierdo = insertar(nodo.izquierdo, tripulante);
        else if (tripulante.getAsiento() > nodo.tripulante.getAsiento())
            nodo.derecho = insertar(nodo.derecho, tripulante);
        else return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = balance(nodo);

        if (balance > 1 && tripulante.getAsiento() < nodo.izquierdo.tripulante.getAsiento())
            return rotacionDerecha(nodo);
        if (balance < -1 && tripulante.getAsiento() > nodo.derecho.tripulante.getAsiento())
            return rotacionIzquierda(nodo);
        if (balance > 1 && tripulante.getAsiento() > nodo.izquierdo.tripulante.getAsiento()) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && tripulante.getAsiento() < nodo.derecho.tripulante.getAsiento()) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    @Override
    public void registrarTripulante(String nombre) {
        Tripulante tripulante = new Tripulante(nombre);
        raiz = insertar(raiz, tripulante);
    }

    @Override
    public List<Tripulante> obtenerTripulantes() {
        List<Tripulante> tripulantes = new ArrayList<>();
        inorder(raiz, tripulantes);
        return tripulantes;
    }

    private void inorder(NodoAVL nodo, List<Tripulante> tripulantes) {
        if (nodo != null) {
            inorder(nodo.izquierdo, tripulantes);
            tripulantes.add(nodo.tripulante);
            inorder(nodo.derecho, tripulantes);
        }
    }
}
