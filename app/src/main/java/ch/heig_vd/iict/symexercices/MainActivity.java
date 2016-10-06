package ch.heig_vd.iict.symexercices;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import ch.heig_vd.iict.symexercices.fragments.AbstractFragment;
import ch.heig_vd.iict.symexercices.fragments.FragmentExercise1;
import ch.heig_vd.iict.symexercices.fragments.FragmentExercise2;
import ch.heig_vd.iict.symexercices.fragments.FragmentExercise3;
import ch.heig_vd.iict.symexercices.fragments.FragmentExercise3Advanced;

public class MainActivity extends AppCompatActivity implements AbstractFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /*
     *  AbstractFragment.OnFragmentInteractionListener implementation
     */

    @Override
    public void displaySnackBar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] sections = {
                getString(R.string.section_1),
                getString(R.string.section_2),
                getString(R.string.section_3),
                getString(R.string.section_3_adv)
        };

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return AbstractFragment.newInstance(FragmentExercise1.class, sections[position]);
                case 1:
                    return AbstractFragment.newInstance(FragmentExercise2.class, sections[position]);
                case 2:
                    return AbstractFragment.newInstance(FragmentExercise3.class, sections[position]);
                case 3:
                    return AbstractFragment.newInstance(FragmentExercise3Advanced.class, sections[position]);
                default:
                    Log.e(TAG, "Unknown section index");
                    return null;
            }
        }

        @Override
        public int getCount() {
            return sections.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position >= 0 && position < sections.length)
                return sections[position];
            return null;
        }
    }
}
