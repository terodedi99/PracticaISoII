package Dominio;

public class TipoProducto {

	private int idTipoProducto;
	private String descripcionTipoProducto;

	public int getIdTipoProducto() {
		return this.idTipoProducto;
	}

	/**
	 * 
	 * @param idTipoProducto
	 */
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getDescripcionTipoProducto() {
		return this.descripcionTipoProducto;
	}

	/**
	 * 
	 * @param descripcionTipoProducto
	 */
	public void setDescripcionTipoProducto(String descripcionTipoProducto) {
		this.descripcionTipoProducto = descripcionTipoProducto;
	}

}