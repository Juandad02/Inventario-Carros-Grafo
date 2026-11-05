package com.mycompany.inventario_carros;

public class ABB {
    Nodo raiz;   // punto de entrada al árbol (null = árbol vacío)

    public ABB() {
        this.raiz = null;
    }

    // ---------- INSERTAR ----------
    public void insertar(Nodo nuevo) {
        raiz = insertarRec(raiz, nuevo);
    }

    private Nodo insertarRec(Nodo actual, Nodo nuevo) {
        if (actual == null) {                       // CASO BASE
            return nuevo;
        }
        if (nuevo.serial < actual.serial) {
            actual.izquierdo = insertarRec(actual.izquierdo, nuevo);
        } else if (nuevo.serial > actual.serial) {
            actual.derecho = insertarRec(actual.derecho, nuevo);
        } else {
            System.out.println("Serial ya registrado");
        }
        return actual;
    }

    // ---------- BUSCAR ----------
    public Nodo buscar(int serial) {
        return buscarRec(raiz, serial);
    }

    private Nodo buscarRec(Nodo actual, int serial) {
        if (actual == null) {                       // no existe
            return null;
        }
        if (serial == actual.serial) {              // encontrado
            return actual;
        }
        if (serial < actual.serial) {
            return buscarRec(actual.izquierdo, serial);
        }
        return buscarRec(actual.derecho, serial);
    }

    // ---------- LISTAR (recorrido inorden) ----------
    public void listar() {
        if (raiz == null) {
            System.out.println("Inventario vacío");
            return;
        }
        listarRec(raiz);
    }

    private void listarRec(Nodo actual) {
        if (actual == null) {
            return;
        }
        listarRec(actual.izquierdo);                // 1) lo menor
        System.out.printf("%d | %s | %s | %d | %s | $%,.0f%n",
                actual.serial, actual.marca, actual.linea,
                actual.modelo, actual.color, actual.precio);   // 2) el nodo
        listarRec(actual.derecho);                  // 3) lo mayor
    }

    // ---------- ACTUALIZAR ----------
    public boolean actualizar(int serial, String marca, String linea,
                              int modelo, String color, double precio) {
        Nodo nodo = buscar(serial);
        if (nodo == null) {
            return false;
        }
        nodo.marca = marca;
        nodo.linea = linea;
        nodo.modelo = modelo;
        nodo.color = color;
        nodo.precio = precio;
        return true;
    }

    // ---------- ELIMINAR ----------
    public boolean eliminar(int serial) {
        if (buscar(serial) == null) {
            return false;                           // no existe
        }
        raiz = eliminarRec(raiz, serial);
        return true;
    }

    private Nodo eliminarRec(Nodo actual, int serial) {
        if (actual == null) {
            return null;
        }
        if (serial < actual.serial) {
            actual.izquierdo = eliminarRec(actual.izquierdo, serial);
        } else if (serial > actual.serial) {
            actual.derecho = eliminarRec(actual.derecho, serial);
        } else {
            // Encontré el nodo a eliminar
            if (actual.izquierdo == null) {         // CASO 1 y 2: hoja o solo hijo derecho
                return actual.derecho;
            }
            if (actual.derecho == null) {           // CASO 2: solo hijo izquierdo
                return actual.izquierdo;
            }
            // CASO 3: dos hijos -> buscar el sucesor (el menor del lado derecho)
            Nodo sucesor = actual.derecho;
            while (sucesor.izquierdo != null) {
                sucesor = sucesor.izquierdo;
            }
            // copiar los datos del sucesor en este nodo
            actual.serial = sucesor.serial;
            actual.marca = sucesor.marca;
            actual.linea = sucesor.linea;
            actual.modelo = sucesor.modelo;
            actual.color = sucesor.color;
            actual.precio = sucesor.precio;
            // eliminar el sucesor de su posición original
            actual.derecho = eliminarRec(actual.derecho, sucesor.serial);
        }
        return actual;
    }
}