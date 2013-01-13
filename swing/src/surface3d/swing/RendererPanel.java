package surface3d.swing;

import java.awt.Dimension;
import javax.swing.JPanel;

public class RendererPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -7987320652322203272L;
    private static final int MIN_WIDTH = 640;
    private static final int MIN_HEIGHT = 480;

    public RendererPanel() {
        this.setPreferredSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
    }
}
