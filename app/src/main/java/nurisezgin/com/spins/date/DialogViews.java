package nurisezgin.com.spins.date;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nurisezgin.com.spins.R;
import nurisezgin.com.spins.core.WheelHorizontalListView;

/**
 * Created by nuri on 10.08.2018
 */
public class DialogViews {

    private final DatePickerConfig config;

    public DialogViews(DatePickerConfig config) {
        this.config = config;
    }

    public void updateViews(final View contentView) {
        final WheelHorizontalListView listView = contentView.findViewById(R.id.date_wheel_list);
        final View divider = contentView.findViewById(R.id.divider);
        final View toolbar = listView.getToolbar();
        final View toolbarView = toolbar.findViewById(R.id.toolbar_view);

        modifyToolbar(toolbarView);
        modifyDivider(divider);
        modifyButtons(toolbar);
    }

    private void modifyToolbar(View toolbarView) {
        final int padding = config.getToolbarPadding();
        toolbarView.setPadding(padding, padding, padding, padding);
        toolbarView.setBackgroundColor(config.getToolbarBackgroundColor());
    }

    private void modifyDivider(View divider) {
        divider.setBackgroundColor(config.getDividerColor());
        ViewGroup.LayoutParams lp = divider.getLayoutParams();
        lp.height = config.getDividerHeight();
        divider.setLayoutParams(lp);
    }

    private void modifyButtons(View toolbar) {
        TextView negativeButton = toolbar.findViewById(R.id.negative_text);
        TextView positiveButton = toolbar.findViewById(R.id.positive_text);

        negativeButton.setTextColor(config.getToolbarButtonColor());
        negativeButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.getTextSize());

        positiveButton.setTextColor(config.getToolbarButtonColor());
        positiveButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.getTextSize());
    }
}
