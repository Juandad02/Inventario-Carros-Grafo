package com.mycompany.inventario_carros;

import java.util.ArrayList;
import java.util.List;

public class GrafoSucursales {

    // Clase interna para representar las Aristas (Rutas)
    public static class Ruta {
        private Sucursal origen;
        private Sucursal destino;
        private double distanciaKm;

        public Ruta(Sucursal origen, Sucursal destino, double distanciaKm) {
            this.origen = origen;
            this.destino = destino;
            this.distanciaKm = distanciaKm;
        }

        public Sucursal getOrigen() { return origen; }
        public Sucursal getDestino() { return destino; }
        public double getDistanciaKm() { return distanciaKm; }

        @Override
        public String toString() {
            return origen.getNombre() + " <---> " + destino.getNombre() + " (" + distanciaKm + " km)";
        }
    }

    private List<Sucursal> vertices;
    private List<Ruta> aristas;

    public GrafoSucursales() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    // ==========================================
    // OPERACIONES BÁSICAS DE VÉRTICES (SUCURSALES)
    // ==========================================

    // 1. Agregar Vértice
    public void agregarSucursal(Sucursal sucursal) {
        if (buscarSucursal(sucursal.getId()) == null) {
            vertices.add(sucursal);
            System.out.println("Sucursal agregada: " + sucursal.getNombre());
        } else {
            System.out.println("Error: Ya existe una sucursal con el ID " + sucursal.getId());
        }
    }

    // 2. Buscar Vértice por ID
    public Sucursal buscarSucursal(String id) {
        for (Sucursal s : vertices) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // 3. Eliminar Vértice (y sus aristas asociadas)
    public boolean eliminarSucursal(String id) {
        Sucursal aEliminar = buscarSucursal(id);
        if (aEliminar != null) {
            aristas.removeIf(r -> r.getOrigen().equals(aEliminar) || r.getDestino().equals(aEliminar));
            vertices.remove(aEliminar);
            System.out.println("Sucursal eliminada correctamente: " + id);
            return true;
        }
        System.out.println("No se encontró la sucursal con ID: " + id);
        return false;
    }

    // ==========================================
    // OPERACIONES BÁSICAS DE ARISTAS (RUTAS) Y MOSTRAR
    // ==========================================

    // 4. Agregar Arista (Ruta entre dos sucursales)
    public boolean agregarRuta(String idOrigen, String idDestino, double distanciaKm) {
        Sucursal origen = buscarSucursal(idOrigen);
        Sucursal destino = buscarSucursal(idDestino);

        if (origen == null || destino == null) {
            System.out.println("Error: Una o ambas sucursales no existen.");
            return false;
        }

        Ruta nuevaRuta = new Ruta(origen, destino, distanciaKm);
        aristas.add(nuevaRuta);
        System.out.println("Ruta agregada: " + origen.getNombre() + " <---> " + destino.getNombre() + " (" + distanciaKm + " km)");
        return true;
    }

    // 5. Eliminar Arista
    public boolean eliminarRuta(String idOrigen, String idDestino) {
        boolean removida = aristas.removeIf(r ->
            (r.getOrigen().getId().equalsIgnoreCase(idOrigen) && r.getDestino().getId().equalsIgnoreCase(idDestino)) ||
            (r.getOrigen().getId().equalsIgnoreCase(idDestino) && r.getDestino().getId().equalsIgnoreCase(idOrigen))
        );

        if (removida) {
            System.out.println("Ruta eliminada entre " + idOrigen + " y " + idDestino);
        } else {
            System.out.println("No se encontró ruta entre esas sucursales.");
        }
        return removida;
    }

    // 6. Mostrar Grafo Completo
    public void mostrarGrafo() {
        System.out.println("\n========== RED DE SUCURSALES (GRAFO) ==========");
        System.out.println("VÉRTICES (SUCURSALES):");
        for (Sucursal s : vertices) {
            System.out.println("  - " + s);
        }
        System.out.println("\nARISTAS (RUTAS CONECTADAS):");
        if (aristas.isEmpty()) {
            System.out.println("  (No hay rutas registradas)");
        } else {
            for (Ruta r : aristas) {
                System.out.println("  - " + r);
            }
        }
        System.out.println("================================================\n");
    }
}