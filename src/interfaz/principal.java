
        
package interfaz;

import estructuras.bitacora;
import estructuras.carpeta;
import estructuras.graphivArbolAVL;
import estructuras.graphvizBitacora;
import estructuras.graphvizGrafo;
import estructuras.graphvizMatriz;
import estructuras.graphvizTablaHash;
import estructuras.matriz;
import estructuras.opUsuarios;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author GUDIEL
 */
public class principal extends javax.swing.JFrame {
    
    opUsuarios misUsuarios; 
    bitacora historial;
    graphvizTablaHash gvTabHashgvTabHash;
    graphivArbolAVL gvArbolAVL;
    graphvizGrafo gvGrafo;
    graphvizBitacora gvBitacora;
    graphvizMatriz gvMatriz;
    String tablaHashGraphviz="";
    String arbolAVLGrapvhiz="";
    String grafoGraphviz="";
    String bitacoraGraphviz="";
    String matrizGraphviz="";
    
    public principal() {
                            
        initComponents();
        
        //inicializando listas
        misUsuarios=new opUsuarios();
        historial=new bitacora();
        gvTabHashgvTabHash=new graphvizTablaHash();
        gvArbolAVL=new graphivArbolAVL();
        gvGrafo= new graphvizGrafo();
        gvBitacora=new graphvizBitacora();
        gvMatriz=new graphvizMatriz();
        
        areaPestan.setSelectedIndex(0);
        areaPestan.setEnabledAt(1, false);
        areaPestan.setEnabledAt(2, false);
        
        /* 7 primeras posiciones de tabla hash */
        DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
        for (int i = 0; i < 7; i++) 
        {
            Object [] fila= new Object[5];
            fila[0]=i;
            fila[1]="-";
            fila[2]="-";
            fila[3]="-";
            fila[4]="-";
            modeloUsCargados.addRow(fila);            
        }
        tableUscargados.setModel(modeloUsCargados);
        
        jpanelOcu.setVisible(false);
        /*--------------------------------------*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaPestan = new javax.swing.JTabbedPane();
        jpLogin = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        bttIngresar = new javax.swing.JButton();
        bttRegistrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsError = new javax.swing.JTable();
        bttCargaMasivaUs = new javax.swing.JButton();
        bttCerrarSesionAdmin = new javax.swing.JButton();
        jpanelOcu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUscargados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableUsuariosOrden = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtableUsMostrarCarga = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bttCrearCarpeta = new javax.swing.JButton();
        bttEliminarCarpeta = new javax.swing.JButton();
        bttModificarCarpeta = new javax.swing.JButton();
        bttCrearArchivo = new javax.swing.JButton();
        bttCompartirArchivo = new javax.swing.JButton();
        bttModificarArchivo = new javax.swing.JButton();
        bttSubirArchivo = new javax.swing.JButton();
        bttEliminarArchivo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRutaActual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreUsuarioActual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableCarpeArchivos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtContenidoArchivo = new javax.swing.JTextField();
        bttActualizarRuta = new javax.swing.JButton();
        bttCerrarSesion = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMostrarRuta = new javax.swing.JTextField();
        bttDescargarArchivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bttActualizarGraphTablHash = new javax.swing.JButton();
        bttActualizarGraphArbolAVL = new javax.swing.JButton();
        scrollPaneReportes = new javax.swing.JScrollPane();
        bttActualizarGrafo = new javax.swing.JButton();
        bttActualizarBitacora = new javax.swing.JButton();
        bttActualizarMatriz = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        reporteTabHash = new javax.swing.JMenuItem();
        reporteGrafo = new javax.swing.JMenuItem();
        reporteMatriz = new javax.swing.JMenuItem();
        reporteAVL = new javax.swing.JMenuItem();
        reporteBitacora = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDD DRIVE");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpLogin.setBackground(new java.awt.Color(102, 102, 102));

        bttIngresar.setText("INGRESAR");
        bttIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttIngresarActionPerformed(evt);
            }
        });

        bttRegistrar.setText("REGISTRAR");
        bttRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addComponent(bttIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword))
                .addGap(561, 561, 561))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(420, Short.MAX_VALUE))
        );

        areaPestan.addTab("LOGIN", jpLogin);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIOS CARGADOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 31, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USUARIOS CON ERROR");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        tableUsError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO", "PASSWORD", "DESCRIPCION"
            }
        ));
        jScrollPane2.setViewportView(tableUsError);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 1430, 230));

        bttCargaMasivaUs.setText("CARGA MASIVA DE USUARIOS");
        bttCargaMasivaUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCargaMasivaUsActionPerformed(evt);
            }
        });
        jPanel2.add(bttCargaMasivaUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, 50));

        bttCerrarSesionAdmin.setText("CERRAR SESION");
        bttCerrarSesionAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCerrarSesionAdminActionPerformed(evt);
            }
        });
        jPanel2.add(bttCerrarSesionAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 200, 50));

        jpanelOcu.setBackground(new java.awt.Color(51, 51, 255));
        jpanelOcu.setLayout(null);

        tableUscargados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDICE", "USUARIO", "PASSWORD", "TIMESTAMP", "PASSWORD ENCRIPTADA"
            }
        ));
        jScrollPane1.setViewportView(tableUscargados);

        jpanelOcu.add(jScrollPane1);
        jScrollPane1.setBounds(39, 0, 1439, 60);

        tableUsuariosOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDICE", "USUARIO", "PASSWORD", "TIMESTAMP", "PASSWORD ENCRIPTADA"
            }
        ));
        jScrollPane4.setViewportView(tableUsuariosOrden);

        jpanelOcu.add(jScrollPane4);
        jScrollPane4.setBounds(38, 66, 1440, 60);

        jPanel2.add(jpanelOcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1490, 140));

        jtableUsMostrarCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDICE", "USUARIO", "PASSWORD", "TIMESTAMP", "PASSWORD ENCRIPTADA"
            }
        ));
        jScrollPane5.setViewportView(jtableUsMostrarCarga);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1440, 220));

        areaPestan.addTab("ADMINISTRADOR", jPanel2);

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ARCHIVOS");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 190, -1));

        bttCrearCarpeta.setText("CREAR");
        bttCrearCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCrearCarpetaActionPerformed(evt);
            }
        });
        jPanel4.add(bttCrearCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 44));

        bttEliminarCarpeta.setText("ELIMINAR");
        bttEliminarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarCarpetaActionPerformed(evt);
            }
        });
        jPanel4.add(bttEliminarCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 190, 44));

        bttModificarCarpeta.setText("MODIFICAR");
        bttModificarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttModificarCarpetaActionPerformed(evt);
            }
        });
        jPanel4.add(bttModificarCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 190, 44));

        bttCrearArchivo.setText("CREAR");
        bttCrearArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCrearArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttCrearArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 190, 44));

        bttCompartirArchivo.setText("COMPARTIR");
        bttCompartirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCompartirArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttCompartirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, 44));

        bttModificarArchivo.setText("MODIFICAR");
        bttModificarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttModificarArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttModificarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 190, 44));

        bttSubirArchivo.setText("SUBIR");
        bttSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSubirArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttSubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 190, 44));

        bttEliminarArchivo.setText("ELIMINAR");
        bttEliminarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttEliminarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 190, 44));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CARPETAS");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, -1));
        jPanel4.add(txtRutaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 770, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("RUTA ACTUAL:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, 30));
        jPanel4.add(txtNombreUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 30, 200, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("USUARIO:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 30, -1, 30));

        jtableCarpeArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CONTENIDO", "RUTA", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableCarpeArchivos.setRowHeight(30);
        jtableCarpeArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableCarpeArchivosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtableCarpeArchivos);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 1240, 510));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("RUTA:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 80, 30));
        jPanel4.add(txtContenidoArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, 1370, 30));

        bttActualizarRuta.setText("ACTUALIZAR RUTA");
        bttActualizarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarRutaActionPerformed(evt);
            }
        });
        jPanel4.add(bttActualizarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 1240, 40));

        bttCerrarSesion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bttCerrarSesion.setText("CERRAR SESION");
        bttCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(bttCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 26, 190, 90));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CONTENIDO:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 669, -1, 20));
        jPanel4.add(txtMostrarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 1370, 30));

        bttDescargarArchivo.setText("DESCARGAR");
        bttDescargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttDescargarArchivoActionPerformed(evt);
            }
        });
        jPanel4.add(bttDescargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 190, 40));

        areaPestan.addTab("PERFIL USUARIO", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(null);

        bttActualizarGraphTablHash.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttActualizarGraphTablHash.setText("TABLA HASH");
        bttActualizarGraphTablHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarGraphTablHashActionPerformed(evt);
            }
        });
        jPanel1.add(bttActualizarGraphTablHash);
        bttActualizarGraphTablHash.setBounds(10, 10, 240, 60);

        bttActualizarGraphArbolAVL.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttActualizarGraphArbolAVL.setText("ARBOL AVL");
        bttActualizarGraphArbolAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarGraphArbolAVLActionPerformed(evt);
            }
        });
        jPanel1.add(bttActualizarGraphArbolAVL);
        bttActualizarGraphArbolAVL.setBounds(320, 10, 240, 60);
        jPanel1.add(scrollPaneReportes);
        scrollPaneReportes.setBounds(10, 80, 1490, 650);

        bttActualizarGrafo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttActualizarGrafo.setText("GRAFO");
        bttActualizarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(bttActualizarGrafo);
        bttActualizarGrafo.setBounds(640, 10, 240, 60);

        bttActualizarBitacora.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttActualizarBitacora.setText("BITACORA");
        bttActualizarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarBitacoraActionPerformed(evt);
            }
        });
        jPanel1.add(bttActualizarBitacora);
        bttActualizarBitacora.setBounds(950, 10, 240, 60);

        bttActualizarMatriz.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bttActualizarMatriz.setText("MATRIZ");
        bttActualizarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarMatrizActionPerformed(evt);
            }
        });
        jPanel1.add(bttActualizarMatriz);
        bttActualizarMatriz.setBounds(1260, 10, 240, 60);

        areaPestan.addTab("REPORTES", jPanel1);

        getContentPane().add(areaPestan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1520, 770));

        jMenu1.setText("GENERAR REPORTES");

        reporteTabHash.setText("TABLA HASH");
        reporteTabHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteTabHashActionPerformed(evt);
            }
        });
        jMenu1.add(reporteTabHash);

        reporteGrafo.setText("GRAFO");
        reporteGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteGrafoActionPerformed(evt);
            }
        });
        jMenu1.add(reporteGrafo);

        reporteMatriz.setText("MATRIZ");
        reporteMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteMatrizActionPerformed(evt);
            }
        });
        jMenu1.add(reporteMatriz);

        reporteAVL.setText("AVL");
        reporteAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteAVLActionPerformed(evt);
            }
        });
        jMenu1.add(reporteAVL);

        reporteBitacora.setText("BITACORA");
        reporteBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteBitacoraActionPerformed(evt);
            }
        });
        jMenu1.add(reporteBitacora);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reporteTabHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteTabHashActionPerformed
        
        try {
            gvTabHashgvTabHash.generarGrafica(tableUscargados);        
            String a=gvTabHashgvTabHash.listTablaHash.get(0);
            tablaHashGraphviz=a;
            bttActualizarGraphTablHash.setBackground(Color.GREEN);
            bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
            bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
            bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
            bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error","Error",JOptionPane.ERROR_MESSAGE);
        }                
    }//GEN-LAST:event_reporteTabHashActionPerformed

    private void reporteGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteGrafoActionPerformed
       
        try {
            misUsuarios.generarGrafo(txtNombreUsuarioActual.getText());
            String a=gvGrafo.listGrafo.get(0);        
            grafoGraphviz=a;
            bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
            bttActualizarGrafo.setBackground(Color.GREEN);
            bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
            bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
            bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error","Error",JOptionPane.ERROR_MESSAGE);
        }
        
       
    }//GEN-LAST:event_reporteGrafoActionPerformed

    private void reporteMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteMatrizActionPerformed

        try {
            misUsuarios.generarGraphMatriz(txtNombreUsuarioActual.getText());
            String a=gvMatriz.listMatriz.get(0);        
            matrizGraphviz=a;
            bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
            bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
            bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
            bttActualizarMatriz.setBackground(Color.GREEN);
            bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
//        matriz nuevo=new matriz();
//        nuevo.insertar("a", "b", "ab");
//        nuevo.insertar("a", "c", "ac");
//        nuevo.insertar("a", "d", "ad");
//        nuevo.insertar("b", "a", "ba");
//        nuevo.insertar("b", "c", "bc");
//        
//        misUsuarios.generarGraphMatriz2("a", nuevo.getRoot());
        
//        String key="/videos/musica/";
//        String key2=key.substring(0,key.length()-1);
//        int key3=key2.lastIndexOf("/");
//        String nombre=key2.substring(key3+1,key2.length());
//        System.out.println(nombre);
        

//        //usuario1
//       misUsuarios.insertar("gudiel");
//       misUsuarios.insertarCarpetaParaUsuario("gudiel", "/"); //usuario, ruta
//       //usuario2
//       misUsuarios.insertar("cris");
//       misUsuarios.insertarCarpetaParaUsuario("cris", "/"); //usuario, ruta
//       
//       txtNombreUsuarioActual.setText("gudiel");
//       txtRutaActual.setText("/");  
       
       
//       
//       tableUscargados.setValueAt("gudiel", 1, 1);
//       tableUscargados.setValueAt("g", 1, 2);
//       
//       tableUscargados.setValueAt("cris", 0, 1);
//       tableUscargados.setValueAt("c", 0, 2);
       //misUsuarios.generarGrafo(txtNombreUsuarioActual.getText());
       //misUsuarios.imprimir();
    }//GEN-LAST:event_reporteMatrizActionPerformed

    private void reporteAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteAVLActionPerformed
        
        try {
            misUsuarios.generarArbolDeCarpeta(txtNombreUsuarioActual.getText(),txtRutaActual.getText());
            String a=gvArbolAVL.listArbol.get(0);
            arbolAVLGrapvhiz=a;
            bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
            bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
            bttActualizarGraphArbolAVL.setBackground(Color.GREEN);
            bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
            bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        /*arbol_AVL miTree=new arbol_AVL();
        graphivArbolAVL naa=new graphivArbolAVL();        
        Node root=null;        
        root=miTree.insertar(root, "nana50","a");
        root=miTree.insertar(root, "hilo17","b");
        root=miTree.insertar(root, "fosa12","c");
        root=miTree.insertar(root, "mas23","d");
        root=miTree.insertar(root, "rana72","e");
        root=miTree.insertar(root, "paso54","f");
        root=miTree.insertar(root, "toma76","g");
        root=miTree.insertar(root, "aja9","h");
        root=miTree.insertar(root, "gudiel14","i");
        root=miTree.insertar(root, "lazo19","j");
        root=miTree.insertar(root, "oso54","k");
        root=miTree.deleteNode(root, "toma76");
        naa.generarGrafica(root);*/
        
        //opUsuarios us=new opUsuarios();
        //se crea usuario y carpeta raiz
       
//        //se inserta una nueva carpeta al grafo (nuevo nodo)
//        misUsuarios.insertarCarpetaParaUsuario("Gudiel","/documentos/");//usuario, carpetaPadre, rutaCarpeta, nombreCarpeta
//        //se crea una carpeta Documentos Dentro de Raiz (se agrega como hijo)
//        misUsuarios.insertarCarpetaHijo("Gudiel","/",new carpeta("videos","/videos/")); // us, carpPadre, carpeta a insertar
//        misUsuarios.insertarCarpetaHijo("Gudiel","/",new carpeta("usac","/usac/")); 
//        misUsuarios.insertarCarpetaHijo("Gudiel","/",new carpeta("image","/image/")); 
//        
//        misUsuarios.insertarCarpetaHijo("Gudiel","/documentos/",new carpeta("mp4","/documentos/mp4/")); // us, carpPadre, rutaCarpetaAcrear, nombreCarpeta
//        misUsuarios.insertarCarpetaHijo("Gudiel","/documentos/",new carpeta("mp3","/documentos/mp3//")); // us, carpPadre, rutaCarpetaAcrear, nombreCarpeta
        //se crea una carpeta Documentos Dentro de Raiz (se agrega como hijo)
        //misUsuarios.insertarCarpetaComoHijo("Gudiel", "/documentos/","/documentos/videos/","videos"); // us, carpPadre, rutaCarpetaAcrear, nombreCarpeta
        //se inserta una nueva carpeta al grafo (nuevo nodo)
        //misUsuarios.insertarCarpetaParaUsuario("Gudiel", "/documentos/", "/documentos/videos/","videos");//usuario, carpetaPadre, rutaCarpeta, nombreCarpeta
        //insertamos archivos a carpeta
//        misUsuarios.insertarArchivoACarpeta("/", "hello.py", "hola mundo", "12-12", "Gudiel");
//        misUsuarios.insertarArchivoACarpeta("/", "alo.py", "hola 2", "13-12", "Gudiel");
//        misUsuarios.insertarArchivoACarpeta("/", "pollo.py", "hola 3", "14-12", "Gudiel");
        //misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, "Gudiel", "/");
        //System.out.println(us.existeCarpeta("Gudiel", "/"));
       // misUsuarios.imprimir();
        
        
    }//GEN-LAST:event_reporteAVLActionPerformed

