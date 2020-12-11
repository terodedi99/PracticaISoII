package Dominio;

public class MetodoPago {

	private int idMetodoPago;
	private String descripcionPago;

	public MetodoPago (int idMetodoPago, String descripcionMetodoPago) {
            this.idMetodoPago = idMetodoPago;
            this.descripcionPago = descripcionMetodoPago;
        }

        public int getIdMetodoPago() {
            return idMetodoPago;
        }

        public void setIdMetodoPago(int idMetodoPago) {
            this.idMetodoPago = idMetodoPago;
        }

        public String getDescripcionPago() {
            return descripcionPago;
        }

        public void setDescripcionPago(String descripcionPago) {
            this.descripcionPago = descripcionPago;
        }     

    @Override
    public String toString() {
        return descripcionPago;
    }
}