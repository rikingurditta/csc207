package com.group0565.engine.android;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.group0565.engine.android.assets.AndroidGameEngine;
import com.group0565.engine.enums.Orientation;
import com.group0565.engine.gameobjects.GameObject;

public abstract class GameActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private static final String TAG = "GameActivity";
    private Orientation orientation;
    private AndroidGameEngine engine;
    private GameView view = null;
    private GameObject game;
    private int fps;

    public GameActivity(GameObject game) {
        this(game, 60);
    }

    public GameActivity(GameObject game, int fps) {
        this(game, fps, Orientation.Landscape);
    }

    public GameActivity(GameObject game, int fps, Orientation orientation) {
        this.fps = fps;
        this.orientation = orientation;
        this.game = game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(orientation.orientation);
        this.engine = new AndroidGameEngine(game, fps, this.getResources().getAssets());
        this.view = new GameView(this, this, engine.getInputManager());
        setContentView(this.view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            this.engine.start();
        } catch (InterruptedException e) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.engine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.engine.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.engine.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
            this.engine.start();
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * This is called immediately after the surface is first created.
     * Implementations of this should start up whatever rendering code
     * they desire.  Note that only one thread can ever draw into
     * a Surface, so you should not draw into the Surface here
     * if your normal rendering will be in another thread.
     *
     * @param holder The SurfaceHolder whose surface is being created.
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.engine.setSurfaceHolder(holder);
    }

    /**
     * This is called immediately after any structural changes (format or
     * size) have been made to the surface.  You should at this point update
     * the imagery in the surface.  This method is always called at least
     * once, after {@link #surfaceCreated}.
     *
     * @param holder The SurfaceHolder whose surface has changed.
     * @param format The new PixelFormat of the surface.
     * @param width  The new width of the surface.
     * @param height The new height of the surface.
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * This is called immediately before a surface is being destroyed. After
     * returning from this call, you should no longer try to access this
     * surface.  If you have a rendering thread that directly accesses
     * the surface, you must ensure that thread is no longer touching the
     * Surface before returning from this function.
     *
     * @param holder The SurfaceHolder whose surface is being destroyed.
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.engine.setSurfaceHolder(null);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        setRequestedOrientation(orientation.orientation);
    }
}
