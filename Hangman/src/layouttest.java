package Hangman.src;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

class layouttest {

	public layouttest() {

		JFrame frame = new JFrame("Layout Examples");

		JPanel root = new JPanel();
		// the default layout manager is a FlowLayout. It lays out 
		// components top-to-bottom and left-to-right and wraps around
		// based on the width of the panel.
		// the other layout managers you need to know are border, box, 
		// and grid
		//root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		root.setLayout(new GridLayout(3, 4));
		/*
		root.setLayout(new BorderLayout());	

		root.add(new JButton("North"), BorderLayout.NORTH);
		root.add(new JButton("South"), BorderLayout.SOUTH);
		root.add(new JButton("East"), BorderLayout.EAST);
		root.add(new JButton("West"), BorderLayout.WEST);
		root.add(new JButton("Center"), BorderLayout.CENTER);
		*/
		for (int i=0; i<10; i++) {
			JButton temp = new JButton("" + (i+1));
			temp.addActionListener(e -> {
				JButton b = ((JButton) e.getSource());
				System.out.println(b.getText());
			});
			root.add(temp);
		}

		frame.getContentPane().add(root);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new layouttest();
	}
}