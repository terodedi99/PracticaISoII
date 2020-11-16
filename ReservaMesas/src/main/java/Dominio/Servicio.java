package Dominio;

import Persistencia.Agente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Servicio {

        public enum Estado {
            LIBRE,
            RESERVADA,
            OCUPADA,
            PIDIENDO,
            EN_ESPERA_DE_COMIDA,
            SERVIDOS,
            ESPERANDO_LA_CUENTA,
            PAGANDO,
            EN_PREPARACION,
            FINALIZADA
        }
    
	private int idServicio;
	private Date fecha;
        private Turno nTurno;
        private Mesa nMesa;
	private int num_comensales;
        private String comentarios;
	private Estado estado;
	
	private Empleado nEmpleado;
        
        public Servicio (int idServicio, int num_comensales, String comentarios) {
            this.idServicio = idServicio;
            this.num_comensales = num_comensales;
            this.comentarios = comentarios;
        }

        public Servicio (int idServicio, Date fecha, Turno nTurno, Mesa nMesa, Estado estado) {
            this.idServicio = idServicio;
            this.fecha = fecha;
            this.nTurno = nTurno;
            this.nMesa = nMesa;
            this.estado = estado;
        }
        
        
        public Servicio(int idServicio, Date fecha, Turno nTurno, Mesa nMesa, int num_comensales, String comentarios, Estado estado) {
            this.idServicio = idServicio;
            this.fecha = fecha;
            this.nTurno = nTurno;
            this.nMesa = nMesa;
            this.num_comensales = num_comensales;
            this.comentarios = comentarios;
            this.estado = estado;
        }

        public int getIdServicio() {
            return idServicio;
        }

        public void setIdServicio(int idServicio) {
            this.idServicio = idServicio;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public Turno getnTurno() {
            return nTurno;
        }

        public void setnTurno(Turno nTurno) {
            this.nTurno = nTurno;
        }

        public Mesa getnMesa() {
            return nMesa;
        }

        public void setnMesa(Mesa nMesa) {
            this.nMesa = nMesa;
        }

        public int getNum_comensales() {
            return num_comensales;
        }

        public void setNum_comensales(int num_comensales) {
            this.num_comensales = num_comensales;
        }

        public String getComentarios() {
            return comentarios;
        }

        public void setComentarios(String comentarios) {
            this.comentarios = comentarios;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }

        public Empleado getnEmpleado() {
            return nEmpleado;
        }

        public void setnEmpleado(Empleado nEmpleado) {
            this.nEmpleado = nEmpleado;
        }
	
	public boolean update() {
            boolean exito = true;
            
            try {
                String sql = "UPDATE SERVICIOS SET COMENTARIOS='" + this.comentarios + "', NUM_COMENSALES="+this.num_comensales+", ESTADO='" + this.estado.toString() + "' WHERE ID_SERVICIO="+this.idServicio;
                Agente a = Agente.getAgente();
                a.update(sql);
            } catch (Exception ex) {
                System.out.println(ex); 
                exito = false;
            }
            
            return exito;
	}
        
        public static ArrayList<Servicio> readServicios(Date fecha, Empleado empleado) {
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
                    "    \"A1\".\"NOMBRE_MESA\"      \"NOMBRE_MESA\"\n" +
                    "FROM\n" +
                    "    \"ISO2\".\"SERVICIOS\"   \"A3\",\n" +
                    "    \"ISO2\".\"TURNOS\"      \"A2\",\n" +
                    "    \"ISO2\".\"MESAS\"       \"A1\"\n" +
                    "WHERE\n" +
                    "    \"A1\".\"ID_RESTAURANTE\" = " + empleado.getnRestaurante().getId() + " \n" +
                    "    AND \"A3\".\"FECHA_SERVICIO\" = '" + formatter.format(fecha) +"' \n" +
                    "    AND \"A3\".\"ID_MESA\" = \"A1\".\"ID_MESA\"\n" +
                    "    AND \"A3\".\"ID_TURNO\" = \"A2\".\"ID_TURNO\"\n" +
                    "    AND \"A3\".\"ESTADO\" IN ('LIBRE', 'RESERVADA')\n" +
                    "ORDER BY 1";
                
                Agente a = Agente.getAgente();
                ArrayList result = a.select(sql);
                
                
                for (int i = 0; i < result.size(); i++) {
                    HashMap row = (HashMap) result.get(i);   
                    Servicio s = new Servicio(Integer.parseInt(row.get("ID_SERVICIO").toString()), formatter.parse(row.get("FECHA_SERVICIO").toString()), new Turno (Integer.parseInt(row.get("ID_TURNO").toString()),row.get("NOMBRE_TURNO").toString()), new Mesa (Integer.parseInt(row.get("ID_MESA").toString()),row.get("NOMBRE_MESA").toString()), Estado.valueOf(row.get("ESTADO").toString()));
                    
                    listaServicios.add(s);
                }    
            } catch (Exception ex) {
                System.out.println(ex); 
            }
            
            return listaServicios;
        }
        
        public static ArrayList<Servicio> readServicios(Date fecha, Empleado empleado, Pase pase) {
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
                    "    \"A1\".\"NOMBRE_MESA\"      \"NOMBRE_MESA\"\n" +
                    "FROM\n" +
                    "    \"ISO2\".\"SERVICIOS\"   \"A3\",\n" +
                    "    \"ISO2\".\"TURNOS\"      \"A2\",\n" +
                    "    \"ISO2\".\"MESAS\"       \"A1\"\n" +
                    "WHERE\n" +
                    "    \"A1\".\"ID_RESTAURANTE\" = " + empleado.getnRestaurante().getId() + " \n" +
                    "    AND \"A3\".\"FECHA_SERVICIO\" = '" + formatter.format(fecha) + "' \n" +
                    "    AND \"A2\".\"ID_PASE\" = " + pase.getIdPase() + " \n" +
                    "    AND \"A3\".\"ID_MESA\" = \"A1\".\"ID_MESA\"\n" +
                    "    AND \"A3\".\"ID_TURNO\" = \"A2\".\"ID_TURNO\"\n" +
                    "    AND \"A3\".\"ESTADO\" IN ('LIBRE', 'RESERVADA')\n" +
                    "ORDER BY 1";
                
                Agente a = Agente.getAgente();
                ArrayList result = a.select(sql);
                
                
                for (int i = 0; i < result.size(); i++) {
                    HashMap row = (HashMap) result.get(i);   
                    Servicio s = new Servicio(Integer.parseInt(row.get("ID_SERVICIO").toString()), formatter.parse(row.get("FECHA_SERVICIO").toString()), new Turno (Integer.parseInt(row.get("ID_TURNO").toString()),row.get("NOMBRE_TURNO").toString()), new Mesa (Integer.parseInt(row.get("ID_MESA").toString()),row.get("NOMBRE_MESA").toString()), Estado.valueOf(row.get("ESTADO").toString()));
                    
                    listaServicios.add(s);
                }    
            } catch (Exception ex) {
                System.out.println(ex); 
            }
            
            return listaServicios;
        }
}