/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;




import Ui.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
/**
 *
 * @author FABIa
 */
public class Control {
    static String getAlphaNumericString(int n) { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
    public static void main(String[] args) {
        TreeMap<String, Administrador> baseDatosAdministrador = new TreeMap<>();
        TreeMap<String, Cliente> baseDatosClientes = new TreeMap<>();
        ArrayList<Apuesta> listaDeApuestas = new ArrayList<> ();
        
        
        
        
        Random ramdongene = new Random();
        String [] deportes ={"futbol","ciclismo","tenis","basketball","baseball","americano"};
        
        
        int f=100;
        for (int i=0;i<=f;i++){
            int p= ramdongene.nextInt(6);
            
            listaDeApuestas.add(new Apuesta(1, "Real Madrid vs Barcelona",deportes[p], "activo","española", 2.1,2));
            
        
        }
        Apuesta apuesta1 = new Apuesta(1, "Real Madrid vs Barcelona","futbol", "activo","española", 2.1,10);
        Apuesta apuesta2 = new Apuesta(2, "Roger Federer vs Rafael Nadal","tenis", "activo","Wimbledon", 2.1,9);
        Apuesta apuesta3 = new Apuesta(3, "Chicago Bulls vs Miami Heat","basketball", "activo","NBA", 2.1,7);
        Apuesta apuesta4 = new Apuesta(1, " vs ","baseball", "activo","", 2.1,1);
        Apuesta apuesta5 = new Apuesta(1, "Real Madrid vs Barcelona","ciclismo", "activo","española", 2.1,6);
        Apuesta apuesta6 = new Apuesta(1, "Real Madrid vs Barcelona","futbol", "activo","española", 2.1,5);
        Apuesta apuesta7 = new Apuesta(1, "Real Madrid vs Barcelona","futbol", "activo","española", 2.1,4);
        Apuesta apuesta8 = new Apuesta(1, "Real Madrid vs Barcelona","futbol", "activo","española", 2.1,3);
        listaDeApuestas.add(new Apuesta(1, "Real Madrid vs Barcelona","futbol", "activo","española", 2.1,2));
        listaDeApuestas.add(apuesta1);
        listaDeApuestas.add(apuesta2);
        listaDeApuestas.add(apuesta3);
        listaDeApuestas.add(apuesta4);
        listaDeApuestas.add(apuesta5);
        listaDeApuestas.add(apuesta6);
        listaDeApuestas.add(apuesta7);
        listaDeApuestas.add(apuesta8);
        ArrayList<Object> hola = new ArrayList<>();
        hola.add(apuesta1);
        hola.add(hola.remove(0));
        
        
        
        Cliente prueba = new Cliente( 0, 0, 0, "fabian", "galindo", "correo", "f", "f");
        Cliente prueba1 = new Cliente( 0, 0, 0, "fabian", "galindo", "correo", "1", "1f");
        Cliente prueba2 = new Cliente( 0, 0, 0, "fabian", "galindo", "correo", "2", "2");
        
        baseDatosClientes.put(prueba.getContraseña(),prueba);
        baseDatosClientes.put(prueba1.getContraseña(),prueba1);
        baseDatosClientes.put(prueba2.getContraseña(),prueba2);
        
        
        
        
        
//        int n=20;
//        int m=100000000;
//        for ( int i=0;i<=m;i++){
//          String contraseña = Control.getAlphaNumericString(n);
//        
//            
//        Cliente prueba3 = new Cliente( 0, 0, 0, "fabian", "galindo", "correo",contraseña, "2");
//        baseDatosClientes.put(prueba3.getContraseña(),new Cliente( 0, 0, 0, "fabian", "galindo", "correo",contraseña, "2"));
//        }
        
        UiInicioCliente inicio = new UiInicioCliente(baseDatosClientes,listaDeApuestas);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        //Graphics g = new Graphics();
        //inicio.paintAll(g);
        
    }  
}
