package nurisezgin.com.spins.date;

import com.aigestudio.wheelpicker.WheelPicker;

import nurisezgin.com.spins.core.WheelListAdapter;

import static nurisezgin.com.spins.date.DataProvider.days;
import static nurisezgin.com.spins.date.DataProvider.months;
import static nurisezgin.com.spins.date.DataProvider.years;

/**
 * Created by nuri on 09.08.2018
 */
final class DatePickerWheelListAdapter implements WheelListAdapter {

    private static final String TAG = "DatePickerWheelListAdap";
    private static final int DATE_SECTION_COUNT = 3;
    private final DatePickerConfig config;

    public DatePickerWheelListAdapter(DatePickerConfig config) {
        this.config = config;
    }

    @Override
    public int getSectionCount() {
        return DATE_SECTION_COUNT;
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
            picker.setDataObserver(() -> picker.setData(days(config)));
            picker.setSelectedData(config.getDay());
        } else if (sectionPosition == 1) {
            picker.addOnItemSelectedListener(new MonthItemSelectedListener());
            picker.setDataObserver(() -> picker.setData(months(config)));
            picker.setSelectedData(MonthNames.toMonthName(config.getMonth()));
        } else {
            picker.addOnItemSelectedListener(new YearItemSelectedListener());
            picker.setDataObserver(() -> picker.setData(years(config)));
            picker.setSelectedData(config.getYear());
        }
    }

    private class DayItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            config.updateDay(Integer.parseInt(data.toString()));
        }
    }

    private class MonthItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            int pos = MonthNames.fromMonthName(data.toString());
            config.updateMonth(pos);
        }
    }

    private class YearItemSelectedListener implements WheelPicker.OnItemSelectedListener {

        @Override
        public void onItemSelected(WheelPicker picker, Object data, int position) {
            config.updateYear(Integer.parseInt(data.toString()));
        }
    }

}
