/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestorServicioTest {
    
    private static Servicio servicioParaCancelacion;
    
    @Test
    public void test1_ReservaMesa() {
        //Se crean los elementos que necesitamos
        String[] numComensales = {"2", "SELECCIONE NUM COMENSALES"};
        String[] comentarios = {"", "", ""};
        for (int i = 0; i < 20; i++) {
            comentarios[1] = comentarios[1] + "T";
        }
        
        for (int i = 0; i < 125; i++) {
            comentarios[2] = comentarios[2] + "T";
        }
            
        //Buscamos posibles servicios
        ArrayList<Servicio> listaServicios = GestorServicio.buscarListaServicios(new Date(), new Empleado(3, "33333333C", "JEFE", "DE SALA", 926123456, Empleado.Rol.JEFE_DE_SALA, new Restaurante(1)), new Pase(1, "COMIDA"));
        servicioParaCancelacion = listaServicios.get(0);
        
        //Probamos con pairwise
        assertEquals(GestorServicio.reservarServicio(0, numComensales[0], comentarios[0]), false);
        assertEquals(GestorServicio.reservarServicio(listaServicios.get(0).getIdServicio(), numComensales[0], comentarios[1]), true);
        assertEquals(GestorServicio.reservarServicio(0, numComensales[0], comentarios[2]), false);

        //Buscamos posibles servicios
        ArrayList<Servicio> listaServicios2 = GestorServicio.buscarListaServicios(new Date(), new Empleado(3, "33333333C", "JEFE", "DE SALA", 926123456, Empleado.Rol.JEFE_DE_SALA, new Restaurante(1)));
        
        //Continuamos las pruebas
        assertEquals(GestorServicio.reservarServicio(listaServicios2.get(0).getIdServicio(), numComensales[1], comentarios[0]), false);
        assertEquals(GestorServicio.reservarServicio(0, numComensales[1], comentarios[1]), false);
        assertEquals(GestorServicio.reservarServicio(0, numComensales[1], comentarios[2]), false); 
        
        
        //Se comprueba la asignación del número de comensales
        Servicio s = GestorServicio.buscarDatosServicio(servicioParaCancelacion.getIdServicio());
        assertEquals(s.getNum_comensales(), 2);
    }
    
    @Test
    public void test2_CancelarReserva() {
        assertEquals(GestorServicio.cancelarServicio(servicioParaCancelacion.getIdServicio()), true);
    }
    
    /**
     * Test of asignarCamareroAServicio method, of class GestorServicio.
     */
    @Test
    public void test3_AsignarServicioACamarero() {
        //Se crean los elementos que necesitamos
        String[] numComensales = {"2", "SELECCIONE NUM COMENSALES"};
        String[] comentarios = {"", "", ""};
        for (int i = 0; i < 20; i++) {
            comentarios[1] = comentarios[1] + "T";
        }
        
        for (int i = 0; i < 125; i++) {
            comentarios[2] = comentarios[2] + "T";
        }
               
        
        //Buscamos los camareros
        ArrayList<Empleado> listaCamareros = GestorCamarero.buscarListaCamareros(new Restaurante(1));
        
        //Probamos con pairwise
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[0], comentarios[0], listaCamareros.get(0).getIdEmpleado()), false);
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[0], comentarios[1], listaCamareros.get(0).getIdEmpleado()), true);
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[0], comentarios[2], listaCamareros.get(0).getIdEmpleado()), false);
        
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[1], comentarios[0], listaCamareros.get(0).getIdEmpleado()), false);
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[1], comentarios[1], listaCamareros.get(0).getIdEmpleado()), false);
        assertEquals(GestorServicio.asignarCamareroAServicio(0, numComensales[1], comentarios[2], listaCamareros.get(0).getIdEmpleado()), false); 
    } 
}
