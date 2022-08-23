/**
    *Importação da biblioteca Date e Random
**/
import java.util.Date;
import java.util.Random;
/**
*Criação da classe Venda implementada pela interface Notificador e que recebe as informações necessarias para realizar a venda de produtos
 */
public final class Vendas implements Notificador{
    private Comprador codcomprador;
    private Distribuidora cdistribuidor;
    private String codvenda = "";
    private String endereço = "";
    private int quantidadeBucha = 0;
    private int quantidadeSisal = 0;
    private double valorcompra = 0;
    private final double frete = 25;
    private double valortotal = 0;
    private Date data = new Date();
    private final Pagamento formadepagamento;
    private final Random r = new Random();
    
    /**
        * @param codvenda - Adicionar o codigo da Venda
      *@param endereço - Adicionar o seu endereço
      *@param quantidadedebucha - Adicionar a quantidade de bucha
      *@param quantidadeSisal - Adicionar a quantidade de Sisal
      *@param valorcompra - Adicionar o valor da Compra
      *@param frete - Adicionar o frete
      *@param valortotal - Adicionar o valor total
      Date data - Data da venda
       formadepagamento - tipo de pagamento: credito, avista ou debito
      */
      public Vendas(Distribuidora d,Comprador codcomprador, String endereço, Pagamento formadepagamento, int quantidadeBucha, int quantidadeSisal) {
        this.codcomprador = codcomprador;
        this.endereço = endereço;
        this.quantidadeBucha = quantidadeBucha;
        this.quantidadeSisal = quantidadeSisal;
        this.formadepagamento = formadepagamento;
        this.codvenda = String.valueOf(r.nextInt(90000)+10001)+"250";
        this.valorcompra = (this.quantidadeBucha*d.getBucha().getPreco())+(this.quantidadeSisal*d.getSisal().getPreco())*this.formadepagamento.getTipo() ;
        this.valortotal = this.valorcompra + this.frete;
        this.data = new Date();
        this.cdistribuidor = d;
        System.out.println(Notificar());
    }
    /**
    * Verifica se uma venda é igual a outra
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof Vendas))
            return false;
        Vendas c = (Vendas) obj;
        if(this.codvenda.equals(c.codvenda))
            return true;
        return false;
    }
    
    
    public Comprador getcodcomprador() {
        return codcomprador;
    }    
   
    
     public Distribuidora getCdistribuidor() {
        return cdistribuidor;
    }
    
    public String getCodvenda() {
        return codvenda;
    }
    
    public String getEndereço() {
        return endereço;
    }
    
    public int getQuantidadeBucha() {
        return quantidadeBucha;
    }
    
    public int getQuantidadeSisal() {
        return quantidadeSisal;
    }
     
    public double getValorcompra() {
        return valorcompra;
    }
     
    public double getFrete() {
        return frete;
    }
    
    public double getValortotal() {
        return valortotal;
    }
    
    public Date getData() {
        return data;
    }
     
    
    /**
     *Notificar a distribuidora que a encomenda foi realizada e retorna o valor total da compra
     * @return
     */
    @Override
    public String Notificar() {
        this.cdistribuidor.ReceberCompra(this.quantidadeBucha, this.quantidadeSisal, this.endereço, this.codcomprador, this);
        return 
        "\n+-------------------------------------------+"+
        "\n          Encomenda Foi Validada             "+
        "\n+-------------------------------------------+";    
    }

    @Override
    public String toString(){
      return 
      "\n+-------------------------------------------+"+
      "\n                NOTA FISCAL                  "+
      "\n+-------------------------------------------+"+
      "\n    COMPRADOR: "+codcomprador.getNome()+
      "\n    CÓDIGO DE INDENTIFICAÇÃO: "+this.codcomprador.getCodigo()+
      "\n    CÓDIGO DA VENDA: "+codvenda+
      "\n    ENDEREÇO: "+endereço+
      "\n    QUANTIDADE DE BUCHA: "+quantidadeBucha+
      "\n    QUANTIDADE DE SISAL: "+quantidadeSisal+
      "\n    VALOR DA COMPRA: "+valorcompra+
      "\n    FRETE: "+frete+
      "\n    VALOR TOTAL: $"+valortotal+
      "\n    DATA: "+data
      +"\n+-------------------------------------------+";
    }


    
}
