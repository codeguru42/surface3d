/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package codeguru.surface3d;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class Surface3DView extends GLSurfaceView {
    
    private static final int GL_VERSION = 2;
    
    public Surface3DView(Context context) {
        super(context);
        
        this.setEGLContextClientVersion(GL_VERSION);
        this.setRenderer(new Surface3DRenderer());
    }
    
}
