/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.Agente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class PagoComanda {
    private int idPagoComanda;
    private Comanda comanda;
    private MetodoPago metPago;

    public PagoComanda(int idPagoComanda, Comanda comanda, MetodoPago metPago) {
        this.idPagoComanda = idPagoComanda;
        this.comanda = comanda;
        this.metPago = metPago;
    }

    public int getIdPagoComanda() {
        return idPagoComanda;
    }

    public void setIdPagoComanda(int idPagoComanda) {
        this.idPagoComanda = idPagoComanda;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public MetodoPago getMetPago() {
        return metPago;
    }

    public void setMetPago(MetodoPago metPago) {
        this.metPago = metPago;
    }
    
    public static ArrayList<Comanda> readListaComandas (Empleado e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Comanda> listaComandas = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                "    \"A4\".\"ID_SERVICIO\"      \"ID_SERVICIO\",\n" +
                "    to_char(\"A4\".\"FECHA_SERVICIO\", 'dd/MM/yyyy') \"FECHA_SERVICIO\",\n" +
                "    \"A2\".\"NOMBRE_TURNO\"     \"TURNO\",\n" +
                "    \"A3\".\"NOMBRE_MESA\"      \"MESA\",\n" +
                "    \"A4\".\"ESTADO\"           \"ESTADO\",\n" +
                "    \"A4\".\"NUM_COMENSALES\"   \"NUM_COMENSALES\",\n" +
                "    \"A1\".\"ID_COMANDA\"       \"ID_COMANDA\",\n" +
                "    \"A1\".\"TOTAL\"            \"TOTAL\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"SERVICIOS_CAMAREROS\"   \"A5\",\n" +
                "    \"ISO2\".\"SERVICIOS\"             \"A4\",\n" +
                "    \"ISO2\".\"MESAS\"                 \"A3\",\n" +
                "    \"ISO2\".\"TURNOS\"                \"A2\",\n" +
                "    \"ISO2\".\"COMANDAS\"              \"A1\"\n" +
                "WHERE\n" +
                "    \"A5\".\"ID_CAMARERO\" = " + e.getIdEmpleado() + "\n" +
                "    AND ( \"A4\".\"ESTADO\" = 'SERVIDOS'\n" +
                "          OR \"A4\".\"ESTADO\" = 'ESPERANDO_LA_CUENTA'\n" +
                "          OR \"A4\".\"ESTADO\" = 'PAGANDO'\n" +
                "          OR \"A4\".\"ESTADO\" = 'EN_PREPARACION' )\n" +
                "    AND \"A5\".\"ID_SERVICIO\" = \"A4\".\"ID_SERVICIO\"\n" +
                "    AND \"A4\".\"ID_MESA\" = \"A3\".\"ID_MESA\"\n" +
                "    AND \"A4\".\"ID_TURNO\" = \"A2\".\"ID_TURNO\"\n" +
                "    AND \"A1\".\"ID_SERVICIO\" = \"A4\".\"ID_SERVICIO\"\n" +
                "ORDER BY\n" +
                "    \"A4\".\"ID_SERVICIO\"";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);
                
                Servicio s = new Servicio(Integer.parseInt(row.get("ID_SERVICIO").toString()), formatter.parse(row.get("FECHA_SERVICIO").toString()), new Turno (0 ,row.get("TURNO").toString()), new Mesa (0, row.get("MESA").toString()), Servicio.Estado.valueOf(row.get("ESTADO").toString()));
                s.setNum_comensales(Integer.parseInt(row.get("NUM_COMENSALES").toString()));
                Comanda c = new Comanda (Integer.parseInt(row.get("ID_COMANDA").toString()), s);
                c.setTotal(Float.parseFloat(row.get("TOTAL").toString()));
                
                listaComandas.add(c);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaComandas;
    }
    
    public static ArrayList<LineaComanda> readLineasComandas (int idComanda) {
        ArrayList<LineaComanda> listaLineas = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                "    \"A2\".\"ID_LINEA_COMANDA\"       \"ID_LINEA_COMANDA\",\n" +
                "    \"A1\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                "    \"A1\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                "    \"A2\".\"CANTIDAD\"               \"CANTIDAD\",\n" +
                "    \"A2\".\"PRECIOVENTA\"            \"PRECIOVENTA\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"LINEAS_COMANDAS\"   \"A2\",\n" +
                "    \"ISO2\".\"PRODUCTOS\"         \"A1\"\n" +
                "WHERE\n" +
                "    \"A2\".\"ID_COMANDA\" = " + idComanda + "\n" +
                "    AND \"A2\".\"ID_PRODUCTO\" = \"A1\".\"ID_PRODUCTO\"\n" +
                "ORDER BY\n" +
                "    \"A2\".\"ID_LINEA_COMANDA\"";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);
                
                Producto p = new Producto (0, row.get("DESCRIPCION_PRODUCTO").toString(), row.get("TIPO_PRODUCTO").toString(), 0.00f);
                LineaComanda l = new LineaComanda(p, Integer.parseInt(row.get("CANTIDAD").toString()), Float.parseFloat(row.get("PRECIOVENTA").toString()));
                l.setIdLineaComanda(Integer.parseInt(row.get("ID_LINEA_COMANDA").toString()));
                
                listaLineas.add(l);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaLineas;
    }
    
    public boolean insert() {
        boolean exito = true;
        
        try {
            String sql = "INSERT INTO COMANDAS_METODOS_PAGO VALUES (SEQ_ID_COMANDAS_METODOS_PAGO.NEXTVAL, " + getComanda().getIdComanda() + "," + getMetPago().getIdMetodoPago() + ")";
            
            Agente a = Agente.getAgente();
            a.insert(sql);    
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
          
        return exito;
    }
    
    public boolean updateComandaPagada () {
        boolean exito = true;
        
        try {
            String sql = "UPDATE COMANDAS SET PAGADO = 1 WHERE ID_COMANDA = " + getComanda().getIdComanda();
            
            Agente a = Agente.getAgente();
            a.update(sql);    
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
          
        return exito;
    }  
}
