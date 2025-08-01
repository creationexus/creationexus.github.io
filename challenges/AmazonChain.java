package challenges;

// Este desafío viene de una empresa que muchos de ustedes conocen, Amazon.

// Diseñe una solución que permita revisar pares de n cadenas de textos siguiendo las siguientes reglas:

// - Cada cadena posee un inicio("BEGIN") y un fin("END") dentro de sus pares
// - Cada par esta separado por un ";"
// - Cada par contiene su ubicacion, luego le sigue un "-", y finalmente una referencia a otro par, ejemplo:
// "BEGIN-1;1-END" //Inicia con BEGIN, tiene una referencia a la posición 1 y luego finaliza con "END".
// - Las posiciones permitidas van de 1 hasta 10000
// - El orden de los pares es irrelevante, por lo tanto no es necesario que el primer par contenga el "BEGIN" y el último el "END"
// - La cadena sólo será valida, cuando sea posible incluir todos los pares en el recorrido, iniciando con "BEGIN" y terminando con "END"
// - Un buble no se considera válido, ya que no le permite llegar a "END"
// - La revisión de cada cadena debe dar como resultado "GOOD" o "BAD", la cantidad de cadenas de texto es desconocida por lo que debe estar siempre estar esperando una cadena nueva.

// Ejemplos:

// GOOD
// BEGIN-1;1-2;2-3;3-END

// GOOD
// BEGIN-1000;1000-91;91-END

// GOOD
// 10000-1;BEGIN-10000;1-END

// GOOD
// 1000-END;BEGIN-1;1-1000

// BAD(BUCLE)
// BEGIN-1000;1000-91;91-1;1-1000

// BAD(SECUENCIA NO FINALIZADA)
// BEGIN-100

// BAD(MALA REFERENCIA)
// BEGIN-100;1-END

// BAD(FUERA DE RANGO)
// BEGIN-100000;100000-END

import java.io.*;

public class AmazonChain {
    private Integer[] addr;

    AmazonChain() {
        this.addr = new Integer[10001];
    }

    private Boolean loadPair(String pair) {
        try {
            String[] p = pair.split("-");
            Integer k = p[0].compareTo("BEGIN") == 0 ? 0 : Integer.parseInt(p[0]);
            Integer v = p[1].compareTo("END") == 0 ? 10001 : Integer.parseInt(p[1]);
            this.addr[k] = v;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean loadChain(String chain) {
        try {
            String[] p = chain.split(";");
            for (int i = 0; i < p.length; i++) {
                if (!this.loadPair(p[i]))
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean validChain() {
        return this.validChainR(0, addr[0]);
    }

    private Boolean validChainR(Integer n, Integer a) {
        try {
            if (a == 10001) {
                return true;
            }
            if (n == a || a == 0) {
                return false;
            } else {
                this.addr[n] = 0;
                return this.validChainR(a, this.addr[a]);
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void showChain() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ">>" + this.addr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        AmazonChain ch = new AmazonChain();
        String s;
        Boolean r1;
        Boolean r2;
        while ((s = in.readLine()) != null) {
            r1 = ch.loadChain(s);
            r2 = ch.validChain();
            if (!r1 || !r2) {
                System.out.println("BAD");
            } else {
                System.out.println("GOOD");
            }
            // ch.showChain();
        }
    }
}