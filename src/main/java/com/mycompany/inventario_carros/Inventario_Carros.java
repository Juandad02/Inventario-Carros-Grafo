package com.mycompany.inventario_carros;

public class Inventario_Carros {

    public static void main(String[] args) {
        ABB inventario = new ABB();

        inventario.insertar(new Nodo(500, "Toyota", "Corolla", 2019, "rojo", 65000000));
        inventario.insertar(new Nodo(300, "Mazda", "CX-5", 2021, "negro", 98000000));
        inventario.insertar(new Nodo(700, "Renault", "Duster", 2018, "gris", 55000000));
        inventario.insertar(new Nodo(250, "Chevrolet", "Spark", 2020, "blanco", 40000000));
        inventario.insertar(new Nodo(400, "Kia", "Rio", 2022, "azul", 52000000));
        inventario.insertar(new Nodo(600, "Ford", "Fiesta", 2017, "plata", 30000000));
        inventario.insertar(new Nodo(800, "Nissan", "Versa", 2023, "blanco", 75000000));

        System.out.println("--- LISTAR ---");
        inventario.listar();

        System.out.println("--- BUSCAR 300 ---");
        Nodo encontrado = inventario.buscar(300);
        System.out.println(encontrado != null ? "Encontrado: " + encontrado.marca + " " + encontrado.linea : "No existe");

        System.out.println("--- SERIAL REPETIDO ---");
        inventario.insertar(new Nodo(500, "Kia", "Picanto", 2022, "azul", 70000000));

        System.out.println("--- ACTUALIZAR 300 ---");
        System.out.println(inventario.actualizar(300, "Mazda", "CX-5", 2021, "azul", 90000000) ? "Actualizado" : "No existe");

        System.out.println("--- ELIMINAR 250 (hoja) ---");
        System.out.println(inventario.eliminar(250) ? "Eliminado" : "No existe");

        System.out.println("--- ELIMINAR 300 (un hijo) ---");
        System.out.println(inventario.eliminar(300) ? "Eliminado" : "No existe");

        System.out.println("--- ELIMINAR 500 (raíz, dos hijos) ---");
        System.out.println(inventario.eliminar(500) ? "Eliminado" : "No existe");

        System.out.println("--- ELIMINAR 999 (no existe) ---");
        System.out.println(inventario.eliminar(999) ? "Eliminado" : "No existe");

        System.out.println("--- LISTAR FINAL ---");
        inventario.listar();
    }
}