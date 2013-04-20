/* ProjetoMD (Main) > Sérgio Barros - Matemática Discreta/2013 */
package Conjuntos;

import java.util.ArrayList;
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
        
/*      a.Add("a");
        a.Add("b");
        a.Add("c");
        a.Add("d");
        a.Print();

        b.Add("d");
        b.Add("e");
        b.Add("f");
        b.Add("g");
        b.Print();
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
}
