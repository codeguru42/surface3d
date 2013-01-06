/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */

package surface3d.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Surface3DMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("3D Surface Renderer");
				frame.add(new Surface3DPanel());
				frame.pack();
				frame.setVisible(true);
			}
			
		});
	}

}
