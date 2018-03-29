package applications.app_one;

import java.awt.image.BufferedImage;

public class Model {

	private final BufferedImage[] images_;
	private double[] weights_;

	private final BufferedImage composite_;

	public Model( BufferedImage[] images ) {
		images_ = images;

		// For now, let's assume all pics have the same dimensions
		final int width = images[ 0 ].getWidth();
		final int height = images[ 0 ].getHeight();
		final int type = images[ 0 ].getType();
		composite_ = new BufferedImage( width, height, type, null );

		weights_ = new double[ images.length ];
		for( int i = 0; i < weights_.length; ++i ) {
			weights_[ i ] = 1.0 / ( (double) weights_.length );
		}
	}

	// Protected Getters

	protected BufferedImage[] images() {
		return images_;
	}

	protected double[] weights() {
		return weights_;
	}

	protected BufferedImage composite() {
		return composite_;
	}

}
