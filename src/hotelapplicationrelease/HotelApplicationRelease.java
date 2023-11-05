/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelapplicationrelease;

import DataLogic.DataConnection;
import java.awt.List;

/**
 *
 * @author caalh
 */
public class HotelApplicationRelease {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataLogic.DataConnection logicaBaseDatos = new DataConnection();
        //Llamado al metodo encargado de adicionar un cliente a la base de datos...
        logicaBaseDatos.AdicionarClientes();
        
        //Llamado al metodo encargado de consultar los clientes a la base de datos...
        List clientes = logicaBaseDatos.ObtenerTodosClientes();
        System.out.println("Los clientes existentes son: ");
        for (int i = 0; i < clientes.getItemCount(); i++) {
            System.out.println(i+ 1 + ": " + clientes.getItem(i));
        } 
        
        //llamado al metodo de consultar un cliente por Id
        String cliente = logicaBaseDatos.ObtenerClienteXId(1);
        System.out.println("El cliente es: "+ cliente);
        
        //Llamado al metodo encargado de eliminar un registro de la tabla tclientes....
        String respuesta = logicaBaseDatos.EliminarCliente(1);
        System.out.println(respuesta);
        
    }
    
}
