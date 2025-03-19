import java.util.Scanner;

import javax.imageio.IIOException;

public class main {
    
    public static void main(String[] args) throws IIOException {

       Scanner ler = new Scanner(System.in);
       Integer input = null;
       expressaoNumerica expressao = null;
       Arvore arvoreDeExpressao = null;
        
        String menu = "\nMenu de Opções: \r\n" + //
                        "\r\n" + //
                        "1. Entrada da expressão aritmética na notação infixa.\r\n" + //
                        "2. Criação da árvore binária de expressão aritmética.\r\n" + //
                        "3. Exibição da árvore binária de expressão aritmética.\r\n" + //
                        "4. Cálculo da expressão (realizando o percurso da árvore).\r\n" + //
                        "5. Encerramento do programa.\n";


        while(true){
            System.out.println(menu);

            try {
                input = ler.nextInt();                 
            } catch (Exception e) {
                input = 0;
                ler.next();
            }
            
            switch (input) {
                case 1:

                try {
                    System.out.printf("Insira a expressão: ");
                    String entrada = ler.next();
                    expressao = new expressaoNumerica(entrada);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                    
                    break;
            
                case 2:

                    try {
                        arvoreDeExpressao = new Arvore(expressao.getExpressaoNumerica());
                        System.out.println("Arvore criada com sucesso!\n");
                    } catch (Exception e) {
                        System.out.printf("Arvore não encontrada!\n%s\n",e);
                    }
            
                    break;

                case 3:
                    
                try {

                    System.out.printf("Pre-Ordem: ");
                    arvoreDeExpressao.visitarPreOrdem();

                    System.out.printf("Em ordem: ");
                    arvoreDeExpressao.visitarEmOrdem();

                    System.out.printf("Pos-Ordem: ");
                    arvoreDeExpressao.visitarPosOrdem();

                } catch (Exception e) {
                    System.out.printf("Arvore ou expressão não encontrada!\n%s\n",e);
                }
                    break;

                case 4:
                
                try {
                    System.out.printf("Resultado: %f", arvoreDeExpressao.calcular());

                } catch (Exception e) {
                    System.out.printf("Arvore ou expressão não encontrada!\n%s\n",e);
                }
                    break;

                case 5:
                    ler.close();
                    System.exit(0);

                    break;

                default:
                    System.out.println("Entrada Inválida! Digite uma opção 1/2/3/4/5");
                    break;
            }

       }


        
    }
}
