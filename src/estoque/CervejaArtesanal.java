package estoque;

import java.util.ArrayList;


public class CervejaArtesanal{
    private String nome;
    private double volume; // quantidade de cerveja produziada
    private double valor;
    private ArrayList<MateriaPrima> rótulo;

    public CervejaArtesanal(Receita receita){
        this.nome = receita.getNome();
        this.valor = receita.getCusto() + (receita.getCusto() * 0.25);//margem de lucro de 25%
        this.volume = receita.getPeso();//forma grosseira de calcular

        this.rótulo = new ArrayList<MateriaPrima>();
        this.rótulo = receita.getConteudo();
    }

    public String getNome(){
        return nome;
    }

    public double getVolume(){
        return volume;
    }

    public double getValor(){
        return valor;
    }

    public String[] listarRótulo(){
 
        String [] itens= new String[rótulo.size()];
      
        for(int i = 0 ; i < rótulo.size(); i++){
            itens[i] = rótulo.get(i).toString();
        }
        return itens;
    }

    public ArrayList<MateriaPrima> getRótulo(){
        return rótulo;
    }

    @Override
    public String toString() {
        
        return getNome() + " " + getValor();
    }
}
