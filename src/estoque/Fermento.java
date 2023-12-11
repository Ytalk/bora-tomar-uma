package estoque;

public class Fermento extends MateriaPrima {

    String descrição;
    Double peso;

    public Fermento(double peso, double custo) {
        super(peso, custo);
        descrição = "Fermento";
        
    }
    
    public void addAdicional(String adicional){
        descrição = descrição + " com " + adicional;
    }
    
    public String getDesc() {
        return descrição;
    }
}