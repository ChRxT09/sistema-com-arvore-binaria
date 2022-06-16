

public class Item {
  private String nome;
  private String cpf;
  private String telefone;
  private String email;
  private double saldo;
  

  //construtor da classe
  public Item(String nome, String cpf, String telefone, String email){
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.saldo = 0.0;
    
  }



  //gets
  public String getNome(){return this.nome;}
  public String getCpf(){return this.cpf;}
  public String getTelefone(){return this.telefone;}
  public String getEmail(){return this.email;}
  public double getSaldo(){return this.saldo;}


  //sets
  public void setNome(String nome){this.nome = nome;}
  public void setCpf(String cpf){this.cpf = cpf;}
  public void setTelefone(String telefone){this.telefone = telefone;}
  public void setEmail(String email){this.email = email;}
  





  //adicionar saldo. Vai adicionar um valor(deposito, rendimento, etc.) ou retirar(saque, débito, etc.) do saldo original 
  public void alterarSaldo(double valor){this.saldo += valor;}


  
}
