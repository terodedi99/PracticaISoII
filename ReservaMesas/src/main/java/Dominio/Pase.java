package Dominio;

public class Pase {

	private int idPase;
	private String nombrePase;

        public Pase (int idPase, String nombrePase) {
            this.idPase = idPase;
            this.nombrePase = nombrePase;
        }
        
        public int getIdPase() {
            return idPase;
        }

        public void setIdPase(int idPase) {
            this.idPase = idPase;
        }

        public String getNombrePase() {
            return nombrePase;
        }

        public void setNombrePase(String nombrePase) {
            this.nombrePase = nombrePase;
        }

        @Override
        public String toString() {
            return this.nombrePase;
        }    
}