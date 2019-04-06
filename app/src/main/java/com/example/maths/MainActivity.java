package com.example.maths;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EquationView equationView;
    private EquationEngine equationEgine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        equationEgine = new EquationEngine();
        this.equationView = equationEgine;

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        refreshEquationViews();
    }

    private void refreshEquationViews() {
        if (equationView != null) {

            TextView equationTextView = findViewById(R.id.equationTextView);
            equationTextView.setText(equationView.getEquationText());

            TextView equationResultView = findViewById(R.id.equationResultView);
            equationResultView.setText(equationView.getEquationResult());

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

    public void onButtonPlus(View view) {
        equationEgine.setEquationType(EquationTypeEnum.plus);
        refreshEquationViews();
    }

    public void onButtonMinus(View view) {
        equationEgine.setEquationType(EquationTypeEnum.minus);
        refreshEquationViews();
    }

    public void onButtonMulti(View view) {
        equationEgine.setEquationType(EquationTypeEnum.multiple);
        refreshEquationViews();
    }

    public void onbuttonDiv(View view) {
        equationEgine.setEquationType(EquationTypeEnum.divide);
        refreshEquationViews();
    }

    public void onScreenTap(View view) {
        equationEgine.process();
        refreshEquationViews();

    }
}
