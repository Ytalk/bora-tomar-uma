package estoque;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import estoque.*;



public class tela extends JFrame{
 Inventario estoque = new Inventario();

 ImageIcon icone_setas = new ImageIcon("./icons/setas.png");
 
 String[] itens = {"ÁGUA","MALTE","LÚPULO","FERMENTO"};//
 
 JList<String> lista_loja = new JList<>(itens);
 JList<String> lista_estoque; 
 JList<String> lista_receita;
 JList<String> lista_cervejas;
 
 JLabel titulo_loja = new JLabel("LOJA");
 JLabel titulo_ingredientes = new JLabel("INGREDIENTES");
 JLabel titulo_cervejas = new JLabel("CERVEJAS");
 JLabel imagem_setas = new JLabel();

 JPanel itemDetalhes = new JPanel();
 
 JButton botao_novaReceita = new JButton("NOVA RECEITA");
 JButton botao_comprar = new JButton("COMPRAR");
 JButton botao_adicionar = new JButton("ADICIONAR");
 JButton botao_criar = new JButton("CRIAR");


    
 public tela (){

        setVisible(true); 
        setSize(800,500);
        setTitle("CERVEJARIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar programa ao clicar no "X"
        setLocationRelativeTo(null); // abrir no centro da tela
        setLayout(null);
        

        JButton botao_inventario = new JButton("INVENTÁRIO");
        botao_inventario.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_inventario.setBounds(100, 200 ,250, 70);
        botao_inventario.setForeground(new Color(237,241,238 ));
        botao_inventario.setBackground(new Color(0,0,0 ));
        


        JButton botao_receitas = new JButton("RECEITAS");
        botao_receitas.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_receitas.setBounds(400, 200 ,250, 70);
        botao_receitas.setForeground(new Color(237,241,238 ));
        botao_receitas.setBackground(new Color(0,0,0 ));
        


        JButton botao_loja = new JButton("LOJA");
        botao_loja.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_loja.setBounds(250, 300 ,250, 70);
        botao_loja.setForeground(new Color(237,241,238 ));
        botao_loja.setBackground(new Color(0,0,0 ));
        
       
       
        botao_loja.addActionListener(this::abrirLoja);
        botao_inventario.addActionListener(this::abrirEstoque);
        botao_receitas.addActionListener(this::abrirReceitas);
        

        JPanel menu_superior = new JPanel();
        menu_superior.setLayout(new GridLayout(1,3));
        menu_superior.setBounds(0,0,400,40);
        add(menu_superior);
        menu_superior.add(botao_inventario);
        menu_superior.add(botao_receitas);
        menu_superior.add(botao_loja);

        lista_receita = new JList<>(estoque.listarCervejas());
        lista_receita.setBounds(400,200,250,100);
        add(lista_receita);
        lista_receita.setVisible(false);
 
 
        // UI ESTOQUE //
        lista_estoque = new JList<>(estoque.listarItens());
        lista_estoque.setBounds(500,150,250,150);        
        lista_estoque.addListSelectionListener(e -> exibirDetalhesItemSelecionado()); // Adicione um ListSelectionListener à JList lista_estoque
        lista_estoque.setVisible(false);
        add(lista_estoque);

        lista_cervejas = new JList<>(estoque.listarCervejas());
        lista_cervejas.setBounds(50,150,250,150);
        lista_cervejas.setVisible(false);
        add(lista_cervejas);

        titulo_cervejas.setBounds(120,100,120,50);
        titulo_cervejas.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        titulo_ingredientes.setBounds(560,100,120,50);
        titulo_ingredientes.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        add(titulo_ingredientes);
        add(titulo_cervejas);
        titulo_ingredientes.setVisible(false);
        titulo_cervejas.setVisible(false);
        
        // Crie um JPanel para exibir os detalhes dos produtos do estoque
    
        itemDetalhes.setLayout(new GridLayout(3, 2));
        itemDetalhes.setBounds(150, 200, 250, 100);
        itemDetalhes.setVisible(false);
        add(itemDetalhes);
       
        // UI ESTOQUE //
        
       // UI DA LOJA //  

       lista_loja.setBounds(400,200,250,100);
       lista_loja.setVisible(false);
       add(lista_loja);
       
       
       titulo_loja.setBounds(500,80,90,50);
       titulo_loja.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       titulo_loja.setVisible(false);
       add(titulo_loja);
       

       botao_comprar.setBounds(650,200,120,50);
       botao_comprar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       botao_comprar.setVisible(false);
       botao_comprar.addActionListener(e -> comprarItem());
       add(botao_comprar);
       
       // UI DA LOJA // 

       // UI DA RECEITA //
 
       lista_receita.setBounds(50,150,250,150);

       botao_criar.setBounds(30,400,120,50);
       botao_criar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       botao_criar.setVisible(false);
       add(botao_criar);

       botao_novaReceita.setBounds(150,400,160,50);
       botao_novaReceita.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       botao_novaReceita.addActionListener(this::menuNovaReceita);
       botao_novaReceita.setVisible(false);
       add(botao_novaReceita);

       imagem_setas.setIcon(icone_setas);
       imagem_setas.setBounds(390,200,30,30);
       imagem_setas.setVisible(false);
       add(imagem_setas);

    }
    
    public void abrirLoja(ActionEvent e){
     
     //remover elementos de outra tela     
     lista_estoque.setVisible(false);
     titulo_ingredientes.setVisible(false);
     titulo_cervejas.setVisible(false);
     itemDetalhes.setVisible(false);
     lista_receita.setVisible(false);
     lista_cervejas.setVisible(false);
      botao_criar.setVisible(false);
      imagem_setas.setVisible(false);

     //exibir elementos da loja
     lista_loja.setVisible(true);
     titulo_loja.setVisible(true);
     botao_comprar.setVisible(true);
     
     
    }

     public void abrirEstoque(ActionEvent e){
        //remover elementos de outra tela
        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        botao_comprar.setVisible(false);
        lista_receita.setVisible(false);
        botao_criar.setVisible(false);
        imagem_setas.setVisible(false);

        //exibir elementos do estoque
        
        lista_cervejas.setVisible(true);
        lista_estoque.setVisible(true);
        titulo_ingredientes.setVisible(true);
        titulo_cervejas.setVisible(true);
        lista_estoque.setListData(estoque.listarItens());
    }

    public void abrirReceitas(ActionEvent e){
        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        titulo_cervejas.setVisible(false);
        botao_comprar.setVisible(false);
        titulo_ingredientes.setVisible(false);
        lista_cervejas.setVisible(false);

        imagem_setas.setVisible(true);
        lista_estoque.addListSelectionListener(a -> ProduzirCerveja());
        lista_receita.setVisible(true);
        botao_criar.setVisible(true);
        itemDetalhes.setBounds(550, 310, 250, 100);
        lista_estoque.setVisible(true);
        lista_estoque.setListData(estoque.listarItens());
        titulo_ingredientes.setVisible(true);
        botao_novaReceita.setVisible(true);
        

    }

    public void menuNovaReceita(ActionEvent e){

        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        titulo_cervejas.setVisible(false);
        botao_comprar.setVisible(false);
        titulo_ingredientes.setVisible(false);
        lista_cervejas.setVisible(false);

        lista_estoque.addListSelectionListener(a -> ProduzirCerveja());
        lista_receita.setVisible(true);
        botao_criar.setVisible(true);
        itemDetalhes.setBounds(550, 310, 250, 100);
        lista_estoque.setVisible(true);
        lista_estoque.setListData(estoque.listarItens());
        titulo_ingredientes.setVisible(true);

        botao_novaReceita.setVisible(false);
        

    }

     private void comprarItem() {
     int indexSelecionado = lista_loja.getSelectedIndex();

            if (indexSelecionado != -1) {
            String itemSelecionado = itens[indexSelecionado];

            MateriaPrima materiaPrima = criarMateriaPrima(itemSelecionado);

            estoque.adicionarItem(materiaPrima);

            // Mensagem de produto comprado
            JOptionPane.showMessageDialog(this, "Você comprou: " + itemSelecionado);
        } else {
            // Caso nenhum item esteja selecionado
            JOptionPane.showMessageDialog(this, "Selecione um item antes de comprar");
        }  
     }

     private void ProduzirCerveja(){
        int indexSelecionado = lista_estoque.getSelectedIndex();

        if(indexSelecionado != -1 ){
            String itemSelecionado = lista_estoque.getModel().getElementAt(indexSelecionado);
                
            JOptionPane.showMessageDialog(this, "Você adicionou à receita: " + itemSelecionado);
        }

     }

     private void criarCerveja(){
     
     }

 

    private MateriaPrima criarMateriaPrima(String tipo) {
    // Lógica para criar e retornar uma instância da classe MateriaPrima desejada
    
     switch (tipo) {
        case "ÁGUA":
            return new Agua(100,10,"Água");
        case "MALTE":
            return new Malte(200,20,"Malte");
        case "LÚPULO":
            return new Lupulo(300,15,"Lupulo");
        // Adicione outros casos conforme necessário
        case "FERMENTO":
        return new Fermento(400, 25, "Fermento");
        
        default:
            throw new IllegalArgumentException("Tipo de matéria-prima desconhecido: " + tipo);
      }   
    }

    // Método para exibir os detalhes do item selecionado
    private void exibirDetalhesItemSelecionado() {
    int indexSelecionado = lista_estoque.getSelectedIndex();
    itemDetalhes.setVisible(true);
    //evitar duplição
    itemDetalhes.removeAll();

    if (indexSelecionado != -1) {
        MateriaPrima itemSelecionado = estoque.getMaterias().get(indexSelecionado);
 

        // Adicione rótulos e valores ao JPanel
        itemDetalhes.add(new JLabel("NOME:"));
        itemDetalhes.add(new JLabel(itemSelecionado.getDesc()));

        itemDetalhes.add(new JLabel("QUANTIDADE:"));
        itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getPeso())));

        itemDetalhes.add(new JLabel("PREÇO:"));
        itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getCusto())));
        
       //atualizar tela
       repaint();
       revalidate();
    }
    
}


}

        
    
    
    


