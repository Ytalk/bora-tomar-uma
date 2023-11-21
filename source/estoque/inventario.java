package estoque_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class inventario{
    private ArrayList <materiaPrima> materias;
    private ArrayList <cervejaArtesanal> cervejas;
    private ArrayList <receita> receitas;
    
    public inventario(){
        this.materias = new ArrayList<materiaPrima>();
        this.cervejas = new ArrayList<cervejaArtesanal>();
        this.receitas = new ArrayList<receita>();
    }

    public void adicionarItem(materiaPrima item){
        materias.add(item);
    }

    public List<materiaPrima> getMaterias() {
        return materias;
    }

    public String[] listarItens() {
        String[] itens = new String[materias.size()];

        for (int i = 0; i < materias.size(); i++) {
            itens[i] = materias.get(i).getDesc(); // Supondo que sua classe materiaPrima tem um método getNome()
        }

        return itens;
    }

    public void adicionarCerveja(cervejaArtesanal cerveja){
        cervejas.add(cerveja);
    }

    public ArrayList<cervejaArtesanal> getCervejas(){
        return cervejas;
    }

    public String listarCervejas(){
        String cervejas = "";
        
        for(cervejaArtesanal cerveja : this.cervejas){
            cervejas = cervejas + cerveja.getNome() + "\n\n" + cerveja.getValor() + "\n" + cerveja.getVolume();
        }
        return cervejas;
    }

    public void addReceita(receita receita){
        receitas.add(receita);
    }
    
    public ArrayList<receita> getReceitas(){
        return receitas;
    }


    public cervejaArtesanal getCerveja(String nome) throws NoSuchElementException{
        for(cervejaArtesanal cerveja: cervejas){
            if(cerveja.getNome() == nome)
                return cerveja;
        }
        throw new NoSuchElementException("cerveja não encontrada com o nome: " + nome);
    }

    public receita getReceita(String nome) throws NoSuchElementException{
        for(receita receita: receitas){
            if(receita.getNome() == nome)
                return receita;
        }
        throw new NoSuchElementException("receita não encontrada com o nome: " + nome);
    }

}
