/* ProjetoMD (Main) > Sérgio Barros / Henryque Cerqueira - Matemática Discreta/2013 */

package Conjuntos;

import javax.swing.JOptionPane;

public class ProjetoMD {

    static Conjuntos<String> a = new Conjuntos<String>("A");
    static Conjuntos<String> b = new Conjuntos<String>("B");

    public static void main(String[] args) {
        String tipo;
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("Digite a Opção:"
                    + "\n[1] - LER CONJUNTOS!"
                    + "\n[2] - União"
                    + "\n[3] - Intersecção"
                    + "\n[4] - Diferença"
                    + "\n[5] - Gnome Sort"
                    + "\n[0] - Sair"));
            switch (op) {
                case 1: // Lancamento
                    inserirConjuntos();
                    break;

                case 2: // Uniao
                    uniao();
                    break;
                case 3: // Intersecção
                    interseccao();
                    break;

                case 4: // Diferença
                    diferenca();
                    break;

                case 5: //  Ordenação com GnomeSort
                    gnomeSort();
                    break;
            }
        } while (op != 0);
    }

    private static void inserirConjuntos() {
        a.Add("1");
        a.Add("2");
        a.Add("3");
        a.Add("4");
        a.Print();
        b.Add("3");
        b.Add("4");
        b.Add("5");
        b.Add("6");
        b.Print();

        /*a.Add("a"); a.Add("b"); a.Add("c"); a.Add("d"); a.Print();
         b.Add("d"); b.Add("e"); b.Add("f"); b.Add("g"); b.Print();
         */
    }

    private static void uniao() {
        Conjuntos<String> uniao = a.Uniao(b);
        uniao.Print();
    }

    private static void diferenca() {
        Conjuntos<String> diferenca = a.Diferenca(b);
        diferenca.Print();
    }

    private static void interseccao() {
        Conjuntos<String> interseccao = a.Interseccao(b);
        interseccao.Print();
    }
    //Outras verificações da classe Conjuntos ...

    private static void gnomeSort() {
        String aux = "";
        int[] vetor = new int[10];
        for (int i = 0; i < 10; i++) {
            vetor[i] = (int) (Math.random() * 10);

            if (i != vetor.length - 1) { //Verifica se é o ultimo elemento do vetor
                aux += vetor[i] + ", ";//armazena em aux o valor da posição do vetor + ", "
            } else {
                aux += vetor[i]; //Corrige o bug da casa vazia
            }
        }
        System.out.println("Entrada = [" + aux + "]");

        a.AdiconarOrd(vetor);
        a.GnomeSort();
        //a.ImprimirOrd();
    }

    public static void Imprimir(Object result) {
        System.out.println(result);
    }
}
