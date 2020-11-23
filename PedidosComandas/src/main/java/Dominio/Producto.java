package Dominio;

public class Producto {

	private int idProducto;
	private String descripcionProducto;
        private String tipoProducto;
	private float precio;

        public Producto(int idProducto, String descripcionProducto, String tipoProducto, float precio) {
            this.idProducto = idProducto;
            this.descripcionProducto = descripcionProducto;
            this.tipoProducto = tipoProducto;
            this.precio = precio;
        }

        public int getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
        }

        public String getDescripcionProducto() {
            return descripcionProducto;
        }

        public void setDescripcionProducto(String descripcionProducto) {
            this.descripcionProducto = descripcionProducto;
        }

        public String getTipoProducto() {
            return tipoProducto;
        }

        public void setTipoProducto(String tipoProducto) {
            this.tipoProducto = tipoProducto;
        }

        public float getPrecio() {
            return precio;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }
}