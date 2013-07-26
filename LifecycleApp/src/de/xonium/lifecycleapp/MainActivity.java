package de.xonium.lifecycleapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
//	private static final String TAG = "MainActivity";

	private final String TAG = this.getClass().getSimpleName();

	// Erste Aenderung nach GIT
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onStart() {
    	super.onStart();
    	Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
    	super.onResume();
    	Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
    	super.onPause();
		Log.i(TAG, "onPause" + (isFinishing() ? " Finishing" : ""));
    }

    @Override
    public void onStop() {
    	super.onStop();
    	Log.i(TAG, "onStop");
    }

    @Override
    public void onRestart() {
    	super.onRestart();
    	Log.i(TAG, "onRestart");
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	Log.i(TAG, "onDestroy");
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	Log.i(TAG, "onRestoreInstanceState");
    }

    // === minor lifecycle calls
    
	@Override
	protected void onPostCreate(Bundle savedState) {
		super.onPostCreate(savedState);
		String answer = null;
		Log.i(TAG, "onPostCreate");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		Log.i(TAG, "onPostResume");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		Log.i(TAG, "onUserLeaveHint");
	}
    
}
