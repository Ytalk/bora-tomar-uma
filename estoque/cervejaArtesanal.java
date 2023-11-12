package estoque;

import java.util.ArrayList;

public abstract class cervejaArtesanal {
private int volume; // quantidade de cerveja produziada
private ArrayList <materiaPrima> receita;

 

public void criarCerveja(materiaPrima item){

receita.add(item);

}

}
