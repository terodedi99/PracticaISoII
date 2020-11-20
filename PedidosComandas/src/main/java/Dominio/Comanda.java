package Dominio;

public class Comanda {

	Servicio nComanda;
	private int idComanda;
	private float total;
	private int pagado;

	public int getIdComanda() {
		return this.idComanda;
	}

	/**
	 * 
	 * @param idComanda
	 */
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public float getTotal() {
		return this.total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	public int getPagado() {
		return this.pagado;
	}

	/**
	 * 
	 * @param pagado
	 */
	public void setPagado(int pagado) {
		this.pagado = pagado;
	}

}