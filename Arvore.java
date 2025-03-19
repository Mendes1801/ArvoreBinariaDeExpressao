import java.util.LinkedList;

public class Arvore {
    private No raiz;

    Arvore(String Entrada) throws Exception{
        inserir(Entrada);
    }

    Arvore(){
    }

    public void inserir(String expressao) throws Exception{

        expressaoNumerica entrada = new expressaoNumerica(expressao);
        inserir(entrada.transformaInfixa());

    }


    private No inserir(LinkedList<Object> expPosFixa) {
        
            //Essa funçã é recursiva
            /* Ela verifica se o node é um OPERADOR ou OPERANDO
            * Se for operador chama recursivamente a isercao a direita e esquerda
            * Se for operando, que é a condição de parada, apenas insere o nó
            */
            
            if (expPosFixa.getLast().getClass().getSimpleName().equals("Character")) {
                
                NoOperador nodeOperador = new NoOperador();
                if (this.raiz ==null) this.raiz = nodeOperador;

                nodeOperador.valorOperador = (Character) expPosFixa.removeLast();
                
                nodeOperador.direita = inserir(expPosFixa);
                nodeOperador.esquerda = inserir(expPosFixa);

                return nodeOperador;
            }
            else {
                NoOperando nodeOperando = new NoOperando();
                nodeOperando.valorOperando = (Float) expPosFixa.removeLast();

                return nodeOperando;
            }

  
    }

    public void exibirArvore() {
        exibirArvore(this.raiz, 0);
    }
    
    private void exibirArvore(No no, int nivel) {
        if (no != null) {
            exibirArvore(no.direita, nivel + 1);
            System.out.println(" ".repeat(nivel * 4) + no.valor());
            exibirArvore(no.esquerda, nivel + 1);
        }
    }
    
    public void visitarEmOrdem() {
        visitarEmOrdem(raiz);
        System.out.print("\n");
    }

    private void visitarEmOrdem(No no) {
        if (no != null) {
            visitarEmOrdem(no.esquerda);
            System.out.print(no.valor() + " ");
            visitarEmOrdem(no.direita);
        }
    }

    public void visitarPreOrdem() {
        visitarPreOrdem(raiz);
        System.out.print("\n");
    }

    public void visitarPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor() + " ");
            visitarPreOrdem(no.esquerda);
            visitarPreOrdem(no.direita);
        }
    }

    public void visitarPosOrdem() {
        visitarPosOrdem(raiz);
        System.out.print("\n");
    }

    public void visitarPosOrdem(No no) {
        if (no != null) {
            visitarPosOrdem(no.esquerda);
            visitarPosOrdem(no.direita);
            System.out.print(no.valor() + " ");
        }
    }

    public Float calcular(){
       return raiz.visitar(); 
    }
}


