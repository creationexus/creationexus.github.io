package chatnoapplet.tcp.servidor;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carriagadad
 */
//El hilo que atiende a clientes simultaneos
public class HiloCliente extends Thread implements Observador {
    //El socket que le fue asignado a este cliente.
    private Socket socket;
    
    private ObjectOutputStream flujoSalidaObjeto;
    private ObjectInputStream flujoEntradaObjeto;
    //El objeto mensaje que sera enviado por la red
    private Usuario usuario;
    private Mensaje mensaje;
    private ControlMensaje control;
    private BufferedReader flujoEntrada;
    private PrintWriter flujoSalida;

    HiloCliente(Socket socket, Usuario usuario, ControlMensaje control) {
        //Socket del cliente actual
        this.socket = socket;
        //String para todos los clientes
        this.control = control;
        //Flujos de String
        this.flujoEntrada = null;
        this.flujoSalida = null;
        //Flujos de Objetos
        this.flujoEntradaObjeto = null;
        this.flujoSalidaObjeto = null;
        
        this.usuario = usuario;
        this.mensaje = null;
        try {            
            this.flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //this.flujoSalida = new PrintWriter(socket.getOutputStream(), true);
            
            this.flujoEntradaObjeto = new ObjectInputStream(socket.getInputStream());
            this.flujoSalidaObjeto = new ObjectOutputStream(socket.getOutputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Object obj;
        try {
        while((obj = this.flujoEntradaObjeto.readObject()) != null){
                    //Verificamos si el objeto recibido es un objeto de la clase Mensaje
                    if (obj instanceof Mensaje) { 
                        this.mensaje = (Mensaje) obj;
                        this.control.enviarMensaje(this.usuario, this.mensaje);
                    }
            }
            this.control.desuscribir(this);
            this.socket.close();
            this.flujoEntrada.close();
            this.flujoSalida.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Class en Mensaje");
        } catch (IOException ex) {
            //System.out.println("Error I/O en Mensaje");
            //System.out.println("Cliente "+this.usuario.getNick()+" se ha retirado de la Sala");
            this.mensaje = new Mensaje();
            this.mensaje.setMensaje(this.usuario.getNick()+" se ha retirado de la Sala");
            this.control.enviarMensaje(new Usuario("CNX"), this.mensaje);
            try {
                this.control.desuscribir(this);
                this.socket.close();
                this.flujoEntrada.close();
                //this.flujoSalida.close();
            } catch (IOException ex1) {
                System.out.println("ERROR: Conexion Perdida con el Cliente");
            }
        }

    }

    @Override
    public void broadcast(Usuario usuario, Mensaje mensaje) {
        //Cuando un cliente en el servidor envia un mensaje es aqui donde se repliega a los demas thread clientes y se envia por el socket asociado a cada cliente.
        //Se filtra la repeticion
        if(!this.usuario.equals(usuario)){
            //Envia objeto Usuario y Mensaje
            this.mensaje = new Mensaje();
            this.mensaje.setMensaje(mensaje.getMensaje()+"\n");
            
            try {
                //Envia el objeto Mensaje
                this.flujoSalidaObjeto.writeObject(this.mensaje);
                this.flujoSalidaObjeto.flush();
                //Envia el Objeto Usuario
                //En esta parte se busca que el nick de la persona aparezca en negrita y el mensaje normal...
                this.flujoSalidaObjeto.writeObject(usuario);
                this.flujoSalidaObjeto.flush();
                
            } catch (IOException ex) {
                System.out.println("Error al enviar el mensaje al cliente desde el servidor");
            }
        }
        if (mensaje == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
