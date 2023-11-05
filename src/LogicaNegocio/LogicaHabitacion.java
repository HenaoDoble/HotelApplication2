/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import DataLogic.DataConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caalh
 */
public class LogicaHabitacion {
    
    private Connection conexion; 
    private Statement statement;
    
    public void AdicionarHabitacion(){
        
        DataConnection conexion = new DataConnection();
        conexion.CrearConexion();
        ResultSet rs; /** sirve como objeto que tiene la capacidad de recibir la respuesta desde la base de datos, como el reflejo de una tabla */

        try {            
            /**INSERTAR información a la base de datos, se debe cambiar el id cada vez que se corra el codigo para insertar un nuevo dato por ser llave primaria*/
            statement.executeUpdate("INSERT INTO tcliente (idtCliente, documento, nombre, apellidoP, apellidoM, telefono, origen, destino) VALUES (002, 6525965, 'Carlos', 'henao', 'henao', '3783155', 'Versalles', 'Cali')");
            rs = statement.executeQuery("SELECT * FROM thabitacion");             
            System.out.println( "Se ha añadido una nueva habitacion."); /** mensaje */                

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
