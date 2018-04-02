package util;

public class RMSF {

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

		//Step 2, compare values to mean
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
