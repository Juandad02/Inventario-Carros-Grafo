package com.mycompany.inventario_carros;

public class Nodo {
    int serial;      // la CLAVE del árbol (no se repite)
    String marca;
    String linea;
    int modelo;      // el año
    String color;
    double precio;

    Nodo izquierdo;  // flecha al hijo con serial menor
    Nodo derecho;    // flecha al hijo con serial mayor

    public Nodo(int serial, String marca, String linea, int modelo, String color, double precio) {
        this.serial = serial;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;

        this.izquierdo = null;
        this.derecho = null;
    }
}