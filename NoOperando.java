//PROJETO DE ARVORE DE EXPRESSAO MACKENZIE - ESTRUTURA DE DADOS 2 - 4N
//Nome:GABRIEL ERICK MENDES 10420391
//Nome:MATEUS TELES MAGALHAES 10427410
//Nome:CAMILA NUNES CARNIEL 10338558

//CLASSE DE NO OPERANDO UTILIZANDO POLIMORFISMO E HERANÇA
class NoOperando extends No{
    Float valorOperando;

    NoOperando(Float valorOperando, No esquerda, No direita){
        super(esquerda, direita);
        this.valorOperando = valorOperando;
    }

    NoOperando(){
        super();
    }

    public String valor(){
        return Float.toString(valorOperando);
    }

    Float visitar(){
        return valorOperando;  
    }  

}