/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatnoapplet.tcp.servidor;

/**
 *
 * @author carriagadad
 */
public class NodoSimbolico {
 
    public NodoSimbolico sgte;
    public Nodo nodo;
 
    NodoSimbolico(Nodo nodo) {
        this(nodo, null);
    }
    NodoSimbolico(Nodo nodo, NodoSimbolico enlace){
        this.nodo = nodo;
        this.sgte = enlace;
    }
}
