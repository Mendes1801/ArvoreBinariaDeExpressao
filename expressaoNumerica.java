//PROJETO DE ARVORE DE EXPRESSAO MACKENZIE - ESTRUTURA DE DADOS 2 - 4N
//Nome:GABRIEL ERICK MENDES 10420391
//Nome:MATEUS TELES MAGALHAES 10427410
//Nome:CAMILA NUNES CARNIEL 10338558

import java.util.LinkedList;
import javax.imageio.IIOException;


/*
 * CLASSE DE EXPRESSAO NUMERICA
 * É UTILIZADA PARA CRIAR UMA EXPRESSAO NUMERICA E VERIFICAR SE ELA ESTA CORRETA
 * A CLASSE UTILIZA A IDEA DE HERANÇA PARA ARMAZENAR OS OPERADORES E NUMEROS EM UMA MESMA LISTA
 * A CLASSE TAMBÉM ARMAZENA UMA LISTA DE NUMEROS E OPERADORES EM NOTACAO POLONESA REVERSA
 */
public class expressaoNumerica {

    private String expressaoNumerica;
    private LinkedList<Object> expressaoList;

    expressaoNumerica(String expressaoNumerica) throws Exception{
        setExpressaoNumerica(expressaoNumerica);
    }

    expressaoNumerica(){
    }

    //Essa funcao verifica se a expressao esta correta
    //Retorna true se estiver correta e false se nao
    //É utilizado a idea de herança para armazenar os operadores e numeros em uma mesma lista
    //O algoritimo utiliza uma pilha para verificar a ordem dos parenteses
    public boolean validarExpressao(String expressao) throws IIOException, Exception{

        LinkedList<Character> pilhaParenteses = new LinkedList<>();
        LinkedList<Character> expressaoList = new LinkedList<>();

        expressao = expressao.strip().trim().replaceAll(" ", "");

        //Transforma a expressao em um vetor de Character
        for(int i=0; i<expressao.length();i++){
            expressaoList.addLast(expressao.charAt(i));
        }

        //valida a ordem dos parenteses utilizando uma pilha
        for(int i =0; i < expressaoList.size();i++){
        Character atual = expressaoList.get(i);

            if (atual==40) pilhaParenteses.addFirst(expressaoList.remove(i--));

                if (atual==41){
                    if (pilhaParenteses.isEmpty()){
                        throw new Exception(String.format("Erro: O Caracter '%c' está sendo utilizando incorretamente!\n",atual));
                    } 
                    else {
                        pilhaParenteses.removeFirst();
                        expressaoList.remove(i--);
                    }
                }
        }

        if (!pilhaParenteses.isEmpty()){
            throw new Exception(String.format("Erro: O Caracter '%c' está sendo utilizando incorretamente!\n" + //
                                "",pilhaParenteses.getFirst()));
        } 

        for(int i =0; i<expressaoList.size();i++){
            Character atual = expressaoList.get(i);

            if(atual >= 42 & atual <=47 & atual != 44){
                    
                    //Valida os operadores binarios e o ponto flutuante

                    try {
                        if (expressaoList.get(i-1) < 48 || expressaoList.get(i-1) > 57) 
                            throw new Exception(String.format("Erro: O Caracter '%c' não está completo!\n",atual));
    
                        if (expressaoList.get(i+1) < 48 || expressaoList.get(i+1) > 57) 
                            throw new Exception(String.format("Erro: O Caracter '%c' não está completo!\n",atual));
                        
                    } catch (Exception e) {
                        System.out.printf("O operador '%c' não está completo!\n", atual);
                    }



            }else if(atual < 48 || atual > 57) 
                throw new Exception(String.format("Erro: O Caracter '%c' é inválido!\n",atual));

        }

        return true;

    }

    public boolean isEmpty(){
        return this.expressaoNumerica.isEmpty();
    }

    public void setExpressaoNumerica(String expressaoNumerica) throws Exception {

        expressaoNumerica = expressaoNumerica.replaceAll(" ", "");

        if(validarExpressao(expressaoNumerica)){
            this.expressaoNumerica = expressaoNumerica;
            this.expressaoList = criarExpressaoList(expressaoNumerica);
        }

    }


    //Essa funcao transforma uma expressao em uma lista de numeros e operadores utilizando a ideia de heranca de classes
    //Retorna uma lista de numeros e operadores
    //O algoritimo utiliza a tabela ascii para identificar os numeros e os operadores
    private LinkedList<Object> criarExpressaoList(String expressaoString){

        LinkedList<Object> entradaArrayList = new LinkedList<>();
        StringBuilder entradaPilha = new StringBuilder();

        for(int i =0; i < expressaoString.length(); i++){

            char c = expressaoString.charAt(i);
            
            if((c >= 48 & c <= 57) || c == 46){
                entradaPilha.append(c);
            } 
                else{
                    if(entradaPilha.length()>0){
                        entradaArrayList.addLast(Float.parseFloat(entradaPilha.toString()));
                        entradaPilha = new StringBuilder();
                    }
                    entradaArrayList.addLast(c);
                }
        }
        if(entradaPilha.length()>0) entradaArrayList.addLast(Float.parseFloat(entradaPilha.toString()));

        return entradaArrayList;
    }

    public String getExpressaoNumerica() {
        return expressaoNumerica;
    }

    public LinkedList<Object> getExpressaoList() {
        return expressaoList;
    }


    //Essa expressão verifica a ordem de prioridade dos operadores
    //Retorna a prioridade do operador
    //O algoritimo utiliza switch case para cada caso de operador
    private int prioridade(Character operador){
        
        switch (operador) {
            case '+':
            case '-':
                return 1; // Prioridade baixa
            case '*':
            case '/':
                return 2; // Prioridade alta
            case '^':
                return 3;
            default:
                return 0; // Para parênteses ou operadores não reconhecidos
        }
    }


    //Essa função transforma uma expressão em uma expressão em notação polonesa reversa
    //Retorma uma lista de operadores e numeros em notação polonesa reversa
    public LinkedList<Object> transformaInfixa(){

        LinkedList<Object> saida = new LinkedList<>();
        LinkedList<Character> operadores = new LinkedList<>();

        // Converte a expressão para notação polonesa reversa
        for (int i = 0; i < expressaoList.size(); i++) {
            Object current = expressaoList.get(i);
    
            // Se for numeral insere na saida
            if (current.getClass().getSimpleName().equals("Float")) {
                saida.addLast(current);

              // Se for ( Empilha  
            } else if (current.equals('(')) {
                operadores.addFirst((Character)current);
              
              // Se for ) Desempilha e insere na saida até encontrar (, e entao desempilha (
            } else if (current.equals(')')) {
                while (!operadores.isEmpty() && operadores.getFirst() != '(') {
                    saida.addLast(operadores.removeFirst()); 
                }
                operadores.removeFirst();
            
            
            }else {
                //Verifica a prioridade entre os operadores, ex * > + exceto se houver ()
                while (!operadores.isEmpty() && prioridade((Character) operadores.getFirst()) >= prioridade((Character)current)) {
                    saida.addLast((Character) operadores.removeFirst()); 
                }

                operadores.addFirst((Character) current);
            }
        }
    
        //Desempilha todos os operadores restantes
        while (!operadores.isEmpty()) {
            saida.addLast((Character) operadores.removeFirst());
        }



        return saida;
    }

}
