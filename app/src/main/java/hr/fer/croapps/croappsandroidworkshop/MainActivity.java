package hr.fer.croapps.croappsandroidworkshop;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

import hr.fer.croapps.croappsandroidworkshop.net.HttpScheduleReader;
import hr.fer.croapps.croappsandroidworkshop.net.ScheduleEntry;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFetch = (Button) findViewById(R.id.btn_fetch);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SCHEDULE", "Button fetch clicked!");
                fetchData();
            }
        });
    }

    protected void fetchData() {
        AsyncTask<Void, Void, List<ScheduleEntry>> task =
            new AsyncTask<Void, Void, List<ScheduleEntry>>() {
                @Override
                protected List<ScheduleEntry> doInBackground(Void... params) {
                    HttpScheduleReader reader = new HttpScheduleReader();
                    reader.fetchSchedule();
                    return reader.getList();
                }

                @Override
                protected void onPostExecute(List<ScheduleEntry> result) {
                    if(result != null) {
                        Intent intent = new Intent(MainActivity.this, ScheduleListActivity.class);
                        intent.putExtra("scheduleList", (LinkedList<ScheduleEntry>)result);
                        startActivity(intent);
                    }
                }
            };

        task.execute();
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
