public class Dados {

    private int total = 0;
    private int promotores = 0;
    private int detratores = 0;
    private double porcentagemPromotores = 0.0;
    private double porcentagemDetratores = 0.0;
    private double npsFinal = 0.0;

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int valor){
        this.total += valor;
    }

    public int getPromotores(){
        return this.promotores;
    }

    public void setPromotores(int valor){
        this.promotores += valor;
    }

    public int getDetratores(){
        return this.detratores;
    }

    public void setDetratores(int valor){
        this.detratores += valor;
    }

    public double getPorcentagemPromotores(){
        return porcentagemPromotores;
    }

    public void setPorcentagemPromotores(double valor){
        this.porcentagemPromotores = valor;
    }

    public double getPorcentagemDetratores(){
        return porcentagemDetratores;
    }

    public void setPorcentagemDetratores(double valor){
        this.porcentagemDetratores = valor;
    }

    public double getNpsFinal(){
        return npsFinal;
    }

    public void setNpsFinal(double valor){
        this.npsFinal = valor;
    }
}
