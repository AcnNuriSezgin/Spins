package nurisezgin.com.spins.date;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;

import com.aigestudio.wheelpicker.WheelPicker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static nurisezgin.com.spins.date.MonthNames.fromMonthName;

/**
 * Created by nuri on 10.08.2018
 */
@RunWith(AndroidJUnit4.class)
public class DatePickerWheelListAdapterTest {

    private Context ctx;
    private DatePickerConfig config;
    
    @Before
    public void setUp_() {
        ctx = InstrumentationRegistry.getTargetContext();
        config = DefaultConfig.newDefaultConfig(ctx);
    }

    @Test
    @UiThreadTest
    public void should_SelectedDayCorrect() {
        final int expected = config.getDay();

        DatePickerWheelListAdapter adapter = new DatePickerWheelListAdapter(config);
        WheelPicker picker = new WheelPicker(ctx);
        adapter.onBindWheelPicker(picker, 0);

        int actual = Integer.parseInt(picker.getSelectedData().toString());
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    @UiThreadTest
    public void should_SelectedMonthCorrect() {
        final int expected = config.getMonth();

        DatePickerWheelListAdapter adapter = new DatePickerWheelListAdapter(config);
        WheelPicker picker = new WheelPicker(ctx);
        adapter.onBindWheelPicker(picker, 1);

        int actual = fromMonthName(picker.getSelectedData().toString());
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    @UiThreadTest
    public void should_SelectedYearCorrect() {
        final int expected = config.getYear();

        DatePickerWheelListAdapter adapter = new DatePickerWheelListAdapter(config);
        WheelPicker picker = new WheelPicker(ctx);
        adapter.onBindWheelPicker(picker, 2);

        int actual = Integer.parseInt(picker.getSelectedData().toString());
        assertThat(actual)
                .isEqualTo(expected);
    }
    
}