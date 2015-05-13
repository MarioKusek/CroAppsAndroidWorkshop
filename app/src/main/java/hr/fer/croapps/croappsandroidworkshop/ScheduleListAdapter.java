package hr.fer.croapps.croappsandroidworkshop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hr.fer.croapps.croappsandroidworkshop.net.ScheduleEntry;

public class ScheduleListAdapter extends BaseAdapter {
    private Activity context;
    private List<ScheduleEntry> schedule;

    public ScheduleListAdapter(Activity context, List<ScheduleEntry> schedule) {
        this.context = context;
        this.schedule = schedule;
    }

    public Activity getContext() {
        return context;
    }

    public List<ScheduleEntry> getSchedule() {
        return schedule;
    }

    @Override
    public int getCount() {
        return schedule.size();
    }

    @Override
    public Object getItem(int position) {
        return schedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.schedule_entry, null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView room = (TextView) convertView.findViewById(R.id.room);

        ScheduleEntry entry = schedule.get(position);
        title.setText(entry.getTitle());
        room.setText(entry.getRoom());

        return convertView;
    }
}
