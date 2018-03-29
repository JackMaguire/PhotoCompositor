package applications.app_one.tabs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class IOTab extends JPanel {

	private static final long serialVersionUID = 800357897265322545L;

	public final static String NAME = "IO";

	private JButton save_image_button = new JButton( "Save Image" );
	private JButton save_session_button = new JButton( "Save Session" );
	private JButton load_session_button = new JButton( "Load Session" );

	public IOTab() {
		// loading this dynamically to help make this future-proof and to allow
		// for rapid prototyping
		ArrayList< JComponent > elements = new ArrayList< JComponent >();

		elements.add( save_image_button );
		elements.add( new JLabel( "" ) );// just to provide space
		elements.add( save_session_button );
		elements.add( load_session_button );

		this.setLayout( new GridLayout( elements.size(), 1 ) );
		for( JComponent element : elements ) {
			this.add( element );
		}

		// Add action listeners
		save_image_button.addActionListener( new SaveImageButtonListener() );
		save_session_button.addActionListener( new SaveSessionButtonListener() );
		load_session_button.addActionListener( new LoadSessionButtonListener() );
	}

	public final static class SaveImageButtonListener implements ActionListener {

		private JPanel panel_ = null;

		public SaveImageButtonListener() {

		}

		public SaveImageButtonListener( JPanel panel_to_open_prompt_in ) {
			panel_ = panel_to_open_prompt_in;
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			JFileChooser fc = new JFileChooser();
			// fc.
			if( panel_ != null ) {
				if( fc.showSaveDialog( panel_ ) != JFileChooser.APPROVE_OPTION )
					return;
			} else {
				if( fc.showSaveDialog( new JFrame() ) != JFileChooser.APPROVE_OPTION )
					return;
			}

			File file = fc.getSelectedFile();
			if( file.exists() ) {
				java.awt.Component comp = ( panel_ == null ? new JFrame() : panel_ );
				int result = JOptionPane.showConfirmDialog( comp, "The file exists, overwrite?", "Existing file",
						JOptionPane.YES_NO_CANCEL_OPTION );

				switch ( result ) {
					case JOptionPane.YES_OPTION:
						break;
					case JOptionPane.NO_OPTION:
					case JOptionPane.CLOSED_OPTION:
					case JOptionPane.CANCEL_OPTION:
						return;
				}
			}

			// TODO
			// util.PhotoIO.imageToFile(image, filename, format);
		}

	}

	public final static class SaveSessionButtonListener implements ActionListener {

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO
		}

	}

	public final static class LoadSessionButtonListener implements ActionListener {

		@Override
		public void actionPerformed( ActionEvent e ) {
			JFileChooser fc = new JFileChooser();
			if( fc.showOpenDialog( new JFrame() ) != JFileChooser.APPROVE_OPTION )
				return;
		}

	}

}
