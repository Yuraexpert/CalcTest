package com.example.yura.calctest;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    ActionBar.Tab calcTab, funcTab;
    CalcFragment calcFragment = new CalcFragment();
    FuncFragment funcFragment = new FuncFragment();
    TextView calcResField;
    String formula;
    Notation notation;

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
        notation = new Notation();

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

    public void ClearFields(View v) {
        calcFragment.ClearFields(v);
    }
    public void calcField() {
        calcResField = (TextView)findViewById(R.id.calc_results);
        TextView textV = (TextView)findViewById(R.id.calc_text);
        String text = textV.getText().toString();
        setFormula(text);
        prepareFormula();
        notation.setFunc(formula);
        double res = notation.calc(0);
        text+=" = ";
        text+=String.valueOf(res);
        text+="\n";
        calcResField.append(text);
    }

    private void prepareFormula() {
        String updated = this.formula.replaceAll("arcsin", "a");
        updated = updated.replaceAll("arccos", "b");
        updated = updated.replaceAll("arctan", "v");
        updated = updated.replaceAll("sin", "s");
        updated = updated.replaceAll("cos", "c");
        updated = updated.replaceAll("tan", "t");
        setFormula(updated);
    }

    public void setFormula(String text) {
        this.formula = text;
    }
}
