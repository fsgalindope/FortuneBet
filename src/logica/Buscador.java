
package logica;

//import Datos.CatalogoDataBaseHandler;
//import Datos.Licor;
//import Datos.Producto;
import data.Apuesta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Buscador {
    
    
    public static ArrayList<Apuesta> tiemposRecientes(ArrayList<Apuesta> productos)//preciosBajos
    {
        ArrayList<Apuesta> ordenProductos =productos;
        Collections.sort(ordenProductos, (Apuesta p1, Apuesta p2) -> new Double(p1.getTiempo()).compareTo(p2.getTiempo()));
        return ordenProductos;
    }
    public static ArrayList<Apuesta> tiemposMenosrecientes(ArrayList<Apuesta> productos){
        ArrayList<Apuesta> ordenProductos=productos;
        Collections.sort(ordenProductos, (Apuesta p2, Apuesta p1) -> new Double(p1.getTiempo()).compareTo(p2.getTiempo()));
        return ordenProductos;
    }

    public static ArrayList<Apuesta> filtroDeporte (String tipo,ArrayList<Apuesta> catalogo){
       
        ArrayList<Apuesta> catalogoTipo = new ArrayList<>();
        tipo=tipo.toUpperCase();
        for (int i=0; i<catalogo.size();i++){
            if((tipo.equals(catalogo.get(i).getDeporte().toUpperCase()))){
                catalogoTipo.add(catalogo.get(i));              
            }  
        } 
    return catalogoTipo;
    }

    
    
    
    
}
