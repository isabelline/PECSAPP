package nhn.nhnnext.hdgallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class PecsSufaceView extends SurfaceView implements Callback{

	private ImageThread thread;
	private boolean mRun = false;
	private SurfaceHolder mSurfaceHolder;
	
	public PecsSufaceView(Context context) {
		super(context);
		mSurfaceHolder = getHolder();
		mSurfaceHolder.addCallback(this);
		thread = new ImageThread(mSurfaceHolder);
		//setBackground(context.getResources().getDrawable(R.drawable.background_landscape));
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		if( thread.getState() == Thread.State.TERMINATED ){
			thread = new ImageThread(holder);
			thread.start();
		}
		else{
			thread.start();
		}
		mRun = true;
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		try{
			thread.join();
		}
		catch(InterruptedException e){}
		mRun = false;
	}
	
	private BitmapDrawable Image = null;
	private Bitmap img_bg = null;
	
	class ImageThread extends Thread{
		public ImageThread(SurfaceHolder surfaceHolder) {
			// TODO Auto-generated constructor stub
			img_bg = InitBackGroundImage(getContext(), 0);
		}
		
		private Bitmap InitBackGroundImage(Context context, int i) {
			// TODO Auto-generated method stub
			Image = (BitmapDrawable)context.getResources().getDrawable(R.drawable.background_landscape);
			return Image.getBitmap();
		}

		private void doDraw(Canvas canvas){
			
		}
		
		@Override
		public void run() {
			while( mRun ){
				Canvas canvas = null;
				try{
					canvas = mSurfaceHolder.lockCanvas();
					synchronized (mSurfaceHolder) {
						sleep(1000);
					}
				}
				catch(Exception e){}
				finally{
					if( canvas != null ){
						mSurfaceHolder.unlockCanvasAndPost(canvas);
					}
				}
			}
		}
	}
}

