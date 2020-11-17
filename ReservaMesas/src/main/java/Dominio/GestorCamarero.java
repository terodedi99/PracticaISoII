/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author pikac
 */
public class GestorCamarero {
    public static ArrayList<Empleado> buscarListaCamareros(Restaurante r) {
        return Empleado.readCamareros(r);
    }
}
