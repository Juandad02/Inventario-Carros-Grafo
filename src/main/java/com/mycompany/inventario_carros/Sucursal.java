package com.mycompany.inventario_carros;

public class Sucursal {
    private String id;
    private String nombre;
    private String ciudad;
    private ABB inventario;

    public Sucursal(String id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.inventario = new ABB();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public ABB getInventario() { return inventario; }

    @Override
    public String toString() {
        return "Sucursal [" + id + "] " + nombre + " - " + ciudad;
    }
}