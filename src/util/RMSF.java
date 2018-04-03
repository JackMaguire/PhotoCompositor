package util;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class RMSF {

	// testing
	public static void main( String[] args ) {

		if( args.length < 2 ){
			System.out.println( "Every argument should be a photo filename. RMSF test output will be saved to rmsf_test.png" );
		}
		

		final BufferedImage[] images = new BufferedImage[ args.length ];
		for( int i = 0; i < args.length; ++i ) {
			images[ i ] = PhotoIO.imageFromFile( args[ i ] );
		}

		final int width = images[ 0 ].getWidth();
		
		final BufferedImage rmsf_test = RMSFImage( images, 10 );
		PhotoIO.imageToFile( rmsf_test, "rmsf_test.png", "PNG" );
	}

	public static BufferedImage RMSFImage( final BufferedImage[] images, double scale ) {

		final int width = images[ 0 ].getWidth();
		final int height = images[ 1 ].getHeight();

		BufferedImage rmsf_image = new BufferedImage( width, height, images[ 0 ].getType() );
		int[][] colors = new int[ images.length ][ 3 ];// reuse this for each i & j

		for( int i = 0; i < width; ++i ) {
			for( int j = 0; j < height; ++j ) {

				for( int k = 0; k < images.length; ++k ) {
					Color color = new Color( images[ k ].getRGB( i, j ) );
					colors[ k ][ 0 ] = color.getRed();
					colors[ k ][ 1 ] = color.getGreen();
					colors[ k ][ 2 ] = color.getBlue();
				}

				double rmsf = 0;
				try {
					rmsf = calcRMSF( colors );
				}
				catch( ColorParsingException e ) {
					System.err.println( e.getLocalizedMessage() );
					e.printStackTrace();
				}

				final int rgb_value = Math.max( 255, (int) ( scale * 255 * rmsf ) );
				final int hash_code = new Color( rgb_value, rgb_value, rgb_value ).hashCode();
				rmsf_image.setRGB( i, j, hash_code );
			} // j
		} // i

		return rmsf_image;
	}

	// Root Mean Square Fluctuation
	public static double calcRMSF( int[][] colors ) throws ColorParsingException {
		// colors from img.getRGB( i, j );

		// Step 1, calculate mean
		double R = 0;
		double G = 0;
		double B = 0;

		for( int[] color : colors ) {
			if( color.length != 3 ) {
				throw new ColorParsingException(
						"calcRMSF is given a color with " + color.length + " elements instead of 3 (RGB)." );
			}

			R += color[ 0 ];
			G += color[ 1 ];
			B += color[ 2 ];
		}

		R /= colors.length;
		G /= colors.length;
		B /= colors.length;
		// (R,G,B) is now the average color

		// Step 2, compare values to mean
		double rmsf = 0;

		for( int[] color : colors ) {
			final double R_diff = Math.abs( R - color[ 0 ] );
			final double G_diff = Math.abs( G - color[ 1 ] );
			final double B_diff = Math.abs( B - color[ 2 ] );

			// Logical Math:
			// final double distance_from_mean = Math.sqrt( R_diff * R_diff + G_diff *
			// G_diff + B_diff * B_diff );
			// rmsf += Math.pow( distance_from_mean, 2 );

			// But it can be shorter because
			// pow( sqrt( x ), 2 ) == x

			rmsf += ( R_diff * R_diff ) + ( G_diff * G_diff ) + ( B_diff * B_diff );
		}

		return Math.sqrt( rmsf );
	}

	private final static class ColorParsingException extends Exception {

		private static final long serialVersionUID = -2677711586289290931L;

		public ColorParsingException( String message ) {
			super( message );
		}
	}

}
