package chat.tcp.servidor;

import chat.shared.Mensaje;
import chat.shared.Usuario;
import java.io.IOException;

/**
 *
 * @author carriagadad
 */
public interface Observador {
    public void broadcast(Usuario usuario, Mensaje mensaje) throws IOException;
}
