package Dominio;

public class MetodoPago {

	private int idMetodoPago;
	private String descripcionPago;

	public int getIdMetodoPago() {
		return this.idMetodoPago;
	}

	/**
	 * 
	 * @param idMetodoPago
	 */
	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getDescripcionPago() {
		return this.descripcionPago;
	}

	/**
	 * 
	 * @param descripcionPago
	 */
	public void setDescripcionPago(String descripcionPago) {
		this.descripcionPago = descripcionPago;
	}

}