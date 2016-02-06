package robinhu.calories;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    private int act = 0;
    private int amt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.activity_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0 || i == 1) {
                    TextView units = (TextView) findViewById(R.id.activity_units);
                    units.setText("reps");
                } else if (i == 2 || i == 3) {
                    TextView units = (TextView) findViewById(R.id.activity_units);
                    units.setText("minutes");
                }
                act = i;
                calculate();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        EditText amount = (EditText) findViewById(R.id.activity_amount);
        amount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    amt = 0;
                } else {
                    amt = Integer.parseInt(s.toString());
                }
                calculate();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
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

    private void calculate() {
        TextView burned = (TextView) findViewById(R.id.burned);
        TextView alt1 = (TextView) findViewById(R.id.alt1);
        TextView alt2 = (TextView) findViewById(R.id.alt2);
        TextView alt3 = (TextView) findViewById(R.id.alt3);
        if (act == 0) {
            String amt1 = Long.toString(Math.round(100.0 / 350.0 * amt));
            String amt2 = Long.toString(Math.round(200.0 / 350.0 * amt));
            String amt3 = Long.toString(Math.round(10.0 / 350.0 * amt));
            String amt4 = Long.toString(Math.round(12.0 / 350.0 * amt));

            burned.setText(amt1);
            alt1.setText("Situps : " + amt2 + " reps");
            alt2.setText("Jumping Jacks : " + amt3 + " minutes");
            alt3.setText("Jogging : " + amt4 + " minutes");
        } else if (act == 1) {
            String amt1 = Long.toString(Math.round(100.0 / 200.0 * amt));
            String amt2 = Long.toString(Math.round(350.0 / 200.0 * amt));
            String amt3 = Long.toString(Math.round(10.0 / 200.0 * amt));
            String amt4 = Long.toString(Math.round(12.0 / 200.0 * amt));

            burned.setText(amt1);
            alt1.setText("Pushups : " + amt2 + " reps");
            alt2.setText("Jumping Jacks : " + amt3 + " minutes");
            alt3.setText("Jogging : " + amt4 + " minutes");
        } else if (act == 2) {
            String amt1 = Long.toString(Math.round(100.0 / 10.0 * amt));
            String amt2 = Long.toString(Math.round(350.0 / 10.0 * amt));
            String amt3 = Long.toString(Math.round(200.0 / 10.0 * amt));
            String amt4 = Long.toString(Math.round(12.0 / 10.0 * amt));

            burned.setText(amt1);
            alt1.setText("Pushups : " + amt2 + " reps");
            alt2.setText("Situps : " + amt3 + " reps");
            alt3.setText("Jogging : " + amt4 + " minutes");
        } else if (act == 3) {
            String amt1 = Long.toString(Math.round(100.0 / 12.0 * amt));
            String amt2 = Long.toString(Math.round(350.0 / 12.0 * amt));
            String amt3 = Long.toString(Math.round(200.0 / 12.0 * amt));
            String amt4 = Long.toString(Math.round(10.0 / 12.0 * amt));

            burned.setText(amt1);
            alt1.setText("Pushups : " + amt2 + " reps");
            alt2.setText("Situps : " + amt3 + " reps");
            alt3.setText("Jumping Jacks : " + amt4 + " minutes");
        }
    }
}