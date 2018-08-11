package nurisezgin.com.spins.date;

import android.test.mock.MockContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by nuri on 10.08.2018
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultConfigTest {

    @Mock
    MockContext mockContext;

    @Test
    public void should_DayCorrect() {
        Calendar calendar = Calendar.getInstance();
        int expected = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerConfig config = DefaultConfig.newDefaultConfig(mockContext);
        int actual = config.getDay();

        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void should_MonthCorrect() {
        Calendar calendar = Calendar.getInstance();
        int expected = calendar.get(Calendar.MONTH) + 1;

        DatePickerConfig config = DefaultConfig.newDefaultConfig(mockContext);
        int actual = config.getMonth();

        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void should_YearCorrect() {
        Calendar calendar = Calendar.getInstance();
        int expected = calendar.get(Calendar.YEAR);

        DatePickerConfig config = DefaultConfig.newDefaultConfig(mockContext);
        int actual = config.getYear();

        assertThat(actual)
                .isEqualTo(expected);
    }

}