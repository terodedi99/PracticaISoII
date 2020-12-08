/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.Date;

public class GestorAlmacen {
 
    public static ArrayList<Producto> readProductosCantidad (Date fecha, Empleado empleado) {
        return Almacen.selectProductosCantidad (fecha, empleado);
    }
    
    public static ArrayList<Elaboracion> readElaboracionesProducto (int idProducto) {
        return Almacen.selectElaboracionesProducto(idProducto);
    }
    
    public static boolean incrementarStockIngredientes (Restaurante r, int idProducto, int incrementoStock) {
        Almacen a = new Almacen (r);
        return a.updateIngredientesRestaurante(idProducto, incrementoStock);
    } 
}
