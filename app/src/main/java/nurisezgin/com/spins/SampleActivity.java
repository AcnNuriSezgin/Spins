package nurisezgin.com.spins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import nurisezgin.com.spins.date.DatePicker;
import nurisezgin.com.spins.date.OnDateSelectedListener;

/**
 * Created by nuri on 09.08.2018
 */
public class SampleActivity extends FragmentActivity implements OnDateSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatePicker.newInstance(this)
                .show(getSupportFragmentManager(), "TAG");
    }

    @Override
    public void onDateSelected(int day, int month, int year) {

    }
}
