package Dominio;

import java.util.ArrayList;

public class GestorProducto {
    
    public static ArrayList<Producto> buscarProductos() {
        return Producto.readProductos();
    } 
    
}