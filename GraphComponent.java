import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.JComponent;

public class GraphComponent extends JComponent 
{
	private Color pColor;
	
	private double curveThickness;
	private int width;
	private int height;
	private Ellipse2D.Double[] points;
	private Line2D.Double[] xNotches;
	private Line2D.Double[] yNotches;
	private Line2D.Double xAxis;
	private Line2D.Double yAxis;
	private static final int POINTS_PER_PIXEL = 100;
	private static final MathExConverter converter = new MathExConverter();
	
	public GraphComponent(int graphWidth, int graphHeight)
	{
		width = graphWidth;
		height = graphHeight;
		pColor = Color.black;
		curveThickness = 4;
		points = new Ellipse2D.Double[width * POINTS_PER_PIXEL];
		for (int i = 0; i < points.length; i++)
			points[i] = new Ellipse2D.Double(-1, -1, curveThickness, curveThickness);
		
		xNotches = new Line2D.Double[20];
		yNotches = new Line2D.Double[20];
		
		for (int i = 0; i < xNotches.length; i++)
			xNotches[i] = new Line2D.Double(0, 0, 0, 0);
		
		for (int i = 0; i < yNotches.length; i++)
			yNotches[i] = new Line2D.Double(0, 0, 0, 0);
		
		xAxis = new Line2D.Double(0, 0, 0, 0);
		yAxis = new Line2D.Double(0, 0, 0, 0);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0,0, width, height);
		
		g2.setColor(Color.black);
		g2.draw(xAxis);
		g2.draw(yAxis);
		
		for (Line2D.Double l : xNotches)
			g2.draw(l);
		
		for (Line2D.Double l : yNotches)
			g2.draw(l);
		
		g2.setColor(pColor);
		for (Ellipse2D.Double p : points)
			if(p != null)
				g2.fill(p);
	}
	
	public void setGraph(GraphPanel gp)
	{
		// changes axes
		if (gp.getXMin() <= 0 && gp.getXMax() >= 0)
		{
			double lineLevel = (width * gp.getXMin()) / (gp.getXMin() - gp.getXMax());
			xAxis.setLine(lineLevel, 0, lineLevel, height);
		}
		
		else
			xAxis.setLine(0, 0, 0, 0);
		
		if (gp.getYMin() <= 0 && gp.getYMax() >= 0)
		{
			double lineLevel = height - (height * gp.getYMin()) / (gp.getYMin() - gp.getYMax());
			yAxis.setLine(0, lineLevel, width, lineLevel);
		}
		
		else
			yAxis.setLine(0, 0, 0, 0);
		
		//changes notches
		
		/*double xN;
		double yN = height - height * -gp.getYMin() / gp.getRange();
		
		for (int i = 0; i < xNotches.length; i++)
		{
			if (i == 0)
			{
				if (gp.getXMin() < 0)
					xNotches[0].setLine(gp.getXMin()
			}

			else
				xNotches[i].setLine(
		}
		
		*/
		
		// changes points
		double x = 0;
		double function = 0;
		double y = 0;
		curveThickness = gp.getThickness();
		pColor = gp.getColor();
		
		for (int count = 0; count < points.length; count++)
		{
			double i = (double) count / POINTS_PER_PIXEL;
			x = i * gp.getDomain() / width + gp.getXMin();
			function = converter.evaluate(gp.getFunction(), "x", x);
			y = height - height * (function - gp.getYMin()) / gp.getRange();
			if (y >= 0 && y < height)
				points[count].setFrame(i - curveThickness/2, y - curveThickness/2, curveThickness, curveThickness);
			else
				points[count].setFrame(0, 0, 0, 0);
		}
		
		repaint();
	}
	

}
