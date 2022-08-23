/**
 *Classe Produto, onde as classes Bucha e Sisal herdam seus atributos
 * @author willi
 */
public abstract class Produto {
  private double preco;
  private double peso;
  /**
   * Construtor onde são colocados os valores iniciais obrigatorios
   * @param preco - Preço do produto
   * @param peso - Peso do pacote
   */
  public Produto(double preco, double peso){
    this.preco = preco;
    this.peso = peso;
  }
  /**
   * Retorno o Preço do produto
   * @return 
   */
  public double getPreco() {
    return preco;
  }
  /**
   * Colocar novo Preço do produto
   * @param preco 
   */
  public void setPreco(double preco) {
    this.preco = preco;
  }
  /**
   * Retorna o Peso do produto
   * @return 
   */
  public double getPeso() {
    return peso;
  }
  /**
   * Adiciona o novo Preço 
   * @param peso 
   */
  public void setPeso(double peso) {
    this.peso = peso;
  }
  /**
   * Retorna as variaveis do produto
   * @return 
   */
  @Override
  public String toString() {
        return "Preco($): " + preco + ", Peso(Kg): " + peso + '}';
    }
  
}