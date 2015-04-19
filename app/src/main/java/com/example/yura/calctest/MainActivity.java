package com.example.yura.calctest;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {
    ActionBar.Tab calcTab, funcTab;
    CalcFragment calcFragment = new CalcFragment();
    FuncFragment funcFragment = new FuncFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        calcTab = actionBar.newTab();
        calcTab.setText(R.string.calcTab);
        funcTab = actionBar.newTab();
        funcTab.setText(R.string.graphTab);

        calcTab.setTabListener(new MyTabListener(calcFragment));
        funcTab.setTabListener(new MyTabListener(funcFragment));

        actionBar.addTab(calcTab);
        actionBar.addTab(funcTab);
        if(savedInstanceState != null) {
            int index = savedInstanceState.getInt("TabIndex");
            actionBar.setSelectedNavigationItem(index);
        }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int i = getActionBar().getSelectedNavigationIndex();
        outState.putInt("TabIndex", i);

    }
}
