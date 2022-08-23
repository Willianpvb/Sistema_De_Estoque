/**
* Criação da classe Pagamento
* que vai estar presente nas classes vendas e comprardor para poder ser informado qual o tipo de pagamento feito
* a variavel tipo vai apenas receber qual a forma de pagamento escolhido pelo usuario.
*/
public enum Pagamento {
    DEBITO(1.1),CREDITO(1.2),AVISTA(1.0);
    
    private double tipo = 0;
    Pagamento(double t){
        this.tipo = t;
    }
    /**
    * Retorna a taxa a ser cobrada de acordo com o pagamento feito 
    * @return 
    */
    public double getTipo() {
        return tipo;
    }
}


