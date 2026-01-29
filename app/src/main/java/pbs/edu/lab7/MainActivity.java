package pbs.edu.lab7;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView listView;
    private Button btnSendSms;

    private List<Sensor> sensorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewSensors);
        btnSendSms = findViewById(R.id.btnSendSms);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Ustaw adapter
        SensorListAdapter adapter = new SensorListAdapter(this, sensorsList);
        listView.setAdapter(adapter);

        btnSendSms.setOnClickListener(v -> sendSensorsAsSms());
    }

    private void sendSensorsAsSms() {
        if (sensorsList.isEmpty()) {
            Toast.makeText(this, "Brak sensorów do wysłania", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder body = new StringBuilder();
        body.append("Lista sensorów urządzenia:\n\n");

        for (int i = 0; i < sensorsList.size(); i++) {
            body.append((i + 1)).append(". ").append(sensorsList.get(i).getName()).append("\n");
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"));
        intent.putExtra("sms_body", body.toString());

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Brak aplikacji SMS", Toast.LENGTH_SHORT).show();
        }
    }
}
