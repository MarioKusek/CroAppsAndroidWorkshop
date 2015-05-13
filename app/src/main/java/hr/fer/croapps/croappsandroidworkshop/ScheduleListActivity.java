package hr.fer.croapps.croappsandroidworkshop;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;


public class ScheduleListActivity extends ListActivity {
    private String[] mStrings = new String[] {"item 1",
            "item 2", "item 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        getListView().setTextFilterEnabled(true);
    }
}
