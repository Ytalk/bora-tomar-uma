package estoque;

import java.util.ArrayList;
import java.util.List;

public abstract class cervejaArtesanal {
private int volume; // quantidade de cerveja produziada
private ArrayList <materiaPrima> materiasUtilizadas;
private double custoTotal;

 public cervejaArtesanal(){
 this.materiasUtilizadas = new ArrayList<>();
 }

    public void adicionarMateriaPrima(materiaPrima item){
    materiasUtilizadas.add(item);
    }

    public List<materiaPrima> getMateriasUtilizadas() {
    return materiasUtilizadas;
    }


    public double calcularCustoTotal() {
     custoTotal = 0;

    for (materiaPrima materia : materiasUtilizadas) {
        custoTotal += materia.getCusto();
    }

    return custoTotal;
    }

}
