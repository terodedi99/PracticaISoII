/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

public class GestorEstadisticas {
    public static ArrayList<Estadistica> buscarEstadisticas (String busqueda) {
        return Estadistica.readEstadisticas(busqueda);
    }
}
