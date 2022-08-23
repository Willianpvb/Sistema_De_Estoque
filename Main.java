import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*Grupo : Willian, Raylla, Mikael e Luis*/
public class Main {
    public static void main(String[] args) {
        for(int i=0; i<10; i++){System.out.print("+\r\n");}
        inicio();
    }
    public static void inicio(){
        /*valores iniciais*/
        Comprador x = new Comprador("09876543211","Willian Pereira","988342312","Rua São Valentin","willian@gmail.com");
        Estoque_Produtos ml = new Estoque_Produtos("Rua São Lucas-PB, 162A", 10000, 10000);
        Bucha bu = new Bucha(4.50, 1);
        Sisal si = new Sisal(3.50, 1);
        Distribuidora wr = new Distribuidora("Rua Santos Drumond de Andrade, 34C",ml, bu, si);
        wr.clientes.put(x.getCodigo(), x);
        boolean rodar = true;
        Scanner s = new Scanner(System.in);
       
        while(rodar){
                System.out.println("\n+-------------------------------------------+"
                        +"\n|             Menu de Opções                |"
                        +"\n+-------------------------------------------+"
                        +"\n| 1 - Cadastrar-se na Distribuidora         |"
                        +"\n| 2 - Remover Conta                         |"
                        +"\n| 3 - Entrar                                |"
                        +"\n| 4 - Outras informações                    |"
                        +"\n| 0 - SAIR                                  |"
                        +"\n+-------------------------------------------+");
                System.out.print("\nOpção escolhida:"); 
                try{
                    String respostas = s.nextLine();
                    int resposta = Integer.parseInt(respostas);
                    for(int i=0; i<10; i++){
                        System.out.print("+\r\n");
                    }
                    switch(resposta){
                        case 0:
                            System.out.println("Encerrando...");
                            rodar = false;
                            break;
                        case 1:
                            cadastrar(wr);
                            break;
                        case 2:
                            remover_conta(wr);
                            break;
                        case 3:
                            entrar(wr);
                            break;
                        case 4:
                            System.out.println("Informações da Distribuidora:\n"+wr.toString());
                            System.out.println("\nInformações do estoque:\n"+ml.toString());
                            break;
                        default:
                            try{
                                System.out.println(
                                "\n+-------------------------------------------+"+
                                "\n+    Opção Inexistente, Tente Novamente     +"+
                                "\n+-------------------------------------------+");
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        
                    }
                }catch(NumberFormatException ex){
                   System.out.println("Ohhhh Really ???,Don´t you know read?");
                }
                for(int i=0; i<10; i++) System.out.print("+\r\n");        
        }
    }
    public static void cadastrar(Distribuidora wr){
        String cpf, nome, telefone, endereco,email;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Iniciando Cadastro...");
            System.out.println("\nDigite seu CPF(11 digitos numéricos) :");
            cpf = sc.nextLine();
            System.out.println("\nDigite seu NOME:");
            nome = sc.nextLine();
            System.out.println("\nDigite seu TELEFONE:");
            telefone = sc.nextLine();
            System.out.println("\nDigite seu ENDEREÇO:");
            endereco = sc.nextLine();
            System.out.println("\nDigite seu E-MAIL:");
            email = sc.nextLine();
            
            Comprador c = new Comprador(cpf, nome, telefone, endereco, email);
            wr.clientes.put(c.getCodigo(), c);
            System.out.println("\nBEM-VINDO Á PLATAFORMA\n");
            System.out.println("ESSAS SÃO SUAS INFORMAÇÕES GUARDE-AS, ELAS SERÃO NECESSARIAS PARA ENTRAR NA PLATAFORMA!!!\n");
            System.out.println(c.toString());
        }catch(java.lang.StringIndexOutOfBoundsException ex ){
            System.out.println("Cpf de tamanho ínvalido, ERRO:"+ ex);

        }
        
    }
    public static void entrar(Distribuidora wr){
        Scanner en = new Scanner(System.in);
        try{
            System.out.println("Digite abaixo as informações de acesso.");
            System.out.println("Digite seu nome ou Cpf(formato:###.###.###-##):");
            String parte2 = en.nextLine();
            System.out.println("Digite aqui seu Codigo de identificação:");
            String cod = en.nextLine();
            boolean cpf2 = wr.getClientes().get(cod).getCpf().equals(parte2);
            boolean cod2 = wr.getClientes().get(cod).getNome().equals(parte2);
            if(wr.clientes.get(cod) == null & (!(cpf2 || cod2))){
                    System.out.println(
                      "\n+-------------------------------------------+"+
                      "\n+ Nenhuma conta corresponde as esses dados  +"+
                      "\n+-------------------------------------------+");
            }else{
                boolean game = true;
                while(game){
                    Comprador entra = wr.getClientes().get(cod);
                    for(int i=0; i<10; i++){
                        try{
                            System.out.print("+\r\n");
                            Thread.sleep(200);
                        }catch(Exception e){
                            System.out.println("-_- Serio?");
                        }
                    }
                    try{
                        System.out.println("+-------------------------------------------+");
                        System.out.println("+              Quadro de opções             +");
                        System.out.println("+-------------------------------------------+");
                        System.out.println("+ 1 - Encomendar (Sisal ou Bucha)           +");
                        System.out.println("+ 2 - Alterar Dados pessoais                +");
                        System.out.println("+ 3 - Rever seus dados                      +");
                        System.out.println("+ 4 - Historico de Encomendas               +");
                        System.out.println("+ 5 - SAIR                                  +");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("Opção escolhida:");
                        String switchs = en.nextLine();
                        int switch2 = Integer.parseInt(switchs);
                        for(int i=0; i<5; i++){
                            System.out.print("+\r\n");
                        }
                        switch(switch2){
                            case 1:
                                entrar_encomendar(en,wr,entra);
                                break;
                            case 2:
                                entrar_alterar(en,wr,cod);
                                break;
                            case 3:
                                System.out.println("Informações atuais sobre você:");
                                System.out.println(wr.clientes.get(cod));
                                break;
                            case 4:
                                if(wr.clientes.get(cod).getEncomendas().isEmpty() == false){
                                    System.out.println(wr.clientes.get(cod).getEncomendas());
                                }else{
                                    System.out.println(
                                    "\n+---------------------------------------------+"+
                                    "\n+        Nenhuma Encomenda Realizada          +"+
                                    "\n+---------------------------------------------+");    
                                }
                                break;
                            case 5:
                                game = false;
                                break;
                            default:
                                System.out.println("Opções de 1 à 5");
                                break;
                        }
                    }catch(NumberFormatException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch(java.lang.NullPointerException e){
            System.out.println(
              "\n+-------------------------------------------+"+
              "\n+         Nenhuma Conta Cadastrada          +"+
              "\n+-------------------------------------------+");
        } 
    }
    public static void remover_conta(Distribuidora wr){
        Scanner rc = new Scanner(System.in);
        System.out.println("Fico triste que tudo esteja acabando tão rápido. Foi bom ter você conosco durante esse tempo!");
        System.out.print("\n\nAdicione aqui o codigo de identificação a ser apagado:");
        String retur = rc.nextLine();
        if(wr.clientes.get(retur) == null){
            System.out.println(
              "\n+-------------------------------------------+"+
              "\n+         Comprador Não Existe              +"+
              "\n+-------------------------------------------+");
        }else{
            wr.clientes.remove(retur);        
            System.out.println("Até a próxima!\nConta destruida...");
        }    
    }
    public static void entrar_encomendar(Scanner en,Distribuidora wr,Comprador entra){
        System.out.println("Qual a forma de Pagamento?(1 - Ávista, 2 - Debito ou 3 - Credito)");
        int paga = en.nextInt();
        Pagamento pagamento = Pagamento.AVISTA; 
        for(int i=0; i<10; i++){System.out.print("+\r\n");}
        switch(paga){
            case 1:
                break;
            case 2:
                pagamento = Pagamento.DEBITO;
                break;
            case 3:
                pagamento = Pagamento.CREDITO;
                break;
            default:
                System.out.println( "\n+-------------------------------------------+"+
                                "\n+ Opção não existente, encomenda cancelada  +"+
                                "\n+-------------------------------------------+");
                break;
        }              
        System.out.println("\n\nAdicione a quantidade de BUCHA a ser comprada:");
        int bucha = en.nextInt();
        System.out.println("\n\nAdicione a quantidade de SISAL a ser comprada:");
        int sisal = en.nextInt();
        System.out.println("\n\nDigite aqui o ENDEREÇO da entrega:");
        String endereco2 = en.nextLine();/*gambiarra*/
        String endereco = en.nextLine();
        entra.Encomendar(wr, endereco, pagamento, bucha, sisal);
    }
    public static void entrar_alterar(Scanner en,Distribuidora wr,String cod){
        try{
            System.out.println("+-------------------------------------------+");
            System.out.println("+              Quadro de opções             +");
            System.out.println("+-------------------------------------------+");
            System.out.println("+ 0 - CPF                                   +");
            System.out.println("+ 1 - Nome                                  +");
            System.out.println("+ 2 - Telefone                              +");
            System.out.println("+ 3 - Endereço                              +");
            System.out.println("+ 4 - E-mail                                +");
            System.out.println("+ 5 - Nenhuma das alternativas              +");
            System.out.println("+-------------------------------------------+");
            System.out.print("Qual Dos seus dados pessoais deseja Alterar?");
            String altter = en.nextLine();
            int alter = Integer.parseInt(altter);
            switch (alter) {
            /*gambiarra até cançar*/
                case 0:
                    System.out.print("Digite o novo Cpf:");
                    String cpfn = en.next();
                    wr.clientes.get(cod).setCpf(cpfn);
                    break;
                case 1:
                    System.out.print("Digite o novo nome:");
                    String nomen2 = en.nextLine();
                    String nomen = en.nextLine();
                    wr.clientes.get(cod).setNome(nomen);
                    break;
                case 3:
                    System.out.print("Digite o novo endereço:");
                    String endern2 = en.nextLine();
                    String endern = en.nextLine();
                    wr.clientes.get(cod).setEndereco(endern);
                    break;
                case 4:
                    System.out.print("Digite o novo E-mail:");
                    String mailn = en.next();
                    wr.clientes.get(cod).setE_mail(mailn);
                    break;
                case 2:
                    System.out.print("Digite o novo Telefone:");
                    String teln = en.next();
                    wr.clientes.get(cod).setTelefone(teln);
                    break;
                case 5:
                    System.out.println(
                    "\n+---------------------------------------------+"+
                    "\n+O seu codigo de identificação não pode ser \nalterado+"+
                    "\n+---------------------------------------------+");
                    break;
                default:
                    System.out.println("\n+---------------------------------------------+");
                    System.out.println("\n+               Opção ínvalida                +".toUpperCase());
                    System.out.println("\n+---------------------------------------------+");
                    break;
            }        
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
    } 
        
    
    
    
    
    
}


    
    
    
    
    

