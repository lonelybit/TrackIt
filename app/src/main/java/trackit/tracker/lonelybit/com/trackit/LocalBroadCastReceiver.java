package trackit.tracker.lonelybit.com.trackit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LocalBroadCastReceiver extends BroadcastReceiver {
    public LocalBroadCastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        if (Constants.BROADCAST_ACTION.equals(intent.getAction())) {
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            Log.d("LocalBroadCastReceiver", "EXTENDED_DATA_STATUS == " + intent.getStringExtra(Constants.EXTENDED_DATA_STATUS) + " at " + formattedDate);
        }
    }
}
