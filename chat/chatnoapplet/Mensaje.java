package chatnoapplet;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author carriagadad
 */

//Transformo el objeto a bytes para posteriormente enviarlo por la red

public class Mensaje implements Serializable {
    private static final long serialVersionUID = 635383749923674L;
    private Calendar calendar;
    private String texto;
    private String fecha;
    public Mensaje(){
        this.calendar = Calendar.getInstance();
        this.texto = null;
        this.fecha = null;
    }
    public void setMensaje(String texto){
        this.texto = texto;
        this.fecha = String.valueOf(this.calendar.get(Calendar.DATE)+"/"+this.calendar.get(Calendar.MONTH)+"/"+this.calendar.get(Calendar.YEAR)+" "+this.calendar.get(Calendar.HOUR_OF_DAY)+":"+this.calendar.get(Calendar.MINUTE)+":"+this.calendar.get(Calendar.SECOND));
    }
    public String getMensaje(){
        return this.texto;
    }
    public String getFecha(){
        return this.fecha;
    }
}
