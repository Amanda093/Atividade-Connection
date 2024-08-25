package Controle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import Conexao.conexao;
import java.sql.*;

public class login extends JFrame {
    conexao con_cliente; // banco de dados
    
    JLabel rTitulo, rUsuario, rSenha;
    JTextField tUsuario;
    JPasswordField tSenha;
    JButton bLogin;
    
    public login() {
        con_cliente = new conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        
        setTitle("Login de Acesso");
        Container tela = getContentPane();
        setLayout(null);
        
        // icon da página
        ImageIcon icone = new ImageIcon("image/form.png");
        setIconImage(icone.getImage());

        // nomeação dos conteudos da tela
        rTitulo = new JLabel("Acesso ao Sistema");
        rTitulo.setFont(new Font("Segoe UI",Font.BOLD,24));
        
        rUsuario = new JLabel("Usuário: ");
        rSenha = new JLabel("Senha: ");
        bLogin = new JButton("Logar");
        
        tUsuario = new JTextField("");
        tSenha = new JPasswordField("");

        // setando a posição dos conteúdos na janela
        rTitulo.setBounds(50,30,500,20);      bLogin.setBounds(50,150,100,25);
        rUsuario.setBounds(50,70,100,20);       tUsuario.setBounds(120,70,140,20);
        rSenha.setBounds(50,110,100,20);       tSenha.setBounds(120,110,140,20);
        
        tela.add(rTitulo);    tela.add(bLogin);
        tela.add(rUsuario);   tela.add(tUsuario);
        tela.add(rSenha);     tela.add(tSenha);
        
         // começo das funcionalidade dos JButton        
        bLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String pesquisa = "select * from tblusuario where usuario like '" + tUsuario.getText() + "' && senha = " + tSenha.getText() + "";
                    con_cliente.executaSQL(pesquisa);
                    
                    if(con_cliente.resultset.first()) { // acesso ao formulario
                        formulario mostra = new formulario();
                        mostra.setVisible(true);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        con_cliente.desconecta();
                        System.exit(0);
                    }
                } catch(SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados! \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }        
        });
        // fim das funcionalidade dos JButton
        
        // dicas & atalhos
        bLogin.setToolTipText("Pressione ALT + L para executar a ação deste botão");
        getRootPane().setDefaultButton(bLogin);
        bLogin.setMnemonic(KeyEvent.VK_L);
        
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String args[]){
        login app = new login();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
