

import java.util.Scanner;


public class MainArv {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        ArvoreBin arvore = new ArvoreBin();
        //Item[] vetor = new Item[10];
        String opcao;
        String nomeCliente, cpfCliente, telCliente, emailCliente;

        do{
            System.out.println("Escolha uma Opção:\n" +
          "1. Cadastrar cliente\n" +
          "2. Pesquisar Cliente\n" +
          "3. Excluir cliente\n" +
          "4. Exibir clientes em ordem alfabética\n" +
          "5. Consultar a média de saldos" +
          "6. listar dados do cliente" +
          "5. Sair");
            opcao = scan.nextLine();
            

            switch(opcao){
                case "1":
                    System.out.println("insira o nome do cliente:\n");
                    nomeCliente = scan.nextLine();
                    System.out.println("insira o CPF do cliente:\n");
                    cpfCliente = scan.nextLine();
                    //aqui tem que formatar colocando apenas numeros.
                    System.out.println("insira o telefone de contato do cliente:\n");
                    telCliente = scan.nextLine();
                    System.out.println("insira o email do cliente:\n");
                    emailCliente = scan.nextLine();
                    if(arvore.inserir(new Item(nomeCliente, cpfCliente, telCliente, emailCliente))){
                        System.out.println("cliente cadastrado com sucesso");
                    }else{
                        System.out.println("Cadastro não efetuado \n"+
                        "Cliente já cadastrado");
                    }
                    break;





                case "2":
                System.out.println("digite o nome do cliente:\n");
                nomeCliente = scan.nextLine();
                if(arvore.pesquisarNome(nomeCliente)){
                    System.out.println("o cliente está cadastrado");
                }else{
                    System.out.println("o cliente não está cadastrado");
                }
                    break;




                case "3":
                    System.out.println("digite o nome do cliente:\n");
                    nomeCliente = scan.nextLine();
                    if(arvore.remover(nomeCliente)){
                        System.out.println("cleinte removido com sucesso");
                    }else{
                        System.out.println("cliente não removido pois não está cadastrado");
                    }
                    break;



                case "4":
                        System.out.println("segue a lista de clientes:\n");
                        arvore.ordemAlfabetica();
                        break;



                case "5":
                    System.out.println("A média de saldos dos clientes é: \n" +
                    arvore.mediaSaldos());
                    break;

                case "6":
                System.out.println("digite o nome do cliente:\n");
                nomeCliente = scan.nextLine();
                if(arvore.pesquisarNome(nomeCliente)){
                    System.out.println("segue os dados do cliente:\n\n" +
                                        "nome: " );
                }
                break;
            }
        }while(true);
    }

}