    private void bttRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegistrarActionPerformed
        DefaultTableModel modeloUsError=(DefaultTableModel) tableUsError.getModel();
                
        String nombre = JOptionPane.showInputDialog("Ingrese nombre para registrar:");
        String password = JOptionPane.showInputDialog("Ingrese password para registrar:");
        try {
            
            if (!nombre.equals(""))
            {
                if (misUsuarios.existeUsuario(nombre)==false)
                {
                    if (password.length()>=8)
                    {
                        try {
                            Date date = new Date();
                            DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
                            
                            ingresarEnTablaHash(nombre, password, obtenerHash(password),horaActual.format(date));
                            
                            DefaultTableModel modeloUsOrden=(DefaultTableModel) tableUsuariosOrden.getModel();
                            Object [] filao= new Object[5];
                            filao[0]="";
                            filao[1]=nombre;
                            filao[2]=password;
                            filao[3]=horaActual.format(date);
                            filao[4]=obtenerHash(password);
                            modeloUsOrden.addRow(filao);
                            tableUsuariosOrden.setModel(modeloUsOrden);
                            
                            //agregando a la lista y creando carpeta raiz
                            misUsuarios.insertar(nombre);
                            misUsuarios.insertarCarpetaParaUsuario(nombre, "/");
                            
                            historial.insertar("Se registro nuevo usuario con nombre: "+nombre, horaActual.format(date), "sistema");
                            
                            int porc=saberPorcentajeDeTabla(tableUscargados.getRowCount());
                            System.out.println("porce: "+porc);
                            
                                    if (porc<25) 
                                    {
                                        DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
                                        int sig=siguienteNumeroPrimo(tableUscargados.getRowCount());
                                        int op1=tableUscargados.getRowCount();
                                        int op2=sig-op1;
                                        for (int i = 0; i < op2; i++) 
                                        {
                                            System.out.println("agregando... "+i);
                                            Object [] fila= new Object[5];
                                            fila[0]="-";
                                            fila[1]="-";
                                            fila[2]="-";
                                            fila[3]="-";
                                            fila[4]="-";
                                            modeloUsCargados.addRow(fila);
                                        }
                                        tableUscargados.setModel(modeloUsCargados);
                                        recalcularIndices();
                                        insertarIndices();
                                    }
                        } catch (Exception e) {
                            System.out.println("puede que el usuario cayo en un ciclo!");
                        }
                        JOptionPane.showMessageDialog(null, "Usuario registrado");
                    }else
                    {
                        Object [] fila= new Object[3];
                        fila[0]=nombre;
                        fila[1]=password;
                        fila[2]="La Password contiene menos de 8 caracteres";
                        modeloUsError.addRow(fila);
                        JOptionPane.showMessageDialog(null, "Usuario no registrado");
                    }
                }else
                {
                    Object [] fila= new Object[3];
                    fila[0]=nombre;
                    fila[1]=password;
                    fila[2]="El nombre de usuario ya existe";
                    modeloUsError.addRow(fila);
                    JOptionPane.showMessageDialog(null, "Usuario no registrado");
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "Usuario no registrado");
            }
            
        } catch (Exception e) {
        }        
        
