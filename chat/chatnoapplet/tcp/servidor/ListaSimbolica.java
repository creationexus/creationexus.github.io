/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatnoapplet.tcp.servidor;

/**
 *
 * @author carriagadad
 */
class ListaSimbolica {

    NodoSimbolico primero;

    ListaSimbolica() {
        this.primero = new NodoSimbolico(null);
    }

    boolean estaVacia() {
        if (this.primero.sgte == null) {
            return true;
        } else {
            return false;
        }
    }

    IteradorLista buscar(Object o) {
        NodoSimbolico nodo = this.primero.sgte;
        while (nodo != null && !nodo.nodo.elemento.equals(o)) {
            nodo = nodo.sgte;
        }
        return new IteradorLista(nodo);
    }

    void insertar(Object o, IteradorLista it) {
        if (it != null && it.actual != null) {
            it.actual.sgte = new NodoSimbolico(new Nodo(o), it.actual.sgte);
        }
    }

    void eliminar(Object o) {
        IteradorLista it = encontrarPrevio(o);
        if (it.actual.sgte != null) {
            it.actual.sgte = it.actual.sgte.sgte;
        }
    }

    IteradorLista encontrarPrevio(Object o) {
        NodoSimbolico nodo = this.primero;
        while (nodo.sgte != null && !nodo.sgte.nodo.elemento.equals(o)) {
            nodo = nodo.sgte;
        }
        return new IteradorLista(nodo);
    }
}
