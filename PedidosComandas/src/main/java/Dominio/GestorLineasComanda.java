/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;


public class GestorLineasComanda {
   
    public static ArrayList<LineaComanda> buscarLineasComandaPendientes (int idEmpleado, String rolEmpleado) {
        return LineaComanda.readLineasComandaPendientes(idEmpleado, rolEmpleado);
    }
    
    public static boolean actualizarLineaServida (int idLineaComanda) {
        LineaComanda l = new LineaComanda (idLineaComanda, null, null, 0, 0.00f, 0);
        return l.actualizarEstadoLinea();
    }
    
    public static boolean actualizarEstadoServicio (int idComanda) {
        Comanda c = new Comanda (idComanda, null);   
        return c.updateServicioComanda();    
    }
       
}