        tableUsError.setModel(modeloUsError);
    }//GEN-LAST:event_bttRegistrarActionPerformed

    private void bttIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttIngresarActionPerformed
        if (txtUsuario.getText().equals("") || txtPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ingrese datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else
        {
            if (txtUsuario.getText().equals("admin") || txtPassword.getText().equals("admin"))
            {
                areaPestan.setSelectedIndex(1);
                areaPestan.setEnabledAt(0, false);
                areaPestan.setEnabledAt(1, true);
                areaPestan.setEnabledAt(2, false);
            }
            else
            {
                for (int i = 0; i < tableUscargados.getRowCount(); i++) 
                {
                    String nombre=tableUscargados.getValueAt(i, 1).toString();
                    String passw=tableUscargados.getValueAt(i, 2).toString();
                    if (txtUsuario.getText().equals(nombre) && txtPassword.getText().equals(passw)) 
                    {
                        txtRutaActual.setText("/");
                        txtNombreUsuarioActual.setText(nombre);
                        
                        areaPestan.setSelectedIndex(2);
                        areaPestan.setEnabledAt(0, false);
                        areaPestan.setEnabledAt(1, false);
                        areaPestan.setEnabledAt(2, true);
                        
                        //actualizando
                        DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                        for (int j = jtableCarpeArchivos.getRowCount()-1; j >= 0; j--) 
                        {
                            modelo.removeRow(j);
                        }
                        misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, nombre, "/");                        
                    }                    
                           
                }
            }
        }
    }//GEN-LAST:event_bttIngresarActionPerformed

    private void bttCargaMasivaUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCargaMasivaUsActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingrese direccion del arhivo CSV");
        try {
            if (!nombre.equals("")) 
            {
              Date date = new Date();
              DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
              leerCSVUsuarios(nombre);
              historial.insertar("Carga masiva de usuarios con nombre: "+nombre,horaActual.format(date) , "admin");
            }
        } catch (Exception e) {
        }        
        
        for (int i = 0; i < jtableUsMostrarCarga.getRowCount(); i++) 
        {
            jtableUsMostrarCarga.setValueAt(i, i, 0);
        }
        
    }//GEN-LAST:event_bttCargaMasivaUsActionPerformed

    private void bttCrearCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCrearCarpetaActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingrese nombre de carpeta");
        Date date = new Date();
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
              
        try {
            if (!nombre.equals("")) 
            {
                String rutCarpeAInsertar=txtRutaActual.getText()+nombre+"/";
                if (misUsuarios.existeCarpeta(txtNombreUsuarioActual.getText(), rutCarpeAInsertar)==false) 
                {                    
                    //
                    misUsuarios.insertarCarpetaParaUsuario(txtNombreUsuarioActual.getText(), rutCarpeAInsertar);
                    misUsuarios.insertarCarpetaHijo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), new carpeta(nombre,rutCarpeAInsertar));
                    historial.insertar("Se creo carpeta con nombre: "+nombre, horaActual.format(date), txtNombreUsuarioActual.getText());
                    //misUsuarios.imprimir();
                    //eliminando contenido de tabla
                    DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                    for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                    {
                        modelo.removeRow(i);
                    }
                    //actualizando visor de archivos y carpetas
                    misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                }else
                {
                    historial.insertar("Error al crear carpeta, en el directorio existe carpeta con mismo nombre: "+nombre, horaActual.format(date), txtNombreUsuarioActual.getText());
                    JOptionPane.showMessageDialog(null, "Error al modificar carpeta, en el directorio existe carpeta con mismo nombre!");
                }
            }
        } catch (Exception e) {
        } 
    }//GEN-LAST:event_bttCrearCarpetaActionPerformed

    private void jtableCarpeArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableCarpeArchivosMouseClicked
        int posicion=jtableCarpeArchivos.rowAtPoint(evt.getPoint());
        if (evt.getClickCount()==2)
        {
            if (jtableCarpeArchivos.getValueAt(posicion, 3).toString().equals("carpeta")) 
            {
                txtRutaActual.setText(jtableCarpeArchivos.getValueAt(posicion, 2).toString());
            }
        }else
        {
            txtContenidoArchivo.setText(jtableCarpeArchivos.getValueAt(posicion, 1).toString());
            txtMostrarRuta.setText(jtableCarpeArchivos.getValueAt(posicion, 2).toString());
        }
        
        
    }//GEN-LAST:event_jtableCarpeArchivosMouseClicked

    private void bttActualizarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarRutaActionPerformed
        
        if (misUsuarios.existeCarpeta(txtNombreUsuarioActual.getText(), txtRutaActual.getText())==true) 
        {
            DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
            for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
            {
                modelo.removeRow(i);
            }
            misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No existe extension de carpeta!");
        }
        
        
    }//GEN-LAST:event_bttActualizarRutaActionPerformed

    private void bttCrearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCrearArchivoActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingrese nombre de archivo");
        String contenido=JOptionPane.showInputDialog("Ingrese contenido de archivo");
        Date date = new Date();
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
        
        try {
            if (!nombre.equals("") && !contenido.equals("")) 
            {
                if (misUsuarios.existeArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText() , nombre)==false) 
                {                    
                    //se agrega archivo
                    misUsuarios.insertarArchivoACarpeta(txtRutaActual.getText(), nombre, contenido , horaActual.format(date), txtNombreUsuarioActual.getText());
                    historial.insertar("Se creo archivo con nombre: "+nombre, horaActual.format(date), txtNombreUsuarioActual.getText());
                    //eliminando contenido de tabla
                    DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                    for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                    {
                        modelo.removeRow(i);
                    }
                    //actualizando visor de archivos y carpetas
                    misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                }else
                {
                    int resp = JOptionPane.showConfirmDialog(null, "¿El archivo ya existe, desea reemplazarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if (resp==0) 
                    {
                        misUsuarios.modificarArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), nombre, nombre, contenido, nombre);
                    }
                }
            }
        } catch (Exception e) {
        } 
    }//GEN-LAST:event_bttCrearArchivoActionPerformed

    private void bttCompartirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCompartirArchivoActionPerformed
        String nombreUsAcompartir = JOptionPane.showInputDialog("Ingrese nombre de usuario a compartir archivo");
        try {
            if (!nombreUsAcompartir.equals("")) 
            {
                int fila=jtableCarpeArchivos.getSelectedRow();
                if (fila>=0) 
                {  
                    String nomArchi=jtableCarpeArchivos.getValueAt(fila, 0).toString();
                    String contenidoArchivoSeleccionado=jtableCarpeArchivos.getValueAt(fila, 1).toString();
                    Date date = new Date();
                    DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    
                    if (misUsuarios.existeUsuario(nombreUsAcompartir)==true) //si el usuario existe
                    {                    
                        if (misUsuarios.existeArchivo(nombreUsAcompartir, "/", nomArchi)==false) //si no existe archivo, inserta
                        {
                            misUsuarios.insertarArchivoACarpeta("/", nomArchi, contenidoArchivoSeleccionado , horaActual.format(date) , nombreUsAcompartir);
                            historial.insertar("Se compartio un archivo con nombre: "+nomArchi, horaActual.format(date), txtNombreUsuarioActual.getText());
                            JOptionPane.showMessageDialog(null, "Archivo compartido!");
                        }
                        else //si ya existe sobre escribe
                        {
                            int resp = JOptionPane.showConfirmDialog(null, "¿El archivo ya existe en la raiz del usuario, desea reemplazarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
                            if (resp==0) 
                            {
                                misUsuarios.modificarArchivo(nombreUsAcompartir, "/", nomArchi, nomArchi, contenidoArchivoSeleccionado, horaActual.format(date));
                                JOptionPane.showMessageDialog(null, "Archivo compartido!");
                            }
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "No existe usuario");
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "Seleccione arcivo");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bttCompartirArchivoActionPerformed

    private void bttModificarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttModificarArchivoActionPerformed
       
        int fila=jtableCarpeArchivos.getSelectedRow();
        System.out.println(fila);
        if (fila>=0) //si selecciono fila
        {
           String nomArchiElim=jtableCarpeArchivos.getValueAt(fila, 0).toString();
           
            if (misUsuarios.existeArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText() , nomArchiElim)==true) 
            {
                String nombre = JOptionPane.showInputDialog("Ingrese nombre nuevo de archivo");
                String contenido=JOptionPane.showInputDialog("Ingrese contenido nuevo de archivo");
                Date date = new Date();
                DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    
                try {
                    if (!nombre.equals("") && !contenido.equals("")) 
                    {
                        misUsuarios.modificarArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), nomArchiElim, nombre , contenido, horaActual.format(date));
                        historial.insertar("Se modifico un archivo: "+nomArchiElim+" por "+nombre, horaActual.format(date), txtNombreUsuarioActual.getText());
                        //actualizando
                        DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                        for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                        {
                            modelo.removeRow(i);
                        }
                        misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                        JOptionPane.showMessageDialog(null, "Archivo modificado!");
                    }
                } catch (Exception e) {
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No existe usuario");
            }
        }
    }//GEN-LAST:event_bttModificarArchivoActionPerformed

    private void bttModificarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttModificarCarpetaActionPerformed

        int fila=jtableCarpeArchivos.getSelectedRow();        
        
        if (fila>=0) 
        {
            String rutCarpModi=jtableCarpeArchivos.getValueAt(fila, 2).toString();
            String nomCarpModi=jtableCarpeArchivos.getValueAt(fila, 0).toString();
            Date date = new Date();
            DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            
            try {
                String respp="¿Esta Seguro que desea modificar la carpeta con nombre: "+nomCarpModi+"?";
                int resp = JOptionPane.showConfirmDialog(null, respp, "Alerta!", JOptionPane.YES_NO_OPTION);
                
                if (resp==0) 
                {
                    String nombreNuevoCarpeta = JOptionPane.showInputDialog("Ingrese nombre nuevo de carpeta");
                    if (!nombreNuevoCarpeta.equals("")) 
                    {                       
                        int op1=nomCarpModi.length();
                        int op2=rutCarpModi.length();
                        int op3=op2-op1;
                        String rutaHastaDondeEstaCarpetaAModificar=rutCarpModi.substring(0,op3-1);
                        String nuevaRuta=rutaHastaDondeEstaCarpetaAModificar+nombreNuevoCarpeta+"/";
                        
                        if (misUsuarios.existeCarpeta(txtNombreUsuarioActual.getText(), nuevaRuta)==false) 
                        {
                            misUsuarios.modificarCarpeta(txtNombreUsuarioActual.getText(), rutCarpModi, nuevaRuta, nombreNuevoCarpeta);
                            historial.insertar("Se Modifico la carpeta con nombre: "+nomCarpModi, horaActual.format(date), txtNombreUsuarioActual.getText());
                            JOptionPane.showMessageDialog(null, "Carpeta modificada!");
                        }
                        else
                        {
                            historial.insertar("Error al modificar carpeta, en el directorio existe carpeta con mismo nombre: "+nombreNuevoCarpeta, horaActual.format(date), txtNombreUsuarioActual.getText());
                            JOptionPane.showMessageDialog(null, "Error al modificar carpeta, en el directorio existe carpeta con mismo nombre!");
                        }
                        
                            
                    } 
                }                                  
            } catch (Exception e) {
                System.out.println("error en modificar carpeta");
            }              
        }                
        
    }//GEN-LAST:event_bttModificarCarpetaActionPerformed

    private void bttActualizarGraphTablHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarGraphTablHashActionPerformed
        JLabel lblImagen=new JLabel();        
        ImageIcon imgi=new ImageIcon(tablaHashGraphviz);
        lblImagen.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        lblImagen.setIcon(imgi);
        
        JPanel aa=new JPanel();
        aa.add(lblImagen);
        aa.setBackground(Color.WHITE);
        aa.setPreferredSize(new Dimension(imgi.getIconWidth(), imgi.getIconHeight()));
        scrollPaneReportes.setViewportView(aa);
        
        bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
        bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
        bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
        bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
        bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_bttActualizarGraphTablHashActionPerformed

    private void bttActualizarGraphArbolAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarGraphArbolAVLActionPerformed
        JLabel lblImagen=new JLabel();        
        ImageIcon imgi=new ImageIcon(arbolAVLGrapvhiz);
        lblImagen.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        lblImagen.setIcon(imgi);
        
        JPanel aa=new JPanel();
        aa.add(lblImagen);
        aa.setBackground(Color.WHITE);
        aa.setPreferredSize(new Dimension(imgi.getIconWidth(), imgi.getIconHeight()));
        scrollPaneReportes.setViewportView(aa);
        
        bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
        bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
        bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
        bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
        bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        
    }//GEN-LAST:event_bttActualizarGraphArbolAVLActionPerformed

    private void bttEliminarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarArchivoActionPerformed
        int fila=jtableCarpeArchivos.getSelectedRow();

        if (fila>=0) //si selecciono fila
        {
           String nomArchiElim=jtableCarpeArchivos.getValueAt(fila, 0).toString();
           Date date = new Date();
           DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
           
           if (misUsuarios.existeArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText() , nomArchiElim)==true) 
            {
                String respp="¿Esta Seguro que desea eliminar el archivo "+nomArchiElim+"?";
                int resp = JOptionPane.showConfirmDialog(null, respp, "Alerta!", JOptionPane.YES_NO_OPTION);
                if (resp==0) 
                {
                    try {
                        misUsuarios.eliminarArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), nomArchiElim); 
                        historial.insertar("Se elimino un archivo con nombre: "+nomArchiElim, horaActual.format(date), txtNombreUsuarioActual.getText());
                        //eliminando contenido de tabla
                        DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                        for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                        {
                            modelo.removeRow(i);
                        }
                        //actualizando visor de archivos y carpetas
                        misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                        JOptionPane.showMessageDialog(null, "Archivo Eliminado!");
                    } catch (Exception e) {}                    
                }                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No existe usuario");
            }
        }
    }//GEN-LAST:event_bttEliminarArchivoActionPerformed

    private void bttSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSubirArchivoActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingrese direccion del arhivo CSV");
        Date date = new Date();
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
        
        try {
            if (!nombre.equals("")) 
            {
              leerCSVArchivos(nombre);
              historial.insertar("Carga masiva de archivos", horaActual.format(date), txtNombreUsuarioActual.getText());
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_bttSubirArchivoActionPerformed

    private void bttActualizarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarGrafoActionPerformed
        JLabel lblImagen=new JLabel();        
        ImageIcon imgi=new ImageIcon(grafoGraphviz);
        lblImagen.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        lblImagen.setIcon(imgi);
        
        JPanel aa=new JPanel();
        aa.add(lblImagen);
        aa.setBackground(Color.WHITE);
        aa.setPreferredSize(new Dimension(imgi.getIconWidth(), imgi.getIconHeight()));
        scrollPaneReportes.setViewportView(aa);
        
        bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
        bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
        bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
        bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
        bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
        //misUsuarios.imprimir();
    }//GEN-LAST:event_bttActualizarGrafoActionPerformed

    private void bttDescargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttDescargarArchivoActionPerformed
        int fila=jtableCarpeArchivos.getSelectedRow();

        if (fila>=0) //si selecciono fila
        {
           String nomArchi=jtableCarpeArchivos.getValueAt(fila, 0).toString();
           String contenido=jtableCarpeArchivos.getValueAt(fila, 1).toString();
           Date date = new Date();
           DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 

            String respp="¿Esta Seguro que desea descargar el archivo "+nomArchi+"?";
            int resp = JOptionPane.showConfirmDialog(null, respp, "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp==0) 
            {
                try {
                    descargarArchivo(nomArchi, contenido); 
                    historial.insertar("Se descargo archivo con nombre: "+nomArchi, horaActual.format(date), txtNombreUsuarioActual.getText());
                } catch (Exception e) {}                    
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione arcivo");
        }
    }//GEN-LAST:event_bttDescargarArchivoActionPerformed

    private void reporteBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteBitacoraActionPerformed
        
        try {
            historial.generarBitacora();
            String a=gvBitacora.listBitacora.get(0);        
            bitacoraGraphviz=a;
            bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
            bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
            bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
            bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
            bttActualizarBitacora.setBackground(Color.GREEN);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error","Error",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_reporteBitacoraActionPerformed

    private void bttActualizarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarBitacoraActionPerformed
        JLabel lblImagen=new JLabel();        
        ImageIcon imgi=new ImageIcon(bitacoraGraphviz);
        lblImagen.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        lblImagen.setIcon(imgi);
        
        JPanel aa=new JPanel();
        aa.add(lblImagen);
        aa.setBackground(Color.WHITE);
        aa.setPreferredSize(new Dimension(imgi.getIconWidth(), imgi.getIconHeight()));
        scrollPaneReportes.setViewportView(aa);
        
        bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
        bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
        bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
        bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
        bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_bttActualizarBitacoraActionPerformed

    private void bttEliminarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarCarpetaActionPerformed
        
        int fila=jtableCarpeArchivos.getSelectedRow();        
        
        if (fila>=0) 
        {
            String rutElim=jtableCarpeArchivos.getValueAt(fila, 2).toString();
            
            try {
                
                String respp="¿Esta Seguro que desea eliminar la carpeta con ruta: "+rutElim+"?";
                int resp = JOptionPane.showConfirmDialog(null, respp, "Alerta!", JOptionPane.YES_NO_OPTION);
                Date date = new Date();
                DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
           
                if (resp==0) 
                {
                    try {
                        misUsuarios.eliminarCarpeta(txtNombreUsuarioActual.getText(), rutElim);
                        historial.insertar("Se Elimino la carpeta con ruta: "+rutElim, horaActual.format(date), txtNombreUsuarioActual.getText());
                        JOptionPane.showMessageDialog(null, "Carpeta eliminada!");
                    } catch (Exception e) {}                    
                } 
                
            } catch (Exception e) {
                System.out.println("error en eliminar carpeta");
            }              
        } 
    }//GEN-LAST:event_bttEliminarCarpetaActionPerformed

    private void bttCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCerrarSesionActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Alerta!", JOptionPane.YES_NO_OPTION);

        if (resp==0) 
        {
            txtUsuario.setText("");
            txtPassword.setText("");
            areaPestan.setSelectedIndex(0);
            areaPestan.setEnabledAt(0, true);
            areaPestan.setEnabledAt(1, false);
            areaPestan.setEnabledAt(2, false);
        }
        
        //usuario1
       misUsuarios.insertar("gudiel");
       misUsuarios.insertarCarpetaParaUsuario("gudiel", "/"); //usuario, ruta
       //usuario2
       misUsuarios.insertar("cris");
       misUsuarios.insertarCarpetaParaUsuario("cris", "/"); //usuario, ruta
       
       txtNombreUsuarioActual.setText("gudiel");
       txtRutaActual.setText("/");  
//       
       
    }//GEN-LAST:event_bttCerrarSesionActionPerformed

    private void bttActualizarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarMatrizActionPerformed
        JLabel lblImagen=new JLabel();        
        ImageIcon imgi=new ImageIcon(matrizGraphviz);
        lblImagen.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        lblImagen.setIcon(imgi);
        
        JPanel aa=new JPanel();
        aa.add(lblImagen);
        aa.setBackground(Color.WHITE);
        aa.setPreferredSize(new Dimension(imgi.getIconWidth(), imgi.getIconHeight()));
        scrollPaneReportes.setViewportView(aa);
        
        bttActualizarGraphTablHash.setBackground(Color.LIGHT_GRAY);
        bttActualizarGrafo.setBackground(Color.LIGHT_GRAY);
        bttActualizarGraphArbolAVL.setBackground(Color.LIGHT_GRAY);
        bttActualizarMatriz.setBackground(Color.LIGHT_GRAY);
        bttActualizarBitacora.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_bttActualizarMatrizActionPerformed

    private void bttCerrarSesionAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCerrarSesionAdminActionPerformed
        
        int resp = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Alerta!", JOptionPane.YES_NO_OPTION);

        if (resp==0) 
        {
            txtUsuario.setText("");
            txtPassword.setText("");
            areaPestan.setSelectedIndex(0);
            areaPestan.setEnabledAt(0, true);
            areaPestan.setEnabledAt(1, false);
            areaPestan.setEnabledAt(2, false);
        }
    }//GEN-LAST:event_bttCerrarSesionAdminActionPerformed

    public void leerCSVUsuarios(String path) {
        
        //DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
        DefaultTableModel modeloUsError=(DefaultTableModel) tableUsError.getModel();
                
        try 
        {            
            int bandera=0;
            boolean bandera2=false;
            
            // Abro el .csv en buffer de lectura
            BufferedReader bufferLectura = new BufferedReader(new FileReader(path));

            // Leo una línea del archivo
            String linea = bufferLectura.readLine();

            while (linea != null) {
                    // Separa la línea leída con el separador definido previamente
                    String[] campos = linea.split(String.valueOf(','));
                    
                    if (bandera==0) //para saber en que columnas estan los usuarios
                    {
                        if (campos[0].toLowerCase().equals("usuario")) 
                        {
                            bandera2=true;
                        }
                    }
                    if (bandera>0 && bandera2==true) //quiere decir que los usuarios estan en la primera fila
                    {
                        if (misUsuarios.existeUsuario(campos[0])==false) //se valida si ya existe el usuario
                        {
                            if (campos[1].length()>=8) //si la contra tiene mas que 8 caracteres
                            {
                                Date date = new Date();
                                DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
                                
                                ingresarEnTablaHash(campos[0], campos[1], obtenerHash(campos[1]),horaActual.format(date)); 
                                
                                //se ingresa a la lista usuario y se crea su raiz
                                misUsuarios.insertar(campos[0]);
                                misUsuarios.insertarCarpetaParaUsuario(campos[0], "/");
                                
                                DefaultTableModel modeloUsOrden=(DefaultTableModel) tableUsuariosOrden.getModel();
                                DefaultTableModel modeloUsMostrarCarga=(DefaultTableModel) jtableUsMostrarCarga.getModel();
                                Object [] filao= new Object[5];
                                filao[0]="";
                                filao[1]=campos[0];
                                filao[2]=campos[1];
                                filao[3]=horaActual.format(date);
                                filao[4]=obtenerHash(campos[1]);
                                modeloUsOrden.addRow(filao);
                                modeloUsMostrarCarga.addRow(filao);
                                tableUsuariosOrden.setModel(modeloUsOrden);
                                jtableUsMostrarCarga.setModel(modeloUsMostrarCarga);                                
                                
                                int porc=saberPorcentajeDeTabla(tableUscargados.getRowCount());
                                System.out.println("porce: "+porc);
                                
                                if (porc<25) 
                                {
                                    DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
                                    int sig=siguienteNumeroPrimo(tableUscargados.getRowCount());
                                    int op1=sig-tableUscargados.getRowCount();
                                    for (int i = 0; i < op1; i++) 
                                    {
                                        Object [] fila= new Object[5];
                                        fila[0]="-";
                                        fila[1]="-";
                                        fila[2]="-";
                                        fila[3]="-";
                                        fila[4]="-";
                                        modeloUsCargados.addRow(fila);                                        
                                    }    
                                    tableUscargados.setModel(modeloUsCargados);
                                    //recalcularIndices();
                                    //insertarIndices();
                                }
                            }else
                            {
                                Object [] fila= new Object[3];
                                fila[0]=campos[0];
                                fila[1]=campos[1];
                                fila[2]="La Password contiene menos de 8 caracteres";
                                modeloUsError.addRow(fila);
                            }
                            
                        }else
                        {
                            Object [] fila= new Object[3];
                            fila[0]=campos[0];
                            fila[1]=campos[1];
                            fila[2]="El nombre de usuario ya existe";
                            modeloUsError.addRow(fila);
                        }
                        
                    }else if(bandera>0 && bandera2==false) //quiere decir que los usuarios estan en la segunda fila
                    {
                        
                    }
                    
                    // Vuelvo a leer del fichero
                    linea = bufferLectura.readLine();
                    
                    bandera++;
            }                     

            // CIerro el buffer de lectura
            if (bufferLectura != null) {
                    bufferLectura.close();
            }   
            recalcularIndices();
            insertarIndices();
            //tableUscargados.setModel(modeloUsCargados);
            tableUsError.setModel(modeloUsError);
            
                        
        } catch (Exception e) 
        { JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARCHIVO"); }                    
}
 
    public void leerCSVArchivos(String path) {
        
        try 
        {            
            int bandera=0;
            boolean bandera2=false;
            Date date = new Date();
            DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            
            // Abro el .csv en buffer de lectura
            BufferedReader bufferLectura = new BufferedReader(new FileReader(path));

            // Leo una línea del archivo
            String linea = bufferLectura.readLine();

            while (linea != null) {
                    // Separa la línea leída con el separador definido previamente
                    String[] campos = linea.split(String.valueOf(','));

                    if (bandera==0) //para saber en que columnas estan los usuarios
                    {
                        if (campos[0].toLowerCase().equals("archivo")) 
                        {
                            bandera2=true;
                        }
                    }
                    if (bandera>0 && bandera2==true) //quiere decir que los archivos estan en la primera fila
                    {
                        if (misUsuarios.existeArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText() , campos[0])==false) 
                        {    
                            
                            //se agrega archivo
                            misUsuarios.insertarArchivoACarpeta(txtRutaActual.getText(), campos[0], campos[1] , horaActual.format(date), txtNombreUsuarioActual.getText());
                            //eliminando contenido de tabla
                            DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                            for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                            {
                                modelo.removeRow(i);
                            }
                            //actualizando visor de archivos y carpetas
                            misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                        }else
                        {
                            int resp = JOptionPane.showConfirmDialog(null, "¿El archivo ya existe, desea reemplazarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
                            if (resp==0) 
                            {
                                misUsuarios.modificarArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), campos[0], campos[0], campos[1], horaActual.format(date));
                            }
                        }
                        
                    }else if(bandera>0 && bandera2==false) //quiere decir que los archivos estan en la segunda fila
                    {
                        if (misUsuarios.existeArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText() , campos[1])==false) 
                        {    
                            
                            //se agrega archivo
                            misUsuarios.insertarArchivoACarpeta(txtRutaActual.getText(), campos[1], campos[0] , horaActual.format(date), txtNombreUsuarioActual.getText());
                            //eliminando contenido de tabla
                            DefaultTableModel modelo=(DefaultTableModel) jtableCarpeArchivos.getModel();
                            for (int i = jtableCarpeArchivos.getRowCount()-1; i >= 0; i--) 
                            {
                                modelo.removeRow(i);
                            }
                            //actualizando visor de archivos y carpetas
                            misUsuarios.mostrarCarpetasYArchivos(jtableCarpeArchivos, txtNombreUsuarioActual.getText(), txtRutaActual.getText());
                        }else
                        {
                            int resp = JOptionPane.showConfirmDialog(null, "¿El archivo ya existe, desea reemplazarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
                            if (resp==0) 
                            {
                                misUsuarios.modificarArchivo(txtNombreUsuarioActual.getText(), txtRutaActual.getText(), campos[1], campos[1], campos[0], horaActual.format(date));
                            }
                        }
                    }
                    
                    // Vuelvo a leer del fichero
                    linea = bufferLectura.readLine();
                    
                    bandera++;
            }                     

            // CIerro el buffer de lectura
            if (bufferLectura != null) {
                    bufferLectura.close();
            }  
                        
        } catch (Exception e) 
        { JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARCHIVO"); }                    
}
         
    public String obtenerHash(String pass)
    {
        String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(pass.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
    public int saberPorcentajeDeTabla(int tamanioTabla)
    {
        int porce=0;
        
        for (int i = 0; i < tamanioTabla; i++) 
        {
            String value=tableUscargados.getValueAt(i, 1).toString();
            if (value.equals("-")) 
            {
                porce++;
            }            
        }
        
        int tamTabla=tamanioTabla;
        int op1 = porce*100;
        int op2=op1/tamTabla;
        System.out.println("Tabla: " + tamTabla + " op1: " + op1 + " op2: " + op2);
                
        return op2;        
    }
    
    public int indiceEnTablaHash(String nomb, int numeroVe)
    {
        int contador=0;
        for (int i = 0; i < nomb.length(); i++) 
        {
            char carac=nomb.charAt(i);
            contador=contador+(int)carac;
        }
        
        //se hace la opracion x mod k
        int tamTabla=tableUscargados.getRowCount();
        int op1= contador%tamTabla;
        
        //se verifica si esta ocupada la posicion
        int dondeIngresar=0;
        for (int i = 0; i < op1; i++) 
        {
            dondeIngresar++;
            if (dondeIngresar>(tableUscargados.getRowCount()-1)) 
            {
                dondeIngresar=0;
            }            
        }   
        
        String valor= tableUscargados.getValueAt(dondeIngresar, 1).toString();
        if (valor.equals("-")) 
        {
            return dondeIngresar;
        }
        else
        {
            
            return colision(op1, numeroVe);
            
            
        }
    }
    
    public int colision(int indiceOriginal, int numeroVe)
    {
        int nuevoIndice=indiceOriginal + (int)Math.pow(numeroVe, 2);
        int dondeIngresar=0;
        for (int i = 0; i < nuevoIndice; i++) 
        {
            dondeIngresar++;
            if (dondeIngresar>(tableUscargados.getRowCount()-1)) 
            {
                dondeIngresar=0;
            }
            
        } 
        String valor= tableUscargados.getValueAt(dondeIngresar, 1).toString();
        if (valor.equals("-")) 
        {
            return dondeIngresar;
        }
        else
        {
            try {
                return colision(indiceOriginal, numeroVe+1);
            } catch (Exception e) {
                System.out.println("se a producido un error, se inciclo!");
                int a=0;
                for (int i = 0; i < tableUscargados.getRowCount(); i++) {
                    String valor2= tableUscargados.getValueAt(i, 1).toString();
                    if (valor2.equals("")) 
                    {
                        break;
                    }
                    a++;
                }
                return a;
            }
            
        }
    }
    
    public void ingresarEnTablaHash(String nom, String pass, String hash, String fecha)
    {
        int dondeIngresar=indiceEnTablaHash(nom,1); //obtengo el indice de la tabla
        
        tableUscargados.setValueAt(dondeIngresar, dondeIngresar, 0);
        tableUscargados.setValueAt(nom, dondeIngresar, 1);
        tableUscargados.setValueAt(pass, dondeIngresar, 2);
        tableUscargados.setValueAt(fecha, dondeIngresar, 3);
        tableUscargados.setValueAt(hash, dondeIngresar, 4);      
               
        
    }
    
    public int siguienteNumeroPrimo(int primoActual)
    {
        int numactual=primoActual;
        boolean bandera=true;
        
        while (bandera==true) 
        {    
            numactual++;
            if (determinarSiEsPrimo(numactual)==true) 
            {
                bandera=false;
            } 
        }
        
        return numactual;
    }
    
    public boolean determinarSiEsPrimo(int value)
    {
        int contador=0;
        boolean resp=false;
        
        for (int i = 1; i <= value; i++) 
        {
            if ((value%i)==0) 
            {
                contador++;
            }
        }
        
        if (contador<=2) 
        {
            resp=true; //es primo
        }
        
        return resp;       
        
    }
    
    public void recalcularIndices()
    {
        int tamActual=tableUscargados.getRowCount();
        
        //limpiando tabla usuariosCargaods
        DefaultTableModel modelo=(DefaultTableModel) tableUscargados.getModel();
        for (int i = tableUscargados.getRowCount()-1; i >= 0; i--) 
        {
            modelo.removeRow(i);
        }
        
        DefaultTableModel modelo2=(DefaultTableModel) tableUscargados.getModel();
        for (int i = 0; i < tamActual; i++) 
        {
            Object [] fila= new Object[5];
            fila[0]="-";
            fila[1]="-";
            fila[2]="-";
            fila[3]="-";
            fila[4]="-";
            modelo.addRow(fila);
        }
        tableUscargados.setModel(modelo2);
        
        //recorrer la tabla de usuarios destructurada
        for (int i = 0; i < tableUsuariosOrden.getRowCount(); i++) 
        {
            String nom=tableUsuariosOrden.getValueAt(i, 1).toString();
            String pass=tableUsuariosOrden.getValueAt(i, 2).toString();
            String fech=tableUsuariosOrden.getValueAt(i, 3).toString();
            String passenc=tableUsuariosOrden.getValueAt(i, 4).toString();
            
            ingresarEnTablaHash(nom, pass, passenc,fech);            
        }
    }
    
    //actualizar indices en tabla hash
    public void insertarIndices()
    {
        for (int i = 0; i < tableUscargados.getRowCount(); i++) 
        {
            tableUscargados.setValueAt(i, i, 0);
        }
    }
    
    //descargar archivo
    public void descargarArchivo(String nomArchi, String contenido)
    {
        try {
            
            String ruta = PathActual()+"\\"+nomArchi+".txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            if(archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(contenido);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(contenido);
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Archivo descargado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione arcivo");
        }
                
    }
    
    public String PathActual(){
        String path="";
         File miDir = new File (".");
         try {
           //System.out.println (miDir.getCanonicalPath());
           path=miDir.getCanonicalPath();
         }
         catch(Exception e) {
           e.printStackTrace();
           }
         return path;
    } 
    
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane areaPestan;
    private javax.swing.JButton bttActualizarBitacora;
    private javax.swing.JButton bttActualizarGrafo;
    private javax.swing.JButton bttActualizarGraphArbolAVL;
    private javax.swing.JButton bttActualizarGraphTablHash;
    private javax.swing.JButton bttActualizarMatriz;
    private javax.swing.JButton bttActualizarRuta;
    private javax.swing.JButton bttCargaMasivaUs;
    private javax.swing.JButton bttCerrarSesion;
    private javax.swing.JButton bttCerrarSesionAdmin;
    private javax.swing.JButton bttCompartirArchivo;
    private javax.swing.JButton bttCrearArchivo;
    private javax.swing.JButton bttCrearCarpeta;
    private javax.swing.JButton bttDescargarArchivo;
    private javax.swing.JButton bttEliminarArchivo;
    private javax.swing.JButton bttEliminarCarpeta;
    private javax.swing.JButton bttIngresar;
    private javax.swing.JButton bttModificarArchivo;
    private javax.swing.JButton bttModificarCarpeta;
    private javax.swing.JButton bttRegistrar;
    private javax.swing.JButton bttSubirArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpanelOcu;
    private javax.swing.JTable jtableCarpeArchivos;
    private javax.swing.JTable jtableUsMostrarCarga;
    private javax.swing.JMenuItem reporteAVL;
    private javax.swing.JMenuItem reporteBitacora;
    private javax.swing.JMenuItem reporteGrafo;
    private javax.swing.JMenuItem reporteMatriz;
    private javax.swing.JMenuItem reporteTabHash;
    private javax.swing.JScrollPane scrollPaneReportes;
    private javax.swing.JTable tableUsError;
    private javax.swing.JTable tableUscargados;
    private javax.swing.JTable tableUsuariosOrden;
    private javax.swing.JTextField txtContenidoArchivo;
    private javax.swing.JTextField txtMostrarRuta;
    private javax.swing.JTextField txtNombreUsuarioActual;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtRutaActual;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
