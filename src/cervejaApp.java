package src;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;

import estoque.*;

public class cervejaApp extends JFrame {

    Inventario estoque = new Inventario();
    

    ImageIcon icone_setas = new ImageIcon("./icons/setas.png");

    String[] itens = { "ÁGUA", "MALTE", "LÚPULO", "FERMENTO" };

    JTextArea textoQntd_loja = new JTextArea();

    JList<String> lista_loja = new JList<>(itens);
    JList<String> lista_estoque;
    JList<String> lista_cervejas;
    JList<String> lista_estoque_receita = new JList<>(estoque.listarItens());
    

    CardLayout layout = new CardLayout(10, 10);
    JPanel tela = new JPanel(layout);

    JPanel itemDetalhes = new JPanel();
    JPanel telaLoja = new JPanel();
    JPanel telaEstoque = new JPanel();
    JPanel telaReceita = new JPanel();
    JPanel telaCerveja = new JPanel();
    Border bordaPreta = new LineBorder(Color.BLACK, 1);

    public cervejaApp() {
        configurarJanela();
    }

    private void configurarJanela() {
        setVisible(true);
        setSize(800, 500);
        setTitle("CERVEJARIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JButton botaoInventario = new JButton("INVENTÁRIO");
        JButton botaonovaReceita = new JButton("NOVA RECEITA");
        JButton botaonovaCerveja = new JButton("NOVA CERVEJA");
        JButton botaoLoja = new JButton("LOJA");

        JComboBox<String> combo = new JComboBox<>(new String[] { "Loja", "Estoque", "Receita","Cerveja" });
        combo.addActionListener(e -> layout.show(tela, (String) combo.getSelectedItem()));

        JPanel menuSuperior = new JPanel();
        menuSuperior.setLayout(new GridLayout(1, 4));
        menuSuperior.setBounds(0, 0, 400, 40);
        menuSuperior.add(botaoInventario);
        menuSuperior.add(botaonovaReceita);
        menuSuperior.add(botaonovaCerveja);
        menuSuperior.add(botaoLoja);
       
        configurarBotao(botaoLoja, this::abrirLoja);
        configurarBotao(botaoInventario, this::abrirEstoque);
        configurarBotao(botaonovaReceita, this::abrirnovaReceita);
        configurarBotao(botaonovaCerveja, this::abrirCerveja);

        // UI LOJA // 

        telaLoja.setLayout(null);
        JLabel itemLoja = new JLabel("NOME");
        itemLoja.setBounds(5, 10, 90, 50);
        telaLoja.add(itemLoja);

        

        lista_loja.setFont(new Font("Arial", Font.BOLD, 14));
        lista_loja.setBorder(bordaPreta);
        lista_loja.setBounds(0, 50, 600, 250);
        telaLoja.add(lista_loja);

        textoQntd_loja.setBounds(400, 300, 200, 20);
        textoQntd_loja.setBorder(bordaPreta);
        telaLoja.add(textoQntd_loja);

        JButton botaoComprar = new JButton("COMPRAR");
        botaoComprar.setBounds(600, 250, 120, 50);
        botaoComprar.addActionListener(e -> comprarItem());
        telaLoja.add(botaoComprar);


        // UI LOJA // 

        // UI ESTOQUE //

        telaEstoque.setLayout(null);
        lista_estoque = new JList<>(estoque.listarItens());
        lista_estoque.setBounds(500, 150, 250, 150);
        lista_estoque.addListSelectionListener(e -> exibirDetalhesItemSelecionado());
        telaEstoque.add(lista_estoque);

        itemDetalhes.setLayout(new GridLayout(3, 2));
        itemDetalhes.setBounds(300, 300, 250, 100);
        telaEstoque.add(itemDetalhes);

        lista_cervejas = new JList<>(estoque.listarCervejas());
        lista_cervejas.setBounds(50, 150, 250, 150);
        telaEstoque.add(lista_cervejas);

        JLabel titulo_cervejas = new JLabel("CERVEJAS");
        titulo_cervejas.setBounds(120, 100, 120, 50);
        titulo_cervejas.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        telaEstoque.add(titulo_cervejas);

        // UI ESTOQUE //

        // UI NOVA RECEITA //

        telaReceita.setLayout(null);
    
        JLabel textReceita = new JLabel("RECEITA");
        textReceita.setBounds(100, 100, 100, 100);
        telaReceita.add(textReceita);
       
        
        lista_estoque_receita.setBounds(500,150,200,200);
        telaReceita.add(lista_estoque_receita);



     
        
    

        // UI NOVA RECEITA //


        //UI CERVEJA // 

        telaCerveja.setLayout(null);
        JLabel textCerveja = new JLabel("CERVEJA");
        textCerveja.setBounds(100, 100, 100, 100);
        telaCerveja.add(textCerveja);

        //UI CERVEJA // 
        
        tela.add("Loja", telaLoja);
        tela.add("Estoque", telaEstoque);
        tela.add("Receita", telaReceita);
        tela.add("Cerveja",textCerveja);

        add(menuSuperior, BorderLayout.NORTH);
        add(combo);
        add(tela);
    }

    private void configurarBotao(JButton botao, ActionListener listener) {
        botao.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        botao.setForeground(new Color(237, 241, 238));
        botao.setBackground(new Color(0, 0, 0));
        botao.addActionListener(listener);
    }

    private void abrirLoja(ActionEvent e) {
        layout.show(tela, "Loja");
        repaint();
        revalidate();
    }

    private void abrirEstoque(ActionEvent e) {
        layout.show(tela, "Estoque");
        repaint();
        revalidate();
    }

    private void abrirnovaReceita(ActionEvent e) {

        layout.show(tela, "Receita");
        repaint();
        revalidate();
    }

    private void abrirCerveja(ActionEvent e){
        layout.show(tela,"Cerveja");
        repaint();
        revalidate();
    }

    private void comprarItem() {
        int indexSelecionado = lista_loja.getSelectedIndex();


        if (indexSelecionado != -1) {
            String itemSelecionado = itens[indexSelecionado];
            String quantidadeText = textoQntd_loja.getText().trim();
    
            if (!quantidadeText.isEmpty()) { // Verifica se a string não está vazia
                int qtd = Integer.parseInt(quantidadeText);
                MateriaPrima materiaPrima = criarMateriaPrima(itemSelecionado, qtd);
                estoque.adicionarItem(materiaPrima);
                lista_estoque.setListData(estoque.listarItens());
                lista_estoque_receita.setListData(estoque.listarItens());
                
                JOptionPane.showMessageDialog(this, "Você comprou: " + itemSelecionado);
            } else {
                JOptionPane.showMessageDialog(this, "Informe a quantidade antes de comprar");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item antes de comprar");
        }
    }

    private Receita novaReceita(String nome){
        
        throw new UnsupportedOperationException("Unimplemented method 'listAll'"); 
   
    }

    private MateriaPrima criarMateriaPrima(String tipo, int qtd) {
        switch (tipo) {
            case "ÁGUA":
                return new Agua(qtd, 10, "Água");
            case "MALTE":
                return new Malte(qtd, 20, "Malte");
            case "LÚPULO":
                return new Lupulo(qtd, 15, "Lúpulo");
            case "FERMENTO":
                return new Fermento(qtd, 25, "Fermento");
            default:
                throw new IllegalArgumentException("Tipo de matéria-prima desconhecido: " + tipo);
        }
    }

    private void exibirDetalhesItemSelecionado() {
        int indexSelecionado = lista_estoque.getSelectedIndex();
        itemDetalhes.setVisible(true);
        itemDetalhes.removeAll();

        if (indexSelecionado != -1) {
            MateriaPrima itemSelecionado = estoque.getMaterias().get(indexSelecionado);

            itemDetalhes.add(new JLabel("NOME:"));
            itemDetalhes.add(new JLabel(itemSelecionado.getDesc()));

            itemDetalhes.add(new JLabel("QUANTIDADE:"));
            itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getPeso())));

            itemDetalhes.add(new JLabel("PREÇO:"));
            itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getCusto())));

            repaint();
            revalidate();
        }
    }

    public static void main(String[] args) {
        new cervejaApp();
    }
}
