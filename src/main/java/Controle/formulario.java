package Controle;

// Parei na criação de barra de pesquisa
import java.awt.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;

import Conexao.conexao;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class formulario extends JFrame {
    conexao con_cliente; // banco de dados
    
    JLabel rCod, rNome, rEmail, rTel, rData;
    JTextField tCod, tNome, tEmail;
    JFormattedTextField tTel, tData;
    MaskFormatter mTel, mData;
    
    JButton bFirst, bLast, bPrevious, bNext, bLimpar, bGravar, bAlterar, bExcluir; // dps adicionar na pagina
    ImageIcon imagens[]; // imagens dos botões
    
    JTable tb_clientes; // datagrid
    JScrollPane scroll_tb; // container do datagrid
    
    public formulario() {
        con_cliente = new conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        
        Container tela = getContentPane();
        setTitle("Conexão Java com MySql");
        tela.setLayout(null);
        setResizable(false);

         // icon da página
        ImageIcon icone = new ImageIcon("");
        setIconImage(icone.getImage());
        
        // icones dos botões
        String icones[]={"image/next.png"};
        
        
        // máscara da data e do telefone
        try {
            mData = new MaskFormatter("##/##/####");
            mTel = new MaskFormatter("(##)####-####");
            mData.setPlaceholderCharacter('_');
            mTel.setPlaceholderCharacter('_');
        }
        catch (ParseException erro){}
        
        rCod = new JLabel("Codigo: "); 
        rNome = new JLabel("Nome: "); 
        rEmail = new JLabel("Email: "); 
        rTel = new JLabel("Telefone: "); 
        rData = new JLabel("Data: ");
        
        bFirst = new JButton("Primeiro");
        bLast = new JButton("Último");
        bPrevious = new JButton("Anterior");
        bNext = new JButton("Próximo");
        
        bLimpar = new JButton("Limpar");
        bGravar = new JButton("Gravar");
        bAlterar = new JButton("Alterar");
        bExcluir = new JButton("Excluir");
        
        tCod = new JTextField("");
        tNome = new JTextField("");
        tEmail = new JTextField("");
        tTel = new JFormattedTextField(mTel);
        tData = new JFormattedTextField(mData);
        
        tb_clientes = new javax.swing.JTable();
        scroll_tb = new javax.swing.JScrollPane();

        // setando a posição dos conteúdos na janela
        rCod.setBounds(50,50,50,20);        tCod.setBounds(120,50,200,20);
        rNome.setBounds(50,90,100,20);      tNome.setBounds(120,90,80,20);
        rEmail.setBounds(50,130,300,20);    tEmail.setBounds(120,130,300,20);
        rTel.setBounds(50,170,300,20);      tTel.setBounds(120,170,300,20);
        rData.setBounds(50,210,300,20);     tData.setBounds(120,210,300,20);
        
        tela.add(rCod);      tela.add(tCod);
        tela.add(rNome);     tela.add(tNome);
        tela.add(rEmail);    tela.add(tEmail);
        tela.add(rTel);      tela.add(tTel);
        tela.add(rData);     tela.add(tData);
        
        // começo das funcionalidade dos JButton
        tipo_Botao("First");
        bLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    con_cliente.resultset.last();
                    mostrar_Dados();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro"
                            + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    con_cliente.resultset.previous();
                    mostrar_Dados();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o Anterior registro"
                            + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    con_cliente.resultset.next();
                    mostrar_Dados();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o Próximo registro"
                            + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tCod.setText("");
                tNome.setText("");
                tEmail.setText("");
                tTel.setText("");
                tData.setText("");
                
                tCod.requestFocus(); // posiciona o cursor neste campo
            }
        });
        bGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = tNome.getText();
                String email = tEmail.getText();
                String telefone = tTel.getText();
                String data_nasc = tData.getText();
                
                try {
                    String insert_sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
                    
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    con_cliente.executaSQL("select * from tbClientes order by cod");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na Gravação: \n " 
                            + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = tNome.getText();
                String email = tEmail.getText();
                String telefone = tTel.getText();
                String data_nasc = tData.getText();
                String sql; String msg = "";
                
                try {
                    if(tCod.getText().equals("")) {
                        sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
                        msg = "Gravação de um novo registro";
                    }
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
        // fim das funcionalidade dos JButton
        
        // começo da configuração da JTable
        tb_clientes.setBounds(50, 250, 550, 200);
        scroll_tb.setBounds(50, 250, 550, 200);
        
        tela.add(tb_clientes);
        tela.add(scroll_tb);
        
        tb_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_clientes.setFont(new java.awt.Font("Arial", 1, 12));
        
        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [] [] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
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
                
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from tbClientes order by cod");
        preencherTabela();
        posicionarRegistro();
    }
    public JButton tipo_Botao(String nome) {
        JButton botao = new JButton(nome);
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (nome.equals("Primeiro")) {
                        con_cliente.resultset.first();
                        mostrar_Dados(); } 
                    else if (nome.equals("Primeiro")) {
                        con_cliente.resultset.first();
                        mostrar_Dados(); }
                    else if (nome.equals("Primeiro")) {
                        con_cliente.resultset.first();
                        mostrar_Dados(); }
                    else if (nome.equals("Primeiro")) {
                        con_cliente.resultset.first();
                        mostrar_Dados(); }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro"
                            + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }  
            }
        });
        return botao;
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
            tData.setText(con_cliente.resultset.getString("dt_nasc"));
            tTel.setText(con_cliente.resultset.getString("telefone"));
            tEmail.setText(con_cliente.resultset.getString("email")); 
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não localizou dados: " + erro, "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void preencherTabela() {
        tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(4);
        tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_clientes.getColumnModel().getColumn(2).setPreferredWidth(11);
        tb_clientes.getColumnModel().getColumn(3).setPreferredWidth(14);
        tb_clientes.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        DefaultTableModel modelo = (DefaultTableModel) tb_clientes.getModel();
        modelo.setNumRows(0);
        
        try {
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                    con_cliente.resultset.getString("cod"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("dt_nasc"),
                    con_cliente.resultset.getString("telefone"),
                    con_cliente.resultset.getString("email")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } // PAREI AQUI!!
    }
    public static void main(String args[]){
        formulario app = new formulario();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
