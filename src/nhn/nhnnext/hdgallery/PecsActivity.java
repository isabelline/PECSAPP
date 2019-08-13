package nhn.nhnnext.hdgallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class PecsActivity extends Activity {
	ImageView img1;
	ImageView img2;
	ImageView img3;
	ImageView img4;
	Animation anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		setContentView(new PecsSufaceView(this));
		setContentView(R.layout.activity_pecs);
		
		img1 = (ImageView)findViewById(R.id.pecs_image_01);
		img1.setBackgroundResource(MainActivity.showImageIds[0]);
		img2 = (ImageView)findViewById(R.id.pecs_image_02);
		img2.setBackgroundResource(MainActivity.showImageIds[1]);
		img3 = (ImageView)findViewById(R.id.pecs_image_03);
		img3.setBackgroundResource(MainActivity.showImageIds[2]);
		img4 = (ImageView)findViewById(R.id.pecs_image_04);
		img4.setBackgroundResource(MainActivity.showImageIds[3]);
		
		anim = AnimationUtils.loadAnimation(this, R.anim.animation);
//		anim.setAnimationListener(new AnimationListener() {
//			
//			@Override
//			public void onAnimationStart(Animation arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onAnimationRepeat(Animation arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onAnimationEnd(Animation arg0) {
//				// TODO Auto-generated method stub
//				//img1.clearAnimation();
//				//img2.clearAnimation();
//				//img3.clearAnimation();
//				//img4.clearAnimation();
//			}
//		});
		anim.setFillAfter(true);
		anim.setFillBefore(true);
		anim.setFillEnabled(true);
		
		img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.clearAnimation();
				img3.clearAnimation();
				img4.clearAnimation();
				img1.startAnimation(anim);
			}
		});
		
		img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img1.clearAnimation();
				img3.clearAnimation();
				img4.clearAnimation();
				img2.startAnimation(anim);
			}
		});
		
		img3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img1.clearAnimation();
				img2.clearAnimation();
				img4.clearAnimation();
				img3.startAnimation(anim);
			}
		});
		
		img4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img1.clearAnimation();
				img2.clearAnimation();
				img3.clearAnimation();
				img4.startAnimation(anim);
			}
		});
	}
}
