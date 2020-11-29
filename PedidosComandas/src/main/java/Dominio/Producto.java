package Dominio;

import Persistencia.Agente;
import Presentacion.IU_Gestion_Comandas;
import java.util.ArrayList;
import java.util.HashMap;

public class Producto {

	private int idProducto;
	private String descripcionProducto;
        private String tipoProducto;
	private float precio;
        
        private int platosDisponibles;

        public Producto(int idProducto, String descripcionProducto, String tipoProducto, float precio) {
            this.idProducto = idProducto;
            this.descripcionProducto = descripcionProducto;
            this.tipoProducto = tipoProducto;
            this.precio = precio;
        }
        
        public Producto(int idProducto, String descripcionProducto, String tipoProducto, float precio, int platosDisponibles) {
            this (idProducto, descripcionProducto, tipoProducto, precio);
            this.platosDisponibles = platosDisponibles;
        }

        public int getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
        }

        public String getDescripcionProducto() {
            return descripcionProducto;
        }

        public void setDescripcionProducto(String descripcionProducto) {
            this.descripcionProducto = descripcionProducto;
        }

        public String getTipoProducto() {
            return tipoProducto;
        }

        public void setTipoProducto(String tipoProducto) {
            this.tipoProducto = tipoProducto;
        }

        public float getPrecio() {
            return precio;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public int getPlatosDisponibles() {
            return platosDisponibles;
        }

        public void setPlatosDisponibles(int platosDisponibles) {
            this.platosDisponibles = platosDisponibles;
        }
        
        public static ArrayList<Producto> readProductos() {
            ArrayList<Producto> listaProductos = new ArrayList<>();
            int idRestaurante = IU_Gestion_Comandas.sesionEmpleado.getnRestaurante().getId();

            try {
                String sql = "SELECT\n" +
                    "    \"A4\".\"ID_PRODUCTO\"            \"ID_PRODUCTO\",\n" +
                    "    \"A4\".\"DESCRIPCION_PRODUCTO\"   \"DESCRIPCION_PRODUCTO\",\n" +
                    "    \"A4\".\"TIPO_PRODUCTO\"          \"TIPO_PRODUCTO\",\n" +
                    "    \"A4\".\"PRECIO\"                 \"PRECIO\",\n" +
                    "    MIN(trunc(\"A1\".\"CANTIDAD\" / \"A3\".\"CANTIDAD_ELABORACION\", 0)) \"PLATOS_DISPONIBLES\"\n" +
                    "FROM\n" +
                    "    \"ISO2\".\"PRODUCTOS\"                   \"A4\",\n" +
                    "    \"ISO2\".\"ELABORACIONES\"               \"A3\",\n" +
                    "    \"ISO2\".\"INGREDIENTES\"                \"A2\",\n" +
                    "    \"ISO2\".\"INGREDIENTES_RESTAURANTES\"   \"A1\"\n" +
                    "WHERE\n" +
                    "    \"A1\".\"ID_RESTAURANTE\" = " + idRestaurante + "\n" +
                    "    AND \"A4\".\"ID_PRODUCTO\" = \"A3\".\"ID_PRODUCTO\"\n" +
                    "    AND \"A3\".\"ID_INGREDIENTE\" = \"A2\".\"ID_INGREDIENTE\"\n" +
                    "    AND \"A2\".\"ID_INGREDIENTE\" = \"A1\".\"ID_INGREDIENTE\"\n" +
                    "GROUP BY\n" +
                    "    \"A4\".\"ID_PRODUCTO\",\n" +
                    "    \"A4\".\"DESCRIPCION_PRODUCTO\",\n" +
                    "    \"A4\".\"TIPO_PRODUCTO\",\n" +
                    "    \"A4\".\"PRECIO\"\n" +
                    "ORDER BY\n" +
                    "    \"A4\".\"ID_PRODUCTO\"";

                Agente a = Agente.getAgente();
                ArrayList result = a.select(sql);

                for (int i = 0; i < result.size(); i++) {
                    HashMap row = (HashMap) result.get(i);   
                    Producto p = new Producto(Integer.parseInt(row.get("ID_PRODUCTO").toString()), row.get("DESCRIPCION_PRODUCTO").toString(), row.get("TIPO_PRODUCTO").toString(), Float.parseFloat(row.get("PRECIO").toString().replace(",", ".")), Integer.parseInt(row.get("PLATOS_DISPONIBLES").toString()));

                    listaProductos.add(p);
                }    
            } catch (Exception ex) {
                System.out.println(ex); 
            }

            return listaProductos;
        }
        
}