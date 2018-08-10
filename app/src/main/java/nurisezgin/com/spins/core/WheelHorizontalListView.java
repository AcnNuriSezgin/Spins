package nurisezgin.com.spins.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.aigestudio.wheelpicker.WheelPicker;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;

import java.util.ArrayList;
import java.util.List;

import nurisezgin.com.spins.R;

/**
 * Created by nuri on 09.08.2018
 */
public class WheelHorizontalListView extends LinearLayout {

    private LinearLayout contentView;
    private FrameLayout toolbarContainer;
    private WheelListAdapter adapter;
    private int mToolbarLayoutId = R.layout.view_wheel_toolbar;
    private int mContentHeight;
    private View toolbarView;

    public WheelHorizontalListView(Context context) {
        super(context);
        init(null);
    }

    public WheelHorizontalListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WheelHorizontalListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setOrientation(VERTICAL);

        initDefaults();
        attachParentLayout();
        parseXmlAttributes(attrs);

        initViews();
    }

    private void initDefaults() {
        mToolbarLayoutId = R.layout.view_wheel_toolbar;
        mContentHeight = getContext().getResources()
                .getDimensionPixelSize(R.dimen.wheelPickerView_default_content_height);
    }

    private void attachParentLayout() {
        LayoutInflater.from(getContext())
                .inflate(R.layout.view_wheel_list, this, true);
    }

    private void parseXmlAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.WheelHorizontalListView);

            int contentHeight = arr.getDimensionPixelSize(R.styleable.WheelHorizontalListView_content_height, mContentHeight);
            mContentHeight = contentHeight;

            int toolbarLayout = arr.getResourceId(R.styleable.WheelHorizontalListView_toolbar_layout, 0);
            if (toolbarLayout != 0) {
                mToolbarLayoutId = toolbarLayout;
            }

            arr.recycle();
        }
    }

    private void initViews() {
        contentView = findViewById(R.id.content_view);
        toolbarContainer = findViewById(R.id.toolbar_container);

        toolbarView = LayoutInflater.from(getContext())
                .inflate(mToolbarLayoutId, this, false);

        toolbarContainer.addView(toolbarView);
    }

    public void setAdapter(WheelListAdapter adapter) {
        contentView.removeAllViews();
        this.adapter = adapter;

        for (int i = 0; i < adapter.getSectionCount(); i++) {
            int section = i;
            WheelPicker picker = new WheelPicker(getContext());
            picker.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            adapter.onBindWheelPicker(picker, section);
            contentView.addView(picker);
        }
    }

    public WheelListAdapter getAdapter() {
        return adapter;
    }

    public void clear() {
        Stream.of(getPickers())
                .forEach(picker -> picker.removeAllOnItemSelectedListeners());
    }

    public List<WheelPicker> getPickers() {
        List<WheelPicker> pickers = new ArrayList<>();
        for (int i = 0; i < contentView.getChildCount(); i++) {
            View view = contentView.getChildAt(i);
            if (view instanceof WheelPicker) {
                pickers.add((WheelPicker) view);
            }
        }

        return pickers;
    }

    public View getToolbar() {
        return toolbarView;
    }

    public SelectedValues getSelectedValues() {
        SelectedValues values = new SelectedValues();

        if (adapter == null || adapter.getSectionCount() < 1) {
            return values;
        }

        forEachPicker(picker -> {
            int position = picker.getCurrentItemPosition();
            String data = (String) picker.getData().get(position);

            SelectedValues.SelectedValue value = new SelectedValues.SelectedValue(position, data);
            values.put(position, value);
        });

        return values;
    }

    public void forEachPicker(Consumer<WheelPicker> consumer) {
        for (int i = 0; i < contentView.getChildCount(); i++) {
            View view = contentView.getChildAt(i);
            if (view instanceof WheelPicker) {
                consumer.accept((WheelPicker) view);
            }
        }
    }
}
