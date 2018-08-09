package nurisezgin.com.spins;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.List;

/**
 * Created by nuri on 09.08.2018
 */
public abstract class WheelListAdapter {

    private static final String KEY_SECTION_COUNT = ":section_count:";
    private static final String KEY_DATA = ":wheel_data:";

    public abstract int getSectionCount();

    public abstract List<String> getData(int section);

    public abstract void onBindWheelPicker(WheelPicker picker);

}
