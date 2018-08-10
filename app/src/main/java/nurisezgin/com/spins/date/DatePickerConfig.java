package nurisezgin.com.spins.date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nuri on 09.08.2018
 */
final class DatePickerConfig implements Parcelable {

    private final int toolbarButtonColor;
    private final int toolbarBackgroundColor;
    private final int toolbarPadding;
    private final int dividerColor;
    private final int dividerHeight;
    private final int textColor;
    private final int selectedTextColor;
    private final int textSize;
    private int day;
    private int month;
    private int year;
    private final int maxYear;
    private final int minYear;
    private final int maxMonth;
    private final int maxDay;

    private DatePickerConfig(int toolbarButtonColor, int toolbarBackgroundColor, int toolbarPadding,
                             int dividerColor, int dividerHeight, int textColor,
                             int selectedTextColor, int textSize, int day, int month, int year,
                             int maxYear, int minYear, int maxMonth, int maxDay) {

        this.toolbarButtonColor = toolbarButtonColor;
        this.toolbarBackgroundColor = toolbarBackgroundColor;
        this.toolbarPadding = toolbarPadding;
        this.dividerColor = dividerColor;
        this.dividerHeight = dividerHeight;
        this.textColor = textColor;
        this.selectedTextColor = selectedTextColor;
        this.textSize = textSize;
        this.day = day;
        this.month = month;
        this.year = year;
        this.maxYear = maxYear;
        this.minYear = minYear;
        this.maxMonth = maxMonth;
        this.maxDay = maxDay;
    }

    protected DatePickerConfig(Parcel in) {
        toolbarButtonColor = in.readInt();
        toolbarBackgroundColor = in.readInt();
        toolbarPadding = in.readInt();
        dividerColor = in.readInt();
        dividerHeight = in.readInt();
        textColor = in.readInt();
        selectedTextColor = in.readInt();
        textSize = in.readInt();
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
        maxYear = in.readInt();
        minYear = in.readInt();
        maxMonth = in.readInt();
        maxDay = in.readInt();
    }

    public void updateYear(int year) {
        this.year = year;
    }

    public void updateMonth(int month) {
        this.month = month;
    }

    public void updateDay(int day) {
        this.day = day;
    }

    public static final Creator<DatePickerConfig> CREATOR = new Creator<DatePickerConfig>() {
        @Override
        public DatePickerConfig createFromParcel(Parcel in) {
            return new DatePickerConfig(in);
        }

        @Override
        public DatePickerConfig[] newArray(int size) {
            return new DatePickerConfig[size];
        }
    };

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(toolbarButtonColor);
        dest.writeInt(toolbarBackgroundColor);
        dest.writeInt(toolbarPadding);
        dest.writeInt(dividerColor);
        dest.writeInt(dividerHeight);
        dest.writeInt(textColor);
        dest.writeInt(selectedTextColor);
        dest.writeInt(textSize);
        dest.writeInt(day);
        dest.writeInt(month);
        dest.writeInt(year);
        dest.writeInt(maxYear);
        dest.writeInt(minYear);
        dest.writeInt(maxMonth);
        dest.writeInt(maxDay);
    }

    public int getToolbarButtonColor() {
        return toolbarButtonColor;
    }

    public int getToolbarBackgroundColor() {
        return toolbarBackgroundColor;
    }

    public int getToolbarPadding() {
        return toolbarPadding;
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public int getDividerHeight() {
        return dividerHeight;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getSelectedTextColor() {
        return selectedTextColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public int getMinYear() {
        return minYear;
    }

    public int getMaxMonth() {
        return maxMonth;
    }

    public int getMaxDay() {
        return maxDay;
    }

    public static class Builder {

        private int toolbarButtonColor;
        private int toolbarBackgroundColor;
        private int toolbarPadding;
        private int dividerColor;
        private int dividerHeight;
        private int textColor;
        private int selectedTextColor;
        private int textSize;
        private int day;
        private int month;
        private int year;
        private int maxYear;
        private int minYear;
        private int maxMonth;
        private int maxDay;

        public Builder toolbarButtonColor(int toolbarButtonColor) {
            this.toolbarButtonColor = toolbarButtonColor;
            return this;
        }

        public Builder toolbarBackgroundColor(int toolbarBackgroundColor) {
            this.toolbarBackgroundColor = toolbarBackgroundColor;
            return this;
        }

        public Builder toolbarPadding(int toolbarPadding) {
            this.toolbarPadding = toolbarPadding;
            return this;
        }

        public Builder dividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        public Builder dividerHeight(int dividerHeight) {
            this.dividerHeight = dividerHeight;
            return this;
        }

        public Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder selectedTextColor(int selectedTextColor) {
            this.selectedTextColor = selectedTextColor;
            return this;
        }

        public Builder textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder day(int day) {
            this.day = day;
            return this;
        }

        public Builder month(int month) {
            this.month = month;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder maxYear(int maxYear) {
            this.maxYear = maxYear;
            return this;
        }

        public Builder minYear(int minYear) {
            this.minYear = minYear;
            return this;
        }

        public Builder maxMonth(int maxMonth) {
            this.maxMonth = maxMonth;
            return this;
        }

        public Builder maxDay(int maxDay) {
            this.maxDay = maxDay;
            return this;
        }

        public DatePickerConfig build() {
            return new DatePickerConfig(toolbarButtonColor, toolbarBackgroundColor,
                    toolbarPadding, dividerColor, dividerHeight,
                    textColor, selectedTextColor, textSize, day, month,
                    year, maxYear, minYear, maxMonth, maxDay);
        }
    }

}
