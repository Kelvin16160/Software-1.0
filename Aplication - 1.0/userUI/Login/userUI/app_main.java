package Login.userUI;

import java.awt.Font;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;


public class app_main {

	/**
	 * @wbp.parser.entryPoint
	 */

	public void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 590, 345);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton estoque = new JButton("Estoque");
		estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estoque_control control = new estoque_control();
				control.setVisible(true);
			}
		});
		estoque.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		estoque.setBounds(0, 0, 319, 23);
		frame.getContentPane().add(estoque);

		JButton Calc = new JButton("Calculadora");
		Calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app_calc calc = new app_calc();
				calc.setVisible(true);
			}
		});
		Calc.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		Calc.setBounds(0, 34, 319, 23);
		frame.getContentPane().add(Calc);

		JLabel image_icon = new JLabel();
		image_icon.setIcon(
				new ImageIcon("E:\\workspace\\K3lvin\\k3lvinapp\\src\\Login\\userUI\\17buNI-removebg-preview.png"));
		image_icon.setBounds(0, 0, 574, 306);
		frame.getContentPane().add(image_icon);
		frame.setVisible(true);
	}
}
