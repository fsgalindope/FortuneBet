/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import data.Cliente;
import java.util.TreeMap;

/**
 *
 * @author FABIa
 */
    
public class InicioCliente {
    private static Cliente clienteActual;

    public static boolean verificarCliente(String cliente, String contraseña, TreeMap<String,Cliente> baseDatosCliente){
        
        
        for(Cliente clientesBaseDatos: baseDatosCliente.values()){
            if((cliente == null ? clientesBaseDatos.getUsuario()== null : cliente.equals(clientesBaseDatos.getUsuario()))&&(contraseña == null ? clientesBaseDatos.getContraseña() == null : contraseña.equals(clientesBaseDatos.getContraseña()))){
                
                Cliente cliente1;
                cliente1 = baseDatosCliente.get(contraseña);
                clienteActual=cliente1;
                return true;
            }
        }
        
        return false;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }
    
    public InicioCliente() {
    }
    
}
