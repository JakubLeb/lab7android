package pbs.edu.lab7;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SensorListAdapter extends ArrayAdapter<Sensor> {

    private final Context context;
    private final List<Sensor> sensors;

    public SensorListAdapter(Context context, List<Sensor> sensors) {
        super(context, R.layout.row_sensor, sensors);
        this.context = context;
        this.sensors = sensors;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.row_sensor, parent, false);
        }

        Sensor sensor = sensors.get(position);

        TextView nameText = row.findViewById(R.id.tvSensorName);
        ImageView icon = row.findViewById(R.id.imgSensorIcon);

        nameText.setText(sensor.getName());
        icon.setImageResource(getIconForSensor(sensor.getType()));

        return row;
    }

    private int getIconForSensor(int type) {
        switch (type) {

            case Sensor.TYPE_ACCELEROMETER:
            case Sensor.TYPE_ACCELEROMETER_UNCALIBRATED:
                return R.drawable.ic_accelerometer;

            case Sensor.TYPE_GYROSCOPE:
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                return R.drawable.ic_gyroscope;

            case Sensor.TYPE_MAGNETIC_FIELD:
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                return R.drawable.ic_magnetometer;

            case Sensor.TYPE_LIGHT:
                return R.drawable.ic_light_sensor;

            case Sensor.TYPE_PROXIMITY:
                return R.drawable.ic_proximity_sensor;

            case Sensor.TYPE_PRESSURE:
                return R.drawable.ic_barometer;

            case Sensor.TYPE_GRAVITY:
                return R.drawable.ic_gravity;

            case Sensor.TYPE_LINEAR_ACCELERATION:
                return R.drawable.ic_linear_acceleration;

            case Sensor.TYPE_ROTATION_VECTOR:
                return R.drawable.ic_rotation_vector;

            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                return R.drawable.ic_game_rotation;

            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                return R.drawable.ic_geomagnetic_rotation;

            case Sensor.TYPE_ORIENTATION:
                return R.drawable.ic_orientation;

            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return R.drawable.ic_ambient_temperature;

            case Sensor.TYPE_TEMPERATURE:
                return R.drawable.ic_temperature;

            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return R.drawable.ic_humidity;

            case Sensor.TYPE_STEP_COUNTER:
                return R.drawable.ic_step_counter;

            case Sensor.TYPE_STEP_DETECTOR:
                return R.drawable.ic_step_detector;

            case Sensor.TYPE_HEART_RATE:
                return R.drawable.ic_heart_rate;

            case Sensor.TYPE_SIGNIFICANT_MOTION:
                return R.drawable.ic_significant_motion;

            case Sensor.TYPE_MOTION_DETECT:
                return R.drawable.ic_motion_detect;

            case Sensor.TYPE_STATIONARY_DETECT:
                return R.drawable.ic_stationary_detect;

            case Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT:
                return R.drawable.ic_offbody_detect;

            case Sensor.TYPE_POSE_6DOF:
                return R.drawable.ic_pose_6dof;

            case Sensor.TYPE_HINGE_ANGLE:
                return R.drawable.ic_hinge_angle;

            default:
                return R.drawable.ic_sensor;
        }
    }
}