package nurisezgin.com.spins.date;

import com.aigestudio.wheelpicker.WheelPicker;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import nurisezgin.com.spins.core.WheelListAdapter;

/**
 * Created by nuri on 09.08.2018
 */
public class DatePickerWheelListAdapter implements WheelListAdapter {

    private final DatePickerConfig config;

    public DatePickerWheelListAdapter(DatePickerConfig config) {
        this.config = config;
    }

    @Override
    public int getSectionCount() {
        return 3;
    }

    @Override
    public void onBindWheelPicker(WheelPicker picker, int sectionPosition) {
        picker.setAtmospheric(true);
        picker.setCyclic(true);
        picker.setCurved(true);
        picker.setItemTextColor(config.getTextColor());
        picker.setSelectedItemTextColor(config.getSelectedTextColor());
        picker.setItemTextSize(config.getTextSize());

        if (sectionPosition == 0) {
            picker.addOnItemSelectedListener(new DayItemSelectedListener());
            picker.setDataObserver(() -> picker.setData(days()));
            picker.setSelectedItemPosition(config.getDay() - 1);
        } else if (sectionPosition == 1) {
            picker.addOnItemSelectedListener(new MonthItemSelectedListener());
            picker.setDataObserver(() -> picker.setData(months()));
            picker.setSelectedItemPosition(config.getMonth() - 1);
        } else {
            picker.addOnItemSelectedListener(new YearItemSelectedListener());
            picker.setDataObserver(() -> picker.setData(years()));
            picker.setSelectedItemPosition(config.getYear() - 1);
        }
    }

    private List<String> days() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, config.getYear());
        calendar.set(Calendar.MONTH, config.getMonth());
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<String> days = new ArrayList<>();

        if (config.getYear() == config.getMaxYear() && config.getMonth() + 1 == config.getMaxMonth()) {
            maxDay = config.getMaxDay();
        }

        for (int i = 1; i <= maxDay; i++) {
            days.add(String.valueOf(i));
        }

        return days;
    }

    private List<String> months() {
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();
        if (config.getYear() == config.getMaxYear()) {
            String[] _months = new String[config.getMaxMonth()];
            for (int i = 0; i < config.getMaxMonth(); i++) {
                _months[i] = months[i];
            }

            return Arrays.asList(_months);
        }
        return Arrays.asList(symbols.getMonths());
    }

    private List<String> years() {
        List<String> years = new ArrayList<>();
        for (int i = config.getMinYear(); i <= config.getMaxYear(); i++) {
            years.add(String.valueOf(i));
        }

        return years;
    }

    private class DayItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            config.updateDay(picker.getCurrentItemPosition());
        }
    }

    private class MonthItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            config.updateMonth(picker.getCurrentItemPosition());
        }
    }

    private class YearItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            config.updateYear(Integer.parseInt(data.toString()));
        }
    }
}
