package nurisezgin.com.spins.date;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by nuri on 10.08.2018
 */
final class DataProvider {

    static final List<String> days(DatePickerConfig config) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, config.getYear());
        calendar.set(Calendar.MONTH, config.getMonth());
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<String> days = new ArrayList<>();

        if (config.getYear() == config.getMaxYear()
                && config.getMonth() == config.getMaxMonth()
                && config.getMaxDay() != 0) {

            maxDay = config.getMaxDay();
        }

        for (int i = 1; i <= maxDay; i++) {
            days.add(String.valueOf(i));
        }

        return days;
    }

    static final List<String> months(DatePickerConfig config) {
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();

        if (config.getYear() == config.getMaxYear() && config.getMaxMonth() != 0) {
            String[] _months = new String[config.getMaxMonth()];
            for (int i = 0; i < config.getMaxMonth(); i++) {
                _months[i] = months[i];
            }

            return Arrays.asList(_months);
        }

        return Stream.of(months)
                .filter(month -> month != null && !month.isEmpty())
                .collect(Collectors.toList());
    }

    static final List<String> years(DatePickerConfig config) {
        List<String> years = new ArrayList<>();
        for (int i = config.getMinYear(); i <= config.getMaxYear(); i++) {
            years.add(String.valueOf(i));
        }

        return years;
    }

}
