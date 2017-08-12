

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackGroundPane extends JPanel {
	BufferedImage img = null;
	
	protected void paintComponent(Graphics g) {
		try {
			img = ImageIO.read(new File("./img/±³¾°.jpg"));
			if(img != null)
				g.drawImage(img, 0, 0, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}