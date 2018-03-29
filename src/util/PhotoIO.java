package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PhotoIO {

	public static BufferedImage imageFromFile( String filename ) {
		File img = new File( filename );
		try {
			BufferedImage image = ImageIO.read( img );
			return image;
		}
		catch( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static void imageToFile( BufferedImage image, String filename, String format ) {
		final File outputfile = new File( filename );
		try {
			ImageIO.write( image, format, outputfile );
		}
		catch( IOException e ) {
			System.err.println( "Could not print image to filename: " + filename + " with format: " + format );
			System.err.println( e.getMessage() );
			e.printStackTrace();
		}
	}

}
