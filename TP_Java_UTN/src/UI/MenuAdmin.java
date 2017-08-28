package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class MenuAdmin extends JInternalFrame {


	public MenuAdmin() {
		setBounds(0, 0, 450, 300);
		

		JLabel lblAdministrador = new JLabel("Administrador");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblAdministrador)
					.addContainerGap(358, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblAdministrador)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
