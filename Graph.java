import static java.lang.System.exit;
import static java.lang.System.out;
import static javax.swing.JOptionPane.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Graph 
{
	public static final int FRAME_WIDTH = 800,
	                        FRAME_HEIGHT = 500;
	
	public static void main(String[] args)
	{
		JFrame mainFrame = new JFrame();
		
		mainFrame.setUndecorated(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		mainFrame.getContentPane().setLayout(null);
		
		int graphWidth = 500;
		int graphHeight = 500;
		
		GraphComponent graph = new GraphComponent(graphWidth, graphHeight);
		graph.setBounds(220, 0, graphWidth, graphHeight);
		mainFrame.getContentPane().add(graph, BorderLayout.EAST);
		
		GraphPanel panel = new GraphPanel(graph);
		panel.setBounds(10,10, 200,300);
		mainFrame.getContentPane().add(panel, BorderLayout.WEST);
		
	    JButton exitButton = new JButton();
		exitButton.addActionListener(new ExitListener());
		exitButton.setBackground(Color.red);
		exitButton.setBounds(FRAME_WIDTH - 20, 0, 20, 20);
		mainFrame.getContentPane().add(exitButton);
		
		mainFrame.setVisible(true);
	}		
}

class ExitListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		exit(0);
	}
}