package nhn.nhnnext.hdgallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageGridAdapter extends BaseAdapter {

	Context context;
	int data;
	int[] imageIDs = null;

	public ImageGridAdapter(Context context, int[] imageIDs) {
		this.context = context;
		this.imageIDs = imageIDs;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		Log.i("Gallery", "getCount : " + imageIDs.length);
		return imageIDs.length;

	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if( convertView == null ){
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(150,150));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

//		if (position < imageIDs.length){
//			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), imageIDs[position]);
//			bmp = Bitmap.createScaledBitmap(bmp, 320, 320, false);
//			imageView.setImageBitmap(bmp);
//			
//			imageView.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View view) {
//					// TODO Auto-generated method stub
//					MainActivity.addShowImage(view.getId());
//				}
//			});
//		}
		Log.i("Gallery", "createScale position : " + position);
		Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
				context.getResources(), imageIDs[position]), 100, 100, false);
		imageView.setImageBitmap(bmp);
		data = imageIDs[position];
//		imageView.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				// TODO Auto-generated method stub
//				int p = data;
//				Log.i("Gallery", "showImage + " + data);
//				MainActivity.addShowImage(data);
//			}
//		});
		return imageView;
//		ImageView imageView = null;
//		if( convertView != null ){
//			imageView = (ImageView)convertView;
//			return imageView;
//		}
//		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), imageIDs[position]);
//		bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);
//		
//		Log.i("Gallery", "imageView try");
//		imageView = new ImageView(context);
//		imageView.setAdjustViewBounds(true);
//		imageView.setImageBitmap(bmp);
//		
//		return imageView;
	}

}
