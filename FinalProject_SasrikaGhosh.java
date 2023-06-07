import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent; 
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.util.HashMap;

public class FinalProject_SasrikaGhosh {
    //These need to be accessible "everywhere".  
    // Initializing global variables
    int width = 800;
    int height = 600;
    int movement = 10;
    boolean Win = false;
    boolean loss = false;
    boolean ifLoss= false;
    float lossTime = 30;
    int[] mouse = {0,0}; 
    //initial position of player
    int initialX = 20;
    int initialY = 20;
    //width and height of player
    int playerWidth = 10;
    int playerHeight = 10;
    //variable to mark the start and end time
    long begin=System.currentTimeMillis();
    long end;
    //array for the player positions and dimensions
    int[] playerPos = {initialX,initialY,playerWidth,playerHeight};
    //walls(when hit player restarts to the beginning)
    int[] wall1 = {100,20,20,400};
    int[] wall2 = {200,200,20,400};
    int[] wall3 = {300,20,20,400};
    int[] wall4 = {400,200,20,400};
    int[] wall5 = {500,20,20,400};
    int[] wall6 = {600,200,20,400};
    int[] wall7 = {700,20,20,400};
    //mines(when hit game ends)
    int[] mine1 = {140, 20, 140, 120};
    int[] mine2 = {340, 20, 140, 120};
    int[] mine3 = {540, 20, 140, 120};
    int[] mine4 = {240, 480, 140, 120};
    int[] mine5 = {440, 480, 140, 120};
        
    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            //Custom colors
            //initializing colors
            Color minesColor = new Color(242, 22, 64);
            Color wallColor = new Color(41, 58, 242);
            
            
        //checking if mine loss is already true
        if(!loss){
            //checking if win is already true
                if(!Win) { 
                drawPlayer(g);
                //begin = System.currentTimeMillis();
                if (Keys.up){
                    //removes player from old position
                    removePlayer(g);
                    //moves the player based off user input
                    playerPos[1]= playerPos[1]-movement;
                    //determines if player position is smaller than initial Y position
                    if (playerPos[1]<= initialY){
                        playerPos[1]=initialY;
                    }
                    //determines if player position is going off the grid
                    if (playerPos[1]>= height){
                        playerPos[1]=height-playerHeight;
                    } 
                    //check for wall collision has occured
                    if (collision()) {
                        reinitializePlayer();
                    }
                    //checks if player has reached the green win rectangle
                    if (didWin()){
                        declareWin(g);
                    }
                    //checks if mine collision has occured
                    if(mineCollision()){
                        mineLoss(g);
                    }
                    //redraws the player to the new position
                    drawPlayer(g);
                }
                //repeating logic above for down key
                if(Keys.down) {
                    removePlayer(g);
                    playerPos[1]= playerPos[1]+movement;
                    if (playerPos[1]<= initialY){
                        playerPos[1]=initialY;
                    }
                    if (playerPos[1]>= height){
                        playerPos[1]=height-playerHeight;
                    } 
                    if (collision()) {
                        reinitializePlayer();
                    }
                    if (didWin()){
                        declareWin(g);
                    }
                    if(mineCollision())
                    {
                        mineLoss(g);
                    }
                    drawPlayer(g);
                }
                //repeating logic above for right key
                if (Keys.right){
                    removePlayer(g);
                    playerPos[0]= playerPos[0]+movement;
                    if (playerPos[0]<= initialX){
                        playerPos[0]=initialX;
                    }
                    if (playerPos[0]>= width){
                        playerPos[0]=width-playerWidth;
                    }
                    if (collision()) {
                        reinitializePlayer();
                    }
                    if (didWin()){
                        declareWin(g);
                    }
                    if(mineCollision())
                    {
                        mineLoss(g);
                    }
                    drawPlayer(g);
                }
                //repeating logic above for left key
                    if (Keys.left){
                        removePlayer(g);
                        playerPos[0]= playerPos[0]-movement;
                    if (playerPos[0]<= initialX){
                        playerPos[0]=initialX;
                    }
                    if (playerPos[0]>= width){
                        playerPos[0]=width-playerWidth;
                    }
                    if (collision()) {
                        reinitializePlayer();
                    }
                    if (didWin()){
                        declareWin(g);
                    }
                    if(mineCollision())
                    {
                        mineLoss(g);
                    }
                    drawPlayer(g);
                }
                //setting customized color for walls
                g.setColor(wallColor);
                //drawing walls
                drawWall(g);
                //drawing win(if true)
                drawWin(g);
                //setting customized color for mines
                g.setColor(minesColor);
                //drawing mines
                drawMine(g);
                    
                //draws the grid
                Methods.drawGrid(g, width, height);
            }
            //checking if player hit the green rectangle
            if (Win) {
                //calling this method to show win screen
                declareWin(g);
                //checking if space is pressed to restart the game
                if(Keys.space)
                {
                    //setting loss variable back to false
                    ifLoss = false;
                    //setting win variable back to false
                    Win = false;
                    //restarting timer 
                    begin=System.currentTimeMillis();
                }
            }
        }
        //checking if player has hit a mine
        if(loss)
        {
            //calling this method to show the mine loss screen
            mineLoss(g);
            //checking if space is pressed to restart the game
            if(Keys.space)
            {
                //setting the mine loss back to false
                loss = false;
                //restarting timer
                begin=System.currentTimeMillis();
            }
        }

