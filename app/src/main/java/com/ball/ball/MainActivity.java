package com.ball.ball;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	GLSurfaceView mGlSurfaceView;
	Ball mBall;
	private float mPreviousY;
	private float mPreviousX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGlSurfaceView = new GLSurfaceView(this);
		mGlSurfaceView.setEGLContextClientVersion(2);
		mBall = new Ball(this);
		mGlSurfaceView.setRenderer(mBall);
		setContentView(mGlSurfaceView);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		float y = e.getY();
		float x = e.getX();
		switch (e.getAction()) {
		case MotionEvent.ACTION_MOVE:
			float dy = y - mPreviousY;//
			float dx = x - mPreviousX;//�
			mBall.yAngle += dx * 0.3f;//
			mBall.xAngle += dy * 0.3f;//
		}
		mPreviousY = y;//�
		mPreviousX = x;//
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onResume();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onPause();
		}
	}

}
