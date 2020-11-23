package Dominio;

public class LineaComanda {

    private int idLineaComanda;
    private Comanda comanda;
    private Producto nLinea;
    private int cantidad;
    private float precioVenta;
    private int servido;

    public LineaComanda(int idLineaComanda, Comanda comanda, Producto nLinea, int cantidad, float precioVenta, int servido) {
        this.idLineaComanda = idLineaComanda;
        this.comanda = comanda;
        this.nLinea = nLinea;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.servido = servido;
    }

    public int getIdLineaComanda() {
        return idLineaComanda;
    }

    public void setIdLineaComanda(int idLineaComanda) {
        this.idLineaComanda = idLineaComanda;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getnLinea() {
        return nLinea;
    }

    public void setnLinea(Producto nLinea) {
        this.nLinea = nLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getServido() {
        return servido;
    }

    public void setServido(int servido) {
        this.servido = servido;
    }
}