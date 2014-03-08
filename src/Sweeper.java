import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Sweeper extends Applet
implements MouseListener{

	int x;
	int y;
	int gamewidth;
	int gameheight;
	int startx;
	int starty;
	Zone [] zone;
	int mousex;
	int mousey;
	int row;
	int column;
	int minenum;
	int zonewidth = 9;
	public void init()
	{
		zone = new Zone[81];
		gamewidth = getWidth();
		gameheight = getHeight();
		minenum = 10;
		
		
		int q = 0;
		
		int p = 0;
		startx = 5;
		starty = 5;
		for (int i = 0; i < zone.length; i++)
		{

			zone[i] = new Zone(startx+p,starty+q,20);
			p=p+21;
			if (p == 189)
			{
				q=q+21;
				p =0;
				
			}

		}
		for (int i = 0; i < minenum; i++)
		{
			
			int temp = (int)(Math.random() * (zone.length-1));
			System.out.println(temp);
			if (zone[temp].has_bomb==true)
			{
				i = i-1;
			}else if (zone[temp].has_bomb==false)
			{
				zone[temp].has_bomb = true;
			}
		}
	      addMouseListener( this );
		repaint();
	}
	public void paint(Graphics g)
	{

		
		
		g.setColor(Color.black);
		g.fillRect(startx-1, starty-1, 9*21, 9*21);
		g.setColor(Color.GRAY);
		int bombcount = 0;
		for (int r = 0; r < zone.length; r++)
			{
			if (zone[r].is_clicked == true && zone[r].has_bomb==false)
			{
				g.setColor(Color.BLUE);
			}else if (zone[r].has_bomb==true && zone[r].is_clicked==true)
			{
				g.setColor(Color.RED);
			}else 
			{
				System.out.println(r);
				g.setColor(Color.GRAY);
			}
			g.fillRect(zone[r].x, zone[r].y, zone[r].sidelength, zone[r].sidelength);
			}
		
		for (int i = 1; i < 10; i++)
		{
			
			if (mousex < (i*21)+startx-1 && mousex > ((i-1)*21)+startx-1)
			{
				System.out.println("This is the " + i);
				row = i;
			}
			
		}
		for (int i = 1; i < 10; i++)
		{
			
			if (mousey < (i*21)+starty-1 && mousey > ((i-1)*21)+starty-1)
			{
				System.out.println("This is the " + i);
				column = i;
			}
			
		}
		int zonenum = ((column -1)*zonewidth) + row -1;
		System.out.println(zonenum);
		if (zone[zonenum].has_bomb == false)
		{
			g.setColor(Color.BLUE);
			//bomb sweeper bugs on the right and left side. need to make 8 "if" statements
			for (int v = zonewidth + 1; v > zonewidth - 2; v--)
			{
				//corner and side check
				if ()
				//top check
				if (zonenum > zonewidth)
				{
					if (zone[zonenum-v].has_bomb == true)
					{
						bombcount++;
					}
				}
				
				
				
				
				//top check
				if (zonenum > zonewidth)
				{
					if (zone[zonenum-v].has_bomb == true)
					{
						bombcount++;
					}
				}
				//bottom check
				if (zonenum < 72)
				{
					if (zone[zonenum+v].has_bomb == true)
					{
						bombcount++;
					}
				}
			}
			//right check
			if (zonenum%zonewidth != zonewidth - 1)
			{
				if (zone[zonenum+1].has_bomb == true)
				{
					bombcount++;
				}
			}
			//left check
			if (zonenum%zonewidth != 0)
			{
				if (zone[zonenum-1].has_bomb == true)
				{
					bombcount++;
				}
			}
				
				System.out.println(bombcount);
			System.out.println(zonenum%zonewidth);
			}else
		{
			System.out.println("Bomb");
			g.setColor(Color.RED);
		}
		g.fillRect(zone[zonenum].x, zone[zonenum].y, zone[zonewidth].sidelength, zone[zonewidth].sidelength);
		zone[zonenum].is_clicked = true;
	//if (zone[zonenum])
	
	
	}
	
		
	public void mouseEntered( MouseEvent e ) { }
	public void mouseExited( MouseEvent e ) { }
	public void mousePressed( MouseEvent e ) { }
	public void mouseReleased( MouseEvent e ) { }   
	public void mouseClicked( MouseEvent e ) 
	   {
		mousex = e.getX();
		mousey = e.getY();
		System.out.println(e.getX() + "  " + e.getY());
	      e.consume();
	      repaint();
	      
	   }
		
	
	
	
	
	
	
	}

