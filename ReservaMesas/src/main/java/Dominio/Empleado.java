package Dominio;

public class Empleado {
        
        public enum Rol {
            CAMARERO,
            JEFE_DE_SALA,
            CAMARERO_BARRA,
            COCINERO,
            ALMACEN,
            DIRECTIVO
        }
        
        private int idEmpleado;
	private String DNI;
	private String nombre;
	private String apellidos;
	private long tfno_contacto;
	private Rol tipoEmpleado;
	private Restaurante nRestaurante;

        public Empleado (int id, String DNI, String nombre, String apellidos) {
            this.idEmpleado = id;
            this.DNI = DNI;
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        
        public Empleado (int id, String DNI, String nombre, String apellidos, long tfno_contacto, Rol tipoEmpleado, Restaurante nRestaurante) {
            this(id, DNI, nombre, apellidos);
            this.tfno_contacto = tfno_contacto;
            this.tipoEmpleado = tipoEmpleado;
            this.nRestaurante = nRestaurante;
        }

        public int getIdEmpleado() {
            return idEmpleado;
        }

        public void setIdEmpleado(int idEmpleado) {
            this.idEmpleado = idEmpleado;
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