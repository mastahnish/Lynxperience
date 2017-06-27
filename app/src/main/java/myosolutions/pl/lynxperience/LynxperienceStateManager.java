package myosolutions.pl.lynxperience;

import android.support.v4.app.FragmentManager;

import myosolutions.pl.lynxperience.fragments.EducationFragment;
import myosolutions.pl.lynxperience.fragments.ExperienceFragment;
import myosolutions.pl.lynxperience.fragments.MapFragment;
import myosolutions.pl.lynxperience.fragments.WelcomeFragment;

/**
 * Created by Jacek on 2017-06-20.
 */

public class LynxperienceStateManager extends BaseStateManager  {

    private static LynxperienceStateManager mInstance;

    private MainState mWelcomeState;
    private ExperienceState mExperienceState;
    private EducationState mEducationState;
    private MapState mMapState;

    private static BaseState mInitialState;


    protected LynxperienceStateManager(FragmentManager fragmentManager) {
        super(fragmentManager);

        if(mWelcomeState == null){
            mWelcomeState = new MainState();
            mExperienceState = new ExperienceState();
            mEducationState = new EducationState();
            mMapState = new MapState();
        }

    }

    @Override
    protected BaseState getInitialState() {
        return mWelcomeState;
    }

    public static BaseState initState(FragmentManager fm) {

        mInstance = new LynxperienceStateManager(fm);
        mInitialState = mInstance.getInitialState();
        if(mInitialState!=null){
            mInitialState.enter();
        }

        return mInitialState;
    }


    private class MainState extends BaseState{
        @Override
        public void enter() {
            addNewFragment(new WelcomeFragment());
        }

        @Override
        public void exit(int event) {

        }

        @Override
        public BaseState nextState(int event) {
            switch(event){
                case EVENT_EDUCATION:

                    return mEducationState;

                case EVENT_EXPERIENCE:

                    return mExperienceState;

                case EVENT_MAP:

                    return mMapState;
                default:
                    return this;

            }

        }
    }

    private class ExperienceState extends BaseState{
        @Override
        public void enter() {
            addNewFragment(new ExperienceFragment());
        }

        @Override
        public void exit(int event) {

        }

        @Override
        public BaseState nextState(int event) {
            switch(event){
                case EVENT_EDUCATION:

                    return mEducationState;

                case EVENT_EXPERIENCE:

                    return mExperienceState;

                case EVENT_MAP:

                    return mMapState;
                default:
                    return this;

            }

        }
    }

    private class EducationState extends BaseState{
        @Override
        public void enter() {
            addNewFragment(new EducationFragment());
        }

        @Override
        public void exit(int event) {

        }

        @Override
        public BaseState nextState(int event) {
            switch(event){
                case EVENT_EDUCATION:

                    return mEducationState;

                case EVENT_EXPERIENCE:

                    return mExperienceState;

                case EVENT_MAP:

                    return mMapState;
                default:
                    return this;
            }

        }
    }

    private class MapState extends BaseState{
        @Override
        public void enter() {
            addNewFragment(new MapFragment());
        }

        @Override
        public void exit(int event) {

        }

        @Override
        public BaseState nextState(int event) {
            switch(event){
                case EVENT_EDUCATION:

                    return mEducationState;

                case EVENT_EXPERIENCE:

                    return mExperienceState;

                case EVENT_MAP:

                    return mMapState;
                default:
                    return this;
            }

        }
    }
}
