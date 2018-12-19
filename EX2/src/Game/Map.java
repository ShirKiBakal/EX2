package Game;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Map extends JFrame implements Runnable,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3526527738468731681L;
	private JFrame jf =new JFrame();
	private JPanel jpanel=new JPanel();
	//private JMenuBar menuBar;
	private String imagePath="Ariel1.png";
	private BufferedImage myPic;
	//private JMenu menu;
	//private JMenuItem menuItem;
	private int x = -1;
	private int y = -1;
	
	public Map(){
		setTitle("Simple Frame");
		this.addMouseListener(this);
	}
	
	private void Rungui(){
		jf.setVisible(true);
		try {
			jf.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(this.imagePath)))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			myPic=ImageIO.read(new File(this.imagePath));		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		MenuItem item1 = new MenuItem("menu item 1");
		MenuItem item2 = new MenuItem("menu item 2");
		
		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		jf.setMenuBar(menuBar);
		jf.setSize(myPic.getWidth(), myPic.getHeight());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public void paint(Graphics g)
	{
		g.drawImage(this.myPic, 0, 0, this);
	
		if(x!=-1 && y!=-1)
		{
			int r = 10;
			x = x - (r / 2);
			y = y - (r / 2);
			g.fillOval(x, y, r, r);
		}
	}
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		this.x = arg.getX();
		this.y = arg.getY();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		Rungui();
		
	}

	
}
