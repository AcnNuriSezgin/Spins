package nurisezgin.com.spins.core;

import com.aigestudio.wheelpicker.WheelPicker;

/**
 * Created by nuri on 09.08.2018
 */
public interface WheelListAdapter {

    int getSectionCount();

    void onBindWheelPicker(WheelPicker picker, int sectionPosition);

}
