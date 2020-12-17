/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


public class GestorLogin {
   public static boolean loginCorrecto (String dni, String pass)  {
       Login l = new Login (dni, pass);
       return l.usuarioLogueado();
   }
   
   public static Empleado cargarEmpleado (String dni) {
       return Login.selectEmpleado(dni);
   }
}
