package Dominio;

public class Empleado {
        
        public enum Rol {
            CAMARERO,
            JEFE_SALA,
            CAMARERO_BARRA,
            COCINERO,
            ALMACEN,
            DIRECTIVO
        }
        
	private String DNI;
	private String nombre;
	private String apellidos;
	private long tfno_contacto;
	private Rol tipoEmpleado;
	private Restaurante nRestaurante;

        public Empleado (String DNI, String nombre, String apellidos) {
            this.DNI = DNI;
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        
        public Empleado (String DNI, String nombre, String apellidos, long tfno_contacto, Rol tipoEmpleado, Restaurante nRestaurante) {
            this(DNI, nombre, apellidos);
            this.tfno_contacto = tfno_contacto;
            this.tipoEmpleado = tipoEmpleado;
            this.nRestaurante = nRestaurante;
        }
        
        public String getDNI() {
            return DNI;
        }

        public void setDNI(String DNI) {
            this.DNI = DNI;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public long getTfno_contacto() {
            return tfno_contacto;
        }

        public void setTfno_contacto(long tfno_contacto) {
            this.tfno_contacto = tfno_contacto;
        }

        public Rol getTipoEmpleado() {
            return tipoEmpleado;
        }

        public void setTipoEmpleado(Rol tipoEmpleado) {
            this.tipoEmpleado = tipoEmpleado;
        }

        public Restaurante getnRestaurante() {
            return nRestaurante;
        }

        public void setnRestaurante(Restaurante nRestaurante) {
            this.nRestaurante = nRestaurante;
        }
}