package se.romedahl.magnus.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MyMessage";

    EditText tvLength;
    EditText tvWeight;
    TextView tvBMI;
    Button btnCalculate;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find View-elements
        tvLength = (EditText) findViewById(R.id.editLength);
        tvWeight = (EditText) findViewById(R.id.editWeight);
        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        tvBMI = (TextView) findViewById(R.id.textResult);

        Log.i(TAG, "onCreate");
    }


    public void onClickCalculate(View v) {
        double bmi = 0, len = 0, weight = 0;
        String status = "";
        // convert cm to meters
        try {
            len = 0.01 * Double.parseDouble(tvLength.getText().toString());
            weight = Double.parseDouble(tvWeight.getText().toString());
        } catch (Exception e) {
            tvBMI.setText("Försök igen");
        }

        if ((len > 0.1 && len < 3) && (weight > 1 && weight < 1000)) {
            bmi = weight / (len * len);

            if (bmi <= 18.5)
                status = "Undervikt: ";
            else if (bmi <= 24.9)
                status = "Normalvikt: ";
            else if (bmi <= 29.9)
                status = "Övervikt: ";
            else if (bmi <= 34.9)
                status = "Fetma grad 1: ";
            else if (bmi <= 39.9)
                status = "Fetma grad 2: ";
            else if (bmi >= 40)
                status = "Fetma grad 2: ";

            tvBMI.setText(String.format("%s%.2f", status, bmi));

        } else
            tvBMI.setText("Försök igen");
    }


    @Override
    protected void onStart() {
        super.onStart();
        // Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        // Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        // Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Log.i(TAG, "onRestoreInstanceState");
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
}
