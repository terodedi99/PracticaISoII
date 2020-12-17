/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.Agente;
import java.util.ArrayList;
import java.util.HashMap;


public class Login {
    
    private String dni;
    private String password;

    public Login(String dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean usuarioLogueado () {
        boolean exito = false;
        
        try {
            String sql = "SELECT\n" +
                "    COUNT(*) \"LOGIN\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"EMPLEADOS\" \"A1\"\n" +
                "WHERE\n" +
                "    \"A1\".\"DNI\" = '" + getDni() + "'\n" +
                "    AND \"A1\".\"PASS\" = standard_hash('" + getPassword() + "', 'MD5')";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            HashMap row = (HashMap) result.get(0);   
            if (Integer.parseInt(row.get("LOGIN").toString()) == 1) {
                exito = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        
        return exito;
    }
    
    public static Empleado selectEmpleado (String dni) {
        Empleado e = null;
        
        try {
            String sql = "SELECT ID_EMPLEADO, DNI, NOMBRE, APELLIDOS, TFNO_CONTACTO, ROL, ID_RESTAURANTE FROM EMPLEADOS WHERE DNI = '" + dni + "'";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            HashMap row = (HashMap) result.get(0);   
            e = new Empleado (Integer.parseInt(row.get("ID_EMPLEADO").toString()), row.get("DNI").toString(), row.get("NOMBRE").toString(), row.get("APELLIDOS").toString(), Long.parseLong(row.get("TFNO_CONTACTO").toString()), Empleado.Rol.valueOf(row.get("ROL").toString()), new Restaurante(Integer.parseInt(row.get("ID_RESTAURANTE").toString())));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return e;
    }
}