        importantUpdateStuff(g);
        }
        
        //-----------------Methods start here--------------------
        //when key is pressed this method removes the player from the old position
        public void removePlayer(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(playerPos[0], playerPos[1], playerPos[2], playerPos[3]); 
        }
            //draws the player
            public void drawPlayer(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(playerPos[0], playerPos[1], playerPos[2], playerPos[3]); 
            }
            //screen for when player won
            public void drawWin(Graphics g) {
                g.setColor(Color.GREEN);
                g.fillRect(780,20,20,20); 
            }
            //draws the blue walls
            public void drawWall(Graphics g) {
                g.fillRect(wall1[0],wall1[1],wall1[2], wall1[3]);
                g.fillRect(wall2[0],wall2[1],wall2[2], wall2[3]);
                g.fillRect(wall3[0],wall3[1],wall3[2], wall3[3]);
                g.fillRect(wall4[0],wall4[1],wall4[2], wall4[3]);
                g.fillRect(wall5[0],wall5[1],wall5[2], wall5[3]);
                g.fillRect(wall6[0],wall6[1],wall6[2], wall6[3]);
                g.fillRect(wall7[0],wall7[1],wall7[2], wall7[3]);
                
            }
            //draws the red mines
            public void drawMine(Graphics g)
            {
                g.fillRect(mine1[0], mine1[1], mine1[2], mine1[3]);
                g.fillRect(mine2[0], mine2[1], mine2[2], mine2[3]);
                g.fillRect(mine3[0], mine3[1], mine3[2], mine3[3]);
                g.fillRect(mine4[0], mine4[1], mine4[2], mine4[3]);
                g.fillRect(mine5[0], mine5[1], mine5[2], mine5[3]);
            }
            //checks if player has collided with any red mines, if collision happpens than game ends
            public boolean mineCollision()
            {
                if(playerPos[0] >= mine1[0] &&  playerPos[0] <= (mine1[0] + mine1[2] - playerWidth) && playerPos[1] >= mine1[1] && playerPos[1] <= (mine1[1] + mine1[3] - playerHeight))
                {
                    return true;
                }
                if(playerPos[0] >= mine2[0] &&  playerPos[0] <= (mine2[0] + mine2[2] - playerWidth) && playerPos[1] >= mine2[1] && playerPos[1] <= (mine2[1] + mine2[3] - playerHeight))
                {
                    return true;
                }
                if(playerPos[0] >= mine3[0] &&  playerPos[0] <= (mine3[0] + mine3[2] - playerWidth) && playerPos[1] >= mine3[1] && playerPos[1] <= (mine3[1] + mine3[3] - playerHeight))
                {
                    return true;
                }
                if(playerPos[0] >= mine4[0] &&  playerPos[0] <= (mine4[0] + mine4[2] - playerWidth) && playerPos[1] >= mine4[1] && playerPos[1] <= (mine4[1] + mine4[3] - playerHeight))
                {
                    return true;
                }
                if(playerPos[0] >= mine5[0] &&  playerPos[0] <= (mine5[0] + mine5[2] - playerWidth) && playerPos[1] >= mine5[1] && playerPos[1] <= (mine5[1] + mine5[3] - playerHeight))
                {
                    return true;
                }
                return false;
            }
            //checks if player has collided with any blue walls, if collision has happened then it brings player back to start
            public boolean collision() {
               if (playerPos[0]>= wall1[0] && playerPos[0]<=(wall1[0]+wall1[2]-playerWidth) && playerPos[1]>= wall1[1] && playerPos[1]<=(wall1[1]+wall1[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall2[0] && playerPos[0]<=(wall2[0]+wall2[2]-playerWidth) && playerPos[1]>= wall2[1] && playerPos[1]<=(wall2[1]+wall2[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall3[0] && playerPos[0]<=(wall3[0]+wall3[2]-playerWidth) && playerPos[1]>= wall3[1] && playerPos[1]<=(wall3[1]+wall3[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall4[0] && playerPos[0]<=(wall4[0]+wall4[2]-playerWidth) && playerPos[1]>= wall4[1] && playerPos[1]<=(wall4[1]+wall4[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall5[0] && playerPos[0]<=(wall5[0]+wall5[2]-playerWidth) && playerPos[1]>= wall5[1] && playerPos[1]<=(wall5[1]+wall5[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall6[0] && playerPos[0]<=(wall6[0]+wall6[2]-playerWidth) && playerPos[1]>= wall6[1] && playerPos[1]<=(wall6[1]+wall6[3]-playerHeight)) {
                   return true;
               }
               if (playerPos[0]>= wall7[0] && playerPos[0]<=(wall7[0]+wall7[2]-playerWidth) && playerPos[1]>= wall7[1] && playerPos[1]<=(wall7[1]+wall7[3]-playerHeight)) {
                   return true;
               }
               
               
               return false; 
            }
            //reinitializes the player to original position and width and height
            public void reinitializePlayer() {
                playerPos[0]= initialX;
                playerPos[1]= initialY;
                playerPos[2]= playerWidth;
                playerPos[3]= playerHeight;
            }
            //checks if player collides with green rectangle, if collision has occured then user wins game
            public boolean didWin() {
                if (playerPos[0]>= 780 && playerPos[1]>= 20 && playerPos[1]<=40) {
                    end = System.currentTimeMillis();
                    return true;
                }
                return false;
            }
            //screen for when user wins game
            public void declareWin(Graphics g) {
                //sets win variable to true so player doesn't move anymore
                Win = true;
                //displays win string
                String displayWin = "You Won!!";
                //reinitializes the player to the start 
                reinitializePlayer();
                //calculates the time taken 
                long timeTaken = (end - begin)/1000;
                //checks if time taken is more than the given win time
                if (timeTaken>lossTime) {
                    ifLoss=true;
                }
                //displays string for time taken 
                String displayTime = "You took " + timeTaken + " seconds";
                //displays direction string to restart game
                String space = "Press space to start again";
                //if time taken is more than the given time then it will show loss screen
                if(ifLoss) {
                    displayWin = "You Lost!!";
                }
                //creating fonts
                Font f = new Font("Helvetica",Font.PLAIN,100);
                Font ft = new Font("Helvetica",Font.PLAIN,50);
                g.setColor(Color.GREEN);
                //setting screen color of loss screen
                if(ifLoss) {
                    g.setColor(Color.RED);
                }
                //filling rectangle for the screen 
                g.fillRect(20,20,780,580);
                //color for string
                g.setColor(Color.BLACK);
                //setting font
                g.setFont(f);
                //drawing the win string
                g.drawString(displayWin, 185, 275);
                //setting font
                g.setFont(ft);
                //drawing the time taken string
                g.drawString(displayTime, 185, 350);
                //drawing the directions to restart the game string
                g.drawString(space, 185, 400);
            }
            //checks if mine collision is true
            public void mineLoss(Graphics g)
            {
                //sets variable to check mine collision to true
                loss = true;
                //redraws the player back to the starting position
                reinitializePlayer();
                //Strings to inform player on what happened and why game has ended
                String lossforMine = "You hit a mine!!";
                //Directions on how to restart the game
                String space = "Press space to start again";
                //initializing new fonts
                Font f = new Font("Helvetica",Font.PLAIN,100);
                Font ft = new Font("Helvetica",Font.PLAIN,50);
                //setting the color to red
                g.setColor(Color.RED);
                //drawing the rectangle background 
                g.fillRect(20, 20, 780, 580);
                //setting string color
                g.setColor(Color.BLACK);
                //setting font 
                g.setFont(f);
                //drawing string for mine loss
                g.drawString(lossforMine, 140, 275);
                //setting font
                g.setFont(ft);
                //drawing string for directions to restart game
                g.drawString(space, 185, 400);
                
            }
        //the method to draw the directions
        public void drawDirections(Graphics g)
        {
            //draws the background of the directions
            g.setColor(new Color(40,40,40));
            g.fillRect(width/2,height,width/2,125);
            //create the font for the directions
            Font hudFont = new Font("Helvetica",Font.PLAIN,10);
            
            //creates the strings for directions
            
            String display1 = "DIRECTIONS:";
            String display2 = "THIS IS AN ESCAPE ROOM! Using the four arrow keys take your";
            String display5 = "player(white rectangle) to the door(green rectangle) to escape...";
            String display3 = "Don't hit the walls or you'll be taken back to the start. Don't touch the mines or you'll lose!!";
            String display4 = "P.S. escape before 30 seconds or else... YOU LOSE!!!";
            
            //This draws the directions to the screen.
            g.setColor(Color.CYAN);
            g.setFont(hudFont);
            g.drawString(display1, 400, height +15);
            g.drawString(display2, 400, height +35);
            g.drawString(display3, 400, height +75);
            g.drawString(display4, 400, height +95);
            g.drawString(display5, 400, height +55);

        }
        /*********************************************************
         ********* HEART OF THE GAME STARTS HERE!!! ***********
         *********************************************************/
        public void updateMousePosition()
        {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, frame);
            mouse[0] = p.x;
            mouse[1] = p.y-30;
        }
        public void importantUpdateStuff(Graphics g)
        {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame.repaint();
            //This code gets the new mouse position and updates mouseX and mouseY
            updateMousePosition();
            //This draws the text in the bottom right of the window
            drawDirections(g);
            //draws which buttons are being pressed
            Methods.drawButtonPressed(g,width,height,mouse[0], mouse[1]);
            //This makes sure that Mouse.buttonJustPressed is only true for one frame
            Mouse.buttonJustPressed = false;
            Keys.resetJustPressed();
        }
        public DrawPanel() {
            KeyListener keys = new Keys();
            
            addKeyListener(keys);
            setFocusable(true);            
            
            MouseListener mListener = new Mouse();
            addMouseListener(mListener);
            setFocusable(true);
        }
    }
    
    JFrame frame;
    DrawPanel drawPanel;
    public static void main(String... args) {
        new FinalProject_SasrikaGhosh().go();
    }
    private void go() {
        frame = new JFrame("2022 2023 Semester 2 starter code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height + 140));
        frame.setBackground(Color.BLACK);
        frame.pack();
        drawPanel = new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setResizable(true);
        
        frame.setLocation(0,0);
        frame.setVisible(true);
    }
}
