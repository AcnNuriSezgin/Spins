package nurisezgin.com.spins.date;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.text.DateFormatSymbols;
import java.util.List;

/**
 * Created by nuri on 10.08.2018
 */
public class MonthNames {

    static final int UNEXPECTED_MONTH = 1;

    static int fromMonthName(String name) {
        List<String> names = getMonthNames();
        for (int i = 0; i < names.size(); i++) {
            String month = names.get(i);
            if (month.equals(name)) {
                return (i + 1);
            }
        }

        return UNEXPECTED_MONTH;
    }

    static String toMonthName(int pos) {
        return getMonthNames().get(pos - 1);
    }

    static List<String> getMonthNames() {
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();

        return Stream.of(months)
                .filter(month -> month != null && !month.isEmpty())
                .collect(Collectors.toList());
    }
}
