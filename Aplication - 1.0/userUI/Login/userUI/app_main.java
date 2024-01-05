package Login.userUI;

import java.awt.Font;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

class app_main {
	private estoque_control control = new estoque_control();
	private app_calc calc = new app_calc();

	/**
	 * @wbp.parser.entryPoint
	 */

	public void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 590, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton estoque = new JButton("Estoque");
		estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setVisible(true);
			}
		});
		estoque.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		estoque.setBounds(0, 0, 319, 23);
		frame.getContentPane().add(estoque);

		JButton Calc = new JButton("Calculadora");
		Calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
