package nurisezgin.com.spins.core;

/**
 * Created by nuri on 10.08.2018
 */
public interface DataObserver {

    void notifyDataSetChanged();

    class Empty implements DataObserver {

        @Override
        public void notifyDataSetChanged() { }
    }
}
