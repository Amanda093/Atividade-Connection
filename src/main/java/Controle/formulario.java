package Controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;

import Conexao.conexao;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class formulario extends JFrame {
    conexao con_cliente; // banco de dados
    
    JLabel rTitulo, rCod, rNome, rEmail, rTel, rData, rPesquisa;
    JTextField tCod, tNome, tEmail, tPesquisa;
    JFormattedTextField tTel, tData;
    MaskFormatter mTel, mData;
    
    JButton bFirst, bLast, bPrevious, bNext, bLimpar, bGravar, bAlterar, bExcluir, bPesquisa, bSair;
    
    JTable tb_clientes; // datagrid
    JScrollPane scroll_tb; // container do datagrid
    
    public formulario() {
        con_cliente = new conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        
        setTitle("Conexão Java com MySql"); // define o titulo da janela
        Container tela = getContentPane();
        tela.setLayout(null);
        setResizable(false);
        
        // icon da página
        ImageIcon icone = new ImageIcon("image/form.png");
        setIconImage(icone.getImage());
        
        // máscara da data e do telefone
        try {
            mData = new MaskFormatter("##/##/####");
            mTel = new MaskFormatter("(##)####-####");
            mData.setPlaceholderCharacter('_');
            mTel.setPlaceholderCharacter('_');
        }
        catch (ParseException erro){}
        
        // nomeação dos conteudos da tela
        rTitulo = new JLabel("FORMULÁRIO");
        rTitulo.setFont(new Font("Segoe UI",Font.BOLD,24));
        
        rCod = new JLabel("Código: "); 
        rNome = new JLabel("Nome: "); 
        rEmail = new JLabel("Email: "); 
        rTel = new JLabel("Telefone: "); 
        rData = new JLabel("Data: ");
        rPesquisa = new JLabel("Pesquisar pelo nome do Cliente: ");
        rPesquisa.setFont(new Font("Segoe UI",Font.BOLD,13));
        
        bFirst = new JButton("Primeiro");
        bLast = new JButton("Ultimo");
        bPrevious = new JButton("Anterior");
        bNext = new JButton("Próximo");
        
        bLimpar = new JButton("Limpar");
        bGravar = new JButton("Gravar");
        bAlterar = new JButton("Alterar");
        bExcluir = new JButton("Excluir");
        
        bPesquisa = new JButton("Pesquisar"); 
        bSair = new JButton("Sair");
        
        tCod = new JTextField("");
        tNome = new JTextField("");
        tEmail = new JTextField("");
        tPesquisa = new JTextField("");
        
        tTel = new JFormattedTextField(mTel);
        tData = new JFormattedTextField(mData);
        
        tb_clientes = new javax.swing.JTable();
        scroll_tb = new javax.swing.JScrollPane();

        // setando a posição dos conteúdos na janela
        rTitulo.setBounds(260,30,500,20);
        rCod.setBounds(50,70,50,20);          tCod.setBounds(120,70,50,20);
        rNome.setBounds(50,110,100,20);       tNome.setBounds(120,110,200,20);
        rEmail.setBounds(50,150,300,20);      tEmail.setBounds(120,150,200,20);
        rTel.setBounds(50,190,300,20);        tTel.setBounds(120,190,90,20);
        rData.setBounds(50,230,300,20);       tData.setBounds(120,230,70,20);
        rPesquisa.setBounds(50,550,300,20);   tPesquisa.setBounds(260,550,240,25);
        
        bPesquisa.setBounds(500,550,100,25);  bSair.setBounds(500,110,100,25);
        bFirst.setBounds(50,270,100,25);      bLast.setBounds(150,270,100,25);
        bPrevious.setBounds(250,270,100,25);  bNext.setBounds(350,270,100,25);
        bLimpar.setBounds(500,150,100,25);    bGravar.setBounds(500,190,100,25);
        bAlterar.setBounds(500,230,100,25);   bExcluir.setBounds(500,270,100,25);
        
        tela.add(rTitulo);   
        tela.add(rCod);      tela.add(tCod);
        tela.add(rNome);     tela.add(tNome);
        tela.add(rEmail);    tela.add(tEmail);
        tela.add(rTel);      tela.add(tTel);
        tela.add(rData);     tela.add(tData);
        tela.add(rPesquisa); tela.add(tPesquisa);
        
        tela.add(bPesquisa); tela.add(bSair);
        tela.add(bFirst);    tela.add(bLast);
        tela.add(bPrevious); tela.add(bNext);
        tela.add(bLimpar);   tela.add(bGravar);
        tela.add(bAlterar);  tela.add(bExcluir);
        
        // começo das funcionalidade dos JButton
        tipo_Botao(bFirst);    tipo_Botao(bLast);
        tipo_Botao(bPrevious); tipo_Botao(bNext);
        
        bLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tCod.setText(""); tNome.setText(""); tEmail.setText(""); tTel.setText(""); tData.setText(""); tCod.requestFocus(); }
        });
        bGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = tNome.getText();      String email = tEmail.getText();
                String telefone = tTel.getText();   String data_nasc = tData.getText();
                
                try {
                    String insert_sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
                    
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    con_cliente.executaSQL("select * from tbClientes order by cod");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na Gravação: \n " 
                            + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); }
            }
        });
        bAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = tNome.getText();      String email = tEmail.getText();
                String telefone = tTel.getText();   String data_nasc = tData.getText();
                String sql; String msg = "";
                
                try {
                    if(tCod.getText().equals("")) {
                        sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
                        msg = "Gravação de um novo registro"; }
                    else {
                        sql = "update tbclientes set nome='" + nome + "',telefone='" + telefone + "', email='" + email + "', dt_nasc='" + data_nasc + "' where cod = " + tCod.getText();
                        msg = "Alteração de registro"; 
                    }
                    
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    con_cliente.executaSQL("select * from tbClientes order by cod");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na Gravação: \n " 
                            + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql;
                try {
                    int option = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, 3);
                    if (option == 0) {
                        sql = "delete from tbclientes where cod = " + tCod.getText();
                        int excluir = con_cliente.statement.executeUpdate(sql);
                        
                        if (excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                            con_cliente.executaSQL("select * from tbclientes order by cod");
                            con_cliente.resultset.first();
                            
                            preencherTabela();
                            posicionarRegistro();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null, "Erro na Exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        });
        bPesquisa.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               try {
                   String pesquisa = "select * from tbclientes where nome like '" + tPesquisa.getText() + "%'";
                   con_cliente.executaSQL(pesquisa);
                   
                   if(con_cliente.resultset.first()) { preencherTabela(); }
                   else {
                       JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);                       
                   }
               } catch (SQLException errosql) {
                   JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
               }
           } 
        });
        // fim das funcionalidade dos JButton
        
        // começo da configuração da JTable
        tb_clientes.setBounds(50,315,550,200);
        scroll_tb.setBounds(50,315,550,200);
        
        tela.add(tb_clientes);
        tela.add(scroll_tb);
        
        tb_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_clientes.setFont(new java.awt.Font("Arial", 1, 12));
        
        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [] [] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {"Código", "Nome", "Data Nascimento", "Telefone", "Email"})
        {
        boolean[] canEdit = new boolean []{
        false, false, false, false, false};
        
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }});
        
        scroll_tb.setViewportView(tb_clientes);
        tb_clientes.setAutoCreateRowSorter(true);
        // fim da configuração da JTable
           
        // dicas
        bFirst.setToolTipText("Pressione ALT + P para executar a ação deste botão");
        bLast.setToolTipText("Pressione ALT + U para executar a ação deste botão");
        bPrevious.setToolTipText("Pressione ALT + A para executar a ação deste botão");
        bNext.setToolTipText("Pressione ALT + R para executar a ação deste botão");
        
        bSair.setToolTipText("Pressione ALT + S para executar a ação deste botão");
        bLimpar.setToolTipText("Pressione ALT + L para executar a ação deste botão");
        bGravar.setToolTipText("Pressione ALT + G para executar a ação deste botão");
        bAlterar.setToolTipText("Pressione ALT + T para executar a ação deste botão");
        bExcluir.setToolTipText("Pressione ALT + E para executar a ação deste botão");
        bPesquisa.setToolTipText("Pressione ALT + Q para executar a ação deste botão");
        
        // atalhos
        getRootPane().setDefaultButton(bNext);
        bFirst.setMnemonic(KeyEvent.VK_P);
        bLast.setMnemonic(KeyEvent.VK_U);
        bPrevious.setMnemonic(KeyEvent.VK_A);
        bNext.setMnemonic(KeyEvent.VK_R);
        
        bSair.setMnemonic(KeyEvent.VK_S);
        bLimpar.setMnemonic(KeyEvent.VK_L);
        bGravar.setMnemonic(KeyEvent.VK_G);
        bAlterar.setMnemonic(KeyEvent.VK_T);
        bExcluir.setMnemonic(KeyEvent.VK_E);
        bPesquisa.setMnemonic(KeyEvent.VK_Q);
        
        setSize(680,650);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from tbClientes order by cod");
        preencherTabela();
        posicionarRegistro();
    }
    public void tipo_Botao(JButton nome) {
        nome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (nome.equals(bFirst)) {
                        con_cliente.resultset.first(); } 
                    
                    else if (nome.equals(bLast)) {
                        con_cliente.resultset.last(); }
                    
                    else if (nome.equals(bPrevious)) {
                        con_cliente.resultset.previous(); }
                    
                    else if (nome.equals(bNext)) {
                        con_cliente.resultset.next(); }
                    
                    mostrar_Dados(); // apresenta os dados
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro"
                            + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }  
            }
        });
    }
    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first(); //posiciona no 1° registro da tabela
            mostrar_Dados(); // metódo que irá buscar o dado na tabela
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: " 
                    + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void mostrar_Dados() {
        try {
            tCod.setText(con_cliente.resultset.getString("cod"));
            tNome.setText(con_cliente.resultset.getString("nome"));
            tEmail.setText(con_cliente.resultset.getString("email")); 
            tTel.setText(con_cliente.resultset.getString("telefone"));
            tData.setText(con_cliente.resultset.getString("dt_nasc"));
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não localizou dados: " + erro, "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void preencherTabela() {
        tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_clientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tb_clientes.getColumnModel().getColumn(3).setPreferredWidth(90);
        tb_clientes.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        DefaultTableModel modelo = (DefaultTableModel) tb_clientes.getModel();
        modelo.setNumRows(0);
        
        try {
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                    con_cliente.resultset.getString("cod"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("email"),
                    con_cliente.resultset.getString("telefone"),
                    con_cliente.resultset.getString("dt_nasc")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String args[]){
        formulario app = new formulario();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
