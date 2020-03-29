import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphPanel extends JPanel
{
	private GraphComponent graph;
	
	private JButton submitButton;
	
	private static final Font mainFont = new Font ("Arial", Font.BOLD | Font.ITALIC, 15);
	
	private JLabel expressionLabel,
	               xMinLabel,
	               xMaxLabel,
	               yMinLabel,
	               yMaxLabel,
	               colorLabel,
	               thicknessLabel;
	
	private JTextField expressionText,
	                   xMinText,
	                   xMaxText,
	                   yMinText,
	                   yMaxText,
	                   colorText,
	                   thicknessText;
	
	private static Color[] colorList = 
	{
		Color.black, Color.blue, Color.red, Color.green, Color.yellow, Color.magenta, Color.orange, 
		Color.pink, Color.lightGray, Color.gray, Color.darkGray, Color.white, Color.cyan
	};
	
	private static String[] colorInputs =
	{
		"black", "blue", "red", "green", "yellow", "magenta", "orange", "pink", "lightGray", "gray", "darkGray",
		"white", "cyan"
	};
	                   
	public GraphPanel(GraphComponent gc)
	{
		graph = gc;
		setLayout(new GridLayout(8,2));
		createLabelsandFields();
		createSubmitButton();
	}
	
	private void createLabelsandFields()
	{
		expressionLabel = new JLabel("y =");
		xMinLabel = new JLabel("x minimum");
		xMaxLabel = new JLabel("x maximum");
		yMinLabel = new JLabel("y minimum");
		yMaxLabel = new JLabel("y maximum");
		colorLabel = new JLabel("Curve Color");
		thicknessLabel = new JLabel("Curve Thickness");
		
		expressionText = new JTextField("abs(x-2)^2");
		xMinText = new JTextField("-5");
		xMaxText = new JTextField("5");
		yMinText = new JTextField("-5");
		yMaxText = new JTextField("5");
		colorText = new JTextField("blue");
		thicknessText = new JTextField("4");
		
		add(expressionLabel);
		add(expressionText);
		
		add(xMinLabel);
		add(xMinText);
		
		add(xMaxLabel);
		add(xMaxText);
		
		add(yMinLabel);
		add(yMinText);
		
		add(yMaxLabel);
		add(yMaxText);
		
		add(colorLabel);
		add(colorText);
		
		add(thicknessLabel);
		add(thicknessText);
		
	}
	
	public void createSubmitButton()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitListener());
		add(submitButton);
	}
	
	public void submitValues()
	{
		graph.setGraph(this);
	}
	
	public String getFunction()
	{
		return expressionText.getText();
	}
	
	public double getThickness() 
	{
		return parseDouble(thicknessText.getText());
	}
	
	public Color getColor()
	{
		for (int i = 0; i < colorInputs.length; i++)
			if (colorText.getText().toLowerCase().equals(colorInputs[i]))
				return colorList[i];
		return null;
	}

	public double getXMin()
	{
		return parseDouble(xMinText.getText());
	}
	
	public double getXMax()
	{
		return parseDouble(xMaxText.getText());
	}

	public double getYMin()
	{
		return parseDouble(yMinText.getText());
	}
	
	public double getYMax()
	{
		return parseDouble(yMaxText.getText());
	}
	
	public double getDomain() 
	{
		return getXMax() - getXMin();
	}
	
	public double getRange()
	{
		return getYMax() - getYMin();
	}
	
	class SubmitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			submitValues();
		}
	}

	

	

}
