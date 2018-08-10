package nurisezgin.com.spins.date;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.List;

import nurisezgin.com.spins.R;
import nurisezgin.com.spins.core.WheelHorizontalListView;

import static nurisezgin.com.spins.date.DefaultConfig.newDefaultConfig;

/**
 * Created by nuri on 09.08.2018
 */
public final class DatePicker extends BottomSheetDialogFragment {

    private static final String TAG = "DatePicker";
    public static final int REQUEST_CODE = 0x11;
    private static final String KEY_CONFIG = ":picker_config:";
    private View contentView;
    private WheelHorizontalListView listView;

    public static DatePicker newInstance(Context context) {
        DatePicker picker = new DatePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CONFIG, newDefaultConfig(context));
        picker.setArguments(bundle);
        return picker;
    }

    public static DatePicker newInstance(DatePickerConfig config) {
        DatePicker picker = new DatePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CONFIG, config);
        picker.setArguments(bundle);
        return picker;
    }

    public static DatePicker newInstance(Fragment fragment) {
        DatePicker picker = new DatePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CONFIG, newDefaultConfig(fragment.getActivity()));
        picker.setArguments(bundle);
        picker.setTargetFragment(fragment, REQUEST_CODE);
        return picker;
    }

    public static DatePicker newInstance(Fragment fragment, DatePickerConfig config) {
        DatePicker picker = new DatePicker();
        picker.setTargetFragment(fragment, REQUEST_CODE);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CONFIG, config);
        picker.setArguments(bundle);
        return picker;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getAnyOfListener() == null) {
            throw new IllegalAccessError("DatePicker, You cannot use this dialog without " +
                    "any implemented OnDateSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        contentView = inflater.inflate(
                R.layout.view_date_picker, container, false);

        listView = contentView.findViewById(R.id.date_wheel_list);

        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listView.clear();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getParcelable(KEY_CONFIG) != null) {
            getArguments().putParcelable(KEY_CONFIG, savedInstanceState.getParcelable(KEY_CONFIG));
        }

        DatePickerConfig config = getArguments().getParcelable(KEY_CONFIG);
        updateViewConfigs(config);

        DatePickerWheelListAdapter adapter = new DatePickerWheelListAdapter(config);
        listView.setAdapter(adapter);

        linkPickers();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        DatePickerConfig config = getArguments().getParcelable(KEY_CONFIG);
        outState.putParcelable(KEY_CONFIG, config);
    }

    private void updateViewConfigs(DatePickerConfig config) {
        new DialogViews(config).updateViews(contentView);

        final View toolbar = listView.getToolbar();
        final TextView negativeButton = toolbar.findViewById(R.id.negative_text);
        final TextView positiveButton = toolbar.findViewById(R.id.positive_text);

        negativeButton.setOnClickListener(v -> dismiss());
        positiveButton.setOnClickListener(this::onDateSelected);
    }

    private void onDateSelected(View v) {
        DatePickerConfig config = getArguments().getParcelable(KEY_CONFIG);
        getAnyOfListener().onDateSelected(config.getDay(), config.getMonth(), config.getYear());
    }

    private void linkPickers() {
        List<WheelPicker> pickers = listView.getPickers();
        pickers.get(0).dependsOn(pickers.get(1));
        pickers.get(1).dependsOn(pickers.get(2));
    }

    private OnDateSelectedListener getAnyOfListener() {
        Fragment fragment = getTargetFragment();
        if (fragment != null && fragment instanceof OnDateSelectedListener) {
            return (OnDateSelectedListener) fragment;
        }

        FragmentActivity activity = getActivity();
        if (activity != null && activity instanceof OnDateSelectedListener) {
            return (OnDateSelectedListener) activity;
        }

        return null;
    }

}
