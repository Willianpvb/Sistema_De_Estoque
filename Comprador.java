/**
* impotação da biblioteca Random
*/
import java.util.ArrayList;
import java.util.Random;
/**
* criação da classe Comprador, assim como seus atributos
*/
public class Comprador {
    private String e_mail = "";
    private String telefone = "";
    private String endereco = "";
    private String codigo = "";
    private String nome = "";
    private String cpf = "";
    private ArrayList<Vendas> encomendas = new ArrayList();
    private final Random r = new Random();
    /**
     * criação do construtor da class Comprador  
     * @param cpf - Adicione seu CPF
     * @param nome - Adicione nome
     * @param telefone - Adicione seu telefone 
     * @param endereco - Adicione o seu endereço 
     * @param email - Adicione o seu email
     */
    public Comprador(String cpf, String nome, String telefone, String endereco, String email){
      this.codigo = String.valueOf(r.nextInt(100000-10000)+10001)+"100" ;
      this.nome = nome;
      this.e_mail = email;
      this.telefone = telefone;
      this.endereco = endereco;
      this.cpf = String.format("%s.%s.%s-%s", cpf.substring(0, 3),cpf.substring(3, 6),cpf.substring(6, 9),cpf.substring(9, 11));
    }
    /**
     * Metodo Encomendar ele pegar as informações do comprardor incluindo  o endereço, o tipo de pagamento e a quantidade do produto, ativa a 
     * classe venda e notifica a Distribuidora
     * @param db - Distribuidora a ser notificado
     * @param endereco - Endereço de entrega
     * @param p - Forma de Pagamento que a compra será paga
     * @param quantB - Quantidade de Bucha a ser comprada
     * @param quantS - Quantidade de Sisal a ser comprado
    */
    public void Encomendar(Distribuidora db,String endereco,Pagamento p,int quantB, int quantS){
        Vendas v = new Vendas(db,this ,endereco, p, quantS, quantB);
        encomendas.add(v);
    }
    /**
    * Verifica se há um comprador igual a outro
    */
    public boolean equals(Object obj) {
        if(!(obj instanceof Comprador))
            return false;
        Comprador c = (Comprador) obj;
        if(this.codigo.equals(c.codigo))
            return true;
        return false;
    }
    /**
     * Retorna o Codigo de identificaçao do Comprador
     * @return 
     */
    public String getCodigo(){
        return codigo;
  }
  /**
   * Retorna a lista de pedidos 
   * @return 
   */  
  public ArrayList getEncomendas(){
      return encomendas;
  }
  /**
   * Da um novo valor a lista de Encomendas
   */
  public void setEncomendas(ArrayList encomendasn){
      this.encomendas = encomendasn;
  }
    /**
     * Retorna o E-mail do Comprador
     * @return 
     */
    public String getE_mail() {
        return e_mail;
    }
    /**
     * Altera o e-mail para um novo a escolha do Usuario
     * @param e_mail 
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    /**
     * Retorna o telefone do Comprador
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Utilizada para trocar o telefone
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Retorna o Endereço do comprador
     * @return 
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Quando acionado você coloca o novo Endereço do Comprador
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * Retorna o nome do Comprador
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * Troca o nome do comprador pelo novo
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Retorna o CPF do comprador
     * @return 
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * Troca o CPF antigo pelo novo dado pelo usuario
     * @param cpf 
     */
    public void setCpf(String cpf) {
        this.cpf = String.format("%s.%s.%s-%s", cpf.substring(0, 3),cpf.substring(3, 6),cpf.substring(6, 9),cpf.substring(9, 11));

    }
    /**
    * Retorna os valores da classe Comprador em forma de string  
    */
    @Override
    public String toString(){
      return
      "\n+-------------------------------------------+"+
      "\n                 Comprador                   "+
      "\n+-------------------------------------------+"+
      "\n      CÓDIGO     : "+codigo+
      "\n       NOME      : "+nome+
      "\n       CPF       : "+cpf+
      "\n       EMAIL     : "+e_mail+
      "\n     TELEFONE    : "+telefone+
      "\n     ENDEREÇO    : "+endereco+
      "\n+-------------------------------------------+";
      }




}

