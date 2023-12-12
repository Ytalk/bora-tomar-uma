package app;

import estoque.MateriaPrima;
import estoque.Agua;
import estoque.Malte;
import estoque.Lupulo;
import estoque.Fermento;
import estoque.Inventario;
import estoque.Receita;
import estoque.CervejaArtesanal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;


public class cervejaApp extends JFrame {

    Inventario estoque = new Inventario();
    

    ImageIcon icone_setas = new ImageIcon("./resource/icons/cerveja.png");

    String[] itens = { "ÁGUA", "MALTE", "LÚPULO", "FERMENTO" };
    String[] itensCusto = { "10.00", "20.00", "15.00", "25.00" };

    JTextArea textoQntd_loja = new JTextArea();

    JList<String> lista_loja = new JList<>(itens);
    JList<String> lista_estoque;
    JList<String> descReceita;
    JList<String> descCerveja;
    
    JList<Receita> lista_receita;
    JList<MateriaPrima> lista_ingredientes;
    JList<CervejaArtesanal> lista_cervejas;

    JList<String> lista_estoque_receita = new JList<>(estoque.listarItens());
    JList<String> lista_estoque_cerveja = new JList<>(estoque.listarItens());
    
    DefaultListModel<CervejaArtesanal> cervejas = new DefaultListModel<>();
    DefaultListModel<MateriaPrima> materia = new DefaultListModel<>();
    DefaultListModel<Receita> receitas = new DefaultListModel<>();

    
    JCheckBox addAdicional = new JCheckBox("ADICIONAL");

