/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author FABIa
 */
public class Administrador extends Usuario {

    public Administrador(Stack<Cliente> listaClientes, int id, String nombre, String apellido, String correo, String usuario, String contraseña) {
        super(id, nombre, apellido, correo, usuario, contraseña);
        this.listaClientes = listaClientes;
    }
    
    private Stack<Cliente> listaClientes;
    
    
}
