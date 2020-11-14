package Dominio;

import java.util.Date;

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
	
	public void update() {
		// TODO - implement Servicio.update
		throw new UnsupportedOperationException();
	}
}