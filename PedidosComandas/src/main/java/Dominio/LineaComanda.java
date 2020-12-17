package Dominio;

import Persistencia.Agente;
import Presentacion.IU_Gestion_Comandas_Internal;
import Presentacion.IU_Lineas_Empleado_Internal;
import java.util.HashMap;
import java.util.ArrayList;

public class LineaComanda {

    private int idLineaComanda;
    private Comanda comanda;
    private Producto nLinea;
    private int cantidad;
    private float precioVenta;
    private int servido;

    public LineaComanda (Producto producto, int cantidad, float precioVenta) {
        this.nLinea = producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }
    
    public LineaComanda(int idLineaComanda, Comanda comanda, Producto nLinea, int cantidad, float precioVenta, int servido) {
        this.idLineaComanda = idLineaComanda;
        this.comanda = comanda;
        this.nLinea = nLinea;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.servido = servido;
    }

    public int getIdLineaComanda() {
        return idLineaComanda;
    }

    public void setIdLineaComanda(int idLineaComanda) {
        this.idLineaComanda = idLineaComanda;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getnLinea() {
        return nLinea;
    }

    public void setnLinea(Producto nLinea) {
        this.nLinea = nLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getServido() {
        return servido;
    }

    public void setServido(int servido) {
        this.servido = servido;
    }
    
    public boolean comprobarStockSuficiente () {
        boolean stockSuficiente = true;
        int idRestaurante = IU_Gestion_Comandas_Internal.sesionEmpleado.getnRestaurante().getId();
        
        try {
            String sql = "SELECT\n" +
                "    \"A2\".\"ID_INGREDIENTE\"         \"ID_INGREDIENTE\",\n" +
                "    \"A1\".\"CANTIDAD\"               \"CANTIDAD_INGREDIENTE\",\n" +
                "    \"A3\".\"CANTIDAD_ELABORACION\"   \"CANTIDAD_ELABORACION\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"ELABORACIONES\"               \"A3\",\n" +
                "    \"ISO2\".\"INGREDIENTES\"                \"A2\",\n" +
                "    \"ISO2\".\"INGREDIENTES_RESTAURANTES\"   \"A1\"\n" +
                "WHERE\n" +
                "    \"A3\".\"ID_PRODUCTO\" = " + getnLinea().getIdProducto() + "\n" +
                "    AND \"A1\".\"ID_RESTAURANTE\" = " + idRestaurante + "\n" +
                "    AND \"A3\".\"ID_INGREDIENTE\" = \"A2\".\"ID_INGREDIENTE\"\n" +
                "    AND \"A2\".\"ID_INGREDIENTE\" = \"A1\".\"ID_INGREDIENTE\"";
            
            Agente a = Agente.getAgente(); 
            ArrayList result = a.select(sql);
            
            for (int i = 0; i < result.size() && stockSuficiente; i++) {
                HashMap row = (HashMap) result.get(i);   
                Elaboracion elaboracion = new Elaboracion (new Ingrediente(Integer.parseInt(row.get("ID_INGREDIENTE").toString()),Float.parseFloat(row.get("CANTIDAD_INGREDIENTE").toString().replace(",", "."))), Float.parseFloat(row.get("CANTIDAD_ELABORACION").toString().replace(",", "."))); 
                stockSuficiente = ((elaboracion.getIngrediente().getCantidad() - (elaboracion.getCantidadElaboracion() * getCantidad())) >= 0);
            }       
        } catch (Exception ex) {
            System.out.println(ex);
            stockSuficiente = false;
        }
        
        return stockSuficiente;
    }
    
    public boolean actualizarStock() {
        boolean actualizado = true;
        int idRestaurante = IU_Gestion_Comandas_Internal.sesionEmpleado.getnRestaurante().getId();
        
        try {
            String sql = "SELECT\n" +
                "    \"A2\".\"ID_INGREDIENTE\"         \"ID_INGREDIENTE\",\n" +
                "    \"A1\".\"CANTIDAD\"               \"CANTIDAD_INGREDIENTE\",\n" +
                "    \"A3\".\"CANTIDAD_ELABORACION\"   \"CANTIDAD_ELABORACION\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"ELABORACIONES\"               \"A3\",\n" +
                "    \"ISO2\".\"INGREDIENTES\"                \"A2\",\n" +
                "    \"ISO2\".\"INGREDIENTES_RESTAURANTES\"   \"A1\"\n" +
                "WHERE\n" +
                "    \"A3\".\"ID_PRODUCTO\" = " + getnLinea().getIdProducto() + "\n" +
                "    AND \"A1\".\"ID_RESTAURANTE\" = " + idRestaurante + "\n" +
                "    AND \"A3\".\"ID_INGREDIENTE\" = \"A2\".\"ID_INGREDIENTE\"\n" +
                "    AND \"A2\".\"ID_INGREDIENTE\" = \"A1\".\"ID_INGREDIENTE\"";
            
            String sql2;
            
            Agente a = Agente.getAgente(); 
            ArrayList result = a.select(sql);
            
            float nuevoStock;
            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);   
                Elaboracion elaboracion = new Elaboracion (new Ingrediente(Integer.parseInt(row.get("ID_INGREDIENTE").toString()),Float.parseFloat(row.get("CANTIDAD_INGREDIENTE").toString().replace(",", "."))), Float.parseFloat(row.get("CANTIDAD_ELABORACION").toString().replace(",", "."))); 
                nuevoStock = (elaboracion.getIngrediente().getCantidad() - (elaboracion.getCantidadElaboracion() * getCantidad()));
                
                sql2 = "UPDATE INGREDIENTES_RESTAURANTES SET CANTIDAD = " + nuevoStock + "WHERE ID_INGREDIENTE = " + elaboracion.getIngrediente().getIdIngrediente() + " AND ID_RESTAURANTE = " + idRestaurante;
                a.update(sql2);
            } 
            
        } catch (Exception ex) {
            System.out.println(ex);
            actualizado = false;
        }
         
        return actualizado;
    }
    
