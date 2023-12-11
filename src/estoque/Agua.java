package estoque;

public class Agua extends MateriaPrima{

    String descrição;
    Double peso;

    public Agua(double peso, double custo){
        super(peso, custo);
        descrição = "Água";
        
    }

    @Override
    public String getDesc() {
        return descrição;
    }

}
    