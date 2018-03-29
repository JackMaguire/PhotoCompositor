package applications.app_one;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class View {

	// Yikes! This only appears to format correctly on my computer.
	// TODO tabs -> spaces to possibly fix this
	/*   Plan:
	 * 
	 * 		.------------------------------.
	 * 		|Tabs	|												|
	 * 		|-----	|												|
	 * 		|			|				Composite				|
	 * 		|			|				 Picture					|
	 * 		|			|												|
	 * 		|			|												|
	 * 		.------------------------------.
	 * 
	 * 
	 * 	Tabs:
	 * 
	 * 	.-------------.
	 *  |			IO			  |
	 *	  |------------	|
	 *  |	Save File		|
	 *  | Save Session	|
	 *  | Load Session	|
	 * 
	 * 
	 * 	.-----------------.
	 *  |		 Weights 		  |
	 *	  |-----------------	|
	 *  |	Slider for pic1 	|
	 *  |	Slider for pic2 	|
	 *  |	Slider for pic3 	|
	 *  ...
	 *  |	Slider for picN 	|
	 *  | ---
	 *  | JComboBox for Formulas (Linear, exponential decay, etc)
	 *  | Options for Formula
	 *  | "Apply" JButton |
	 * 
	 * 
	 * 	.-------------.
	 * 	|  ImageType  | <- Using JCheckBoxs instead of JComboBox in case two options are compatible
	 * 	|-------------|
	 * 	| JCheckBox for Weighted
	 * 	| JCheckBox for Mean
	 * 	| JCheckBox for RMSF
	 * 
	 */

	// private data
	private final CompositeView composite_view_ = new CompositeView();

	final JTabbedPane tabs = new JTabbedPane();

	public View() {

	}

	private final static class CompositeView extends JPanel {

		// Generated by eclipse
		private static final long serialVersionUID = 6480445680168474579L;

		private BufferedImage image_ = null;

		public CompositeView() {

		}

		public void setImage( BufferedImage image ) {
			image_ = image;
			repaint();
		}

		private double getScale( int panelD, int imageD ) {
			return ( (double) panelD ) / imageD;
		}

		private double getScale( int panel_width, int panel_height, int image_width, int image_height ) {
			return Math.min( getScale( panel_width, image_width ), getScale( panel_height, image_height ) );
		}

		public void paintComponent( Graphics g ) {
			if( image_ == null )
				return;

			super.paintComponent( g );
			Graphics2D g2 = (Graphics2D) g;

			final int image_width = image_.getWidth();
			final int image_height = image_.getHeight();

			final int pane_width = getWidth();
			final int panel_height = getHeight();
		}
	}
}
