package com.example.rcjp.myapplicationportfolio;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
*/

    // alternative method of injecting code using Butterknife  from jakewharton.github.io/butterknife
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick_SpotifyStreamerApp(View v) {
        myLaunch(getString(R.string.spotify_toast_text));
    }

    public void onClick_ScoresApp(View v) {
        myLaunch(getString(R.string.scores_toast_text));
    }

    public void onClick_LibraryApp(View v) {
        myLaunch(getString(R.string.library_toast_text));
    }

    // Build_it_bigger and XYZ_reader use alternative Butterknife

    public void onClick_CapstoneApp(View v) {
        myLaunch(getString(R.string.capstone_my_own_app_toast_text));
    }

    private void myLaunch(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }

    // alternative shorter method - uses button text
    public void myLaunch_alt(View view) {
        Button btn = (Button)view;
        Toast.makeText(getApplicationContext(), "Button launches " + (CharSequence) btn.getText(), Toast.LENGTH_SHORT).show();
    }

    // another alternative method using Butterknife from jakewharton.github.io/butterknife  see onCreate above
    @OnClick({R.id.btn_build_it_bigger,R.id.btn_xyz_reader})
    public void showToast(Button btn){
        Toast.makeText(this, String.format("Butterknife Onclick launches %s", btn.getText()), Toast.LENGTH_SHORT).show();
    }
}
