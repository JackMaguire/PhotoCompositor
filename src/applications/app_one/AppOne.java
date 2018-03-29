package applications.app_one;

import java.awt.image.BufferedImage;

public class AppOne {

	public static void main(String[] args) {
		
		if( args.length < 2 ){
			System.out.println("Every argument should be the path to an image file.");
			return;
		}
		
		BufferedImage[] images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; ++i) {
			images[ i ] = util.PhotoIO.imageFromFile( args[i] );
		}
		
		final Model model = new Model( images );
	}

}
