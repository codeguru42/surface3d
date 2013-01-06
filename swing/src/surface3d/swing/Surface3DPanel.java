/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */

package surface3d.swing;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Surface3DPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3588179080443507358L;

	public Surface3DPanel() {
		this.setLayout(new BorderLayout());
		this.add(new RendererPanel(), BorderLayout.CENTER);
		this.add(new InputPanel(), BorderLayout.PAGE_END);
	}
	
}
