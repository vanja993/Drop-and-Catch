import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle {

	static int X_POSITION;
	static int Y_POSITION;
	int currentScore = 0;

	Score(int x, int y) {
		Score.X_POSITION = x;
		Score.Y_POSITION = y;
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("MV Boli", Font.PLAIN, 20));
		g.drawString("SCORE: " + currentScore,X_POSITION,Y_POSITION);
	}
}
