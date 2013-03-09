package com.example.gomianimation;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vibration
		final TextView txtVibration = (TextView) findViewById(R.id.txtVibration);
		final Animation animVibrate = AnimationUtils.loadAnimation(this,  R.anim.shake);

		findViewById(R.id.btnVibration).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txtVibration.startAnimation(animVibrate);
			}
		});
		
		((TextView) findViewById(R.id.current)).setText(String.valueOf(i++));
		// ++i;
		final ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_in));
		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_out));
		findViewById(R.id.btnPush).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (i > 30) {
					viewFlipper.startAnimation(animVibrate);
				} else {
					if (viewFlipper.getDisplayedChild() == 0) {
						((TextView) findViewById(R.id.next)).setText(String.valueOf(i++));
						// ++i;
					} else {
						((TextView) findViewById(R.id.current)).setText(String.valueOf(i++));
						// ++i;
					}
					viewFlipper.showNext();
				}
			}
		});
		
		
	}

}
