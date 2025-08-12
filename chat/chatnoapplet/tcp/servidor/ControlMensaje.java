package chatnoapplet.tcp.servidor;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;

/**
 *
 * @author carriagadad
 */
public class ControlMensaje {

    BroadCast broadcast;
    String fuente;
    Mensaje mensaje;

    public ControlMensaje() {
        this.broadcast = new BroadCast();
    }

    public void suscribir(Observador observador) {
        this.broadcast.agregarObservador(observador);
    }

    public void desuscribir(Observador observador) {
        this.broadcast.eliminarObservador(observador);
    }

    public void enviarMensaje(Usuario usuario, Mensaje mensaje) {
        this.broadcast.nuevoMensaje(usuario, mensaje);
    }
}
