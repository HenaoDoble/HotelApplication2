/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLogic;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author caalh
 */
public class DataConnection {
    
    /** referenciar el usuario y password con el cual me conectaré a la base de datos */
    private String usuario = "root"; 
    private String password = "";
    private String url= "jdbc:mysql://localhost:3306/base_hotel";
    
    private Connection conexion; 
    private Statement statement; /** permite ejecutar sentencias sql a través de la conexión establecida */
    
    public void CrearConexion(){
        
        try {
            /** metodos */
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();    /** permite ejecutar sentencias sql a través de la conexión establecida */
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Getconnection(){
        
        /** establecer conexión */
        Connection conexion; 
        Statement statement; /** permite ejecutar sentencias sql a través de la conexión establecida */
        ResultSet rs; /** sirve como objeto que tiene la capacidad de recibir la respuesta desde la base de datos, como el reflejo de una tabla */

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        /** establecer la conexion*/
        

    }
    
    public void AdicionarClientes(){
        
        CrearConexion();
        ResultSet rs; /** sirve como objeto que tiene la capacidad de recibir la respuesta desde la base de datos, como el reflejo de una tabla */

        try {            
            /**INSERTAR información a la base de datos, se debe cambiar el id cada vez que se corra el codigo para insertar un nuevo dato por ser llave primaria*/
            statement.executeUpdate("INSERT INTO tcliente (idtCliente, documento, nombre, apellidoP, apellidoM, telefono, origen, destino) VALUES ( 003, 8545990, 'Ivan', 'Parra', 'Muñoz', '315841354', 'cali', 'Palmira')");
            rs = statement.executeQuery("SELECT * FROM tcliente");             
            System.out.println( "Se ha añadido un nuevo cliente."); /** mensaje */                

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List ObtenerTodosClientes(){
        
        List listaClientes = new List();
        CrearConexion();
        ResultSet rsClientes;
        
        try {
            rsClientes = statement.executeQuery("SELECT * FROM tcliente");
            rsClientes.next();
            
            do {
                listaClientes.add(rsClientes.getString("nombre") + " " + rsClientes.getString("apellidoP"));
            } while(rsClientes.next());
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
    
    public String ObtenerClienteXId (int idCliente){
        
        String cliente = "";
        CrearConexion();
        ResultSet rsCliente;
        
        try {
            rsCliente = statement.executeQuery("SELECT * FROM tcliente WHERE idtCliente = "+ idCliente);
            rsCliente.next();
            
            if (rsCliente.getRow() != 0) {
                cliente = rsCliente.getString("nombre") + " " + rsCliente.getString("apellidoP");
            } else {
                cliente = "No existe un cliente con el Id " + idCliente;
            }
            
            
        } catch (SQLException e) {
             Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return cliente;
    }
    
     public String EliminarCliente (int idCliente){
        
        String respuesta = "";
        CrearConexion();
       
        
        try {
          boolean result = statement.execute("delete from tcliente where idtCliente =" + idCliente);
          respuesta = "El cliente ha sido eliminado";
            
            
        } catch (SQLException e) {
             Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, e);
             respuesta = "El cliente NO se ha eliminado";
             
        }
        
        return respuesta;
    }

    
}
