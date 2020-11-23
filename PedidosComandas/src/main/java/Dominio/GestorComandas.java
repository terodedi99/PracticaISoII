package Dominio;

import java.util.ArrayList;

public class GestorComandas {
    
    public static ArrayList<Servicio> buscarListaServicios(Empleado empleado) {
            return Comanda.readServicios(empleado);
    } 
}