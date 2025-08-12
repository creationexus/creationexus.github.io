package chatnoapplet.tcp.cliente;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;
import chatnoapplet.graficos.Chat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carriagadad
 */
public class HiloEntrada extends Thread {
    private Socket socket;
    private Chat chat;
    private Mensaje mensaje;
    private ObjectInputStream flujoObjeto;
    private HiloGuardaHistorial historial;
    public HiloEntrada(Socket socket, Chat chat, HiloGuardaHistorial historial){
        this.chat = chat;
        this.socket = socket;
        this.mensaje = null;
        //this.flujoEntrada = null;
        this.flujoObjeto = null;
        this.historial = null;
        try {
            this.flujoObjeto = new ObjectInputStream(this.socket.getInputStream());
            this.historial = historial;
        } catch (IOException ex) {
            Logger.getLogger(HiloEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        try {
            Object obj1, obj2;
            //El mensaje sin usuario no es valido
            while(((obj1 = this.flujoObjeto.readObject()) != null) && (obj2 = this.flujoObjeto.readObject()) != null){
            //while((line = this.flujoEntrada.readLine()).compareTo("null") != 0){
                if((obj1 instanceof Mensaje) && ((obj2) instanceof Usuario)){
                    this.mensaje = (Mensaje) obj1;
                    Usuario usuario = (Usuario) obj2;
                
                String info = this.mensaje.getMensaje();
                
                System.out.println(info);
                this.chat.jTextN(usuario.getNick()+": ");
                this.chat.jText(info);
                //Guardamos en el historial
                this.historial.escribe(this.mensaje.getFecha()+" | "+usuario.getNick()+": "+info);
                }
            }
            
            this.flujoObjeto.close();
            this.socket.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            this.chat.jTextN("CNX: ");
            this.chat.jText("Servidor Desconectado\n");
            //System.out.println("Servidor Desconectado");
        }
    }
}