    CardLayout layout = new CardLayout(10, 10);
    JPanel tela = new JPanel(layout);
    
    
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
        setTitle("PAMPA'S BEER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    //bloco responsável pela UI LOJA, atualiza o preço total e inicializa duas areas.
    JTextArea textoPreçoTotal_loja = new JTextArea();
    JTextArea textoPreço_loja = new JTextArea();
    private void updatePreçoTotal(){

        String inputPeso = textoQntd_loja.getText().trim();

        try{
        double pesoInformado = Double.parseDouble(inputPeso);
        int itemSelecionado = lista_loja.getSelectedIndex();

            if(itemSelecionado >= 0 && pesoInformado > 0){
                double preço = Double.parseDouble(itensCusto[itemSelecionado]); 

                double resultado = pesoInformado * (preço / 1000);

                DecimalFormat df = new DecimalFormat("#.##");
                String resultadoFormatado = df.format(resultado);

                textoPreçoTotal_loja.setText(resultadoFormatado);
            }
        }
        catch (RuntimeException ex){
            textoPreçoTotal_loja.setText("");//valor inválido limpa o campo
        }
    
    }

    private void inicializarComponentes() {
        JButton botaoInventario = new JButton("INVENTÁRIO");
        JButton botaonovaReceita = new JButton("RECEITA");
        JButton botaonovaCerveja = new JButton("CERVEJA");
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

        //seleciona, informa peso e compra
        JLabel itemLoja = new JLabel("NOME");
        itemLoja.setBounds(70, 10, 90, 50);
        telaLoja.add(itemLoja);

        lista_loja.setFont(new Font("Arial", Font.BOLD, 14));
        lista_loja.setBorder(bordaPreta);
        lista_loja.setBounds(0, 50, 180, 250);
        telaLoja.add(lista_loja);

        textoQntd_loja.setBounds(0, 310, 180, 20);//campo para informar peso
        textoQntd_loja.setBorder(bordaPreta);
        telaLoja.add(textoQntd_loja);

        JButton botaoComprar = new JButton("COMPRAR");
        botaoComprar.setBounds(380, 140, 96, 40);
        botaoComprar.addActionListener(e -> {
            try{
                comprarItem();
            } 
            catch(InvalidItemException ex){
                ex.showMessage();
            }
        });
        telaLoja.add(botaoComprar);

        addAdicional.setBounds(483,140,90,40);


        //area dos valores
        JLabel labelPreço = new JLabel("PREÇO (kg)");
        labelPreço.setBounds(250, 10, 90, 50);
        telaLoja.add(labelPreço);

        StringBuilder valores = new StringBuilder();
        for (String item : itensCusto){
            valores.append(item).append(" $\n");
        }

        textoPreço_loja.setEditable(false);
        textoPreço_loja.setBounds(190, 50, 180, 250);
        textoPreço_loja.setBorder(bordaPreta);
        textoPreço_loja.setText(valores.toString());
        textoPreço_loja.setFont(new Font("Arial", Font.BOLD, 14));
        telaLoja.add(textoPreço_loja);

        JLabel labelPeso = new JLabel("INFORMAR PESO (g)");
        labelPeso.setBounds(190, 310, 180, 20);
        labelPeso.setHorizontalAlignment(SwingConstants.CENTER);
        labelPeso.setVerticalAlignment(SwingConstants.CENTER);
        telaLoja.add(labelPeso);


        //area total
        JLabel labelPreçoTotal = new JLabel("PREÇO TOTAL");
        labelPreçoTotal.setBounds(430, 10, 90, 50);
        telaLoja.add(labelPreçoTotal);

        textoPreçoTotal_loja.setEditable(false);
        textoPreçoTotal_loja.setBounds(380, 50, 180, 80);
        textoPreçoTotal_loja.setBorder(bordaPreta);
        textoPreçoTotal_loja.setFont(new Font("Arial", Font.BOLD, 14));
        telaLoja.add(textoPreçoTotal_loja);
        

        textoQntd_loja.getDocument().addDocumentListener(new DocumentListener(){//atualiza preço total

            @Override
            public void insertUpdate(DocumentEvent e){
                updatePreçoTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e){
                updatePreçoTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e){
                updatePreçoTotal();
            }
        });

        telaLoja.add(addAdicional);

        // UI LOJA // 

       // UI ESTOQUE //

       telaEstoque.setLayout(null);
        
       lista_estoque = new JList<>(estoque.listarItens());
       lista_estoque.setBounds(250, 30, 500, 250);
       lista_estoque.setBorder(bordaPreta);
    
       descCerveja = new JList<>();
       descCerveja.setBorder(bordaPreta);
       descCerveja.setBounds(250,310,500,100);
       
       lista_cervejas = new JList<>();
       lista_cervejas.setBounds(0, 30, 250, 380);
       lista_cervejas.addListSelectionListener(e -> exibirDetalhes_cerveja());
       lista_cervejas.setBorder(bordaPreta);
       lista_cervejas.setModel(cervejas);
      
       JLabel titulo_cervejas = new JLabel("CERVEJAS");
       titulo_cervejas.setBounds(70, 0, 120, 40);
       titulo_cervejas.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
       

       telaEstoque.add(titulo_cervejas,BorderLayout.CENTER);
       telaEstoque.add(descCerveja);
       telaEstoque.add(lista_cervejas,BorderLayout.EAST);
       telaEstoque.add(lista_estoque);

       // UI ESTOQUE //

        // UI NOVA RECEITA //

        telaReceita.setLayout(null);
    
        JLabel textReceita = new JLabel("INGREDIENTES");
        textReceita.setFont(new Font("Arial", Font.BOLD, 14));
        textReceita.setBounds(25, 25, 150, 25);

        JLabel textReceita2 = new JLabel("ESTOQUE");
        textReceita2.setFont(new Font("Arial", Font.BOLD, 14));
        textReceita2.setBounds(550, 25, 150, 25);
        
        JButton criar_receita = new JButton("CRIAR");
        criar_receita.setFont(new Font("Arial", Font.BOLD, 14));
        criar_receita.setBounds(100,350,80,40);
        criar_receita.addActionListener(e -> criarReceita());
       
        lista_ingredientes = new JList<>();
        lista_ingredientes.setFont(new Font("Arial", Font.BOLD, 14));
        lista_ingredientes.setBorder(bordaPreta);
        lista_ingredientes.setBounds(0,50,200,300);
        lista_ingredientes.setModel(materia);
        lista_ingredientes.addListSelectionListener(e -> tirarIngrediente());

        lista_estoque_receita.setBounds(500,50,200,300);
        lista_estoque_receita.setBorder(bordaPreta);
        lista_estoque_receita.addListSelectionListener(e -> {
            try{
                adicionarItemReceita();
            }   
            catch(InvalidItemException ex){
                ex.showMessage();
            }
        });
        lista_estoque_receita.setBounds(500,50,200,300);
        lista_estoque_receita.setBorder(bordaPreta);
       
         
        telaReceita.add(textReceita);
        telaReceita.add(textReceita2);
        telaReceita.add(lista_ingredientes);
        telaReceita.add(lista_estoque_receita);
        telaReceita.add(criar_receita);
    
        // UI NOVA RECEITA //

        //UI CERVEJA // 

        telaCerveja.setLayout(null);
        JLabel textCerveja = new JLabel("RECEITAS");
        textCerveja.setFont(new Font("Arial", Font.BOLD, 14));
        textCerveja.setBounds(50, 15, 100, 50);

        JLabel textCerveja2 = new JLabel("ESTOQUE");
        textCerveja2.setFont(new Font("Arial", Font.BOLD, 14));
        textCerveja2.setBounds(560,15,150,50);
        
        lista_receita = new JList<>();
        lista_receita.setFont(new Font("Arial", Font.BOLD, 14));
        lista_receita.setBorder(bordaPreta);
        lista_receita.setBounds(0,50,200,250);
        lista_receita.addListSelectionListener(e -> exibirDetalhes_receita());
        lista_receita.setModel(receitas);
        

        JButton criar_cerveja = new JButton("CRIAR");
        criar_cerveja.setFont(new Font("Arial", Font.BOLD, 14));
        criar_cerveja.setBounds(200,260,80,40);
        criar_cerveja.addActionListener(e -> criarCerveja());

        JButton apagar_receita  = new JButton("APAGAR");
        apagar_receita.setFont(new Font("Arial", Font.BOLD, 14));
        apagar_receita.setBounds(285,260,100,40);
        apagar_receita.addActionListener(e -> apagarReceita());

        descReceita = new JList<>();
        descReceita.setBorder(bordaPreta);
        descReceita.setBounds(0,310,500,100);
       

        lista_estoque_cerveja.setBounds(500,50,200,250);
        lista_estoque_cerveja.setBorder(bordaPreta);
        
        telaCerveja.add(textCerveja);
        telaCerveja.add(textCerveja2);
        telaCerveja.add(lista_receita);
        telaCerveja.add(criar_cerveja);
        telaCerveja.add(apagar_receita);
        telaCerveja.add(descReceita);
        telaCerveja.add(lista_estoque_cerveja);
      
        //UI CERVEJA // 
        
        tela.add("Loja", telaLoja);
        tela.add("Estoque", telaEstoque);
        tela.add("Receita", telaReceita);
        tela.add("Cerveja",telaCerveja);

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

    private void adicionarItemReceita() throws InvalidItemException{
         
        int indexSelecionado = lista_estoque_receita.getSelectedIndex();
    
       
           if(indexSelecionado != -1){

          
            String  tratamento = JOptionPane.showInputDialog("Informe a quantidade em g do item");

            if(tratamento.isEmpty()){
                throw new InvalidItemException("A quantidade não foi informada!", "PESO NÃO INFORMADO");
            } 
            else if(!tratamento.matches("-?\\d+")){
                throw new InvalidItemException("A quantidade não deve conter letras!", "O PESO NÃO DEVE CONTER LETRAS");
            } 
            else if(Double.parseDouble(tratamento) <= 0){
                throw new InvalidItemException("A quantidade deve ser maior que zero!", "O PESO DEVE SER POSITIVO");
            } 
            else{
               
               // ArrayList<MateriaPrima> itens = new ArrayList<>(estoque.getMaterias());
                
                double qtd = Double.parseDouble(tratamento);
                MateriaPrima ingrediente = estoque.getMaterias().get(indexSelecionado);
                ingrediente.setPeso(qtd);
             
                
                // Verifica se o item já está presente na lista de ingredientes
                for(int i = 0; i < lista_ingredientes.getModel().getSize(); i++){
                    MateriaPrima itemLista = materia.getElementAt(i);
        
                    if(ingrediente.equals(itemLista)){
                        return;
                    }
                }

                materia.addElement(ingrediente);
            }

         }
    
    }

    private void criarReceita() {

        if (lista_ingredientes.getModel().getSize() > 0) {
            String nomeReceita = JOptionPane.showInputDialog("Informe o nome da receita:");
            Receita receita = new Receita(nomeReceita);
          
            for (int i = 0; i < lista_ingredientes.getModel().getSize(); i++) {
                MateriaPrima ingrediente = materia.getElementAt(i);
                receita.addIngrediente(ingrediente);
            }
            JOptionPane.showMessageDialog(this, "RECEITA CRIADA!");
            estoque.adicionarReceita(receita);
            receitas.addElement(receita);
            
            materia.clear();
        } 
        else{
            JOptionPane.showMessageDialog(this, "A lista de receita está vazia.", "receita vazia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void criarCerveja() {
        
        if (lista_receita.getSelectedIndex() != -1) {
            Receita receita = receitas.getElementAt(lista_receita.getSelectedIndex());
            try{
                CervejaArtesanal cerveja = new CervejaArtesanal(receita);
            
             //    for(MateriaPrima materia : estoque.getMaterias()){
               //     estoque.diminuirMateria(materia, materia.getPeso());
                //}

                cervejas.addElement(cerveja);

                JOptionPane.showMessageDialog(this, "CRIADO!.");
            }
            catch(InvalidItemException ex){
                ex.showMessage();
            }
        } 
        else{
            JOptionPane.showMessageDialog(this, "Selecione uma receita antes de criar a cerveja.", "receita não informada", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void comprarItem() throws InvalidItemException {
        int indexSelecionado = lista_loja.getSelectedIndex();
    
        if (indexSelecionado != -1) {
            String itemSelecionado = itens[indexSelecionado];
            String quantidadeText = textoQntd_loja.getText().trim();
    
            if(quantidadeText.isEmpty()){
                throw new InvalidItemException("A quantidade não foi informada!", "PESO NÃO INFORMADO");
            } 
            else if(!quantidadeText.matches("-?\\d+")){
                throw new InvalidItemException("A quantidade não deve conter letras!", "O PESO NÃO DEVE CONTER LETRAS");
            } 
            else if(Integer.parseInt(quantidadeText) <= 0){
                throw new InvalidItemException("A quantidade deve ser maior que zero!", "O PESO DEVE SER POSITIVO");
            } 
            else{
                int qtd = Integer.parseInt(quantidadeText);
                MateriaPrima materiaPrima = criarMateriaPrima(itemSelecionado, qtd);
    
                if (addAdicional.isSelected()){
                    String adicional = JOptionPane.showInputDialog("Informe o adicional:");
                    materiaPrima.addAdicional(adicional);
                }
    
                estoque.adicionarItem(materiaPrima);
                lista_estoque.setListData(estoque.listarItens());
                lista_estoque_receita.setListData(estoque.listarItens());
                lista_estoque_cerveja.setListData(estoque.listarItens());
    
                JOptionPane.showMessageDialog(this, "Você comprou: " + itemSelecionado);
            }
        } 
        else{
            throw new InvalidItemException("O item desejado deve ser selecionado antes de comprar!", "ITEM NÃO INFORMADO");
        }
    }

    private MateriaPrima criarMateriaPrima(String tipo, double qtd){


        switch (tipo) {
            case "ÁGUA":
                return new Agua(qtd, 10);
            case "MALTE":
                return new Malte(qtd, 20);
            case "LÚPULO":
                return new Lupulo(qtd, 15);
            case "FERMENTO":
                return new Fermento(qtd, 25);
            default:
                throw new IllegalArgumentException("Tipo de matéria-prima desconhecido: " + tipo);
        }
    }
  
    private void exibirDetalhes_cerveja(){
        int indexSelecionado = lista_cervejas.getSelectedIndex();
   
        descCerveja.setVisible(true);
       
   
        if (indexSelecionado != -1) {
            CervejaArtesanal cervejaSelecionada = cervejas.getElementAt(indexSelecionado);
        
            descCerveja.removeAll();
            descCerveja.setListData(cervejaSelecionada.listarRótulo());
 
        }
        repaint();
        revalidate();
    }

     private void exibirDetalhes_receita(){
        int indexSelecionado = lista_receita.getSelectedIndex();

        descReceita.setVisible(true);
       

        if(indexSelecionado != -1){
            Receita receitaSelecionada = receitas.getElementAt(indexSelecionado);
            descReceita.removeAll();
            descReceita.setListData(receitaSelecionada.listarIngredientes());
        }

     }

    public void tirarIngrediente(){
        int indexSelecionado = lista_ingredientes.getSelectedIndex();
        if(indexSelecionado != -1){

            materia.remove(indexSelecionado);
        }
      }

      public void apagarReceita() {
        int indexSelecionado = lista_receita.getSelectedIndex();
        if (indexSelecionado != -1) {
          Receita receitaSelecionada = receitas.getElementAt(indexSelecionado);
          receitas.remove(indexSelecionado);
          estoque.deletarReceita(receitaSelecionada.getNome());
          
        } else {
          JOptionPane.showMessageDialog(this, "Nenhuma receita selecionada");
        }
      }


    public static void main(String[] args) {
    
        new cervejaApp();
     
    }

}
