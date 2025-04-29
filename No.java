
//PROJETO DE ARVORE DE EXPRESSAO MACKENZIE - ESTRUTURA DE DADOS 2 - 4N
//Nome:GABRIEL ERICK MENDES 10420391
//Nome:MATEUS TELES MAGALHAES 10427410
//Nome:CAMILA NUNES CARNIEL 10338558

//APLICANDO A IDEIA DE CLASSE ABSTRATA E POLIMORFISMO ENTRE CLASSES
//SUPER CLASSE DE NO OPERANDO E NO OPERADOR
abstract class  No {
    No esquerda, direita;

    No(No esquerda, No direita){
        this.esquerda = esquerda;
        this.direita = direita;
    }

    No(){}

    public abstract String valor();

    Float visitar(){
        return Float.NaN;  
    }  

}