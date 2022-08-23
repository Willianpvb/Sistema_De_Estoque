/**
 * A classe Sisal herda os atributos da Classe Produto
 * 
 * @author Nós
 */
public class Sisal extends Produto{
    /**
     * 
     * @param preco - Preço do Sisal
     * @param peso - Peso do Pacote do Sisal 
     */
    public Sisal(double preco, double peso) {
        super(preco, peso);
    }
    /**
     * Retorna os valores do peso e do preço
     * @return 
     */
    @Override
    public String toString(){
        return super.toString();
  }
}

