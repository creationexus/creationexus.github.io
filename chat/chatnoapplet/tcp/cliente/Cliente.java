package chatnoapplet.tcp.cliente;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carriagadad
 */
public class Cliente extends chatnoapplet.graficos.Chat {

    private Socket socket;
    private HiloEntrada in;
    private HiloSalida out;
    
    private File temporal;
    private HiloGuardaHistorial historial;
    
    public Cliente(String host, int puerto){
        //Socket del Cliente
        this.socket = null;
        //Hilos de Entrada y Salida
        this.in = null;
        this.out = null;
        this.historial = null;
        try {
            //Hago visible la interfaz grafica
            super.setVisible(rootPaneCheckingEnabled);
            //Socket del cliente
            this.socket = new Socket(host, puerto);
            //Para guardar el historial
            this.temporal = File.createTempFile("Historial", ".dat");
            this.historial = new HiloGuardaHistorial(temporal);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn y el boton y jtext para controlar la entrada desde el form
            this.out = new HiloSalida(this.socket, this, this.jTextArea1, this.jButton1, this.historial);
            //Hilo de Salida con la clase chat para los metodos jtext y jtextn
            this.in = new HiloEntrada(this.socket, this, this.historial);
            
            this.inix();
        
        } catch (UnknownHostException ex) {
            System.out.println("Error al conectar al Servidor");
        } catch (IOException ex) {
            this.jTextN("CNX: ");
            this.jText("Servidor no activo");
        }
    }
    private void inix(){
            this.in.setPriority(Thread.MAX_PRIORITY);
            //Thread fue reemplazado
            //this.out.setPriority(Thread.MAX_PRIORITY);
            
            this.in.start();
            //Thread fue reemplazado
            //this.out.start();
    }
    public static void main(String[] args){
        try {
            InetAddress host = InetAddress.getLocalHost();
            Cliente c = new Cliente(host.getHostName(), 8030);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
