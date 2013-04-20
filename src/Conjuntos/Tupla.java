/* Tupla > Sérgio Barros - Matemática Discreta/2013 */
package Conjuntos;

public class Tupla<T> {

    public T tupla1;
    public T tupla2;

    public Tupla(T tp1, T tp2) {
        super();
        this.tupla1 = tp1;
        this.tupla2 = tp2;
    }

    @Override
    public String toString() {
        return "(" + tupla1.toString() + ", " + tupla2.toString() + ")";
    }
}
