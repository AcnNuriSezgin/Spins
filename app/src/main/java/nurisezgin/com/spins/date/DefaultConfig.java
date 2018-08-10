package nurisezgin.com.spins.date;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.Calendar;
import java.util.Date;

import nurisezgin.com.spins.R;

/**
 * Created by nuri on 09.08.2018
 */
final class DefaultConfig {

    static DatePickerConfig newDefaultConfig(Context context) {
        int toolbarButtonColor = ContextCompat.getColor(context, R.color.color_black);
        int toolbarColor = ContextCompat.getColor(context, R.color.color_white);
        int toolbarPadding = context.getResources()
                .getDimensionPixelSize(R.dimen.wheelPickerView_default_toolbar_padding);
        int dividerColor = ContextCompat.getColor(context, R.color.color_white);
        int dividerHeight = context.getResources()
                .getDimensionPixelSize(R.dimen.wheelPickerView_default_divider_height);
        int textColor = ContextCompat.getColor(context, R.color.color_gray);
        int selectedTextColor = ContextCompat.getColor(context, R.color.color_black);
        int textSize = context.getResources()
                .getDimensionPixelSize(R.dimen.wheelPickerView_default_text_size);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        return DatePickerConfig.builder().toolbarButtonColor(toolbarButtonColor)
                .toolbarBackgroundColor(toolbarColor)
                .toolbarPadding(toolbarPadding)
                .dividerColor(dividerColor)
                .dividerHeight(dividerHeight)
                .textColor(textColor)
                .selectedTextColor(selectedTextColor)
                .textSize(textSize)
                .day(currentDay)
                .month(currentMonth)
                .year(currentYear)
                .maxYear(currentYear + 20)
                .minYear(currentYear - 20)
                .maxMonth(10)
                .maxDay(22)
                .build();
    }

}
