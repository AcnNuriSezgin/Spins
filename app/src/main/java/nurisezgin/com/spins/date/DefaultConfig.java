package nurisezgin.com.spins.date;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;

import java.util.Calendar;
import java.util.Date;

import nurisezgin.com.spins.R;

/**
 * Created by nuri on 09.08.2018
 */
final class DefaultConfig {

    static DatePickerConfig newDefaultConfig(Context context) {
        int toolbarButtonColor = toColor(context, R.color.color_black);
        int toolbarColor = toColor(context, R.color.color_white);
        int dividerColor = toColor(context, R.color.color_white);
        int textColor = toColor(context, R.color.color_gray);
        int selectedTextColor = toColor(context, R.color.color_black);
        int toolbarPadding = toPixel(context, R.dimen.wheelPickerView_default_toolbar_padding);
        int dividerHeight = toPixel(context, R.dimen.wheelPickerView_default_divider_height);
        int textSize = toPixel(context, R.dimen.wheelPickerView_default_text_size);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        return DatePickerConfig.builder().toolbarButtonColor(toolbarButtonColor)
                .toolbarButtonColor(toolbarButtonColor)
                .toolbarBackgroundColor(toolbarColor)
                .toolbarPadding(toolbarPadding)
                .dividerColor(dividerColor)
                .dividerHeight(dividerHeight)
                .textColor(textColor)
                .selectedTextColor(selectedTextColor)
                .textSize(textSize)
                .day(currentDay)
                .month(currentMonth + 1)
                .year(currentYear)
                .maxYear(currentYear + 20)
                .minYear(currentYear - 20)
                .maxMonth(10)
                .maxDay(22)
                .build();
    }

    @ColorInt
    private static int toColor(Context ctx, @ColorRes int resId) {
        try {
            return ContextCompat.getColor(ctx, resId);
        } catch (Exception e) {
            return Color.TRANSPARENT;
        }
    }

    @Px
    private static int toPixel(Context ctx, @DimenRes int resId) {
        try {
            return ctx.getResources().getDimensionPixelSize(resId);
        } catch (Exception e) {
            return 0;
        }
    }

}
