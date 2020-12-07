/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.Agente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Almacen {
    
    private int idAlmacenIngrediente;
    private Ingrediente ingrediente;
    private Restaurante restaurante;
    private int cantidad;

    public Almacen(int idAlmacenIngrediente, Ingrediente ingrediente, Restaurante restaurante, int cantidad) {
        this.idAlmacenIngrediente = idAlmacenIngrediente;
        this.ingrediente = ingrediente;
        this.restaurante = restaurante;
        this.cantidad = cantidad;
    }

    public int getIdAlmacenIngrediente() {
        return idAlmacenIngrediente;
    }

    public void setIdAlmacenIngrediente(int idAlmacenIngrediente) {
        this.idAlmacenIngrediente = idAlmacenIngrediente;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public static ArrayList<Producto> selectProductosCantidad (Date fecha, Empleado e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                "    \"A1\".\"ID_PRODUCTO\"            \"ID_PRODUCTO\",\n" +
                "    \"A1\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                "    \"A1\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                "    (\n" +
                "        SELECT\n" +
                "            nvl(SUM(\"A4\".\"CANTIDAD\"), 0) \"NVL(SUM(L.CANTIDAD),0)\"\n" +
                "        FROM\n" +
                "            \"ISO2\".\"LINEAS_COMANDAS\"   \"A4\",\n" +
                "            \"ISO2\".\"COMANDAS\"          \"A3\",\n" +
                "            \"ISO2\".\"SERVICIOS\"         \"A2\",\n" +
                "            \"ISO2\".\"MESAS\"             \"A5\"\n" +
                "        WHERE\n" +
                "            \"A5\".\"ID_MESA\" = \"A2\".\"ID_MESA\"\n" +
                "            AND \"A4\".\"ID_PRODUCTO\" = \"A1\".\"ID_PRODUCTO\"\n" +
                "            AND \"A3\".\"ID_COMANDA\" = \"A4\".\"ID_COMANDA\"\n" +
                "            AND \"A3\".\"ID_SERVICIO\" = \"A2\".\"ID_SERVICIO\"\n" +
                "            AND \"A2\".\"FECHA_SERVICIO\" = '" + formatter.format(fecha) + "'\n" +
                "            AND \"A5\".\"ID_RESTAURANTE\" = " + e.getnRestaurante().getId() + "\n" +
                "    ) \"TOTAL PREPARADOS\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"PRODUCTOS\" \"A1\"\n" +
                "ORDER BY\n" +
                "    \"A1\".\"ID_PRODUCTO\"";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);


            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);   
                Producto p = new Producto (Integer.parseInt(row.get("ID_PRODUCTO").toString()), row.get("DESCRIPCION_PRODUCTO").toString(), row.get("TIPO_PRODUCTO").toString(), 0.00f);
                p.setPlatosPreparados(Integer.parseInt(row.get("TOTAL PREPARADOS").toString()));
                
                listaProductos.add(p);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaProductos;
    }
    
}
