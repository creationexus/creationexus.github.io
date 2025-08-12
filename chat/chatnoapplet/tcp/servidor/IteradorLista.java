package chatnoapplet.tcp.servidor;

/**
 *
 * @author carriagadad
 */
class IteradorLista {

    NodoSimbolico actual;

    IteradorLista(NodoSimbolico n) {
        this.actual = n;
    }

    boolean estaFuera() {
        if (actual == null) {
            return true;
        } else {
            return false;
        }
    }

    Object obtener() {
        return this.actual.nodo.elemento;
    }

    void avanzar() {
        if (!estaFuera()) {
            this.actual = this.actual.sgte;
        }
    }
}
