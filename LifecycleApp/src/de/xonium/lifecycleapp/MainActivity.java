package de.xonium.lifecycleapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private final String TAG = this.getClass().getSimpleName();
	private final String RESTORE = ", can restore state";
	
	private final String state = "fortytwo";
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String answer = null;
        if (savedInstanceState != null) {
        	answer = savedInstanceState.getString("answer");	
        }
		Log.i(TAG, "onCreate" + (savedInstanceState == null ? "" : (RESTORE + " '" + answer + "'")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Log.i(TAG, "onCreateOptionsMenu");
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
    	Log.i(TAG, "onDestroy " + Integer.toString(getChangingConfigurations(), 16));
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	outState.putString("answer", state);
    	super.onSaveInstanceState(outState);
    	Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public Object onRetainNonConfigurationInstance(){
    	Log.i(TAG, "onRetainNonConfigurationInstance");
    	return Integer.valueOf(getTaskId());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	String answer = savedInstanceState != null ? savedInstanceState.getString("answer") : null;
    	Object old = getLastNonConfigurationInstance();
    	if (old != null) {
    		int oldTaskId = ((Integer) old).intValue();
    		assert oldTaskId == getTaskId();
    	}
    	Log.i(TAG, "onRestoreInstanceState" + (savedInstanceState == null ? "" : (RESTORE + " '" + answer  + "'")));
    }

    // === minor lifecycle calls
    
	@Override
	protected void onPostCreate(Bundle savedState) {
		super.onPostCreate(savedState);
		String answer = savedState != null ? savedState.getString("answer") : null;
		Log.i(TAG, "onPostCreate" + (savedState == null ? "" : (RESTORE + " '" + answer + "'")));
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
