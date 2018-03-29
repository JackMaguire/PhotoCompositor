package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	// Following two methods are thanks to
	// https://stackoverflow.com/questions/15058663/how-to-serialize-an-object-that-includes-bufferedimages

	public static void writeObject( BufferedImage[] images, ObjectOutputStream out ) throws IOException {
		// out.defaultWriteObject();
		out.writeInt( images.length );
		for( BufferedImage eachImage : images ) {
			ImageIO.write( eachImage, "png", out );
		}
	}

	public static BufferedImage[] readObject( ObjectInputStream in ) throws IOException, ClassNotFoundException {
		// in.defaultReadObject();
		final int imageCount = in.readInt();
		BufferedImage[] images = new BufferedImage[ imageCount ];
		for( int i = 0; i < imageCount; i++ ) {
			images[ i ] = ImageIO.read( in );
		}
		return images;
	}

}
