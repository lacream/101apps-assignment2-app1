package example.of.webview;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends ActionBarActivity {
	
	MediaPlayer music;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("file:///android_asset/jabberwocky.html");
		myWebView.getSettings().setBuiltInZoomControls(true);
		
	}

	@Override
	protected void onResume() {
		music = MediaPlayer.create(this, R.raw.music);
		music.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		music.stop();
		music.release();
		super.onPause();
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}
	
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	WebView myWebView = (WebView) findViewById(R.id.webview);
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void Wikipedia(View view) {
		WebView myWebView = (WebView) findViewById(R.id.webview);
	    myWebView.loadUrl("https://en.wikipedia.org/wiki/Jabberwocky");
	}
	
	public void Image(View view) {
		WebView myWebView = (WebView) findViewById(R.id.webview);
	    myWebView.loadUrl("file:///android_asset/jabberwocky.jpg");
	}
	
}


