
hii git hello everyone
/*<applet code="BouncingBall"width="800"height="600"></applet>*/
import java.awt.*;
import java.applet.*;
class Ball
{
   int x,y,radius,dx,dy;
   Color Ballcolor;
   public Ball(int x,int y,int radius,int dx,int dy,Color bcolor)
   {
     this.x=x;
     this.y=y;
     this.radius=radius;
     this.dx=dx;
     this.dy=dy;
     this.Ballcolor=bcolor;
   }
}
public class BouncingBall extends Applet implements Runnable
{
  Thread t; 
  String msg="Gudipally Hareesh";
  Ball redBall,blackBall,pinkBall,greenBall,blueBall,yellowBall,orangeBall;
  Boolean flag=false;
  public void init()
  {
    setBackground(Color.white);
    setForeground(Color.red); 
    setFont(new Font("Arial",Font.BOLD,50)); 
    redBall=new Ball(120,120,100,5,4,Color.red);
    blackBall=new Ball(120,120,100,3,2,Color.black);
    pinkBall=new Ball(200,200,100,3,4,Color.pink);
    greenBall=new Ball(200,200,100,5,3,Color.green);
    blueBall=new Ball(200,200,100,4,3,Color.blue);
    yellowBall=new Ball(200,200,100,3,5,Color.yellow);
   // brownBall=new Ball(200,200,70,3,4,Color.brown);
    orangeBall=new Ball(200,200,100,4,5,Color.orange);
    t=new Thread(this);
    t.start();
}
public void start()
{
 flag=true;  
 t=new Thread(this,"BouncingBall"); 
 t.start();
 
 }
 public void paint(Graphics g)
 { 
   g.drawString(msg,200,200);
   g.setColor(redBall.Ballcolor);
   g.fillOval(redBall.x,redBall.y,redBall.radius,redBall.radius);
   g.setColor(blackBall.Ballcolor);
   g.fillOval(blackBall.x,blackBall.y,blackBall.radius,blackBall.radius);
   g.setColor(pinkBall.Ballcolor);
   g.fillOval(pinkBall.x,pinkBall.y,pinkBall.radius,pinkBall.radius);
   g.setColor(greenBall.Ballcolor);
   g.fillOval(greenBall.x,greenBall.y,greenBall.radius,greenBall.radius);
    g.setColor(blueBall.Ballcolor);
   g.fillOval(blueBall.x,blueBall.y,blueBall.radius,blueBall.radius);
    g.setColor(yellowBall.Ballcolor);
   g.fillOval(yellowBall.x,yellowBall.y,yellowBall.radius,yellowBall.radius);
 //  g.setColor(brownBall.Ballcolor);
  //g.fillOval(brownBall.x,brownBall.y,brownBall.radius,brownBall.radius);
    g.setColor(orangeBall.Ballcolor);
   g.fillOval(orangeBall.x,orangeBall.y,orangeBall.radius,orangeBall.radius); 
 } 
public void run()
{
  while(flag)
  {
    try
    {
        repaint();
         Thread.sleep(20);
        char ch=msg.charAt(0);
        msg=msg.substring(1,msg.length());
        msg=msg+ch;
       displacementOperator(redBall);
       displacementOperator(blackBall);
       displacementOperator(pinkBall);
       displacementOperator(greenBall);
      displacementOperator(blueBall);
      displacementOperator(yellowBall);
 //    displacementOperator(brownBall);
        displacementOperator(orangeBall);
        Thread.sleep(1);
       repaint();
    }
   catch(Exception e){}
 }
}

public void displacementOperator(Ball ball)
{
    if(ball.y>=300||ball.y<=0)
    {
       ball.dy=-ball.dy;
    }
     if(ball.x>=600||ball.y<=0)
     {
        ball.dx=-ball.dx;
     }
  ball.y=ball.y-ball.dy;
  ball.x=ball.x-ball.dx;
}
public void stop()
{
   msg+="stop()";
   flag=false;
    t=null;
}  

}       
    