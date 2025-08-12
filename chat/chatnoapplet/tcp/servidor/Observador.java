package chatnoapplet.tcp.servidor;

import chatnoapplet.Mensaje;
import chatnoapplet.Usuario;
import java.io.IOException;

/**
 *
 * @author carriagadad
 */
public interface Observador {
    public void broadcast(Usuario usuario, Mensaje mensaje) throws IOException;
}
