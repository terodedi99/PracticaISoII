package Dominio;

public class Turno {

	private int idTurno;
	private String nombreTurno;
	private Pase nPase;

        public Turno (int idTurno, String nombreTurno) {
            this.idTurno = idTurno;
            this.nombreTurno = nombreTurno;
        }
        
        public Turno (int idTurno, String nombreTurno, Pase nPase) {
            this(idTurno, nombreTurno);
            this.nPase = nPase;
        }

        public int getIdTurno() {
            return idTurno;
        }

        public void setIdTurno(int idTurno) {
            this.idTurno = idTurno;
        }

        public String getNombreTurno() {
            return nombreTurno;
        }

        public void setNombreTurno(String nombreTurno) {
            this.nombreTurno = nombreTurno;
        }

        public Pase getnPase() {
            return nPase;
        }

        public void setnPase(Pase nPase) {
            this.nPase = nPase;
        }
}