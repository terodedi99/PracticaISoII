package Dominio;

import Persistencia.Agente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Comanda {
    
    private int idComanda;
    private float total;
    private int pagada;
    private Servicio servicio;
    private MetodoPago metodoPago;

    public Comanda (Servicio s) {
        this.servicio = s;
    }
    
    public Comanda (int idComanda, float total, int pagada) {
        this.idComanda = idComanda;
        this.total = total;
        this.pagada = pagada;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getPagada() {
        return pagada;
    }

    public void setPagada(int pagada) {
        this.pagada = pagada;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }     

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
       
    public static ArrayList<Servicio> readServicios(Empleado empleado) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Servicio> listaServicios = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                "    \"A3\".\"ID_SERVICIO\"      \"ID_SERVICIO\",\n" +
                "    to_char(\"A3\".\"FECHA_SERVICIO\", 'dd/MM/yyyy') \"FECHA_SERVICIO\",\n" +
                "    \"A3\".\"ESTADO\"           \"ESTADO\",\n" +
                "    \"A3\".\"ID_TURNO\"         \"ID_TURNO\",\n" +
                "    \"A2\".\"NOMBRE_TURNO\"     \"NOMBRE_TURNO\",\n" +
                "    \"A3\".\"ID_MESA\"          \"ID_MESA\",\n" +
                "    \"A1\".\"NOMBRE_MESA\"      \"NOMBRE_MESA\",\n" +
                "    \"A3\".\"NUM_COMENSALES\"   \"NUM_COMENSALES\"\n" +
                "FROM\n" +
                "    \"ISO2\".\"SERVICIOS\"   \"A3\",\n" +
                "    \"ISO2\".\"TURNOS\"      \"A2\",\n" +
                "    \"ISO2\".\"MESAS\"       \"A1\",\n" +
                "    \"ISO2\".\"SERVICIOS_CAMAREROS\" \"A4\"\n" +
                "WHERE\n" +
                "    \"A1\".\"ID_RESTAURANTE\" = " + empleado.getnRestaurante().getId() + " \n" +
                "    AND \"A4\".\"ID_CAMARERO\" = " + empleado.getIdEmpleado() + " \n" +
                "    AND \"A4\".\"ID_SERVICIO\" = \"A3\".\"ID_SERVICIO\" \n" +
                "    AND \"A3\".\"ID_MESA\" = \"A1\".\"ID_MESA\"\n" +
                "    AND \"A3\".\"ID_TURNO\" = \"A2\".\"ID_TURNO\"\n" +
                "    AND \"A3\".\"ESTADO\" IN ('OCUPADA','PIDIENDO')\n" +
                "ORDER BY 1";

            Agente a = Agente.getAgente();
            ArrayList result = a.select(sql);

            for (int i = 0; i < result.size(); i++) {
                HashMap row = (HashMap) result.get(i);   
                Servicio s = new Servicio(Integer.parseInt(row.get("ID_SERVICIO").toString()), formatter.parse(row.get("FECHA_SERVICIO").toString()), new Turno (Integer.parseInt(row.get("ID_TURNO").toString()),row.get("NOMBRE_TURNO").toString()), new Mesa (Integer.parseInt(row.get("ID_MESA").toString()),row.get("NOMBRE_MESA").toString()), Servicio.Estado.valueOf(row.get("ESTADO").toString()));
                s.setNum_comensales(Integer.parseInt(row.get("NUM_COMENSALES").toString()));

                listaServicios.add(s);
            }    
        } catch (Exception ex) {
            System.out.println(ex); 
        }

        return listaServicios;
    }
    
    public boolean insert() {
        boolean exito = true;
        
        try {
            String sql = "INSERT INTO COMANDAS VALUES (SEQ_ID_COMANDA.NEXTVAL, " + getTotal() + ", 0, " + getServicio().getIdServicio() + ")";
            
            Agente a = Agente.getAgente();
            a.insert(sql);    
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
          
        return exito;
    }
    
    
    public boolean updateServicio () {
        boolean exito = true;
        
        try {
            String sql = "UPDATE SERVICIOS SET ESTADO='" + getServicio().getEstado().toString() + "' WHERE ID_SERVICIO=" + servicio.getIdServicio();
            
            Agente a = Agente.getAgente();
            a.update(sql);
            
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
         
        return exito;
    }     
}