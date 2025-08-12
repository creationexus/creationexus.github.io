package chat;

import chat.tcp.servidor.Servidor;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author carriagadad
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor s = new Servidor(7585, 150);
        //3800
        /*
        InetAddress host;
        try {
            host = InetAddress.getLocalHost();
            //Cliente c = new Cliente(host.getHostName(), 8030);
        } catch (UnknownHostException ex) {
            System.out.println("Error al conectar al Servidor");
        }*/
            
    }
}
