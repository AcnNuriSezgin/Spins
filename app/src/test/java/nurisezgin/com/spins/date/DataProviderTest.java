package nurisezgin.com.spins.date;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by nuri on 10.08.2018
 */
public class DataProviderTest {

    private DatePickerConfig config;

    @Before
    public void setUp_() {
        config = DefaultConfig.newDefaultConfig(null);
    }

    @Test
    public void should_DaysSizeCorrect() {
        final int expectedSize = 31;

        config.updateYear(2018);
        config.updateMonth(0);
        List<String> days = DataProvider.days(config);

        assertThat(days)
                .hasSize(expectedSize);
    }

    @Test
    public void should_MaxDaySizeCorrect() {
        final int expectedSize = config.getMaxDay();

        config.updateYear(config.getMaxYear());
        config.updateMonth(config.getMaxMonth());
        List<String> days = DataProvider.days(config);

        assertThat(days)
                .hasSize(expectedSize);
    }

    @Test
    public void shouldMonthsSizeCorrect() {
        final int expectedSize = 12;

        config.updateYear(2018);
        List<String> months = DataProvider.months(config);

        assertThat(months)
                .hasSize(expectedSize);
    }

    @Test
    public void should_MaxMonthsSizeCorrect() {
        final int expectedSize = config.getMaxMonth();

        config.updateYear(config.getMaxYear());
        config.updateMonth(config.getMaxMonth());
        List<String> months = DataProvider.months(config);

        assertThat(months)
                .hasSize(expectedSize);
    }

    @Test
    public void should_YearsSizeCorrect() {
        final int expectedSize = config.getMaxYear() - config.getMinYear() + 1;

        List<String> years = DataProvider.years(config);

        assertThat(years)
                .hasSize(expectedSize);
    }

}