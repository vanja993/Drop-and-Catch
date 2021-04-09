import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	static final int GAME_WIDTH = 500;
	static final int GAME_HEIGHT = 500;
	static final int COLLECTOR_WIDTH = 60;
	static final int COLLECTOR_HEIGHT = 30;
	static final int BALL_DIAM = 25;

	Thread gameThread;
    Ball ball;
    Collector collector;
	Score score;
    Image image;
	Graphics graphics;
	Image background;
	Random random;
	boolean running = true;

	GamePanel() {
        
		newBall();
		newCollector();
		score = new Score(350, 50);
		background = new ImageIcon("wall1.jpg").getImage();
		
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.addKeyListener(new ActionListen());
		this.setFocusable(true);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void newBall() {
		random = new Random();
		int randomBallWidth = random.nextInt(GAME_WIDTH - BALL_DIAM);
		if (randomBallWidth >= GAME_WIDTH - BALL_DIAM / 2) 
			randomBallWidth = randomBallWidth - BALL_DIAM;
		ball = new Ball(randomBallWidth, 0, BALL_DIAM);
	}
	public void newCollector() {
		collector = new Collector((GAME_WIDTH / 2), GAME_HEIGHT - COLLECTOR_HEIGHT, COLLECTOR_WIDTH, COLLECTOR_HEIGHT);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	public void draw(Graphics g) {
		if (running) {
			g.drawImage(background, 0, 0, null);
			collector.draw(g);
			ball.draw(g);
			score.draw(g);
		} else {
			g.drawImage(background, 0, 0, null);
			g.setColor(Color.black);
			g.setFont(new Font("MV Boli", Font.PLAIN, 50));
			g.drawString("GAME OVER", 100, 200);
			g.drawString("Score: " + score.currentScore, 100, 250);
		}
	}
	public void move() {
		collector.move();
		ball.move();
	}
	public void checkCollision() {
		if (ball.y >= GAME_HEIGHT - ball.height) 
			running = false;
       	if (ball.intersects(collector)) {
			score.currentScore++;
			if (score.currentScore % 5 == 0)
				ball.ySpeed++;
			random = new Random();
			int randomBallWidth = random.nextInt(GAME_WIDTH);
			int randomBallImage = random.nextInt(3);
			if (randomBallWidth >= GAME_WIDTH - BALL_DIAM / 2)
				randomBallWidth = randomBallWidth - BALL_DIAM;
			ball.y = 0;
			ball.x = randomBallWidth;
			ball.randomBallImage = randomBallImage;
		}
		if (collector.x <= 0)
			collector.x = 0;
		if (collector.x + collector.width >= GAME_WIDTH) 
			collector.x = GAME_WIDTH - collector.width;
	}
	public void run() {
		long lastTime = System.nanoTime(); 
		double amountOfTics = 60.0;
		double ns = 1000000000 / amountOfTics; 
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}try {
			gameThread.join();
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
	}
	public class ActionListen extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			collector.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			collector.keyReleased(e);
		}
	}
}
