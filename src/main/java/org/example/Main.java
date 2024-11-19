package org.example;

import org.example.SistemaAereo;
import org.example.model.Tripulante;
import org.example.model.Vuelo;

public class Main {
    public static void main(String[] args) {

        SistemaAereo sistema = new SistemaAereo();



        sistema.registrarVuelo("CORDOBA", "BUENOS AIRES", 105000);
        sistema.registrarVuelo("CORDOBA", "BUENOS AIRES", 120000);
        sistema.registrarVuelo("CORDOBA", "BUENOS AIRES", 115000);


        System.out.println("Vuelos registrados entre CORDOBA y BUENOS AIRES:");
        sistema.mostrarVuelos();


        Vuelo vueloBarato1 = sistema.buscarVueloMasBarato("CORDOBA", "BUENOS AIRES");
        if (vueloBarato1 != null) {
            System.out.println("Vuelo más barato de CORDOBA a BUENOS AIRES seleccionado: $" + vueloBarato1.getPrecioBase());


            vueloBarato1.registrarTripulante(new Tripulante("Juancito", "12345678", 1));
            vueloBarato1.registrarTripulante(new Tripulante("Anita", "87654321", 2));
            vueloBarato1.registrarTripulante(new Tripulante("Carlito", "11223344", 3));
            vueloBarato1.registrarTripulante(new Tripulante("Marcelo", "11443344", 4));
            vueloBarato1.registrarTripulante(new Tripulante("Maria Laura", "32424442", 5));
            vueloBarato1.registrarTripulante(new Tripulante("Clara", "99213992", 6));
            vueloBarato1.registrarTripulante(new Tripulante("Jaime", "73248492", 7));



            System.out.println("Precio con descuento por ocupación: $" + vueloBarato1.getPrecioBase());
            System.out.println("Tripulantes registrados en el vuelo de CORDOBA a BUENOS AIRES:");
            vueloBarato1.imprimirTripulantes();
        } else {
            System.out.println("No se encontró un vuelo de CORDOBA a BUENOS AIRES.");
        }

        System.out.println("---------------------------------------------------");


        sistema.registrarVuelo("JUJUY", "BARILOCHE", 75000);
        sistema.registrarVuelo("JUJUY", "BARILOCHE", 95000);
        sistema.registrarVuelo("JUJUY", "BARILOCHE", 85000);


        System.out.println("Vuelos registrados entre JUJUY y BARILOCHE:");
        sistema.mostrarVuelos();


        Vuelo vueloBarato2 = sistema.buscarVueloMasBarato("JUJUY", "BARILOCHE");
        if (vueloBarato2 != null) {
            System.out.println("Vuelo más barato de JUJUY a BARILOCHE seleccionado: $" + vueloBarato2.getPrecioBase());


            vueloBarato2.registrarTripulante(new Tripulante("Juan Perez", "33445566", 1));
            vueloBarato2.registrarTripulante(new Tripulante("Ana Gomez", "66778899", 2));
            vueloBarato2.registrarTripulante(new Tripulante("Carlos Ruiz", "55667788", 3));


            System.out.println("Precio con descuento por ocupación: $" + vueloBarato2.getPrecioBase());
            System.out.println("Tripulantes registrados en el vuelo de JUJUY a BARILOCHE:");
            vueloBarato2.imprimirTripulantes();
        } else {
            System.out.println("No se encontró un vuelo de JUJUY a BARILOCHE.");
        }
    }
}
