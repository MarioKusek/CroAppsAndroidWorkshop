package hr.fer.croapps.croappsandroidworkshop;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.LinkedList;
import java.util.List;

import hr.fer.croapps.croappsandroidworkshop.net.ScheduleEntry;


public class ScheduleListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        @SuppressWarnings("unchecked")
        List<ScheduleEntry> schedule = (List<ScheduleEntry>)
                getIntent().getSerializableExtra("scheduleList");

        List<String> mStrings = new LinkedList<String>();
        for(ScheduleEntry entry: schedule) {
            mStrings.add(entry.toString());
        }
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        getListView().setTextFilterEnabled(true);
    }
}
