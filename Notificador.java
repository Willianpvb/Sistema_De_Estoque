/**
* criação da class Notificador
* A classe Notificador vai estar introduzida em outras duas classes ( Distribuidora, Estoque_Produtos e vendas)
* que vai enviar um notificação para essas classes serem informadas quando algo acontecer
*/
public interface Notificador {
    /**
    * Metodo que será reescrito em outras classes que necessitam de uma notificação
    */
    public String Notificar();
}




