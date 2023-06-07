import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.HashMap;

public class Methods
{
    /**********************************************
     ******** Methods to use in your code *********
     **********************************************/
    /*
     *      drawButtonPressed(Graphics g, int width, int height,int[] mouse)
     *      drawGrid(Graphics g, int width, int height)
     */
     
     
    
    //This shows all the buttons being pressed on the keyboard, mouse, and mouse position
    public static void drawButtonPressed(Graphics g, int width, int height,int mouseX, int mouseY)
    {
        int startRow0 = 120;
        int startRow1 = 130;
        int startRow2 = 140;
        int startRow3 = 150;

        int spacing = 20;
        
        g.setColor(new Color(40,40,40));
        g.fillRect(0,height,width/2,125);
        g.setColor(Color.GRAY);
        //up
        g.fillRect(50,height + 20,20,20);
        //down
        g.fillRect(50,height +60,20,20);
        //left
        g.fillRect(30,height +40,20,20);
        //right
        g.fillRect(70,height +40,20,20);
        //mouse button
        g.fillOval(20,height +80,15,15);
        g.drawString("X:" + mouseX + " Y:" + mouseY, 40, height +93); 
        
        
        g.drawString("1", startRow0, height +15); 
        g.drawString("2", startRow0+spacing, height +15); 
        g.drawString("3", startRow0+2 * spacing, height +15); 
        g.drawString("4", startRow0+3 * spacing, height +15); 
        g.drawString("5", startRow0+4 * spacing, height +15); 
        g.drawString("6", startRow0+5 * spacing, height +15); 
        g.drawString("7", startRow0+6 * spacing, height +15); 
        g.drawString("8", startRow0+7 * spacing, height +15); 
        g.drawString("9", startRow0+8 * spacing, height +15); 
        g.drawString("0", startRow0+9 * spacing, height +15); 
        
        g.drawString("Q", startRow1, height +35); 
        g.drawString("W", startRow1+spacing, height +35); 
        g.drawString("E", startRow1+2 * spacing, height +35); 
        g.drawString("R", startRow1+3 * spacing, height +35); 
        g.drawString("T", startRow1+4 * spacing, height +35); 
        g.drawString("Y", startRow1+5 * spacing, height +35); 
        g.drawString("U", startRow1+6 * spacing, height +35); 
        g.drawString("I", startRow1+7 * spacing, height +35); 
        g.drawString("O", startRow1+8 * spacing, height +35); 
        g.drawString("P", startRow1+9 * spacing, height +35); 
    
        g.drawString("A", startRow2, height +55); 
        g.drawString("S", startRow2+spacing, height +55); 
        g.drawString("D", startRow2+2 * spacing, height +55); 
        g.drawString("F", startRow2+3 * spacing, height +55); 
        g.drawString("G", startRow2+4 * spacing, height +55); 
        g.drawString("H", startRow2+5 * spacing, height +55); 
        g.drawString("J", startRow2+6 * spacing, height +55); 
        g.drawString("K", startRow2+7 * spacing, height +55); 
        g.drawString("L", startRow2+8 * spacing, height +55); 
    
        g.drawString("Z", startRow3, height +75); 
        g.drawString("X", startRow3+spacing, height +75); 
        g.drawString("C", startRow3+2 * spacing, height +75); 
        g.drawString("V", startRow3+3 * spacing, height +75); 
        g.drawString("B", startRow3+4 * spacing, height +75); 
        g.drawString("N", startRow3+5 * spacing, height +75); 
        g.drawString("M", startRow3+6 * spacing, height +75); 
        
        //space
        g.fillRect(165,height +85,100,10);
        
        g.setColor(Color.YELLOW);
        if(Keys.up)
            g.fillRect(50,height +20,20,20);
        if(Keys.down)
            g.fillRect(50,height +60,20,20);
        if(Keys.left)
            g.fillRect(30,height +40,20,20);
        if(Keys.right)
            g.fillRect(70,height +40,20,20);
        if(Keys.space)
            g.fillRect(165,height +85,100,10);
        
        if(Mouse.button) 
            g.fillOval(20,height +80,15,15);
        //Row 1
        if(Keys.num1)
            g.drawString("1", startRow0, height +15);
        if(Keys.num2)
            g.drawString("2", startRow0+spacing, height +15);
        if(Keys.num3)
            g.drawString("3", startRow0+2 * spacing, height +15);
        if(Keys.num4) 
            g.drawString("4", startRow0+3 * spacing, height +15);
        if(Keys.num5) 
            g.drawString("5", startRow0+4 * spacing, height +15);
        if(Keys.num6) 
            g.drawString("6", startRow0+5 * spacing, height +15); 
        if(Keys.num7)
            g.drawString("7", startRow0+6 * spacing, height +15); 
        if(Keys.num8)
            g.drawString("8", startRow0+7 * spacing, height +15); 
        if(Keys.num9)
            g.drawString("9", startRow0+8 * spacing, height +15); 
        if(Keys.num0)
            g.drawString("0", startRow0+9 * spacing, height +15); 
        
        if(Keys.q)
            g.drawString("Q", startRow1, height +35); 
        if(Keys.w)
            g.drawString("W", startRow1+spacing, height +35); 
        if(Keys.e)
            g.drawString("E", startRow1+2 * spacing, height +35); 
        if(Keys.r)
            g.drawString("R", startRow1+3 * spacing, height +35); 
        if(Keys.t)
            g.drawString("T", startRow1+4 * spacing, height +35); 
        if(Keys.y)
            g.drawString("Y", startRow1+5 * spacing, height +35); 
        if(Keys.u)
            g.drawString("U", startRow1+6 * spacing, height +35); 
        if(Keys.i)
            g.drawString("I", startRow1+7 * spacing, height +35); 
        if(Keys.o)
            g.drawString("O", startRow1+8 * spacing, height +35); 
        if(Keys.p)
            g.drawString("P", startRow1+9 * spacing, height +35); 
        
        if(Keys.a)
            g.drawString("A", startRow2, height +55); 
        if(Keys.s)
            g.drawString("S", startRow2+spacing, height +55); 
        if(Keys.d)
            g.drawString("D", startRow2+2 * spacing, height +55); 
        if(Keys.f)
            g.drawString("F", startRow2+3 * spacing, height +55); 
        if(Keys.g)
            g.drawString("G", startRow2+4 * spacing, height +55); 
        if(Keys.h)
            g.drawString("H", startRow2+5 * spacing, height +55); 
        if(Keys.j)
            g.drawString("J", startRow2+6 * spacing, height +55); 
        if(Keys.k)
            g.drawString("K", startRow2+7 * spacing, height +55); 
        if(Keys.l)
            g.drawString("L", startRow2+8 * spacing, height +55); 

        
        if(Keys.z)
            g.drawString("Z", startRow3, height +75); 
        if(Keys.x)
            g.drawString("X", startRow3+spacing, height +75); 
        if(Keys.c)
            g.drawString("C", startRow3+2 * spacing, height +75); 
        if(Keys.v)
            g.drawString("V", startRow3+3 * spacing, height +75); 
        if(Keys.b)
            g.drawString("B", startRow3+4 * spacing, height +75); 
        if(Keys.n)
            g.drawString("N", startRow3+5 * spacing, height +75); 
        if(Keys.m)
            g.drawString("M", startRow3+6 * spacing, height +75); 
  
    }
    public static void drawGrid(Graphics g, int width, int height)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        Font gridFont = new Font("Helvetica", Font.PLAIN, 10);
        g2d.setFont(gridFont);
        g2d.setColor(new Color(75,75,75));
        for (int x = 0; x<=width; x+= 20)
        {
            g2d.setColor(new Color(75,75,75));
            g2d.drawLine(x, 0, x, 600); 
            g2d.rotate(Math.toRadians(90),x,0);
            g2d.setColor(new Color(175,175,175));
            g2d.drawString(""+x,x,-1);
            g2d.rotate(Math.toRadians(-90),x,0);
        }
        for (int y = 0; y<=height; y+= 20)
        {
            g2d.setColor(new Color(75,75,75));
            g2d.drawLine(0,y,800,y); 
            g2d.setColor(new Color(175,175,175));
            g2d.drawString(""+y,1,y-1);
        }
        g.setColor(new Color(175,175,175));
        for (int x = 0; x<=800; x+= 100)
            g.drawLine(x, 0, x, 600);
        for (int y = 0; y<=600; y+= 100)
            g.drawLine(0, y, 800, y); 
    }
}
