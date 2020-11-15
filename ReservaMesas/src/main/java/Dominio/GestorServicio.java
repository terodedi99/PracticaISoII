package Dominio;

import java.util.ArrayList;
import java.util.Date;

public class GestorServicio {
  
	public static void reservarServicio(Date fecha, int turno, int numComensales, int mesa, String comentarios) {
		// TODO - implement Gestor_Servicio.reservarServicio
		throw new UnsupportedOperationException();
	}

	public static void cancelarServicio(Date fecha, int turno, int mesa) {
		// TODO - implement Gestor_Servicio.cancelarServicio
		throw new UnsupportedOperationException();
	}

	public static void asignarCamareroAServicio(Date fecha, int turno, int mesa, int camarero) {
		// TODO - implement Gestor_Servicio.asignarCamareroAServicio
		throw new UnsupportedOperationException();
	}
        
        public static ArrayList<Servicio> buscarListaServicios(Date fecha, Empleado empleado) {
            return Servicio.readServicios(fecha, empleado);
        }
        
        public static ArrayList<Servicio> buscarListaServicios(Date fecha, Empleado empleado, Pase pase) {
            return Servicio.readServicios(fecha, empleado, pase);
        }
}