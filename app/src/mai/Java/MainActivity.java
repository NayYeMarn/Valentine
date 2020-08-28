package com.mycompany.vday;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.Button;
import android.view.View.*;
import android.media.MediaPlayer;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.*;
import java.util.*;
public class MainActivity extends Activity implements View.OnClickListener
{


	Button b;
	MediaPlayer sound;
	String test="......"+".......";
	int charlength=0;
	TextView textV;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textV = (TextView)findViewById(R.id.nayye);
		textV.setTextSize(17);
		AnimateText(test);
		Toast.makeText(this, "Developed by Nay Ye Marn.", 0).show();

		b = (Button) findViewById(R.id.showLove);
		b.setOnClickListener(this);
		
	}

	
	
	private void AnimateText(final CharSequence text)
	{
		if(charlength<text.length()){
			charlength+=1;
			CharSequence mtext=text.subSequence(0, charlength);
			textV.setText(mtext);
		}
		new Handler().postDelayed(new Runnable(){

				@Override
				public void run()
				{
					AnimateText(text);
				}

			},150);

    }
	
	
	
	public void onClick(View arg0) {
		
		if(sound!=null){
			if(sound.isPlaying()){
				sound.stop();
			}
			sound=MediaPlayer.create(MainActivity.this, R.raw.m1);
			sound.start();
		}
		else{
			sound=MediaPlayer.create(MainActivity.this, R.raw.m1);
			sound.start();}}
		
    public void onBackPressed() {
        
        AlertDialog alert_back = new AlertDialog.Builder(this).create();

        
        alert_back.setTitle("        အမွတ္တရ လက္ေဆာင္");

      
        alert_back.setMessage("ဒီ app ေလးကို သေဘာက်တယ္ဆိုရင္\n\nျကိုက္တယ္ မျကိုက္ဘူး ေျပာခဲ့ပါ\n\nအမွတ္တရ အျဖစ္သိမ္းထားေပးပါ။");

        
        alert_back.setButton("ျကိုက္တယ္", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

					
					MainActivity.this.finish();
					if(sound!=null){
						if(sound.isPlaying()){
							sound.stop();
						}
					}
				}
			});

        
        alert_back.setButton2("မျကိုက္ဘူး", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

					
					dialog.dismiss();
				}
			});

       
        alert_back.show();  
	}
	
}


