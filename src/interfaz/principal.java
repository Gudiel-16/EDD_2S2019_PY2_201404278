
        
package interfaz;

import estructuras.arbol_AVL;
import estructuras.arbol_AVL.Node;
import estructuras.graphivArbolAVL;
import estructuras.opUsuarios;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author GUDIEL
 */
public class principal extends javax.swing.JFrame {
            
    public principal() {
                            
        initComponents();
        
        /* 7 primeras posiciones de tabla hash */
        DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
        for (int i = 0; i < 7; i++) 
        {
            Object [] fila= new Object[3];
            fila[0]="";
            fila[1]="";
            fila[2]="";
            modeloUsCargados.addRow(fila);            
        }
        tableUscargados.setModel(modeloUsCargados);
        /*--------------------------------------*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaPestan = new javax.swing.JTabbedPane();
        jpLogin = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        bttIngresar = new javax.swing.JButton();
        bttRegistrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUscargados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsError = new javax.swing.JTable();
        bttCargaMasivaUs = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        bttCompartirCarpeta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bttCrearCarpeta = new javax.swing.JButton();
        bttEliminarCarpeta = new javax.swing.JButton();
        bttModificarCarpeta = new javax.swing.JButton();
        bttCrearArchivo = new javax.swing.JButton();
        bttCompartirArchivo = new javax.swing.JButton();
        bttModificarArchivo = new javax.swing.JButton();
        bttSubirArchivo = new javax.swing.JButton();
        bttSubirCarpeta = new javax.swing.JButton();
        bttEliminarArchivo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpReportes = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        reporteTabHash = new javax.swing.JMenuItem();
        reporteGrafo = new javax.swing.JMenuItem();
        reporteMatriz = new javax.swing.JMenuItem();
        reporteAVL = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpLogin.setBackground(new java.awt.Color(153, 153, 255));

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
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addComponent(bttIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(561, 561, 561))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
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
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        tableUscargados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDICE", "USUARIO", "PASSWORD", "TIMESTAMP", "PASSWORD ENCRIPTADA"
            }
        ));
        jScrollPane1.setViewportView(tableUscargados);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 69, 1439, 298));

        tableUsError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO", "PASSWORD", "DESCRIPCION"
            }
        ));
        jScrollPane2.setViewportView(tableUsError);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 1430, 290));

        bttCargaMasivaUs.setText("CARGA MASIVA DE USUARIOS");
        bttCargaMasivaUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCargaMasivaUsActionPerformed(evt);
            }
        });
        jPanel2.add(bttCargaMasivaUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, -1, 50));

        areaPestan.addTab("ADMINISTRADOR", jPanel2);

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttCompartirCarpeta.setText("COMPARTIR");
        jPanel4.add(bttCompartirCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 141, 44));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ARCHIVOS");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        bttCrearCarpeta.setText("CREAR");
        jPanel4.add(bttCrearCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 141, 44));

        bttEliminarCarpeta.setText("ELIMINAR");
        jPanel4.add(bttEliminarCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 141, 44));

        bttModificarCarpeta.setText("MODIFICAR");
        jPanel4.add(bttModificarCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 141, 44));

        bttCrearArchivo.setText("CREAR");
        jPanel4.add(bttCrearArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 423, 141, 44));

        bttCompartirArchivo.setText("COMPARTIR");
        jPanel4.add(bttCompartirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 479, 141, 44));

        bttModificarArchivo.setText("MODIFICAR");
        jPanel4.add(bttModificarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 141, 44));

        bttSubirArchivo.setText("SUBIR");
        jPanel4.add(bttSubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 141, 44));

        bttSubirCarpeta.setText("SUBIR");
        jPanel4.add(bttSubirCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 141, 44));

        bttEliminarArchivo.setText("ELIMINAR");
        jPanel4.add(bttEliminarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 141, 44));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CARPETAS");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        areaPestan.addTab("PERFIL USUARIO", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jpReportesLayout = new javax.swing.GroupLayout(jpReportes);
        jpReportes.setLayout(jpReportesLayout);
        jpReportesLayout.setHorizontalGroup(
            jpReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1491, Short.MAX_VALUE)
        );
        jpReportesLayout.setVerticalGroup(
            jpReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        areaPestan.addTab("REPORTES", jPanel1);

        getContentPane().add(areaPestan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1520, 770));

        jMenu1.setText("REPORTES");

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

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reporteTabHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteTabHashActionPerformed
        
        jpReportes.removeAll();
        jpReportes.revalidate();
        jpReportes.repaint();
        
        graphivArbolAVL naa=new graphivArbolAVL();        
        String a=naa.listArbol.get(0);
        System.out.println(a);
        JLabel aa=new JLabel();        
        ImageIcon imgi=new ImageIcon(a);
        aa.setBounds(0, 0, imgi.getIconWidth(), imgi.getIconHeight());
        aa.setIcon(imgi);
        
        JPanel aja=new JPanel();
        aja.add(aa);
        
        JScrollPane jsp = new JScrollPane(aja);
        jsp.setBounds(0, 0, 1491, 718);
        jsp.setViewportView(aja);
        
        jpReportes.add(jsp);
        jpReportes.revalidate();
        jpReportes.repaint();
        
        
    }//GEN-LAST:event_reporteTabHashActionPerformed

    private void reporteGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteGrafoActionPerformed
        System.out.println(saberPorcentajeDeTabla());
        int op=146 % 7;
        int op2=146 % 11;
        int op3=146 % 17;
        int op4=146 % 19;
        System.out.println(op);
        System.out.println(op2);
        System.out.println(op3);
        System.out.println(op4);
        
    }//GEN-LAST:event_reporteGrafoActionPerformed

    private void reporteMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteMatrizActionPerformed
        areaPestan.setEnabledAt(0, true);
    }//GEN-LAST:event_reporteMatrizActionPerformed

    private void reporteAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteAVLActionPerformed
                
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
        
        opUsuarios us=new opUsuarios();
        us.insertar("Gudiel");
        us.insertarGrafoRaiz("Gudiel", "principal", "/");
        us.insertar("Chris");
        us.insertarGrafoRaiz("Chris", "raiz", "/documentos/");
        us.imprimir();
        
        
    }//GEN-LAST:event_reporteAVLActionPerformed

    private void bttRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegistrarActionPerformed
        DefaultTableModel modeloUsError=(DefaultTableModel) tableUsError.getModel();
        DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
        
        String nombre = JOptionPane.showInputDialog("Ingrese nombre para registrar:");
        String password = JOptionPane.showInputDialog("Ingrese password para registrar:");
        try {
            
            if (!nombre.equals(""))
            {
                if (validarExistenciaUsuario(nombre)==false)
                {
                    if (password.length()>=8)
                    {
                        ingresarEnTablaHash(nombre, password, obtenerHash(password));
                        int porc=saberPorcentajeDeTabla();
                                //System.out.println(porc);
                                if (porc<25) 
                                {
                                    int sig=siguienteNumeroPrimo(tableUscargados.getRowCount());
                                    int op1=sig-tableUscargados.getRowCount();
                                    for (int i = 0; i < op1; i++) 
                                    {
                                        Object [] fila= new Object[5];
                                        fila[0]="";
                                        fila[1]="";
                                        fila[2]="";
                                        fila[3]="";
                                        fila[4]="";
                                        modeloUsCargados.addRow(fila);
                                    }
                                }
                    }else
                    {
                        Object [] fila= new Object[3];
                        fila[0]=nombre;
                        fila[1]=password;
                        fila[2]="La Password contiene menos de 8 caracteres";
                        modeloUsError.addRow(fila);
                    }
                }else
                {
                    Object [] fila= new Object[3];
                    fila[0]=nombre;
                    fila[1]=password;
                    fila[2]="El nombre de usuario ya existe";
                    modeloUsError.addRow(fila);
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "SE PRODUJO UN ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
        }        
        
        tableUsError.setModel(modeloUsError);
    }//GEN-LAST:event_bttRegistrarActionPerformed

    private void bttIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttIngresarActionPerformed
        if (txtUsuario.getText().equals("") || txtPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "INGRESE DATOS", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else
        {
            if (txtUsuario.getText().equals("admin") || txtPassword.getText().equals("admin"))
            {
                areaPestan.setSelectedIndex(1);
            }
            else
            {
                //registrar usuario
            }
        }
    }//GEN-LAST:event_bttIngresarActionPerformed

    private void bttCargaMasivaUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCargaMasivaUsActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingrese direccion del arhivo CSV");
        try {
            if (!nombre.equals("")) 
            {
                leerCSVSimple(nombre);
            }
        } catch (Exception e) {
        }        
        
    }//GEN-LAST:event_bttCargaMasivaUsActionPerformed

    public void leerCSVSimple(String path) {
        
        DefaultTableModel modeloUsCargados=(DefaultTableModel) tableUscargados.getModel();
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
                        if (validarExistenciaUsuario(campos[0])==false) //se valida si ya existe el usuario
                        {
                            if (campos[1].length()>=8) //si la contra tiene mas que 8 caracteres
                            {
                                ingresarEnTablaHash(campos[0], campos[1], obtenerHash(campos[1]));
                                int porc=saberPorcentajeDeTabla();
                                if (porc<25) 
                                {
                                    int sig=siguienteNumeroPrimo(tableUscargados.getRowCount());
                                    int op1=sig-tableUscargados.getRowCount();
                                    for (int i = 0; i < op1; i++) 
                                    {
                                        Object [] fila= new Object[5];
                                        fila[0]="";
                                        fila[1]="";
                                        fila[2]="";
                                        fila[3]="";
                                        fila[4]="";
                                        modeloUsCargados.addRow(fila);
                                    }
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
                        if (validarExistenciaUsuario(campos[1])==false) //se valida si ya existe el usuario
                        {
                            if (campos[0].length()>=8) //si la contra tiene mas que 8 caracteres
                            {
                                Object [] fila= new Object[3];
                                fila[0]=campos[1];
                                fila[1]=campos[0];
                                fila[2]=obtenerHash(campos[1]);
                                modeloUsCargados.addRow(fila);
                            }else
                            {
                                Object [] fila= new Object[3];
                                fila[0]=campos[1];
                                fila[1]=campos[0];
                                fila[2]="La Password contiene menos de 8 caracteres";
                                modeloUsError.addRow(fila);
                            }
                            
                        }else
                        {
                            Object [] fila= new Object[3];
                            fila[0]=campos[1];
                            fila[1]=campos[0];
                            fila[2]="El nombre de usuario ya existe";
                            modeloUsError.addRow(fila);
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
            
            tableUscargados.setModel(modeloUsCargados);
            tableUsError.setModel(modeloUsError);
                        
        } catch (Exception e) 
        { JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARCHIVO"); }                    
}
    
    public boolean validarExistenciaUsuario(String nomb)
    {
        for (int i = 0; i < tableUscargados.getRowCount(); i++) 
        {
            String nomus=tableUscargados.getValueAt(i, 0).toString();
            if (nomb.equals(nomus)) 
            {
                return true;
            }
        }
        return false;
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
    
    public int saberPorcentajeDeTabla()
    {
        int porce=0;
        
        for (int i = 0; i < tableUscargados.getRowCount(); i++) 
        {
            String value=tableUscargados.getValueAt(i, 1).toString();
            if (value.equals("")) 
            {
                porce++;
            }            
        }
        
        int tamTabla=tableUscargados.getRowCount();
        int op1 = porce*100;
        int op2=op1/tamTabla;
        System.out.println("Tabla: " + tamTabla + " op1: " + op1 + " op2: " + op2);
                
        return op2;        
    }
    
    public int indiceEnTablaHash(String nomb)
    {
        int contador=0;
        for (int i = 0; i < nomb.length(); i++) 
        {
            char carac=nomb.charAt(i);
            contador=contador+(int)carac;
        }
        
        int tamTabla=tableUscargados.getRowCount();
        int op1= contador%tamTabla;
        
        return op1;
    }
    
    public void ingresarEnTablaHash(String nom, String pass, String hash)
    {
        int indice=indiceEnTablaHash(nom); //obtengo el indice de la tabla
        int dondeIngresar=0;
        
        for (int i = 0; i < indice; i++) 
        {
            dondeIngresar++;
            if (dondeIngresar>tableUscargados.getRowCount()-1) 
            {
                dondeIngresar=0;
            }            
        }
        
        Date date = new Date();
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");       
        
        tableUscargados.setValueAt(dondeIngresar, dondeIngresar, 0);
        tableUscargados.setValueAt(nom, dondeIngresar, 1);
        tableUscargados.setValueAt(pass, dondeIngresar, 2);
        tableUscargados.setValueAt(horaActual.format(date), dondeIngresar, 3);
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
        //recorrer la tabla de usuarios destructurada
        for (int i = 0; i < tableUscargados.getRowCount(); i++) 
        {
            
        }
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
    private javax.swing.JButton bttCargaMasivaUs;
    private javax.swing.JButton bttCompartirArchivo;
    private javax.swing.JButton bttCompartirCarpeta;
    private javax.swing.JButton bttCrearArchivo;
    private javax.swing.JButton bttCrearCarpeta;
    private javax.swing.JButton bttEliminarArchivo;
    private javax.swing.JButton bttEliminarCarpeta;
    private javax.swing.JButton bttIngresar;
    private javax.swing.JButton bttModificarArchivo;
    private javax.swing.JButton bttModificarCarpeta;
    private javax.swing.JButton bttRegistrar;
    private javax.swing.JButton bttSubirArchivo;
    private javax.swing.JButton bttSubirCarpeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpReportes;
    private javax.swing.JMenuItem reporteAVL;
    private javax.swing.JMenuItem reporteGrafo;
    private javax.swing.JMenuItem reporteMatriz;
    private javax.swing.JMenuItem reporteTabHash;
    private javax.swing.JTable tableUsError;
    private javax.swing.JTable tableUscargados;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
