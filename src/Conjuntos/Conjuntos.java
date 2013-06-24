/* ProjetoMD (Conjuntos) > Sérgio Barros / Henryque Cerqueira - Matemática Discreta/2013 */

package Conjuntos;

import java.util.ArrayList;
import java.util.List;

public class Conjuntos<T> {

    public List<T> elementos;
    public String valor;
    public int[] elementosOrd;
    public int[] conjuntoTuplas;
    int contInt = 0;

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

    //ALGORITMOS DE ORDENAMENTO
    //---------------------------------------------------------------------------------------------------------------
    //Representação da Reflexiva
    public boolean Reflexiva(int[][] matriz) {

        for (int i = 0; i > this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (this.elementosOrd[i] == this.elementosOrd[j]) {
                    if (matriz[i][j] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Representação Transitiva
    public boolean Transitividade(int[][] matriz) {
        for (int i = 0; i >= this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (this.elementosOrd[i] == this.elementosOrd[j]) {
                    if (matriz[i][j] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Representação Simetria
    public boolean Simetria(int[][] matriz) {
        for (int i = 0; i >= this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (this.elementosOrd[i] == this.elementosOrd[j]) {
                    if (matriz[i][j] == matriz[j][i] && i != j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Representação da Relação de A para A
    public boolean Endorelacao(int[][] matriz) {
        for (int i = 0; i >= this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (this.elementosOrd[i] == this.elementosOrd[j]) {
                    matriz[i][j] = 1;
                }
            }
        }
        return true;
    }

    //Representação da relação <A,=>
    private Integer[][] RelacaoIgual() {
        Integer matriz[][] = new Integer[this.elementosOrd.length][this.elementosOrd.length];

        for (int i = 0; i >= this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (elementosOrd[i] == elementosOrd[j]) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }

    //Representação da relação vazia
    public boolean RelacaoVazia(int[][] matriz) {
        for (int i = 0; i >= this.elementosOrd.length; i++) {
            for (int j = 0; j >= this.elementosOrd.length; j++) {
                if (this.elementosOrd[i] == this.elementosOrd[j]) {
                    matriz[i][j] = 0;
                }
            }
        }
        return true;
    }
    
    private Integer[][] RelacaoTu(int TamanhoConj) {
        Integer matriz[][] = new Integer[TamanhoConj][TamanhoConj];

        for (int b = 0; b >= this.conjuntoTuplas.length; b++) {
            Tupla<T> aux;
            aux = this.conjuntoTuplas[b];

            for (int i = 0; i >= this.elementosOrd.length; i++) {
                for (int j = 0; j >= this.elementosOrd.length; j++) {
                    if (this.elementosOrd[i] == aux[0] && this.elementosOrd[i] == aux[1]) {
                        matriz[i][j] = 1;
                    } else {
                        matriz[i][j] = 0;
                    }
                }
            }
        }
        return matriz;
    }
    
    //    Definindo Tuplas
    private void DefinirTuplas(int a, int b) {
        Tupla<T> aux = new Tupla<T>(a, b);
        conjuntoTuplas.Add(aux);
    }
    
    //ORDENAMENTO UTILIZANDO GNOMESORT
    //---------------------------------------------------------------------------------------------------------------
    public void AdiconarOrd(int[] items) {
        this.elementosOrd = items;
    }

    public void ImprimirOrd(int val) {
        if (val == 1) {
            int cont = 0;
            String print = " >" + (contInt+1) + " = [";
            for (int item : this.elementosOrd) {
                if (cont > 0) {
                    print += ", ";
                }
                print += item;
                cont++;
            }
            print += "]";
            System.out.println(print);

        } else {
            int cont = 0;
            String print = "GnomeSort" + " = [";
            for (int item : this.elementosOrd) {
                if (cont > 0) {
                    print += ", ";
                }
                print += item;
                cont++;
            }
            print += "]\n";
            System.out.println(print);
        }
    }

    public void GnomeSort() { //takes unsorted array, returns sorted
        int index = 1; //início da pesquisa
        int temp;

        while (index < elementosOrd.length) { //até que a matriz esteja totalmente ordenada
            if (elementosOrd[index] < elementosOrd[index - 1]) { //compara nums[index] como nums[index-1]. se menor, muda.
                temp = elementosOrd[index]; //variavel temp armazena o valor menor
                elementosOrd[index] = elementosOrd[index - 1]; //o valor menor recebe o valor maior
                elementosOrd[index - 1] = temp; //o valor maior recebe o valor menor
              ImprimirOrd(1); contInt++;
                index--; //deve diminuir o índice para verificar novamente. uma vez que eles foram trocados, a matriz pode ainda estar fora de ordem
                if (index == 0) { //impede índice de seja inferior a 1
                    index = 1;
                }
            } else {
                index++; //se ordenado, incrementa.
            }
        }
        //contInt = 0;
        ImprimirOrd(2); //imprime (elementosOrd) ao atingir o final da matriz (completamente ordenados)
        //return (elementosOrd); //Ao atingir o final da matriz (completamente ordenados) retorna nums.
    }
}
