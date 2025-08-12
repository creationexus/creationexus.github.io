/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Chat.java
 *
 * Created on 24-11-2011, 02:48:50 PM
 */
package chat.tcp.cliente;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author carriagadad
 */
public class Chat extends javax.swing.JApplet {
    private static final long serialVersionUID = 635383749923661L;
    /** Initializes the applet Chat */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    initComponents();
                    //inix();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void inix(){
/*        //Socket del Cliente
        this.socket = null;
        //Hilos de Entrada y Salida
        this.in = null;
        this.out = null;
        this.historial = null;
        try {
            //Socket del cliente
            this.socket = new Socket("127.0.0.1", 8010);
            //Para guardar el historial
            this.temporal = File.createTempFile("Historial", ".dat");
            this.historial = new HiloGuardaHistorial(temporal);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn y el boton y jtext para controlar la entrada desde el form
            this.out = new HiloSalida(this.socket, this, this.jTextArea1, this.jButton1, this.historial);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn

            this.in = new HiloEntrada(this.socket, this, this.historial);
            this.in.setPriority(Thread.MAX_PRIORITY);
            //Thread fue reemplazado
            //this.out.setPriority(Thread.MAX_PRIORITY);
            
            this.in.start();
            //Thread fue reemplazado
            //this.out.start();
        } catch (UnknownHostException ex) {
            //System.out.println("Error al conectar al Servidor");
        } catch (IOException ex) {
            this.jTextN("CNX: ");
            this.jText("Servidor no activo");
        }*/
    }
    public void jText(String s) {
        if (s == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        // Atributos para la frase, en negrita
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, false);
        try {
            // Se inserta
            jTextPane1.getStyledDocument().insertString(jTextPane1.getStyledDocument().getLength(), s, attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void jTextN(String s) {
        if (s == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        // Atributos para la frase, en negrita
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, true);
        try {
            // Se inserta
            jTextPane1.getStyledDocument().insertString(jTextPane1.getStyledDocument().getLength(), s, attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setDoubleBuffered(true);

        jTextPane1.setEditable(false);
        jTextPane1.setFocusable(false);
        jScrollPane1.setViewportView(jTextPane1);

        jTabbedPane1.addTab("Principal", jScrollPane1);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "CNX" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setForeground(new java.awt.Color(23, 56, 180));
        jLabel1.setText("Usuarios Online");
        jLabel1.setDoubleBuffered(true);

        jButton1.setText("Enviar");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(true);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextArea1.setDoubleBuffered(true);
        jTextArea1.setFocusCycleRoot(true);
        jTextArea1.setFocusTraversalPolicyProvider(true);
        jTextArea1.setInheritsPopupMenu(true);
        jScrollPane3.setViewportView(jTextArea1);

        jToolBar1.setRollover(true);

        jLabel2.setText("Version: 0.0001");
        jToolBar1.add(jLabel2);

        jToolBar2.setRollover(true);

        jLabel3.setBackground(new java.awt.Color(30, 161, 28));
        jLabel3.setText("Estado:");
        jToolBar2.add(jLabel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	//Socket del Cliente
	this.socket = null;
        //Hilos de Entrada y Salida
        this.in = null;
        this.out = null;
        this.historial = null;
        //try {
	    //SocketPermission p1 = new SocketPermission("186.104.242.1", "connect,accept");
	    //InetAddress address = InetAddress.getByAddress(new byte[] {(byte)186,(byte)104,(byte)167,(byte)235});
            this.jTextN("CNX: ");
            this.jText("Servidor de chat no activo");
            //Socket del cliente
            //this.socket = new Socket(InetAddress.getByName("186.104.167.235"), 3000);
	    //this.socket = new Socket("186.104.167.235", 7585);
	    //this.socket = new Socket("186.104.188.57", 7585);
            //Para guardar el historial
            //this.temporal = File.createTempFile("Historial", ".dat");
            //this.historial = new HiloGuardaHistorial(temporal);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn y el boton y jtext para controlar la entrada desde el form
            this.out = new HiloSalida(this.socket, this, this.jTextArea1, this.jButton1/*, this.historial*/);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn

            this.in = new HiloEntrada(this.socket, this/*, this.historial*/);
            this.in.setPriority(Thread.MAX_PRIORITY);
            //Thread fue reemplazado
            //this.out.setPriority(Thread.MAX_PRIORITY);
            
            this.in.start();
            //Thread fue reemplazado
            //this.out.start();
        //} catch (UnknownHostException ex) {
        //    this.jTextN("CNX: ");
        //    this.jText("Error al conectar al Servidor");
        //} catch (IOException ex) {
        //    this.jTextN("CNX: ");
        //    this.jText("Servidor no activo");
        //}
    }// </editor-fold>//GEN-END:initComponents

    private Socket socket;
    private HiloEntrada in;
    private HiloSalida out;
    
    private File temporal;
    private HiloGuardaHistorial historial;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    protected javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
