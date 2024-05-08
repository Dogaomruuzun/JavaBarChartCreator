import java.awt.Color;
import java.awt.Graphics;

public class Bar
{
    private String label;
    private double value;
    public static final int HEIGHT = 15;
    
    public Bar(String aLabel, double aValue)
   {
     label = aLabel;
     value = aValue;
   }

   public void draw(Graphics g, int y, double scale)
   {
     final int GAP = 2;
     g.fillRect(0, y, (int) (value * scale), HEIGHT);
     g.setColor(Color.WHITE);
     g.drawString(label, GAP, y + HEIGHT - GAP);
     g.setColor(Color.BLACK);
   }
}