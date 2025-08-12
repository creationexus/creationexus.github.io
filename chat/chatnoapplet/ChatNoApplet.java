package chatnoapplet;

import chatnoapplet.tcp.servidor.Servidor;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author carriagadad
 */
public class ChatNoApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor s;
        if(args.length == 1){
                s = new Servidor(Integer.parseInt(args[0]), 2);
            }
            else
                s = new Servidor(8030, 2);
        InetAddress host;
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Error al conectar al Servidor");
        }
            
    }
}
