package nurisezgin.com.spins.date;

import org.junit.Test;

import java.text.DateFormatSymbols;

import static com.google.common.truth.Truth.assertThat;
import static nurisezgin.com.spins.date.MonthNames.UNEXPECTED_MONTH;

/**
 * Created by nuri on 10.08.2018
 */
public class MonthNamesTest {

    @Test
    public void should_FromMonthNameCorrect() {
        final int expected = 1;

        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();
        String firstMonth = months[expected - 1];

        int actual = MonthNames.fromMonthName(firstMonth);

        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void should_FromUnexpectedMonthNameCorrect() {
        final int expected = UNEXPECTED_MONTH;

        int actual = MonthNames.fromMonthName("");

        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void should_ToMonthNameCorrect() {
        int index = 1;

        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();
        final String expected = months[index - 1];

        String actual = MonthNames.toMonthName(index);

        assertThat(actual)
                .isEqualTo(expected);
    }

}