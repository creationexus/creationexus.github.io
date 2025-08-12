package chatnoapplet.tcp.cliente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carriagadad
 */
public class HiloGuardaHistorial {
    private File temporal;
    private FileWriter out;
    public HiloGuardaHistorial(File temporal){
        this.temporal = temporal;
        try {
            this.out = new FileWriter(temporal, true);
        } catch (IOException ex) {
            Logger.getLogger(HiloGuardaHistorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public synchronized void escribe(String texto){
        try {            
            out.write(texto);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(HiloGuardaHistorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
