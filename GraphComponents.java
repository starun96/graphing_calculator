import javax.swing.JComponent;
import java.awt.geom.*;
import java.awt.*;

public class GraphComponents extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D.Double background = new Rectangle2D.Double(0, 0, Viewer.FW, Viewer.FH);
		Line2D.Double xaxis = new Line2D.Double(0, Viewer.FH/2, Viewer.FW, Viewer.FH/2);
		Line2D.Double yaxis = new Line2D.Double(Viewer.FW/2, 0, Viewer.FW/2, Viewer.FH);
		Ellipse2D.Double p = new Ellipse2D.Double(-2, Viewer.FH/2 - 2, 4, 4);
		
		g2.setColor(Color.WHITE);
		g2.fill(background);
		
		g2.setColor(Color.BLUE);
		g2.draw(xaxis);
		g2.draw(yaxis);
		
		if (Viewer.COLOR.equals("b"))
			g2.setColor(Color.BLUE);
		else if (Viewer.COLOR.equals("bl"))
			g2.setColor(Color.BLACK);
		else if (Viewer.COLOR.equals("r"))
			g2.setColor(Color.RED);
		else if (Viewer.COLOR.equals("p"))
			g2.setColor(Color.MAGENTA);
		else if (Viewer.COLOR.equals("pi"))
			g2.setColor(Color.PINK);
		else if (Viewer.COLOR.equals("y"))
			g2.setColor(Color.YELLOW);
		else if (Viewer.COLOR.equals("o"))
			g2.setColor(Color.ORANGE);
		else if (Viewer.COLOR.equals("g"))
			g2.setColor(Color.GREEN);
		else
			g2.setColor(Color.BLACK);
		
		for(double i = -2; i < Viewer.FW - 2; i+=.01)
		{
			double x = Viewer.DOMAIN * (2 * i - Viewer.FW + 4) / (2 * Viewer.FW);
			double y = 30 * Math.cos(2 * x) * Math.pow(Math.E, Math.cos(2*x));
			p.setFrame(i, Viewer.FH/2 - 2 - y, 4, 4);
			g2.fill(p);
		}
		
	}

}
