package nurisezgin.com.spins;

import android.text.TextUtils;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nuri on 09.08.2018
 */
public final class SelectedValues {

    private Map<Integer, SelectedValue> values = new HashMap<>();

    public Map<Integer, SelectedValue> getValues() {
        return values;
    }

    public void put(int position, SelectedValue value) {
        values.put(position, value);
    }

    public static class SelectedValue {

        private final int position;
        private final String data;

        public SelectedValue(int position, String data) {
            this.position = position;
            this.data = data;
        }

        public int getPosition() {
            return position;
        }

        public String getData() {
            return data;
        }
    }

    @Override
    public String toString() {
        List<String> valueText = Stream.of(values)
                .map(entry -> "Pos = " + entry.getKey() + ", Value = " + entry.getValue().getData())
                .collect(Collectors.toList());

        return TextUtils.join(",", valueText);
    }
}
