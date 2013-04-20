/* Conjuntos > Sérgio Barros - Matemática Discreta/2013 */
package Conjuntos;

import java.util.ArrayList;
import java.util.List;

public class Conjuntos<T> {

    public List<T> elementos;
    public String valor;

    public Conjuntos(String name) {
        this.elementos = new ArrayList<T>();
        this.valor = name;
    }

    //União
    public Conjuntos<T> Uniao(Conjuntos<T> conjunto) {
        Conjuntos<T> uni = new Conjuntos<T>(this.valor + " v " + conjunto.valor);
        uni.Add(this.elementos);
        for (T items : conjunto.elementos) {
            if (!uni.Pertinencia(items)) {
                uni.Add(items);
            }
        }
        return uni;
    }

    //Intersecção
    public Conjuntos<T> Interseccao(Conjuntos<T> conjunto) {
        Conjuntos<T> inter = new Conjuntos<T>(this.valor + " ^ " + conjunto.valor);

        for (T item : conjunto.elementos) {
            if (this.Pertinencia(item)) {
                inter.Add(item);
            }
        }
        return inter;
    }

    //Diferença
    public Conjuntos<T> Diferenca(Conjuntos<T> conjunto) {
        Conjuntos<T> dif = new Conjuntos<T>(this.valor + " - " + conjunto.valor);

        for (T item : this.elementos) {
            if (!conjunto.Pertinencia(item)) {
                dif.Add(item);
            }
        }

        for (T item : conjunto.elementos) {
            if (!this.Pertinencia(item)) {
                dif.Add(item);
            }
        }
        return dif;
    }

    //Pertinencia
    public boolean Pertinencia(T dados) {
        if (elementos.contains(dados)) {
            return true;
        }
        return false;
    }

    //Continencia
    public boolean Continencia(Conjuntos<T> conj) {
        for (T item : conj.elementos) {
            if (!this.Pertinencia(item)) {
                return false;
            }
        }
        return true;
    }

    //Complemento
    public Conjuntos<T> Complemento(Conjuntos<T> Uni) {
        return this.Diferenca(Uni);
    }

    //Produto cartesiano
    public Conjuntos<Tupla<T>> Cartesiano(Conjuntos<T> conj) {
        Conjuntos<Tupla<T>> prod = new Conjuntos<Tupla<T>>(this.valor + " x " + conj.valor);
        for (T item1 : this.elementos) {
            for (T item2 : conj.elementos) {
                Tupla<T> t = new Tupla<T>(item1, item2);
                prod.Add(t);
            }
        }
        return prod;
    }

    //Impressão
    public void Print() {
        int cont = 0;
        String result = valor + " = {";
        for (T items : this.elementos) {
            if (cont > 0) {
                result += ", ";
            }
            result += items.toString();
            cont++;
        }
        result += "}";
        System.out.println(result);
    }

    //Adicionar
    public void Add(T valor) {
        elementos.add(valor);
    }

    public void Add(List<T> items) {
        this.elementos.addAll(items);
    }

    //Remover
    public boolean Remover(T dados) {
        try {
            elementos.remove(dados);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    //Limpar
    public void Clear() {
        this.elementos.clear();
    }

    //Verificação se está Vazio
    public boolean Vazio() {
        if (this.elementos.size() == 0) {
            return true;
        }
        return false;
    }

    //Cardinalidade
    public int Cadinalidade() {
        return elementos.size();
    }
}
