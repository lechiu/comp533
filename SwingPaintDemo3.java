package painting;
import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics.*;
import java.awt.event.*;
import javax.swing.UIManager;

public class SwingPaintDemo3 extends JFrame{
           public SwingPaintDemo3(){
                   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

           }





       public void go(){
              Drawpanel = new Mypanel();
           JFrame frame = new JFrame("Chasing Line");
           JButton mybutton1 = new JButton("Please");
           JButton mybutton2 = new JButton("Help");
           JButton mybutton3 = new JButton("Me!!");
           Drawpanel.add(mybutton1); 
           Drawpanel.add(mybutton2);
           Drawpanel.add(mybutton3);

           frame.getContentPane().add(BorderLayout.CENTER, Drawpanel);
           frame.setSize(300,300);
           frame.setVisible(true);


              Drawpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {


                        public void mouseMoved(java.awt.event.MouseEvent evt) {
                                  DrawpanelMouseMoved(evt);
                          }
             }); 




       }

              public void DrawpanelMouseMoved(java.awt.event.MouseEvent evt) {

                               xpos=evt.getX();
                               ypos=evt.getY();
                            System.out.println("Coordinates : X :"+ xpos+"Y: "+ypos);
                         Drawpanel.paintImage(xpos,ypos);



              } 

    class Mypanel extends JPanel{


                    public void paintImage(int xpost,int ypost){
                                       Graphics d = getGraphics();
                                        d.clearRect(0,0, this.getWidth(), this.getHeight());
                                        d.setColor(Color.black);
                                       d.drawLine(xpost, 0, xpost, this.getHeight());
                                       d.setColor(Color.red);
                                       d.drawLine(0, ypost, this.getWidth(),ypost);
                                       this.validate();




                    }

    } // end the inner class 


           public static void main(String[] args){
                           try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");


                                } catch(Exception e) {

                                    System.err.println("Look and feel not set");

                                }

                        SwingPaintDemo3 win = new SwingPaintDemo3();

                        win.go();


           }

                  Mypanel Drawpanel;
                  private int xpos=0;
                  private int ypos=0;
}