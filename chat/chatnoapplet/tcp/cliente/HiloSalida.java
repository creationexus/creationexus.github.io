package chatnoapplet.tcp.cliente;

import chatnoapplet.graficos.Chat;
import chatnoapplet.Mensaje;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carriagadad
 */
public class HiloSalida /*extends Thread*/ {   
   private Chat chat;
   private Socket socket;
   
   private ObjectOutputStream flujoObjeto;
   
   private Mensaje mensaje; 
   //#REEMPLAZADO
   //private BufferedReader teclado;
   
   //#GRAFICO
   private javax.swing.JTextArea jtext;
   
   private HiloGuardaHistorial historial;
   
   public HiloSalida(Socket socket, Chat chat, javax.swing.JTextArea jtext, javax.swing.JButton jbutton, HiloGuardaHistorial historial){
       //Objeto chat grafico
       this.chat = chat;
       //Socket del cliente
       this.socket = socket;
       //flujo de objetos
       this.flujoObjeto = null;
       //#REEMPLAZADO
       //this.teclado = null;
       //#GRAFICO
       this.jtext = jtext;
       
       this.historial = historial;
        try {
            this.flujoObjeto = new ObjectOutputStream(socket.getOutputStream());
            
            //#REEMPLAZADO
            //this.teclado = new BufferedReader(new InputStreamReader(System.in));
            
            //Escuchador para el boton
            jbutton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbuttonMouseReleased(evt);
            }
        });
            
        } catch (IOException ex) {
            Logger.getLogger(HiloSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   private void jbuttonMouseReleased(java.awt.event.MouseEvent evt){
        try {
            String line = this.jtext.getText();
            
             this.chat.jTextN("Yo: ");
             this.chat.jText(line+"\n");
            
             this.mensaje = new Mensaje();
             this.mensaje.setMensaje(line);
                     
             this.flujoObjeto.writeObject(this.mensaje);
             this.flujoObjeto.flush();
                     
            //Luego de enviar el texto limpiamos la caja de texto
            this.jtext.setText("");
            //Guardamos en el historial
            this.historial.escribe(this.mensaje.getFecha()+" | Yo: "+line+"\n");
        } catch (IOException ex) {
            this.chat.jTextN("CNX: ");
            this.chat.jText("Servidor Desconectado\n");
            //System.out.println("Servidor Desconectado");
        }
   }
   //El escuchador del boton reemplazo al uso de la clase Thread...
   /*
   public void run(){
       String line;
       
       try {
       while((line = this.teclado.readLine()) != null){
                this.chat.jTextN("Yo: ");
                this.chat.jText(line+"\n");
                
                this.mensaje = new Mensaje();
                this.mensaje.setMensaje(line);
                
                this.flujoObjeto.writeObject(this.mensaje);
                this.flujoObjeto.flush();
        }
        } catch (IOException ex) {
            Logger.getLogger(HiloSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.flujoObjeto.close();
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
   }*/
}
