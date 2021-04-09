import java.awt.Color;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	MyFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Drop game");
		this.add(new GamePanel());
		this.setResizable(false);
		this.setBackground(Color.cyan);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
