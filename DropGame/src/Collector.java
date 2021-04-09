import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Collector extends Rectangle {

	int xSpeed;
	Image image;

	Collector(int x, int y, int xCOLLECTOR, int yCOLLECTOR) {
	   super(x, y, xCOLLECTOR, yCOLLECTOR);
       image = new ImageIcon("basket2.png").getImage();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setX(-7);
			move();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setX(7);
			move();
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setX(0);
			move();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setX(0);
			move();
		}
	}
	public void setX(int xMove) {
		xSpeed = xMove;
	}
	public void move() {
		x = x + xSpeed;
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawImage(image, x, y, null);
	}
}
