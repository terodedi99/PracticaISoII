package Dominio;

public class Mesa {

	private int idMesa;
	private String nombreMesa;
        private Restaurante nRestaurante;
        private Servicio servicioActivo;

        public Mesa(int idMesa, String nombreMesa) {
            this.idMesa = idMesa;
            this.nombreMesa = nombreMesa;
        }

        public Mesa(int idMesa, String nombreMesa, Restaurante nRestaurante) {
            this (idMesa, nombreMesa);
            this.nRestaurante = nRestaurante;
        }
        
        public int getIdMesa() {
            return idMesa;
        }

        public void setIdMesa(int idMesa) {
            this.idMesa = idMesa;
        }

        public String getNombreMesa() {
            return nombreMesa;
        }

        public void setNombreMesa(String nombreMesa) {
            this.nombreMesa = nombreMesa;
        }

        public Restaurante getnRestaurante() {
            return nRestaurante;
        }

        public void setnRestaurante(Restaurante nRestaurante) {
            this.nRestaurante = nRestaurante;
        } 

        public Servicio getServicioActivo() {
            return servicioActivo;
        }

        public void setServicioActivo(Servicio servicioActivo) {
            this.servicioActivo = servicioActivo;
        }     
}