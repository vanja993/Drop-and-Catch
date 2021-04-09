import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Ball extends Rectangle {

	Image strawberryBallImage;
	Image appleBallImage;
	Image bananaBallImage;
	Image ballImage;
	int ySpeed = 2;
	int randomBallImage;

	Ball(int x, int y, int diam) {
		super(x, y, diam, diam);
		bananaBallImage = new ImageIcon("bananas.png").getImage();
		strawberryBallImage = new ImageIcon("strawberry.png").getImage();
		appleBallImage = new ImageIcon("apple.png").getImage();
	}
	public void move() {
		y = y + ySpeed; // move the ball on y coordinate
	}
	public void draw(Graphics g) {
		ballImage = setImage(randomBallImage);
		g.drawImage(ballImage, x, y, null);
	}
	public Image setImage(int random) {
		switch(random) {
		  case 0:return bananaBallImage;
		  case 1:return strawberryBallImage;
		  default:return appleBallImage;
		}
	}
}
