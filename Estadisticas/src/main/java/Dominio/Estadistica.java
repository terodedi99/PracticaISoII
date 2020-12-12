/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.Agente;
import java.util.ArrayList;
import java.util.HashMap;


public class Estadistica {
    private String nombreId;
    private String tiempoTotal;

    public Estadistica(String nombreId, String tiempoTotal) {
        this.nombreId = nombreId;
        this.tiempoTotal = tiempoTotal;
    }

    public String getNombreId() {
        return nombreId;
    }

    public void setNombreId(String nombreId) {
        this.nombreId = nombreId;
    }

    public String getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(String tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }
    
    public static ArrayList<Estadistica> readEstadisticas (String busqueda) {
        ArrayList<Estadistica> listaEstadisticas = new ArrayList<>();

        try {
            String sql = "";
            switch (busqueda) {
                case "1 1":
                    sql = "SELECT R.NOMBRE_RESTAURANTE \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_TOMA_COMANDAS T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.NOMBRE_RESTAURANTE";
                    break;
                case "1 2":
                    sql = "SELECT R.CIUDAD \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.TOMA_COMANDAS),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\"\n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_TOMA_COMANDAS T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.CIUDAD";
                    break;
                case "2 1":
                    sql = "SELECT R.NOMBRE_RESTAURANTE \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_PREPARACION_COMIDA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.NOMBRE_RESTAURANTE";
                    break;
                case "2 2":
                    sql = "SELECT R.CIUDAD \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_COMIDA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_PREPARACION_COMIDA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.CIUDAD";
                    break;
                case "3 1":
                    sql = "SELECT R.NOMBRE_RESTAURANTE \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_ENTREGA_NOTA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.NOMBRE_RESTAURANTE";
                    break;
                case "3 2":
                    sql = "SELECT R.CIUDAD \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.ENTREGA_NOTA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_ENTREGA_NOTA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.CIUDAD";
                    break;
                case "4 1":
                    sql = "SELECT R.NOMBRE_RESTAURANTE \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_PREPARACION_MESA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.NOMBRE_RESTAURANTE";
                    break;
                case "4 2":
                    sql = "SELECT R.CIUDAD \"NOMBRE\", TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24, 24))||' HORAS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24*60, 60))||' MINUTOS '||TRUNC(MOD(NVL(AVG(T.PREPARACION_MESA),0)*24*60*60, 60)) || ' SEGUNDOS' \"TIEMPO_TOTAL\" \n" +
                        "    FROM RESTAURANTES R INNER JOIN MESAS M ON R.ID_RESTAURANTE = M.ID_RESTAURANTE LEFT OUTER JOIN TIEMPO_PREPARACION_MESA T ON M.ID_MESA = T.ID_MESA\n" +
                        "    GROUP BY R.CIUDAD";
                    break;        
            }

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);
                Estadistica e = new Estadistica (row.get("NOMBRE").toString(), row.get("TIEMPO_TOTAL").toString());
                
                listaEstadisticas.add(e);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaEstadisticas;
    }
}
