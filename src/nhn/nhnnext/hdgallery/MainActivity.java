package nhn.nhnnext.hdgallery;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {

	public static int[] showImageIds = new int[] { 0, 0, 0, 0 };
	static int k = 0;
	static ImageView i1, i2, i3, i4;

	public static void addShowImage(int i) {
		if (i != 0) {
			if (showImageIds[0] == 0)
				showImageIds[0] = i;
			else if (showImageIds[1] == 0)
				showImageIds[1] = i;
			else if (showImageIds[2] == 0)
				showImageIds[2] = i;
			else if (showImageIds[3] == 0)
				showImageIds[3] = i;
			else {
				showImageIds[k] = i;
				k = (k + 1) % 4;
			}
		}

		if (showImageIds[0] != 0)
			i1.setBackgroundResource(showImageIds[0]);
		if (showImageIds[1] != 0)
			i2.setBackgroundResource(showImageIds[1]);
		if (showImageIds[2] != 0)
			i3.setBackgroundResource(showImageIds[2]);
		if (showImageIds[3] != 0)
			i4.setBackgroundResource(showImageIds[3]);

	}

	public static boolean isShowImageFull() {
		if (showImageIds[0] != 0 && showImageIds[1] != 0
				&& showImageIds[2] != 0 && showImageIds[3] != 0)
			return true;
		return false;
	}

	ImageView browse;
	ImageView play;
	ImageView help;

	int mem_list;
	int imageIDs[][] = new int[6][5];
	ImageGridAdapter[] adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		i1 = (ImageView) findViewById(R.id.main_img_01);
		i2 = (ImageView) findViewById(R.id.main_img_02);
		i3 = (ImageView) findViewById(R.id.main_img_03);
		i4 = (ImageView) findViewById(R.id.main_img_04);
		
		addShowImage(0);

		adapter = new ImageGridAdapter[6];

		imageIDs[0][0] = R.drawable.src_grid_image_food_01;
		imageIDs[1][0] = R.drawable.src_grid_image_play_01;
		imageIDs[2][0] = R.drawable.src_grid_image_place_01;
		imageIDs[3][0] = R.drawable.src_grid_image_people_01;
		imageIDs[4][0] = R.drawable.src_grid_image_fruits_01;
		imageIDs[5][0] = R.drawable.src_grid_image_apply_01;
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j < 5; j++) {
				imageIDs[i][j] = imageIDs[i][0] + j;
			}
			adapter[i] = null;
		}

		play = (ImageView) findViewById(R.id.main_play_img);
		browse = (ImageView) findViewById(R.id.main_browse_img);
		help = (ImageView) findViewById(R.id.main_help_img);

		play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, PecsActivity.class));
			}
		});

		browse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Dialog dialog = new Dialog(MainActivity.this) {
					ArrayList<String> category = new ArrayList<String>();

					@Override
					protected void onCreate(Bundle savedInstanceState) {
						super.onCreate(savedInstanceState);
						setContentView(R.layout.dialog_browse);
						// Grid Image를 보여줄 리스트 선택지.
						ListView category_list;
						category_list = (ListView) findViewById(R.id.list_category);

						category.add("음식");
						category.add("놀이");
						category.add("장소");
						category.add("사람");
						category.add("과일");
						category.add("기계");

						for (int i = 0; i < 6; i++) {
							adapter[i] = new ImageGridAdapter(getContext(),
									imageIDs[i]);
						}

						setGridImage(0);

						category_list.setAdapter(new ArrayAdapter<String>(
								getContext(),
								android.R.layout.simple_list_item_1, category));

						category_list
								.setOnItemClickListener(new OnItemClickListener() {

									@Override
									public void onItemClick(
											AdapterView<?> arg0, View arg1,
											int arg2, long arg3) {

										setGridImage(arg2);
									}

								});

					}

					private void setGridImage(int i) {
						mem_list = i;
						Log.i("Gallery", "setGridImage : " + i);
						GridView gridViewImages = (GridView) findViewById(R.id.dialog_browse_img_grid);
						adapter[i] = new ImageGridAdapter(getContext(),
								imageIDs[i]);
						gridViewImages.setAdapter(adapter[i]);
						gridViewImages.setOnItemClickListener(new OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int arg2, long arg3) {
								// TODO Auto-generated method stub
								MainActivity.addShowImage(imageIDs[mem_list][arg2]);
							}
						});
					}
				};

				dialog.getWindow().setBackgroundDrawable(
						new ColorDrawable(Color.TRANSPARENT));
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
				dialog.setContentView(R.layout.dialog_browse);
				dialog.show();
			}
		});

		help.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Dialog dialog = new Dialog(MainActivity.this) {

					ArrayList<String> helpCategoryArray = new ArrayList<String>();
					LinearLayout help_category_main_about_pecs;
					LinearLayout help_category_main_how_to_pecs;

					@Override
					protected void onCreate(Bundle savedInstanceState) {
						// TODO Auto-generated method stub
						super.onCreate(savedInstanceState);

						ListView help_category_list;

						help_category_list = (ListView) findViewById(R.id.helpCategoryXml);
						help_category_main_about_pecs = (LinearLayout) findViewById(R.id.dialog_help_content_list_1);
						help_category_main_how_to_pecs = (LinearLayout) findViewById(R.id.dialog_help_content_list_2);

						helpCategoryArray.add("About Pecs");
						helpCategoryArray.add("How to PECS");

						help_category_list.setAdapter(new ArrayAdapter<String>(
								getContext(),
								android.R.layout.simple_list_item_1,
								helpCategoryArray));

						help_category_list
								.setOnItemClickListener(new OnItemClickListener() {
									@Override
									public void onItemClick(
											AdapterView<?> parent, View v,
											int position, long id) {
										// TODO Auto-generated method stub

										if (position == 0) {
											help_category_main_about_pecs
													.setVisibility(View.VISIBLE);
											help_category_main_how_to_pecs
													.setVisibility(View.INVISIBLE);
										}

										if (position == 1) {
											help_category_main_about_pecs
													.setVisibility(View.INVISIBLE);
											help_category_main_how_to_pecs
													.setVisibility(View.VISIBLE);
										}
									}
								});
					}
				};

				dialog.getWindow().setBackgroundDrawable(
						new ColorDrawable(Color.TRANSPARENT));
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
				dialog.setContentView(R.layout.dialog_help);
				dialog.show();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
