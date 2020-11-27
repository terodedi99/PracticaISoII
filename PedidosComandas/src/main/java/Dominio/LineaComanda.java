package Dominio;

import Persistencia.Agente;
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
        
        try {
            String sql = "SELECT\n" +
                "    \"A1\".\"ID_INGREDIENTE\"         \"ID_INGREDIENTE\",\n" +
                "    \"A1\".\"CANTIDAD\"               \"CANTIDAD_INGREDIENTE\",\n" +
                "    \"A2\".\"CANTIDAD_ELABORACION\"   \"CANTIDAD_ELABORACION\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"ELABORACIONES\"   \"A2\",\n" +
                "    \"ISO2\".\"INGREDIENTES\"    \"A1\"\n" +
                "WHERE\n" +
                "    \"A2\".\"ID_PRODUCTO\" = " + getnLinea().getIdProducto() + "\n" +
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
        
        try {
            String sql = "SELECT\n" +
                "    \"A1\".\"ID_INGREDIENTE\"         \"ID_INGREDIENTE\",\n" +
                "    \"A1\".\"CANTIDAD\"               \"CANTIDAD_INGREDIENTE\",\n" +
                "    \"A2\".\"CANTIDAD_ELABORACION\"   \"CANTIDAD_ELABORACION\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"ELABORACIONES\"   \"A2\",\n" +
                "    \"ISO2\".\"INGREDIENTES\"    \"A1\"\n" +
                "WHERE\n" +
                "    \"A2\".\"ID_PRODUCTO\" = " + getnLinea().getIdProducto() + "\n" +
                "    AND \"A2\".\"ID_INGREDIENTE\" = \"A1\".\"ID_INGREDIENTE\"";
            
            String sql2;
            
            Agente a = Agente.getAgente(); 
            ArrayList result = a.select(sql);
            
            float nuevoStock;
            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);   
                Elaboracion elaboracion = new Elaboracion (new Ingrediente(Integer.parseInt(row.get("ID_INGREDIENTE").toString()),Float.parseFloat(row.get("CANTIDAD_INGREDIENTE").toString().replace(",", "."))), Float.parseFloat(row.get("CANTIDAD_ELABORACION").toString().replace(",", "."))); 
                nuevoStock = (elaboracion.getIngrediente().getCantidad() - (elaboracion.getCantidadElaboracion() * getCantidad()));
                
                sql2 = "UPDATE INGREDIENTES SET CANTIDAD = " + nuevoStock + "WHERE ID_INGREDIENTE = " + elaboracion.getIngrediente().getIdIngrediente();
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
}