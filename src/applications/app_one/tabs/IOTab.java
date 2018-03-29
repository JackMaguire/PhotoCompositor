package applications.app_one.tabs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IOTab extends JPanel {

	public final static String NAME = "IO";

	private JButton save_image_button = new JButton("Save Image");
	private JButton save_session_button = new JButton("Save Session");
	private JButton load_session_button = new JButton("Load Session");

	public IOTab() {
		//loading this dynamically to help make this future-proof and to allow for rapid prototyping
		ArrayList<JComponent> elements = new ArrayList<JComponent>();

		elements.add(save_image_button);
		elements.add( new JLabel("") );//just to provide space
		elements.add(save_session_button);
		elements.add(load_session_button);
		
		this.setLayout(new GridLayout(elements.size(), 1));
		for( JComponent element : elements ){
			this.add(element);
		}
		
		//Add action listeners
		save_image_button.addActionListener( new SaveImageButtonListener() );
		save_session_button.addActionListener( new SaveSessionButtonListener() );
		load_session_button.addActionListener( new LoadSessionButtonListener() );
	}

	public final static class SaveImageButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
		}

	}
	
	public final static class SaveSessionButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
		}
		
	}
	
	public final static class LoadSessionButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
		}
		
	}

}
