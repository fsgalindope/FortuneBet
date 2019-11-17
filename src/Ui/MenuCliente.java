/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;


import data.Administrador;
import data.Apuesta;
import data.Cliente;
import data.QueueRefGeneric;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.wrapLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Buscador;


import logica.wrapLayout;


/**
 *
 * @author JAndres
 */
public class MenuCliente extends javax.swing.JFrame {
 
    /**
     * Creates new form GUIBuscador
     */
    QueueRefGeneric<Apuesta> listaApuestaOrdenada;
    String valorBusqueda;
    ArrayList<Apuesta> carrito;
    ArrayList<Apuesta> listaApuestas;
    TreeMap <String, Cliente> baseDatosClientes;
    TreeMap <String,Administrador> baseDatosAdministrador;

    public MenuCliente(TreeMap <String, Cliente> baseDatosClientes,ArrayList<Apuesta> listaApuestas,Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.listaApuestas = listaApuestas;
        this.baseDatosClientes=baseDatosClientes;
        this.baseDatosAdministrador= baseDatosAdministrador;
        crearCatalogo(listaApuestas);
        this.txtMin.setEnabled(false);
        this.txtMax.setEnabled(false);
        this.btnOrganizarPrecio.setEnabled(false);
        //setIconImage(new ImageIcon(getClass().getResource("/recursos/iconoPrincipal.png")).getImage());
        this.setTitle("Menu Cliente");
        jLabel10.setText("Mostrando "+listaApuestas.size()+" resultados.");
        ImageIcon icon= new ImageIcon();
        Icon iconScale;
        Image image= new ImageIcon(getClass().getResource("/recursos/FortuneBet1.jpg")).getImage();
        icon.setImage(image);
        iconScale = new ImageIcon(icon.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
        labelLogo.setIcon(iconScale);


    }

    private void organizarPrecio(boolean verdad) {

        if (verdad) {
            this.txtMin.setEnabled(true);
            this.txtMax.setEnabled(true);
            this.btnOrganizarPrecio.setEnabled(true);
        } else {
            this.txtMin.setEnabled(false);
            this.txtMax.setEnabled(false);
            this.btnOrganizarPrecio.setEnabled(false);
        }

    }

    private void crearCatalogo(ArrayList<Apuesta> catalogo) {

        panel1.removeAll();

        panel1.setLayout(new wrapLayout(wrapLayout.CENTER, 10, 10));

        catalogo.forEach((catalogo1) -> {
            panel1.add(crearProducto(catalogo1, panel1));
        });

        panel1.validate();
        panelOpciones.validate();
        panelOpciones.repaint();
    }
//     private void crearCatalogo1(QueueRefGeneric<Apuesta> catalogo) {
//
//        panel1.removeAll();
//
//        panel1.setLayout(new wrapLayout(wrapLayout.CENTER, 10, 10));
//        int tamaño = catalogo.getTamaño();
//        for (int i=0;i<tamaño;i++){
//            panel1.add(crearProducto(catalogo.dequeue(), panel1));
//            
//        }
//        
////        catalogo.forEach((catalogo1) -> {
////            panel1.add(crearProducto(catalogo1, panel1));
////        });
//
//        panel1.validate();
//        panelOpciones.validate();
//        panelOpciones.repaint();
//    }

    public void busquedaEspecifica(String valorBusqueda){
        ArrayList<Apuesta> busquedaEspecifica= new ArrayList<>();
        for (Apuesta prd: listaApuestas){
            if (prd.getDeporte().toUpperCase().contains(valorBusqueda)){
                busquedaEspecifica.add(prd);
            } else if (prd.getLiga().toUpperCase().contains(valorBusqueda)){
                if (!busquedaEspecifica.contains(prd)){
                    busquedaEspecifica.add(prd);
                }
            
            }else {//Recordar comparar por fecha
                
            }
        }
        crearCatalogo(busquedaEspecifica);
        //crearCatalogo(Buscador.preciosBajos(busquedaEspecifica));
        //jLabel10.setText("Mostrando "+Buscador.preciosBajos(busquedaEspecifica).size()+" resultados.");
    }
    public final Panel crearProducto(Apuesta apuesta, Panel panel) {
        
        //Licor licor;
        
        ImageIcon icon= new ImageIcon();
        Icon iconScale;
        Image image= new ImageIcon(getClass().getResource(apuesta.getImagen())).getImage();
        Panel panelProducto = new Panel();
        Dimension dimensioProducto = new Dimension(200, 200);
        panelProducto.setLayout(new BoxLayout(panelProducto, BoxLayout.Y_AXIS));
        panelProducto.setSize(dimensioProducto);
        panelProducto.setMinimumSize(dimensioProducto);
        panelProducto.setForeground(Color.black);
        JLabel cabecera = new JLabel("  ");
        JLabel deporte = new JLabel(apuesta.getDeporte());  //nombre
        //JLabel cuota = new JLabel("$" + String.valueOf(apuesta.getCuota())); //precio
        JLabel liga = new JLabel(apuesta.getLiga());
        /*if(producto.getClass().equals(Licor.class)){
            licor = (Licor) producto;
            if(licor.getFactorPromocion()!=1){
        precio.setText("$" + String.valueOf(producto.getPrecio())+"  -"+
                String.valueOf(Integer.valueOf((int) (100-licor.getFactorPromocion()*100)))+"%");   
            }
        }*/
        
        JLabel imagen = new JLabel();
        JLabel estado = new JLabel(apuesta.getDescripcion());  // lugar
        icon.setImage(image);
        iconScale = new ImageIcon(icon.getImage().getScaledInstance(panel.getWidth()/7, panel.getWidth()/7, Image.SCALE_FAST));
        imagen.setIcon(iconScale);

        cabecera.setAlignmentX(panelProducto.CENTER_ALIGNMENT);
        imagen.setAlignmentX(panelProducto.CENTER_ALIGNMENT);
        deporte.setAlignmentX(panelProducto.CENTER_ALIGNMENT);
        liga.setAlignmentX(panelProducto.CENTER_ALIGNMENT);
        estado.setAlignmentX(panelProducto.CENTER_ALIGNMENT);

        panelProducto.add(cabecera);
        panelProducto.add(imagen);
        panelProducto.add(deporte);
        panelProducto.add(liga);
        panelProducto.add(estado);

        panelProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*GUIProductoEspecifico mostrarProducto = new GUIProductoEspecifico(producto, catalogo, carrito,baseDatosUsuarios,controladorBaseUsuariosGeneracion,controladorBaseCatalogo);
                mostrarProducto.setVisible(rootPaneCheckingEnabled);
                dispose();*/
            }
        });

        panelProducto.setBackground(Color.WHITE);

        return panelProducto;

    }

    public MenuCliente() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        panelTitulo = new java.awt.Panel();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        irCarrito = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelOpciones = new java.awt.Panel();
        txtBuscadorEspecifico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jrbMenorMayor = new javax.swing.JRadioButton();
        jrbMayorMenor = new javax.swing.JRadioButton();
        jrbFutbol = new javax.swing.JRadioButton();
        jrbBasket = new javax.swing.JRadioButton();
        jrbTennis = new javax.swing.JRadioButton();
        jrbBaseball = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtMax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnOrganizarPrecio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jrbRango = new javax.swing.JRadioButton();
        jrbCiclismo = new javax.swing.JRadioButton();
        jrbJumbo = new javax.swing.JRadioButton();
        jrbCarulla = new javax.swing.JRadioButton();
        jrbExito = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        panel1 = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setName("Buscador"); // NOI18N

        panelTitulo.setBackground(new java.awt.Color(255, 81, 81));

        btnSalir.setBackground(new java.awt.Color(255, 204, 51));
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 81, 81));
        jLabel9.setFont(new java.awt.Font("Rockwell", 2, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FORTUNEBET");
        jLabel9.setOpaque(true);

        irCarrito.setBackground(new java.awt.Color(255, 204, 51));
        irCarrito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        irCarrito.setText("Carrito");
        irCarrito.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        irCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irCarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addComponent(irCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(irCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jScrollPane1.setOpaque(false);

        panelOpciones.setBackground(new java.awt.Color(240, 240, 240));
        panelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscadorEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorEspecificoActionPerformed(evt);
            }
        });
        txtBuscadorEspecifico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorEspecificoKeyTyped(evt);
            }
        });
        panelOpciones.add(txtBuscadorEspecifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 126, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Qué estas buscando?");
        panelOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 143, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Organizar por:");
        panelOpciones.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, 27));

        buttonGroup1.add(jrbMenorMayor);
        jrbMenorMayor.setText("Precio: menor a mayor");
        jrbMenorMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMenorMayorActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbMenorMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 183, 30));

        buttonGroup1.add(jrbMayorMenor);
        jrbMayorMenor.setText("Precio:mayor a menor");
        jrbMayorMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMayorMenorActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbMayorMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 183, -1));

        buttonGroup1.add(jrbFutbol);
        jrbFutbol.setText("Futbol");
        jrbFutbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFutbolActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbFutbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 179, -1));

        buttonGroup1.add(jrbBasket);
        jrbBasket.setText("Basketball");
        jrbBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBasketActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbBasket, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 179, -1));

        buttonGroup1.add(jrbTennis);
        jrbTennis.setText("Tenis");
        jrbTennis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTennisActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbTennis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 179, -1));

        buttonGroup1.add(jrbBaseball);
        jrbBaseball.setText("Baseball");
        jrbBaseball.setToolTipText("");
        jrbBaseball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBaseballActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbBaseball, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 179, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");
        panelOpciones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 82, -1));

        txtMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinKeyTyped(evt);
            }
        });
        panelOpciones.add(txtMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 79, -1));

        txtMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxKeyTyped(evt);
            }
        });
        panelOpciones.add(txtMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 79, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("min.");
        panelOpciones.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 51, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("max.");
        panelOpciones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 51, 20));

        btnBuscar.setBackground(new java.awt.Color(255, 204, 51));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelOpciones.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 90, 25));

        btnOrganizarPrecio.setBackground(new java.awt.Color(255, 204, 51));
        btnOrganizarPrecio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOrganizarPrecio.setText("Organizar");
        btnOrganizarPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOrganizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizarPrecioActionPerformed(evt);
            }
        });
        panelOpciones.add(btnOrganizarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 80, 25));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Deporte:");
        panelOpciones.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 73, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Liga:");
        panelOpciones.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        buttonGroup1.add(jrbRango);
        jrbRango.setText("Seleccionar rango");
        jrbRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbRangoActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 184, -1));

        buttonGroup1.add(jrbCiclismo);
        jrbCiclismo.setText("Ciclismo");
        jrbCiclismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCiclismoActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbCiclismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 179, -1));

        buttonGroup1.add(jrbJumbo);
        jrbJumbo.setText("TIPO1");
        jrbJumbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbJumboActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbJumbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        buttonGroup1.add(jrbCarulla);
        jrbCarulla.setText("TIPO1");
        jrbCarulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCarullaActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbCarulla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        buttonGroup1.add(jrbExito);
        jrbExito.setText("TIPO1");
        jrbExito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbExitoActionPerformed(evt);
            }
        });
        panelOpciones.add(jrbExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jScrollPane1.setViewportView(panelOpciones);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mostrando resultados:");

        panel1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        scrollPane1.add(panel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?",
                "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jrbExitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbExitoActionPerformed
        
    }//GEN-LAST:event_jrbExitoActionPerformed

    private void jrbCarullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCarullaActionPerformed
        
    }//GEN-LAST:event_jrbCarullaActionPerformed

    private void jrbJumboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbJumboActionPerformed
      
    }//GEN-LAST:event_jrbJumboActionPerformed

    private void jrbCiclismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCiclismoActionPerformed
        organizarPrecio(false);
        crearCatalogo(Buscador.filtroDeporte(jrbCiclismo.getText(), listaApuestas));
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando " + String.valueOf(Buscador.filtroDeporte(jrbCiclismo.getText(), listaApuestas).size()) + " resultados.");
    }//GEN-LAST:event_jrbCiclismoActionPerformed

    private void jrbRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbRangoActionPerformed
        // TODO add your handling code here:
        organizarPrecio(true);
    }//GEN-LAST:event_jrbRangoActionPerformed

    private void btnOrganizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizarPrecioActionPerformed
      
    }//GEN-LAST:event_btnOrganizarPrecioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        valorBusqueda=this.txtBuscadorEspecifico.getText().toUpperCase();
        busquedaEspecifica(valorBusqueda);
        organizarPrecio(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxKeyTyped
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxKeyTyped

    private void txtMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinKeyTyped
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinKeyTyped

    private void jrbBaseballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBaseballActionPerformed
        crearCatalogo(Buscador.filtroDeporte(jrbBaseball.getText(), listaApuestas));
        organizarPrecio(false);
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.filtroDeporte(jrbBaseball.getText(), listaApuestas).size())+" resultados.");
    }//GEN-LAST:event_jrbBaseballActionPerformed

    private void jrbTennisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTennisActionPerformed
        // TODO add your handling code here:
        crearCatalogo(Buscador.filtroDeporte(jrbTennis.getText(),listaApuestas ));
        organizarPrecio(false);
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.filtroDeporte(jrbTennis.getText(), listaApuestas).size())+" resultados.");
    }//GEN-LAST:event_jrbTennisActionPerformed

    private void jrbBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBasketActionPerformed
        // TODO add your handling code here:
        crearCatalogo(Buscador.filtroDeporte(jrbBasket.getText(), listaApuestas));
        organizarPrecio(false);
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.filtroDeporte(jrbBasket.getText(), listaApuestas).size())+" resultados.");
    }//GEN-LAST:event_jrbBasketActionPerformed

    private void jrbFutbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFutbolActionPerformed
        // TODO add your handling code here:
        organizarPrecio(false);
        crearCatalogo(Buscador.filtroDeporte(jrbFutbol.getText(), listaApuestas));
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.filtroDeporte(jrbFutbol.getText(), listaApuestas).size())+" resultados.");
    }//GEN-LAST:event_jrbFutbolActionPerformed

    private void jrbMayorMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMayorMenorActionPerformed
        /*crearCatalogo(Buscador.preciosAltos(catalogo));
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.preciosAltos(catalogo).size())+" resultados.");
        organizarPrecio(false);*/
    }//GEN-LAST:event_jrbMayorMenorActionPerformed

    private void jrbMenorMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMenorMayorActionPerformed
        /*ArrayList<Apuesta> aux = Buscador.tiemposRecientes(listaApuestas);
        for(int i=0;i<aux.size();i++){
            
            
            listaApuestaOrdenada.enqueue(aux.get(listaApuestas.size()-i-1));
        }
        crearCatalogo1(listaApuestaOrdenada);
        jLabel10.validate();
        jLabel10.repaint();
        jLabel10.setText("Mostrando "+String.valueOf(Buscador.tiemposMenosrecientes(listaApuestas).size())+" resultados.");
        organizarPrecio(false);*/
    }//GEN-LAST:event_jrbMenorMayorActionPerformed

    private void txtBuscadorEspecificoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorEspecificoKeyTyped
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetter(tecla)&&!Character.isSpace(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscadorEspecificoKeyTyped

    private void txtBuscadorEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorEspecificoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorEspecificoActionPerformed

    private void irCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irCarritoActionPerformed
       
    }//GEN-LAST:event_irCarritoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOrganizarPrecio;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton irCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbBaseball;
    private javax.swing.JRadioButton jrbBasket;
    private javax.swing.JRadioButton jrbCarulla;
    private javax.swing.JRadioButton jrbCiclismo;
    private javax.swing.JRadioButton jrbExito;
    private javax.swing.JRadioButton jrbFutbol;
    private javax.swing.JRadioButton jrbJumbo;
    private javax.swing.JRadioButton jrbMayorMenor;
    private javax.swing.JRadioButton jrbMenorMayor;
    private javax.swing.JRadioButton jrbRango;
    private javax.swing.JRadioButton jrbTennis;
    private javax.swing.JLabel labelLogo;
    private java.awt.Panel panel1;
    private java.awt.Panel panelOpciones;
    private java.awt.Panel panelTitulo;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField txtBuscadorEspecifico;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    // End of variables declaration//GEN-END:variables
}
