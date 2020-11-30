package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Agente
 */
public class Agente {
    //Atributos de la clase
    protected static Agente mInstancia=null;
    protected Connection mBD;
    
    //Atributos pertenecientes a la conexión
    private static final String IP = "20.49.186.234";
    private static final String NUMPUERTO="1521";
    private static final String NOMBREUSUARIO="ISO2";
    private static final String CONTRASENAUSUARIO="ISO2";
    
    /**
     * Constructor de la clase
     * @throws Exception
     */
    protected Agente() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.mBD = DriverManager.getConnection("jdbc:oracle:thin:@"+IP+":"+NUMPUERTO+":xe",NOMBREUSUARIO,CONTRASENAUSUARIO);
    }
    
    /**
     * Método destinado a la obtención del 
     * Objeto Agente desde otras clases
     * @return Objeto Agente
     * @throws Exception 
     */
    public static Agente getAgente() throws Exception {
        if (mInstancia==null) {
            mInstancia=new Agente();
        }
        return mInstancia;
    }
    
    /**
     * Método destinado
     * a la obtención de datos
     * interactuando con la base de datos
     * @param sql sentencia
     * @return ResulSet con la información solicitada
     */
    public ArrayList select (String sql) {
        try {
            Statement sentencia = mBD.createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            
            return resultSetToArrayList(result);
        } catch (SQLException ex) {
            System.out.println("[ Comidas Cinquillo ] >> Error al buscar datos en la base de datos : "+ex.getMessage());
            return null;
        }
    }
    
    private ArrayList resultSetToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList results = new ArrayList();

        while (rs.next()) {
            HashMap row = new HashMap();
            results.add(row);

            for(int i=1; i<=columns; i++){
                row.put(md.getColumnName(i),rs.getObject(i));
            }
        }
        return results;
    }

    /**
     * Método destinado
     * a la inserción de datos
     * interactuando con la base de datos
     * @param sql sentencia
     */
    public void insert (String sql) {
        try {
            Statement sentencia = mBD.createStatement();
            int filasInsertadas = sentencia.executeUpdate(sql);
            
            if (filasInsertadas==1) {
                System.out.println("[ Comidas Cinquillo ] >> Se ha insertado correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("[ Comidas Cinquillo ] >> Error al insertar datos en la base de datos : "+ex.getMessage());
        }
    }
    
    /**
     * Método destinado
     * a la actualización de datos
     * interactuando con la base de datos
     * @param sql sentencia
     */
    public void update (String sql) {
        try {
            Statement sentencia = mBD.createStatement();
            int filas = sentencia.executeUpdate(sql);
            
            System.out.println("[ Comidas Cinquillo ] >> Se han actualizado "+filas);
        } catch (SQLException ex) {
            System.out.println("[ Comidas Cinquillo ] >> Error al actualizar datos en la base de datos : "+ex.getMessage());
        }
    }
    
    /**
     * Método destinado
     * a la eliminación de datos
     * interactuando con la base de datos
     * @param sql sentencia
     */
    public void delete (String sql) {
        try {
            Statement sentencia = mBD.createStatement();
            int filasBorradas = sentencia.executeUpdate(sql);
            
            if (filasBorradas==1) {
                System.out.println("[ Comidas Cinquillo ] >> Se ha borrado correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("[ Comidas Cinquillo ] >> Error al borrar registro en la base de datos : "+ex.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            mBD.close();
        } catch (SQLException ex) {
            System.out.println("[ Comidas Cinquillo ] >> Error al desconectarse de la base de datos : "+ex.getMessage());
        }
    }
}
