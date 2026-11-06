package com.mycompany.inventario_carros;

public class Inventario_Carros {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE LA RED DE SUCURSALES (GRAFO) ===");

        // 1. Instanciar el Grafo
        GrafoSucursales redSucursales = new GrafoSucursales();

        // 2. Crear Vértices (Sucursales)
        Sucursal suc1 = new Sucursal("SUC01", "Sede Norte", "Bogotá");
        Sucursal suc2 = new Sucursal("SUC02", "Sede Centro", "Bogotá");
        Sucursal suc3 = new Sucursal("SUC03", "Sede Poblado", "Medellín");

        // 3. Agregar Vértices al Grafo
        System.out.println("\n--- REGISTRANDO SUCURSALES ---");
        redSucursales.agregarSucursal(suc1);
        redSucursales.agregarSucursal(suc2);
        redSucursales.agregarSucursal(suc3);

        // 4. Agregar Aristas (Rutas con distancia)
        System.out.println("\n--- CONECTANDO RUTAS ---");
        redSucursales.agregarRuta("SUC01", "SUC02", 14.5);
        redSucursales.agregarRuta("SUC01", "SUC03", 415.0);

        // 5. Mostrar el Grafo
        redSucursales.mostrarGrafo();

        // 6. Prueba de eliminación de una ruta
        System.out.println("--- PRUEBA DE ELIMINACIÓN ---");
        redSucursales.eliminarRuta("SUC01", "SUC02");
        redSucursales.mostrarGrafo();
    }
}