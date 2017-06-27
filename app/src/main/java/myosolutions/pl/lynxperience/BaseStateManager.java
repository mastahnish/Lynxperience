package myosolutions.pl.lynxperience;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by Jacek on 2017-06-06.
 */

public abstract class BaseStateManager {

    private static final String TAG = BaseStateManager.class.getSimpleName();

    public static final int EVENT_EXPERIENCE = 11;
    public static final int EVENT_EDUCATION = 12;
    public static final int EVENT_MAP = 13;
    public static final int EVENT_FINISH = 99;



    private FragmentManager mFragmentManager;

    protected FinishProcessState mFinishProcessState;

    protected BaseStateManager(FragmentManager fragmentManager){
        mFragmentManager = fragmentManager;
        if(mFinishProcessState == null) {
            mFinishProcessState = new FinishProcessState();
        }
    }

    protected void addNewFragment(Fragment fragment) {
        addFragment(fragment, new Bundle());
    }

    public void addNewFragment(Fragment fragment, Bundle bundle) {
        addFragment(fragment, bundle == null ? new Bundle() : bundle);
    }

    private void addFragment(Fragment fragment, Bundle bundle) {
        Fragment oldFragment = getCurrentFragment();
        Log.d(TAG, "addFramgment oldfragment is null " + String.valueOf(oldFragment == null));
        if (oldFragment == null) {
            fragment.setArguments(bundle);
            mFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        } else {
            fragment.setArguments(bundle);
            mFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }


    protected abstract BaseState getInitialState();

    protected Fragment getCurrentFragment() {
        return mFragmentManager.findFragmentById(R.id.fragment_container);
    }

    public abstract class BaseState {

        public abstract void enter();

        public abstract void exit(int event);

        public abstract BaseState nextState(int event);

        public BaseState processState(int event) {
            BaseState newState = nextState(event);
            exit(event);
            newState.enter();
            return newState;
        }

    }


    protected class FinishProcessState extends BaseState {

        @Override
        public void enter() {
            Fragment fragment = getCurrentFragment();
            fragment.getActivity().finish();
        }

        @Override
        public void exit(int event) {
            throw new UnsupportedOperationException();
        }

        @Override
        public BaseState nextState(int event) {
            throw new UnsupportedOperationException();
        }

    }

    public interface IStateChangeListener {
        BaseStateManager.BaseState processState(int event);
    }

}
