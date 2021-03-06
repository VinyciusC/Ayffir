package telas;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import telas.Inicio;
import telas.Atualizacao;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import conexao.ModuloConexao;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class Atualizacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PainelInicio;
	
	Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualizacao frame = new Atualizacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Atualizacao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Atualizacao.class.getResource("/icones/LogoMenorAinda - Ayffir.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ayffir - Atualização");
		setBounds(290, 60, 800, 600);
		PainelInicio = new JPanel();
		PainelInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelInicio);
		PainelInicio.setLayout(null);
		
		JButton Atualizacao = new JButton("");
		Atualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse(new java.net.URI("http://oglle.com.br/Instalador%20-%20Ayffir.exe"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		Atualizacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Atualizacao.setIcon(new ImageIcon(Atualizacao.class.getResource("/icones/Atualizar - Ayffir.png")));
		Atualizacao.setBorderPainted(false);
		Atualizacao.setBorder(null);
		Atualizacao.setBounds(289, 284, 90, 25);
		PainelInicio.add(Atualizacao);
		
		JButton Fechar = new JButton("");
		Fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio inicio = new Inicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		Fechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Fechar.setIcon(new ImageIcon(Atualizacao.class.getResource("/icones/Fechar - Ayffir.png")));
		Fechar.setBorderPainted(false);
		Fechar.setBorder(null);
		Fechar.setBounds(389, 284, 90, 25);
		PainelInicio.add(Fechar);
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Atualizacao.class.getResource("/icones/FundoAtualizacao - Ayffir.png")));
		Fundo.setBounds(0, 0, 800, 571);
		PainelInicio.add(Fundo);
		
		conexao = ModuloConexao.conector();
	}
}
