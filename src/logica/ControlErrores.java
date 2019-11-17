
package logica;

import java.util.Scanner;


public class ControlErrores {
    public int seleccionGeneral(String string, int integer, Scanner scanner, boolean comprobar){
        return integer;
    }
    
    public double seleccionGeneralDouble(String string, double doubleValue, Scanner scanner, boolean comprobar){
        return doubleValue;
    }
    
    public static boolean comprobacionNumerica(String stringOpcion){
        try {
            Integer.valueOf(stringOpcion);
            return true;
        } catch (NumberFormatException excepcionNumero){
            return false;
        }
    }
    
    public static boolean comprobacionNumericaDouble(String string){
        try {
            Double.valueOf(string);
            return true;
        } catch (NumberFormatException excepcionDouble){
            return false;
        }
    }
}
