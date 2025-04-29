//PROJETO DE ARVORE DE EXPRESSAO MACKENZIE - ESTRUTURA DE DADOS 2 - 4N
//Nome:GABRIEL ERICK MENDES 10420391
//Nome:MATEUS TELES MAGALHAES 10427410
//Nome:CAMILA NUNES CARNIEL 10338558

import java.util.Scanner;

import javax.imageio.IIOException;

public class main {
    
    public static void main(String[] args) throws IIOException, Exception {

       Scanner ler = new Scanner(System.in);
       String input = null;
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
                input = ler.next();                 
            } catch (Exception e) {
                input = "0";
                ler.next();
            }
            
            switch (Integer.parseInt(input)) {
                case 1:

                try {
                    System.out.printf("Insira a expressão: ");
                    ler.nextLine();
                    String entrada = ler.nextLine();
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
