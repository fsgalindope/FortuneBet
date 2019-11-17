
package logica;

import data.Cliente;
//import Datos.UsuariosDataBaseHandler;
import java.util.TreeMap;


public class GeneracionCliente {
    
    public static boolean validarDatosIngresados(String nombre,String apellido,String correo,String usuario,String contraseña,String reingresoContraseña, String edad,String id,TreeMap<String,Cliente> baseDatos){
        

        if(nombre==null||apellido==null||correo==null||usuario==null||contraseña==null||reingresoContraseña==null||edad==null){
            return false;
        }
        if(!contraseña.equals(reingresoContraseña)){
            return false;
        }
        if(!ControlErrores.comprobacionNumerica(edad)){
            return false;
        }

        if(!ControlErrores.comprobacionNumerica(id)){
            return false;
        }
        
        if (!baseDatos.values().stream().noneMatch((usuariosBaseDatos) -> (usuario.equals(usuariosBaseDatos.getUsuario())))) {
            return false;
        }
        
        for(Cliente generador: baseDatos.values()){
            if(generador.getId()==Integer.parseInt(id)){
                return false;
            }
        }
        

        return true;
    }

    
  public static Cliente crearCliente (TreeMap<String,Cliente> baseDatos,int id, String nombre, String apellido, int edad, String correo, String usuario, String contraseña){        
        
        return (new Cliente( id, edad, id, nombre, apellido, correo, usuario, contraseña));
        
    }    
}
