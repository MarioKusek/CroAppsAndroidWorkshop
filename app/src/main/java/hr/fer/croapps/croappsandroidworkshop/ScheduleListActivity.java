package hr.fer.croapps.croappsandroidworkshop;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        setListAdapter(new ScheduleListAdapter(this, schedule));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        Object o = this.getListAdapter().getItem(position);
        ScheduleEntry entry = (ScheduleEntry) o;

        String action = "hr.fer.projekt.android.contacts.map.ROOM";
        String hotel = "ferdroid://room/" + entry.getRoom();
        Uri data = Uri.parse(hotel);

        Intent intent = new Intent(action, data);
        startActivity(intent);
    }

}
