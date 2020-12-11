/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

public class GestorPagoComanda {
    public static ArrayList<Comanda> buscarListaComandas (Empleado e) {
        return PagoComanda.readListaComandas(e);
    }
    
    public static ArrayList<LineaComanda> buscarLineasComanda (int idComanda) {
        return PagoComanda.readLineasComandas(idComanda);
    }
    
    public static boolean guardarPagoComanda (int idComanda, int idServicio, MetodoPago metodo) {
        boolean exito = true;
        
        Servicio s = new Servicio(idServicio, 0, ""); s.setEstado(Servicio.Estado.EN_PREPARACION);
        Comanda c = new Comanda (idComanda, 0.00f, 0); c.setServicio(s); 
        PagoComanda p = new PagoComanda (0, c, metodo);
        
        exito = exito && p.insert();
        if (exito) {
            exito = exito && p.updateComandaPagada();
            if (exito) {
                c.updateServicio();
            }
        }
        
        return exito;
    }
}
