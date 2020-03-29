import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Viewer 
{
	public static double DOMAIN = Double.parseDouble(JOptionPane.showInputDialog("enter total width")); 
	public static int FW = 680;
	public static int FH = 660;
	public static String COLOR= JOptionPane.showInputDialog("which color do you want the graph to be? type the first letter(s) of the desired color." +
													   "\nr - red\nb - blue\ng - green\nbl - black\ny - yellow\np - purple\no - orange\npi - pink");
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(FW + 20, FH + 40);
		frame.setTitle("graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphComponents graph = new GraphComponents();
		frame.add(graph);
		
		frame.setVisible(true);
	}

}
