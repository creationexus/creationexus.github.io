package chatnoapplet.tcp.servidor;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carriagadad
 */
public class Conex implements Observador {
    //El socket del servidor.

    private ServerSocket socketServidor;
    private HiloCliente[] clientes;
    private ControlMensaje control;
    private Mensaje mensajeCentral;
    private Usuario[] usuarios;
    private int puerto;
    private int idCliente;

    Conex(int puerto, int maxClientes) {
        this.socketServidor = null;
        this.control = new ControlMensaje();
        this.puerto = puerto;
        this.clientes = new HiloCliente[maxClientes];
        this.usuarios = new Usuario[maxClientes];
        this.mensajeCentral = null;
        this.idCliente = 0;
        //Inicia el servicio
        this.inixServicio();
    }

    private void inixServicio() {
        try {
            this.socketServidor = new ServerSocket(this.puerto);
        } catch (IOException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Suscibrimos a esta clase(Conex) para que escuche a los Clientes.
        this.control.suscribir(this);
    }

    public void clienteNuevo() {
        try {
            boolean disponible = false;
            Socket socket = this.socketServidor.accept();
            for (int i = 0; i < this.clientes.length; i++) {
                //Reviso si queda una entrada disponible
                if ((this.clientes[i] == null) || (!this.clientes[i].isAlive())) {
                    //Crea un objeto usuario
                    this.usuarios[i] = new Usuario("Anonimo"+(this.idCliente++));
                    //Le pasamos el control para enviar mensajes al cliente nuevo, para que envie mensajes.
                    this.clientes[i] = new HiloCliente(socket, this.usuarios[i], this.control);
                    
                    //Suscribo al nuevo cliente para que reciba mensajes del resto.
                    this.control.suscribir(this.clientes[i]);
                    
                    //Luego que se ha enviado el primer mensaje desde la central esa fecha es la ini del usuario
                    this.mensajeCentral = new Mensaje();
                    this.mensajeCentral.setMensaje(this.usuarios[i].getNick()+" ha entrado a la Sala");
                    //Utilizo esa fecha para setear la fecha de inicio del usuario
                    this.usuarios[i].setFechaIni(this.mensajeCentral.getFecha());
                    
                    this.control.enviarMensaje(new Usuario("CNX"), this.mensajeCentral);
                    
                    this.clientes[i].setPriority(Thread.MAX_PRIORITY);
                    this.clientes[i].start();
                    
                    disponible = true;
                    break;
                }
            }
            if (!disponible) {
                System.out.println("Server Full");
            }
        } catch (IOException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void broadcast(Usuario usuario, Mensaje mensaje) {
        //Observador para conex y servidor este al tanto de lo que hablan los clientes.
        if(mensaje != null)
            System.out.println("["+mensaje.getFecha()+"] "+usuario.getNick()+": "+mensaje.getMensaje());
        if (usuario == null || mensaje == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