    public boolean insert() {
        boolean exito = true;
        
        try {
            String sql = "INSERT INTO LINEAS_COMANDAS VALUES (SEQ_ID_LINEA_COMANDA.NEXTVAL, " + getCantidad() + ", " + String.valueOf(getPrecioVenta()).replace(",", ".") + ", 0, (SELECT NVL(MAX(ID_COMANDA), 0) \"ULTIMA_COMANDA\" FROM COMANDAS), " + getnLinea().getIdProducto() + ")";
            
            Agente a = Agente.getAgente();
            a.insert(sql);     
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        
        
        return exito;
    }
    
    public static ArrayList<LineaComanda> readLineasComandaPendientes(int idEmpleado, String rolEmpleado) {
        ArrayList<LineaComanda> listaLineas = new ArrayList<>();
        int idRestaurante = IU_Lineas_Empleado_Internal.sesionEmpleado.getnRestaurante().getId();
              
        try {
            String sql = "";
            
            switch (rolEmpleado) {
                case "CAMARERO_BARRA":
                    sql = "SELECT\n" +
                        "    \"A3\".\"ID_COMANDA\"             \"ID_COMANDA\",\n" +
                        "    \"A2\".\"ID_LINEA_COMANDA\"       \"ID_LINEA_COMANDA\",\n" +
                        "    \"A1\".\"ID_PRODUCTO\"            \"ID_PRODUCTO\",\n" +
                        "    \"A1\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                        "    \"A1\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                        "    \"A2\".\"CANTIDAD\"               \"CANTIDAD\",\n" +
                        "    \"A5\".\"NOMBRE_MESA\"            \"NOMBRE_MESA\"\n" +
                        "FROM\n" +
                        "    \"ISO2\".\"MESAS\"             \"A5\",\n" +
                        "    \"ISO2\".\"SERVICIOS\"         \"A4\",\n" +
                        "    \"ISO2\".\"COMANDAS\"          \"A3\",\n" +
                        "    \"ISO2\".\"LINEAS_COMANDAS\"   \"A2\",\n" +
                        "    \"ISO2\".\"PRODUCTOS\"         \"A1\"\n" +
                        "WHERE\n" +
                        "    \"A2\".\"SERVIDO\" = 0\n" +
                        "    AND \"A5\".\"ID_RESTAURANTE\" = " + idRestaurante + "\n" +
                        "    AND \"A1\".\"TIPO_PRODUCTO\" = 'BEBIDA'\n" +
                        "    AND \"A5\".\"ID_MESA\" = \"A4\".\"ID_MESA\"\n" +
                        "    AND \"A4\".\"ID_SERVICIO\" = \"A3\".\"ID_SERVICIO\"\n" +
                        "    AND \"A3\".\"ID_COMANDA\" = \"A2\".\"ID_COMANDA\"\n" +
                        "    AND \"A2\".\"ID_PRODUCTO\" = \"A1\".\"ID_PRODUCTO\"\n" +
                        "ORDER BY\n" +
                        "    \"A3\".\"ID_COMANDA\",\n" +
                        "    \"A2\".\"ID_LINEA_COMANDA\",\n" +
                        "    \"A1\".\"TIPO_PRODUCTO\"";
                    break;
                case "COCINERO":
                    sql = "SELECT\n" +
                        "    \"A3\".\"ID_COMANDA\"             \"ID_COMANDA\",\n" +
                        "    \"A2\".\"ID_LINEA_COMANDA\"       \"ID_LINEA_COMANDA\",\n" +
                        "    \"A1\".\"ID_PRODUCTO\"            \"ID_PRODUCTO\",\n" +
                        "    \"A1\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                        "    \"A1\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                        "    \"A2\".\"CANTIDAD\"               \"CANTIDAD\",\n" +
                        "    \"A5\".\"NOMBRE_MESA\"            \"NOMBRE_MESA\"\n" +
                        "FROM\n" +
                        "    \"ISO2\".\"MESAS\"             \"A5\",\n" +
                        "    \"ISO2\".\"SERVICIOS\"         \"A4\",\n" +
                        "    \"ISO2\".\"COMANDAS\"          \"A3\",\n" +
                        "    \"ISO2\".\"LINEAS_COMANDAS\"   \"A2\",\n" +
                        "    \"ISO2\".\"PRODUCTOS\"         \"A1\"\n" +
                        "WHERE\n" +
                        "    \"A2\".\"SERVIDO\" = 0\n" +
                        "    AND \"A5\".\"ID_RESTAURANTE\" = " + idRestaurante + "\n" +
                        "    AND ( \"A1\".\"TIPO_PRODUCTO\" = 'PRIMER PLATO'\n" +
                        "          OR \"A1\".\"TIPO_PRODUCTO\" = 'SEGUNDO PLATO'\n" +
                        "          OR \"A1\".\"TIPO_PRODUCTO\" = 'POSTRE' )\n" +
                        "    AND \"A5\".\"ID_MESA\" = \"A4\".\"ID_MESA\"\n" +
                        "    AND \"A4\".\"ID_SERVICIO\" = \"A3\".\"ID_SERVICIO\"\n" +
                        "    AND \"A3\".\"ID_COMANDA\" = \"A2\".\"ID_COMANDA\"\n" +
                        "    AND \"A2\".\"ID_PRODUCTO\" = \"A1\".\"ID_PRODUCTO\"\n" +
                        "ORDER BY\n" +
                        "    \"A3\".\"ID_COMANDA\",\n" +
                        "    \"A2\".\"ID_LINEA_COMANDA\",\n" +
                        "    \"A1\".\"TIPO_PRODUCTO\"";
                    break;
                case "CAMARERO":
                    sql = "SELECT\n" +
                        "    \"A4\".\"ID_COMANDA\"             \"ID_COMANDA\",\n" +
                        "    \"A3\".\"ID_LINEA_COMANDA\"       \"ID_LINEA_COMANDA\",\n" +
                        "    \"A3\".\"CANTIDAD\"               \"CANTIDAD\",\n" +
                        "    \"A2\".\"ID_PRODUCTO\"            \"ID_PRODUCTO\",\n" +
                        "    \"A2\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                        "    \"A2\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                        "    \"A6\".\"NOMBRE_MESA\"            \"NOMBRE_MESA\"\n" +
                        "FROM\n" +
                        "    \"ISO2\".\"MESAS\"                 \"A6\",\n" +
                        "    \"ISO2\".\"SERVICIOS\"             \"A5\",\n" +
                        "    \"ISO2\".\"COMANDAS\"              \"A4\",\n" +
                        "    \"ISO2\".\"LINEAS_COMANDAS\"       \"A3\",\n" +
                        "    \"ISO2\".\"PRODUCTOS\"             \"A2\",\n" +
                        "    \"ISO2\".\"SERVICIOS_CAMAREROS\"   \"A1\"\n" +
                        "WHERE\n" +
                        "    \"A3\".\"SERVIDO\" = 1\n" +
                        "    AND \"A1\".\"ID_CAMARERO\" = " + idEmpleado + "\n" +
                        "    AND \"A6\".\"ID_MESA\" = \"A5\".\"ID_MESA\"\n" +
                        "    AND \"A5\".\"ID_SERVICIO\" = \"A4\".\"ID_SERVICIO\"\n" +
                        "    AND \"A4\".\"ID_COMANDA\" = \"A3\".\"ID_COMANDA\"\n" +
                        "    AND \"A3\".\"ID_PRODUCTO\" = \"A2\".\"ID_PRODUCTO\"\n" +
                        "    AND \"A5\".\"ID_SERVICIO\" = \"A1\".\"ID_SERVICIO\"\n" +
                        "ORDER BY\n" +
                        "    \"A4\".\"ID_COMANDA\",\n" +
                        "    \"A3\".\"ID_LINEA_COMANDA\",\n" +
                        "    \"A2\".\"TIPO_PRODUCTO\"";
                    break;
            }

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);   
                
                Mesa m = new Mesa (0, row.get("NOMBRE_MESA").toString());
                Producto p = new Producto (Integer.parseInt(row.get("ID_PRODUCTO").toString()), row.get("DESCRIPCION_PRODUCTO").toString(), row.get("TIPO_PRODUCTO").toString(), 0.00f);
                Servicio s = new Servicio (0, 0, ""); s.setnMesa(m);
                Comanda c = new Comanda (Integer.parseInt(row.get("ID_COMANDA").toString()), s);
                
                LineaComanda l = new LineaComanda (Integer.parseInt(row.get("ID_LINEA_COMANDA").toString()), c, p, Integer.parseInt(row.get("CANTIDAD").toString()), 0.00f, 0);
                
                listaLineas.add(l);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaLineas;
    }
    
    public boolean actualizarEstadoLinea () {
        boolean exito = true;
    
        try {
            String sql = "UPDATE LINEAS_COMANDAS SET SERVIDO = SERVIDO + 1 WHERE ID_LINEA_COMANDA = " + getIdLineaComanda();
            
            Agente a = Agente.getAgente();
            a.update(sql);   
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        
        return exito;
    }
    
    
    
}