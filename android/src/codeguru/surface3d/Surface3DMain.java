/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package codeguru.surface3d;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class Surface3DMain extends Activity {

    private GLSurfaceView glView = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.glView = new Surface3DView(this);
        this.setContentView(glView);
    }
}
