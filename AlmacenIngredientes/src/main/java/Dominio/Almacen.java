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
    private float cantidad;

    public Almacen (Restaurante r) {
        this.restaurante = r;
    }
    
    public Almacen(int idAlmacenIngrediente, Ingrediente ingrediente, Restaurante restaurante, float cantidad) {
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

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
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
    
    public static ArrayList<Elaboracion> selectElaboracionesProducto (int idProducto) {
        ArrayList<Elaboracion> listaElaboraciones = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                "    \"A1\".\"QCSJ_C000000000300001_3\"     \"ID_INGREDIENTE\",\n" +
                "    \"A1\".\"DESCRIPCION_INGREDIENTE_4\"   \"DESCRIPCION_INGREDIENTE\",\n" +
                "    \"A1\".\"CANTIDAD_ELABORACION_2\"      \"CANTIDAD_ELABORACION\",\n" +
                "    \"A1\".\"UNIDAD_5\"                    \"UNIDAD\"\n" +
                "FROM\n" +
                "    (\n" +
                "        SELECT\n" +
                "            \"A3\".\"ID_PRODUCTO\"               \"ID_PRODUCTO_0\",\n" +
                "            \"A3\".\"ID_INGREDIENTE\"            \"QCSJ_C000000000300000\",\n" +
                "            \"A3\".\"CANTIDAD_ELABORACION\"      \"CANTIDAD_ELABORACION_2\",\n" +
                "            \"A2\".\"ID_INGREDIENTE\"            \"QCSJ_C000000000300001_3\",\n" +
                "            \"A2\".\"DESCRIPCION_INGREDIENTE\"   \"DESCRIPCION_INGREDIENTE_4\",\n" +
                "            \"A2\".\"UNIDAD\"                    \"UNIDAD_5\"\n" +
                "        FROM\n" +
                "            \"ISO2\".\"ELABORACIONES\"   \"A3\",\n" +
                "            \"ISO2\".\"INGREDIENTES\"    \"A2\"\n" +
                "        WHERE\n" +
                "            \"A3\".\"ID_INGREDIENTE\" = \"A2\".\"ID_INGREDIENTE\"\n" +
                "    ) \"A1\"\n" +
                "WHERE\n" +
                "    \"A1\".\"ID_PRODUCTO_0\" = " + idProducto;

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);
                Ingrediente ingr = new Ingrediente (Integer.parseInt(row.get("ID_INGREDIENTE").toString()), row.get("DESCRIPCION_INGREDIENTE").toString(), 0, row.get("UNIDAD").toString(), 0);
                Elaboracion e = new Elaboracion (ingr, Float.parseFloat(row.get("CANTIDAD_ELABORACION").toString()));
                
                listaElaboraciones.add(e);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaElaboraciones;
    }
    
    public boolean updateIngredientesRestaurante(int idProducto, int incrementoStock) {
        boolean actualizado = true;
        
        try {
            String sql = "UPDATE INGREDIENTES_RESTAURANTES IR\n" +
                "    SET IR.CANTIDAD = IR.CANTIDAD + ((SELECT E.CANTIDAD_ELABORACION FROM ELABORACIONES E WHERE E.ID_INGREDIENTE = IR.ID_INGREDIENTE AND E.ID_PRODUCTO = " + idProducto + ")*" + incrementoStock + ") \n" +
                "    WHERE IR.ID_RESTAURANTE = " + getRestaurante().getId() + "\n" +
                "        AND IR.ID_INGREDIENTE IN (\n" +
                "            SELECT\n" +
                "                \"A1\".\"QCSJ_C000000000300001_3\" \"ID_INGREDIENTE\"\n" +
                "            FROM\n" +
                "                (\n" +
                "                    SELECT\n" +
                "                        \"A3\".\"ID_PRODUCTO\"               \"ID_PRODUCTO_0\",\n" +
                "                        \"A3\".\"ID_INGREDIENTE\"            \"QCSJ_C000000000300000\",\n" +
                "                        \"A3\".\"CANTIDAD_ELABORACION\"      \"CANTIDAD_ELABORACION_2\",\n" +
                "                        \"A2\".\"ID_INGREDIENTE\"            \"QCSJ_C000000000300001_3\",\n" +
                "                        \"A2\".\"DESCRIPCION_INGREDIENTE\"   \"DESCRIPCION_INGREDIENTE_4\",\n" +
                "                        \"A2\".\"UNIDAD\"                    \"UNIDAD_5\"\n" +
                "                    FROM\n" +
                "                        \"ISO2\".\"ELABORACIONES\"   \"A3\",\n" +
                "                        \"ISO2\".\"INGREDIENTES\"    \"A2\"\n" +
                "                    WHERE\n" +
                "                        \"A3\".\"ID_INGREDIENTE\" = \"A2\".\"ID_INGREDIENTE\"\n" +
                "                ) \"A1\"\n" +
                "            WHERE\n" +
                "                \"A1\".\"ID_PRODUCTO_0\" = " + idProducto + ")";
            
            Agente a = Agente.getAgente(); 
            a.update(sql);
        } catch (Exception ex) {
            System.out.println(ex);
            actualizado = false;
        }
        
        return actualizado;
    }
    
}
