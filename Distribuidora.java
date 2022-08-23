
/**
* importando a biblioteca HashMape Map
*/
import java.util.HashMap;
import java.util.Map;

/**
* criação do construtor da class Comprador  
* @param nome - Nome da empressa
* @param cod_venda - Codigo da venda
* @param Estoque_Produtos - Atribui o estoque a distribuidora 
* @param Bucha - informa as informações do produto bucha(peso e preço)
* @param Sisal - informa as informações do produto bucha(peso e preço)
*/
public class Distribuidora implements Notificador{
  private String nome = "MLWR";
  private Vendas cod_venda; 
  private Estoque_Produtos estoque;
  private Bucha bucha;
  private Sisal sisal;
  private String endereco;
  protected Map<String, Comprador> clientes = new HashMap<>();

  /**
  * Elementos iniciais para criar uma distribuidora
  * @param e - Endereço
  * @param estoque - instância de classe estoque
  * @param b - instância da classe Bucha
  * @param s - instância da classe Sisal
  */

  public Distribuidora(String e, Estoque_Produtos estoque, Bucha b, Sisal s){
    this.endereco = e;
    this.estoque = estoque;
    this.bucha = b;
    this.sisal = s;
  }

  /**
  * Vai verificar se o endereço é igual e se tem uma distribuidora com mesmo nome
  */
  public boolean equals(Object obj) {
        if(!(obj instanceof Distribuidora))
            return false;
        Distribuidora c = (Distribuidora) obj;
        if(this.endereco.equals(c.endereco) && this.nome.equals(c.nome))
            return true;
        return false;
  }
    /**
    * A notificação que a Distribuidora vai receber é que quando uma compra for feita ela vai avisar ao estoque os
    * produtos que vão ser enviados pra o comprador.
    */
    @Override
    public String Notificar(){
        return 
        "\n+-------------------------------------------+"+
        "\n+          Produtos Solicitados             +"+
        "\n+-------------------------------------------+";
    }
    /**
    * Ele recebe tudo que precisa pra realizar a compra ou seja, vai pedir a quantidade de bucha,
    * a quantidade se sisal, o endereco, quem vai comprar e o codigo da venda.
    *
    * @param qBucha - a quantidade de bucha
    * @param qSisal - a quantidade se sisal
    * @param endereco - endereço de entrega
    * @param comprador - comprador que encomendou e receberá a compra
    * @param cvenda - Codigo de identifição
    */
    public void ReceberCompra(int qBucha,int qSisal,String endereco,Comprador comprador,Vendas cvenda){
        System.out.println(Notificar());
        System.out.println(this.estoque.EnviarProduto(qBucha, qSisal, endereco, comprador.getCodigo(), cvenda));
    }
    
    public Map<String, Comprador> getClientes() {
        return clientes;
    }
   
    public void setClientes(Map<String, Comprador> clientes) {
        this.clientes = clientes;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Bucha getBucha() {
        return bucha;
    }

    public void setBucha(Bucha bucha) {
        this.bucha = bucha;
    }

    public Sisal getSisal() {
        return sisal;
    }

    public void setSisal(Sisal sisal) {
        this.sisal = sisal;
    }
  
    public Vendas getCod_venda(){
      return cod_venda;
    }

    public void setCod_venda(Vendas cv){
      this.cod_venda = cv;
    }
    public Estoque_Produtos getEstoque(){
      return estoque;
    }

    public void setEstoque(Estoque_Produtos estoque){
      this.estoque = estoque;
    }

    @Override
    public String toString() {
        return 
         "\n+-------------------------------------------+"+
         "\n               Distribuidora                 "+
         "\n+-------------------------------------------+"+
         "\nNOME: " + nome +
         "\nENDEREÇO: "+this.endereco+
         "\nVALORES DO SISAL {" + this.sisal+ 
         "\nVALORES DA BUCHA { "+ this.bucha+
         "\n+-------------------------------------------+" ;}
    
    
}
  
  
 
