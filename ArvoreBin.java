
public class ArvoreBin {
    private NoArv raiz;
    private int quantNos;

    //construtor
    public ArvoreBin(){
        this.quantNos = 0;
        this .raiz = null;
    }


    //gets
    public boolean eVazia() {return (this.raiz == null);}
    public NoArv getRaiz() {return this.raiz;}
    public int getQuantNos() {return this.quantNos;}

    //inserir
    public boolean inserir(Item elem){
        if(this.pesquisarNome(elem.getNome()) || this.pesquisarCpf(elem.getCpf())){
            return false;
        }else{
            this.raiz = inserir(elem, this.raiz);
            this.quantNos++;
            return true;
        }
    }


    public NoArv inserir(Item elem, NoArv no){
        if(no == null){NoArv novo =new NoArv(elem); return novo;}else{
            if(elem.getNome().compareTo(no.getInfo().getNome()) == -1){
                no.setEsq(inserir(elem, no.getEsq()));
                return no;
            }else{
                no.setDir(inserir(elem, no.getDir()));
                return no;
            }
        }
    }


    //pesquisarNome
    public boolean pesquisarNome(String nome){
        if (pesquisarNome(nome, this.raiz) != null) return true;
        else return false;
    }
    private NoArv pesquisarNome(String nome, NoArv no){
        if(no != null){
            if(nome.compareTo(no.getInfo().getNome()) == -1){
                no = pesquisarNome(nome, no.getEsq());
            }else if(nome.compareTo(no.getInfo().getNome())== 1){
                no = pesquisarNome(nome, no.getDir());
            }

        }
        return no;
    }

    //pesquisar CPF
    public boolean pesquisarCpf(String cpf){
        if (pesquisarCpf(cpf, this.raiz) != null) return true;
        else return false;
    }
    private NoArv pesquisarCpf(String cpf, NoArv no){
        if(no != null){
            if(cpf.compareTo(no.getInfo().getCpf()) == -1){
                no = pesquisarCpf(cpf, no.getEsq());
            }else if(cpf.compareTo(no.getInfo().getCpf())== 1){
                no = pesquisarCpf(cpf, no.getDir());
            }

        }
        return no;
    }



    //remover
    public boolean remover(String nome) {
        if (pesquisarNome(nome, this.raiz) != null) {
        this.raiz = remover(nome, this.raiz);
        this.quantNos--;
        return true;
        } else {
        return false;
        }
    }
    public NoArv remover(String nome, NoArv arv) {
        if (nome.compareTo(arv.getInfo().getNome()) == -1) {
        arv.setEsq(remover(nome, arv.getEsq()));
        } else {
        if (nome.compareTo(arv.getInfo().getNome())== 1) {
            arv.setDir(remover(nome, arv.getDir()));
        } else {
            if (arv.getDir() == null) {
            return arv.getEsq();
            } else {
            if (arv.getEsq() == null) {
                return arv.getDir();
            } else {
                arv.setEsq(Arrumar(arv, arv.getEsq()));
            }
            }
        }
        }
        return arv;
    }

    private NoArv Arrumar(NoArv arv, NoArv maior) {
        if (maior.getDir() != null) {
        maior.setDir(Arrumar(arv, maior.getDir()));
        } else {
        arv.setInfo(maior.getInfo());
        maior = maior.getEsq();
        }
        return maior;
    }

    



    // caminhamento central
    public Item[] CamCentral() {
        int[] n = new int[1];
        n[0] = 0;
        Item[] vet = new Item[this.quantNos];
        return (FazCamCentral(this.raiz, vet, n));
    }

    private Item[] FazCamCentral(NoArv arv, Item[] vet, int[] n) {
        if (arv != null) {
        vet = FazCamCentral(arv.getEsq(), vet, n);
        vet[n[0]] = arv.getInfo();
        n[0]++;
        vet = FazCamCentral(arv.getDir(), vet, n);
        }
        return vet;
    }

    // caminhamento pré-fixado
    public Item[] CamPreFixado() {
        int[] n = new int[1];
        n[0] = 0;
        Item[] vet = new Item[this.quantNos];
        return (FazCamPreFixado(this.raiz, vet, n));
    }

    private Item[] FazCamPreFixado(NoArv arv, Item[] vet, int[] n) {
        if (arv != null) {
        vet[n[0]] = arv.getInfo();
        n[0]++;
        vet = FazCamPreFixado(arv.getEsq(), vet, n);
        vet = FazCamPreFixado(arv.getDir(), vet, n);
        }
        return vet;
    }

    // caminhamento pós-fixado
    public Item[] CamPosFixado() {
        int[] n = new int[1];
        n[0] = 0;
        Item[] vet = new Item[this.quantNos];
        return (FazCamPosFixado(this.raiz, vet, n));
    }

    private Item[] FazCamPosFixado(NoArv arv, Item[] vet, int[] n) {
        if (arv != null) {
        vet = FazCamPosFixado(arv.getEsq(), vet, n);
        vet = FazCamPosFixado(arv.getDir(), vet, n);
        vet[n[0]] = arv.getInfo();
        n[0]++;
        }
        return vet;
    }







    //listar clientes em ordem alfabetica
    public void ordemAlfabetica() {
        Item [] vet = this.CamCentral();
        for(int i =0; i < vet.length; i++)
        {
            System.out.println("cliente " + i + ": " + vet[i].getNome());
        }

    }


    //talvez esse seja mais eficiente do que o de cima. tem que conversar com o grupo
    public String[] ordemAlfabeticaAA(){
        int[] n = new int[1];
        n[0] = 0;
        String [] clientes = new String[this.quantNos];
        return fazOrdemAlfabeticaAA(this.raiz, clientes, n);


       
    }
    private String [] fazOrdemAlfabeticaAA(NoArv arv, String[] clientes, int [] n){
        if(arv != null){
            clientes = fazOrdemAlfabeticaAA(arv.getEsq(), clientes, n);
            clientes[n[0]] = arv.getInfo().getNome();
            n[0]++;
            clientes = fazOrdemAlfabeticaAA(arv.getDir(), clientes, n);
        }
        return clientes;
    }


    //media de saldos
    public double mediaSaldos(){
        double [] vet = this.vetSaldos();
        double soma = 0.0;
        for(int i =0; i < vet.length; i++){
            soma+= vet[i];
        }
        return soma / this.quantNos;
    }


    private double[] vetSaldos() {
        int[] n = new int[1];
        n[0] = 0;
        double[] saldos = new double[this.quantNos];
        return (fazVetSaldos(this.raiz, saldos, n));
    }

    private double[] fazVetSaldos(NoArv arv, double[] saldos, int[] n) {
        if (arv != null) {
        saldos = fazVetSaldos(arv.getEsq(), saldos, n);
        saldos[n[0]] = arv.getInfo().getSaldo();
        n[0]++;
        saldos = fazVetSaldos(arv.getDir(), saldos, n);
        }
        return saldos;
    }



    public void listarDadosCliente(String nome){
        
    }


}