package estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Inventario{
    private ArrayList <MateriaPrima> materias;
    private ArrayList <CervejaArtesanal> cervejas;
    private ArrayList <Receita> receitas;
    
    public Inventario(){
        this.materias = new ArrayList<MateriaPrima>();
        this.cervejas = new ArrayList<CervejaArtesanal>();
        this.receitas = new ArrayList<Receita>();
    }

    public void adicionarItem(MateriaPrima item){
        boolean existente = false;
        for(MateriaPrima itens : materias){
            if(item.getDesc().equals(itens.getDesc())){
                itens.setPeso(itens.getPeso() + item.getPeso());
                existente = true;
            }
        }
        if(existente == false){
            materias.add(item);
        }
    }

    public List<MateriaPrima> getMaterias() {
        return materias;
    }

    public String[] listarItens() {
        String[] itens = new String[materias.size()];

        for (int i = 0; i < materias.size(); i++) {
            itens[i] = materias.get(i).getDesc(); // Supondo que sua classe materiaPrima tem um método getNome()
        }

        return itens;
    }

    public void adicionarCerveja(CervejaArtesanal cerveja){
        ArrayList<MateriaPrima> label = cerveja.getRótulo();

        for(MateriaPrima item: materias){
            for(MateriaPrima rótulo: label){
                if ((item.getPeso() > rótulo.getPeso()) && (item.getDesc().equals(rótulo.getDesc()))){
                    item.setPeso(item.getPeso() - rótulo.getPeso());
                    cervejas.add(cerveja);
                }
            }
        }
    }



    public ArrayList<CervejaArtesanal> getCervejas(){
        return cervejas;
    }

    public String[] listarCervejas(){
       String[] itens = new String[cervejas.size()];
       for (int i = 0; i < materias.size(); i++) {
            itens[i] = cervejas.get(i).getNome(); // Supondo que sua classe materiaPrima tem um método getNome()
        }

        return itens;
    }

    public void addReceita(Receita receita){
        receitas.add(receita);
    }
    
    public ArrayList<Receita> getReceitas(){
        return receitas;
    }

    public void deletarReceita(String nome){
        Iterator<Receita> iterator = receitas.iterator();
    
        while(iterator.hasNext()){
            Receita receita = iterator.next();
            if(receita.getNome().equals(nome)){
                iterator.remove();
                System.out.println("Receita removida do estoque: " + receita.getNome()); 
            }
        }
    }

    public CervejaArtesanal getCerveja(String nome) throws NoSuchElementException{
        for(CervejaArtesanal cerveja: cervejas){
            if(cerveja.getNome() == nome)
                return cerveja;
        }
        throw new NoSuchElementException("cerveja não encontrada com o nome: " + nome);
    }

    public void deletarCerveja(String nome){
        Iterator<CervejaArtesanal> iterator = cervejas.iterator();
    
        while(iterator.hasNext()){
            CervejaArtesanal cerveja = iterator.next();
            if (cerveja.getNome().equals(nome)){
                iterator.remove();
                System.out.println("Cerveja removida do estoque: " + cerveja.getNome());
            }
        }
    }

    public Receita getReceita(String nome) throws NoSuchElementException{
        for(Receita receita: receitas){
            if(receita.getNome() == nome)
                return receita;
        }
        throw new NoSuchElementException("receita não encontrada com o nome: " + nome);
    }

}

