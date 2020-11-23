package Dominio;

public class Ingrediente {

	private int idIngrediente;
	private String descripcionIngrediente;
        private float cantidad;
	private String unidad;
	private float stockIdeal;

        public Ingrediente(int idIngrediente, String descripcionIngrediente, float cantidad, String unidad, float stockIdeal) {
            this.idIngrediente = idIngrediente;
            this.descripcionIngrediente = descripcionIngrediente;
            this.cantidad = cantidad;
            this.unidad = unidad;
            this.stockIdeal = stockIdeal;
        }

        public int getIdIngrediente() {
            return idIngrediente;
        }

        public void setIdIngrediente(int idIngrediente) {
            this.idIngrediente = idIngrediente;
        }

        public String getDescripcionIngrediente() {
            return descripcionIngrediente;
        }

        public void setDescripcionIngrediente(String descripcionIngrediente) {
            this.descripcionIngrediente = descripcionIngrediente;
        }

        public float getCantidad() {
            return cantidad;
        }

        public void setCantidad(float cantidad) {
            this.cantidad = cantidad;
        }

        public String getUnidad() {
            return unidad;
        }

        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }

        public float getStockIdeal() {
            return stockIdeal;
        }

        public void setStockIdeal(float stockIdeal) {
            this.stockIdeal = stockIdeal;
        }
}