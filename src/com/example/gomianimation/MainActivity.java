package com.example.gomianimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView txtVibration = (TextView) findViewById(R.id.txtVibration);
		final Animation animVibrate = AnimationUtils.loadAnimation(this,  R.anim.shake);

		findViewById(R.id.btnVibration).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txtVibration.startAnimation(animVibrate);
			}
		});
	}

}
