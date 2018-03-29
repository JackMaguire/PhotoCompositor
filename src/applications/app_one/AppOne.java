package applications.app_one;

import java.awt.image.BufferedImage;

public class AppOne {

	public static void main(String[] args) {
		BufferedImage[] images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; ++i) {
			images[ i ] = util.PhotoIO.imageFromFile( args[i] );
		}
		
		final Model model = new Model( images );
	}

}
