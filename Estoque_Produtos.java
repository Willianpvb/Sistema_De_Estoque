/**
* impotação da biblioteca Level e Logger.
*/
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Classe Estoque_Produtos que é implementado pela interface Notificador.
*/
public class Estoque_Produtos implements Notificador{
  private int limite_sisal;
  private int limite_bucha;
  private String local;
  private int phone = 88400282;
/**
  * criação do construtor da class   
  * @param limite_sisal - limite do estoque do produto sisal
  * @param limite_bucha - limite do estoque do produto Bucha
  * @param local - Endereço de onde o Estoque fica localizado 
  * @param phone - informa o número de telefone do estoque
  */
public Estoque_Produtos(String local, int limiteB, int limiteS){
    this.local = local;
    this.limite_bucha = limiteB;
    this.limite_sisal = limiteS;
}
/**
 * construtor Estoque_Produto automático, é necessário informar apenas o local e as outras informações serão complementadas automáticamente  
 
*/
public Estoque_Produtos(String local){
    this.limite_bucha = 100;
    this.limite_sisal = 100;
}

/**
* Método EnviarProduto que verifica no estoque se há quantidade suficiente desejada pelo comprador. Se houver quantidade suficiente o sistema irá notificar ao cliente que a compra foi realizada, caso não haja quantidade suficiente, o sistema irá notificar que o estoque é Insuficiente para realizar a compra. Se o estoque não se encaixar em nenhuma dessas condições, seu estoque estará vazio.
*/
public String EnviarProduto(int qBucha,int qSisal,String endereco,String comprador, Vendas v){
    if(this.limite_bucha >= qBucha && this.limite_sisal >= qSisal){
        this.limite_sisal = limite_sisal - qSisal;
        this.limite_bucha = limite_bucha - qBucha;
        System.out.println(Notificar());
        System.out.println(v.toString());
        return
        "\n+-------------------------------------------+"+ 
        "\n         Compra Feita com Sucesso           +"+
        "\n+-------------------------------------------+";
    }else if(this.limite_bucha > 0 && this.limite_sisal > 0){
        return  "\n+-------------------------------------------+"
                +"Estoque Insuficiente no Momento, peça novamente com quatidades menores que "
                +String.valueOf(this.limite_bucha)+" para BUCHA e "
                +String.valueOf(this.limite_sisal)+" para Sisal"
                +"\n+-------------------------------------------+";
    }else{
        return 
        "\n+-------------------------------------------+"+
        "\n               Estoque Vazio                 "+
        "\n+-------------------------------------------+";
    }
}

  /**
   * Retorna o endereço de onde esta localizado o estoque 
   * @return 
   */
public String getLocal() {
    return local;
    }

    /**
     *Utilizado para receber outro endereço, se necessário.
     * @param local
     */

public void setLocal(String local) {
    this.local = local;
    }
  /**
   * Retorna o contato da empresa 
   * @return 
   */
public int getPhone() {
    return phone;
    }
    /**
     * Usado para alterar contato
     * @param phone
     */
public void setPhone(int phone) {
    this.phone = phone;
    }
  /**
   * Retorna A quantidade de produtos Sisal no estoque
   * @return 
   */
public int getLimite_sisal(){
    return limite_sisal;
}
    /**
     * Usado para atualizar a quantidade de produtos no estoque Sisal
     * @param limite_sisal
     */
public void setLimite_sisal(int slimite){
    this.limite_sisal = slimite;
}
  /**
   * Retorna a quantidade de produtos Bucha no estoque
   * @return 
   */
public int getLimite_bucha(){
    return limite_bucha;
}
  /**
     * Usado para atualizar a quantidade de produtos no estoque Bucha
     * @param limite_bucha
     */ 
public void setLimite_bucha(int blimite){
    this.limite_bucha = blimite;
}

/**
 * O toString esta retornando todas as informações que poderão ser mostradas na classe Main
*/
@Override
public String toString() {
        return 
         "\n+-------------------------------------------+"+
         "\n             Estoque Produtos                "+
         "\n+-------------------------------------------+"+
         "\nSISAL NO ESTOQUE: " + limite_sisal +
         "\nBUCHA NO ESTOQUE: "+limite_bucha+
         "\nENDEREÇO: " + local+ 
         "\nTELEFONE: "+ phone+
         "\n+-------------------------------------------+" ;}

    /**
     * O metodo notificar está informando ao usuário que a encomenda foi reservada.
     */
    public String Notificar() {
      try {
          Thread.sleep(1500);
      } catch (InterruptedException ex) {
          Logger.getLogger(Estoque_Produtos.class.getName()).log(Level.SEVERE, null, ex);
      }
        return 
        "\n+-------------------------------------------+"+
        "\n+           Encomenda Reservada             +"+
        "\n+-------------------------------------------+";
    }

}




