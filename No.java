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