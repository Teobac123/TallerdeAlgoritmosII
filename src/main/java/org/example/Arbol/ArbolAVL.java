package org.example.Arbol;

import org.example.model.NodoAVL;
import org.example.model.Tripulante;

public class ArbolAVL {
    private NodoAVL raiz;

    // Método para insertar un tripulante en el árbol AVL
    public void insertar(Tripulante tripulante) {
        raiz = insertarRecursivo(raiz, tripulante);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, Tripulante tripulante) {
        if (nodo == null) return new NodoAVL(tripulante);

        if (tripulante.getAsiento() < nodo.tripulante.getAsiento()) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, tripulante);
        } else if (tripulante.getAsiento() > nodo.tripulante.getAsiento()) {
            nodo.derecho = insertarRecursivo(nodo.derecho, tripulante);
        } else {
            return nodo;
        }

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

    // Método para contar los nodos en el árbol AVL (ocupación)
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRecursivo(nodo.izquierdo) + contarNodosRecursivo(nodo.derecho);
    }

    // Método para imprimir los tripulantes en orden de asientos
    public void imprimirInOrden() {
        imprimirInOrdenRecursivo(raiz);
    }

    private void imprimirInOrdenRecursivo(NodoAVL nodo) {
        if (nodo != null) {
            imprimirInOrdenRecursivo(nodo.izquierdo);
            System.out.println(nodo.tripulante);
            imprimirInOrdenRecursivo(nodo.derecho);
        }
    }

    // Métodos de altura, balance, y rotaciones (como antes)
    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    private int balance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }
}
