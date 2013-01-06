package surface3d.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 696144688619726136L;
	private static final int INPUT_COLS = 30;
	
	public InputPanel() {
		this.add(new JLabel("f(x, y) = "));
		this.functionTextField.setColumns(INPUT_COLS);
		this.add(this.functionTextField);
		
		JButton okButton = new JButton("OK");
		this.add(okButton);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				String funcStr = "f(x, y) = " + InputPanel.this.functionTextField.getText();
				
			}
			
		});
	}
	
	private JTextField functionTextField = new JTextField();

}
