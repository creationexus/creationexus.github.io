package chatnoapplet.tcp.servidor;

/**
 *
 * @author carriagadad
 */

public class Servidor {
    private Conex conex;
    public Servidor(int puerto, int maxUser){
        this.conex = new Conex(puerto, maxUser);
        this.esperaClientes();
    }
    private void esperaClientes(){
        while(true)
            this.conex.clienteNuevo();
    }
}
