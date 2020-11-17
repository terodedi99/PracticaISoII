package Dominio;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class GestorServicio {
  
	public static boolean reservarServicio(int idServicio, String numComensales, String comentarios) {
            boolean exito;
            
            try {
                int num_comensales = Integer.parseInt(numComensales);
                if (comentarios.length() > 0 && comentarios.length() < 120) {
                    Servicio s = new Servicio (idServicio, num_comensales, comentarios);
                    s.setEstado(Servicio.Estado.valueOf("RESERVADA"));
                    exito = s.update();
                } else {
                    JOptionPane.showMessageDialog(null, "EL COMENTARIO NO PUEDE SER VACIO Y NO SOBREPASAR LOS 120 CARACTERES", "ERROR", JOptionPane.ERROR_MESSAGE);
                    exito = false;
                }    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR EL NUMERO DE COMENSALES", "ERROR", JOptionPane.ERROR_MESSAGE);
                exito = false;
            }
            
            return exito;
	}

	public static boolean cancelarServicio(int idServicio) {
            boolean exito;
            
            Servicio s = new Servicio (idServicio, 0, " ");
            s.setEstado(Servicio.Estado.valueOf("LIBRE"));
            exito = s.update();
            
            return exito;
	}

	public static boolean asignarCamareroAServicio(int idServicio, String numComensales, String comentarios, int idCamarero) {
            boolean exito;
            
            try {
                int num_comensales = Integer.parseInt(numComensales);
                if (comentarios.length() > 0 && comentarios.length() < 120) {
                    Servicio s = new Servicio (idServicio, num_comensales, comentarios);
                    s.setEstado(Servicio.Estado.valueOf("OCUPADA"));
                    
                    Empleado e = new Empleado (idCamarero, "", "", "");
                    s.setnEmpleado(e);
                    
                    exito = s.update() && s.insertServicioCamarero();
                } else {
                    JOptionPane.showMessageDialog(null, "EL COMENTARIO NO PUEDE SER VACIO Y NO SOBREPASAR LOS 120 CARACTERES", "ERROR", JOptionPane.ERROR_MESSAGE);
                    exito = false;
                }    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR EL NUMERO DE COMENSALES", "ERROR", JOptionPane.ERROR_MESSAGE);
                exito = false;
            }
            
            return exito;
	}
        
        public static ArrayList<Servicio> buscarListaServicios(Date fecha, Empleado empleado) {
            return Servicio.readServicios(fecha, empleado);
        }
        
        public static ArrayList<Servicio> buscarListaServicios(Date fecha, Empleado empleado, Pase pase) {
            return Servicio.readServicios(fecha, empleado, pase);
        }
        
        public static Servicio buscarDatosServicio (int idServicio) {           
            Servicio s = new Servicio (idServicio, 0, "");
            s.select();
            
            return s;
        }
}