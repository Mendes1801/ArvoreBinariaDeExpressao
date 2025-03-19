class NoOperador extends No{
    Character valorOperador;

    NoOperador(Character valorOperador, No esquerda, No direita){
        super(esquerda, direita);
        this.valorOperador = valorOperador;
    }

    NoOperador(){
        super();
    }

    public String valor(){
            return Character.toString(valorOperador);
        }


    public Float visitar(){

        switch (valorOperador) {
            case '+':

                return esquerda.visitar() + direita.visitar();

            case '-':
            
                return esquerda.visitar() - direita.visitar();

            case '*':
                return esquerda.visitar() * direita.visitar();

            case '/':
                return esquerda.visitar() / direita.visitar();

            default:
                return Float.NaN;
        }

    }  

}