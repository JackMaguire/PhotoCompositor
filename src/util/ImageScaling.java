package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageScaling {

	public static BufferedImage scale( BufferedImage in, int width, int height ){
		BufferedImage out = new BufferedImage( width, height, in.getType() );
		Graphics g = out.createGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage( in, 0, 0, width, height, null );
		return out;
	}
	
}
