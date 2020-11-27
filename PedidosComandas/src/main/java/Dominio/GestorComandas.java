package Dominio;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorComandas {
    
    public static ArrayList<Servicio> buscarListaServicios(Empleado empleado) {
            return Comanda.readServicios(empleado);
    }
    
    public static boolean cambiarEstadoServicio (int idServicio, String estado) {
        boolean exito = true;
        
        Servicio s = new Servicio(idServicio, 0, "");
        s.setEstado(Servicio.Estado.valueOf(estado));
        
        Comanda comanda = new Comanda(s);
        exito = exito && comanda.updateServicio();
        
        return exito;
    }
    
    public static boolean insertarComanda (Comanda comanda, ArrayList<LineaComanda> lineasComanda) {
        boolean exito = true; int lineaComanda = 0;
        
        try {
            for (int i = 0; i < lineasComanda.size() && exito; i++) {
                exito = exito && lineasComanda.get(i).comprobarStockSuficiente();
                lineaComanda = i;
            }
            
            if (exito) {
                exito = exito && comanda.insert();
                
                if (!exito) {
                    JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LA COMANDA", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < lineasComanda.size() && exito; i++) {
                        exito = exito && lineasComanda.get(i).insert();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY STOCK DE " + lineasComanda.get(lineaComanda).getnLinea().getDescripcionProducto(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        
        return exito;
    }
    
    public static boolean actualizarStock (ArrayList<LineaComanda> lineasComanda) {
        boolean exito = true;
        
        try {
            for (int i = 0; i < lineasComanda.size(); i++) {
                lineasComanda.get(i).actualizarStock();
            }
        
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        
        return exito;
    }
}