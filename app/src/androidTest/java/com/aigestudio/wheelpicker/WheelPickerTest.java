package com.aigestudio.wheelpicker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by nuri on 10.08.2018
 */
@RunWith(AndroidJUnit4.class)
public class WheelPickerTest {

    private Context ctx;
    private WheelPicker picker;

    @Before
    public void setUp_() {
        ctx = InstrumentationRegistry.getTargetContext();
    }

    @Test
    @UiThreadTest
    public void should_SeItemPositionCorrect() {
        final int expected = 3;

        picker = new WheelPicker(ctx);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        picker.setData(list);
        picker.setSelectedItemPosition(expected, false);
        int actual = picker.getSelectedItemPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @UiThreadTest
    public void should_SetSelectedDataCorrect() {
        final int expected = 3;

        picker = new WheelPicker(ctx);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        picker.setData(list);
        picker.setSelectedData(4);
        int actual = picker.getSelectedItemPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @UiThreadTest
    public void should_ObserveDataCorrect() {
        final int expected = 3;
        picker = new WheelPicker(ctx);
        picker.setDataObserver(() -> picker.setData(Arrays.asList(1, 2, 3, 4, 5, 6)));
        picker.setSelectedData(4);

        int actual = picker.getSelectedItemPosition();

        assertThat(actual).isEqualTo(expected);
    }

}