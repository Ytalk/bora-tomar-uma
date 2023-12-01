package src;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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



public class cervejaApp extends JFrame{
    Inventario estoque = new Inventario();

    ImageIcon icone_setas = new ImageIcon("./icons/setas.png");
    
    String[] itens = {"ÁGUA","MALTE","LÚPULO","FERMENTO"};//
    
    private DefaultListModel<String> lojaListModel = new DefaultListModel<>();
    private JList<String> listaLoja = new JList<>(itens);

    private DefaultListModel<String> receitaListModel = new DefaultListModel<>();
    private JList<String> listaReceita = new JList<>(receitaListModel);

    
    private JButton botaoComprar = new JButton("COMPRAR");

   
   
    JPanel telaLoja = new JPanel(new BorderLayout(5,5));
    JPanel telaEstoque = new JPanel(new BorderLayout());
    JTextArea textoQntd_loja = new JTextArea();
       
    public cervejaApp (){
   
        configurarJanela();
   
    }

    private void configurarJanela(){

           setVisible(true); 
           setSize(800,500);
           setTitle("CERVEJARIA");
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar programa ao clicar no "X"
           setLocationRelativeTo(null); // abrir no centro da tela
         //  setLayout(new BorderLayout());

    }
    
    private void inicializarComponentes(){

      JButton botaoInventario = new JButton("INVENTÁRIO");
      JButton botaoReceitas = new JButton("RECEITAS");
      JButton botaoLoja = new JButton("LOJA");


      JLabel tituloLoja = new JLabel("LOJA");

        // Configurar layout superior
        JPanel menuSuperior = new JPanel();
        menuSuperior.setLayout(new GridLayout(1, 3));
        menuSuperior.setBounds(0,0,400,40);
        menuSuperior.add(botaoInventario);
        menuSuperior.add(botaoReceitas);
        menuSuperior.add(botaoLoja);
          
        configurarBotao(botaoLoja, this::abrirLoja);
        configurarBotao(botaoInventario, this::abrirEstoque);
        

        //TELA LOJA//
        telaLoja.add(tituloLoja,BorderLayout.WEST);
        telaLoja.add(listaLoja,BorderLayout. PAGE_START);
        telaLoja.add(textoQntd_loja,BorderLayout.CENTER);
        telaLoja.add(botaoComprar,BorderLayout.SOUTH);
        telaLoja.setVisible(false);
        
        //TELA LOJA//
        

        // Adicionar componentes à janela
       add(menuSuperior, BorderLayout.NORTH);
       add(telaLoja,BorderLayout.CENTER);   
                                
     
    }

    private void configurarBotao(JButton botao, ActionListener listener) {
        botao.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        botao.setForeground(new Color(237, 241, 238));
        botao.setBackground(new Color(0, 0, 0));
        botao.addActionListener(listener);
    }

    private void abrirLoja(ActionEvent e){

        telaLoja.setVisible(true);
        
    }

    private void abrirEstoque(ActionEvent e){
        telaLoja.setVisible(false);
        telaEstoque.setVisible(true);
    }



 public static void main(String[] args) {
    new cervejaApp().inicializarComponentes();
 }

}

        
    
    
    


