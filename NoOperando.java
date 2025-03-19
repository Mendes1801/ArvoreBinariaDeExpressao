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