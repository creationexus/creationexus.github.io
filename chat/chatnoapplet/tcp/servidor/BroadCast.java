package chatnoapplet.tcp.servidor;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carriagadad
 */
public class BroadCast {
    private ListaSimbolica listaObservadores;
    private IteradorLista iterador;
    private Mensaje mensaje;
    public BroadCast(){
        this.mensaje = new Mensaje();
        this.listaObservadores = new ListaSimbolica();
        this.iterador = null;
    }

    public void agregarObservador(Observador observador) {
        this.iterador = new IteradorLista(this.listaObservadores.primero);
        this.listaObservadores.insertar(observador, this.iterador);
    }
    public void eliminarObservador(Observador observador){
        this.listaObservadores.eliminar(observador);
    }
    public void nuevoMensaje(Usuario usuario, Mensaje men) {
        this.mensaje = men;
        for(this.iterador = new IteradorLista(this.listaObservadores.primero), iterador.avanzar(); !(this.iterador.estaFuera()); this.iterador.avanzar()){
            try {
                ((Observador)this.iterador.obtener()).broadcast(usuario, men);
            } catch (IOException ex) {
                Logger.getLogger(BroadCast.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
