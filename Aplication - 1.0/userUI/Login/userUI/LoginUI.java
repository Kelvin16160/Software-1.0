package Login.userUI;

import static javax.swing.SwingUtilities.invokeLater;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import userDAO.UserDAO;
import userDTO.UserDTO;

class LoginUI {
	/**
	 * @wbp.parser.entryPoint
	 */
	private static JFrame frmUsuario;
	private static JTextField txtLogin;
	private static JTextField txtSenha;
	private static JLabel lblLogin;
	private static JLabel lblSenha;

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					try {
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException errolook) {
						errolook.printStackTrace();
					}
				}
			}
		} catch (UnsupportedLookAndFeelException errolook) {
			JOptionPane.showMessageDialog(null, errolook);
		}

		invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginUI();
					LoginUI.frmUsuario.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Montar Mostrar a Janela Pelo Metodo Invoke \n" + e);
				}
			};
		});
	}



	/**
	 * @wbp.parser.entryPoint
	 */
	public LoginUI() {
		initialize();
	}

	void initialize() {
		frmUsuario = new JFrame("Aplication 1.0");
		frmUsuario.setResizable(false);
		frmUsuario.setAlwaysOnTop(true);
		frmUsuario.getContentPane().setEnabled(false);
		frmUsuario.setDefaultCloseOperation(0);
		frmUsuario.setFocusTraversalKeysEnabled(false);
		frmUsuario.setAutoRequestFocus(true);
		frmUsuario
				.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagens\\Sem título (2).png"));
		frmUsuario.getContentPane().setBackground(new Color(125, 128, 128));
		frmUsuario.setBounds(100, 100, 437, 297);
		frmUsuario.getContentPane().setLayout(null);

		lblLogin = new JLabel("Login");
		lblLogin.setDisplayedMnemonic('T');
		lblLogin.setLocation(10, 0);
		lblLogin.setBounds(13, 11, 31, 16);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frmUsuario.getContentPane().add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(54, 5, 125, 28);
		frmUsuario.getContentPane().add(txtLogin);
		txtLogin.setColumns(5);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(189, 9, 36, 21);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		frmUsuario.getContentPane().add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(237, 5, 125, 28);
		txtSenha.setColumns(5);
		frmUsuario.getContentPane().add(txtSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setSelectedIcon(new ImageIcon("C:\\Users\\K3lvin\\Downloads\\play-button.png"));
		btnLogar.setBounds(62, 54, 113, 28);
		frmUsuario.getContentPane().add(btnLogar);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(247, 54, 103, 28);
		frmUsuario.getContentPane().add(btnCadastro);
		btnCadastro.setSelectedIcon(
				new ImageIcon("C:\\Users\\K3lvin\\Downloads\\fast-forward.png"));
		
		JButton close = new JButton();
		close.setText("Exit");
		close.setSelectedIcon(new ImageIcon("C:\\Users\\K3lvin\\Downloads\\3541911.png"));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.setBounds(150, 131, 111, 28);
		frmUsuario.getContentPane().add(close);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Cadastro tela = new Tela_Cadastro();
				tela.initialize();
			}
		});
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDTO User = new UserDTO();
					User.setUsuario(txtLogin.getText());
					User.setSenha(txtSenha.getText());
					UserDAO user = new UserDAO();
					ResultSet rsResultSet = user.authentication01(User);
					if (rsResultSet.next()) {
						JOptionPane.showMessageDialog(null, "Bem vindo!");
						txtLogin.setText("");
						txtSenha.setText("");
						frmUsuario.setVisible(false);
						progressbar barra = new progressbar();
						if (barra.progress.getValue() == 100)  {	
							JOptionPane.showMessageDialog(null, barra.progress.getValue());
							app_main main = new app_main();
							main.initialize();
							
						} else {

						}
					} else {
						txtLogin.setText("");
						txtSenha.setText("");
						JOptionPane.showMessageDialog(null, "Dados invalidos");
					}
				} catch (SQLException error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
	}
}