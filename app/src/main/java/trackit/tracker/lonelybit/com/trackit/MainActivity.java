package trackit.tracker.lonelybit.com.trackit;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Timer timer1 = new Timer();



        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer1.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Log.d("MyActivity", "Capturing...");
                        startActionCamera();
                    }
                }, 0, 5000);
            }
        });

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyActivity", "Capturing Stoped!");
                timer1.cancel();
            }
        });



        IntentFilter filterIntent = new IntentFilter();
        filterIntent.addAction(Constants.BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(new LocalBroadCastReceiver(), filterIntent);
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    private void startActionCamera() {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.setAction(Constants.ACTION_START_CAMERA);
        intent.putExtra(Constants.EXTRA_CAMERA_PARAM1, "Parameter 1");
        intent.putExtra(Constants.EXTRA_CAMERA_PARAM2, "Parameter 2");
        startService(intent);
    }
}
