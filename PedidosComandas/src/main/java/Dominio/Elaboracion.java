package Dominio;

public class Elaboracion {

        private int idElaboracion;
	private Producto producto;
	private Ingrediente ingrediente;
	private float cantidadElaboracion;

        public Elaboracion (Ingrediente ingrediente, float cantidadElaboracion) {
            this.ingrediente = ingrediente;
            this.cantidadElaboracion = cantidadElaboracion;
        }
        
        public Elaboracion (int idElaboracion, Producto producto, Ingrediente ingrediente, float cantidadElaboracion) {
            this.idElaboracion = idElaboracion;
            this.producto = producto;
            this.ingrediente = ingrediente;
            this.cantidadElaboracion = cantidadElaboracion;
        }

        public int getIdElaboracion() {
            return idElaboracion;
        }

        public void setIdElaboracion(int idElaboracion) {
            this.idElaboracion = idElaboracion;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public Ingrediente getIngrediente() {
            return ingrediente;
        }

        public void setIngrediente(Ingrediente ingrediente) {
            this.ingrediente = ingrediente;
        }

        public float getCantidadElaboracion() {
            return cantidadElaboracion;
        }

        public void setCantidadElaboracion(float cantidadElaboracion) {
            this.cantidadElaboracion = cantidadElaboracion;
        }
}