package chatnoapplet.graficos;

/**
 *
 * @author carriagadad
 */
public class Interface {
    private String line;
    private InterfazGrafica ui;
    public void inix(InterfazGrafica ui){
        this.ui = ui;
    }
    public void entrada(String s) {
        if(s == null) throw new UnsupportedOperationException("Not supported yet.");
        this.line = s;
        ((InterfazGrafica)this.ui).entrada(s);
    }
}
