package Login.userUI;

import userDAO.UserDAO;
import userDTO.UserDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;
class Tela_Cadastro{
	
	/**
	 * @wbp.parser.entryPoint
	 */

    void initialize() {
    	JFrame
        frame = new JFrame();
        frame.getContentPane().setFocusable(true);
        frame.getContentPane().setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
        frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frame.setVisible(true);
        frame.setTitle("Cadastro");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K3lvin\\Pictures\\Sem título (2).png"));
        frame.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
        frame.setDefaultCloseOperation(1);
        frame.getContentPane().setBackground(new Color(192, 192, 192));
        frame.setBounds(100, 100, 520, 383);
        frame.getContentPane().setLayout(null);

        // Textos de identificao

        JLabel LoginJLabel = new JLabel("Login");
        LoginJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LoginJLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
        LoginJLabel.setBounds(10, 11, 135, 15);
        frame.getContentPane().add(LoginJLabel);

        JLabel SenhaJLabel = new JLabel("Senha");
        SenhaJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SenhaJLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
        SenhaJLabel.setBounds(10, 66, 135, 15);
        frame.getContentPane().add(SenhaJLabel);

        // Box dos Valores

        JTextField txtLoginCad = new JTextField();
        txtLoginCad.setBounds(10, 35, 148, 25);
        frame.getContentPane().add(txtLoginCad);
        txtLoginCad.setColumns(10);

        JTextField txtSenhaCad = new JTextField();
        txtSenhaCad.setBounds(10, 85, 148, 25);
        frame.getContentPane().add(txtSenhaCad);
        txtSenhaCad.setColumns(10);

        JButton btnNewButton = new JButton("Cadastrar");
        frame.getContentPane().add(btnNewButton);
        btnNewButton.setBounds(167, 174, 164, 31);
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\K3lvin\\Pictures\\Sem título (2).png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UserDTO Cad = new UserDTO();
                    Cad.setCad_Login(txtLoginCad.getText());
                    Cad.setCad_Senha(txtSenhaCad.getText());
                    UserDAO user = new UserDAO();
                    ResultSet rsResultSet = user.authentication(Cad);
                    if (rsResultSet != null) {
                        while (rsResultSet.next()){
                            showMessageDialog(null, "Cadastro Efetuado com Sucesso");
                            txtLoginCad.setText(null);
                            txtSenhaCad.setText(null);
                            rsResultSet.next();
                            frame.getContentPane();
                        }
                    }
                } catch (SQLException error) {
                    showMessageDialog(null, "Dados de Cadastro Invalidos");
                    showMessageDialog(null, error);
                }

            }
        });
    }
}

