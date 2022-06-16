

public class NoArv {
    private Item info;
    private NoArv esq, dir;


    //construtor
    public NoArv(Item elem) {
        this.info = elem;
        this.esq = null;
        this.dir = null;
    }



    //gets
    public NoArv getEsq()           {return this.esq;}
    public NoArv getDir()           {return this.dir;}
    public Item getInfo()           {return this.info;}


    //sets
    public void setEsq(NoArv no)    {this.esq = no;}
    public void setDir(NoArv no)    {this.dir = no;}
    public void setInfo(Item elem)  {this.info = elem;}
    
    }

    