package com.fenchtose.contactsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class ContactsActivity extends AppCompatActivity {

    private Fragment mContactsFragment;
    private Fragment mSpeedDialFragment;
    private Fragment mRecentDialFragment;

    private final String CONTACTS_FRAGMENT_KEY = "contacts_fragmnet";
    private final String SPEEDDIAL_FRAGMENT_KEY = "speeddial_fragment";
    private final String RECENTDIAL_FRAGMENT_KEY = "recentdial_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager mViewPager = (ViewPager)findViewById(R.id.viewpager);
        if (mViewPager != null) {
            initializeFragments(savedInstanceState);
            setupViewPager(mViewPager);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        if (mContactsFragment != null) {

            /* Bug? -> https://code.google.com/p/android/issues/detail?id=77285 */
            try {
                getFragmentManager().putFragment(outState, CONTACTS_FRAGMENT_KEY, mContactsFragment);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        if (mRecentDialFragment != null) {
            getFragmentManager().putFragment(outState, RECENTDIAL_FRAGMENT_KEY, mRecentDialFragment);
        }

        if (mSpeedDialFragment != null) {
            getFragmentManager().putFragment(outState, SPEEDDIAL_FRAGMENT_KEY, mSpeedDialFragment);
        }
    }

    private void initializeFragments(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Fragment cFramgnet = getFragmentManager().getFragment(savedInstanceState,
                    CONTACTS_FRAGMENT_KEY);

            if (cFramgnet != null && cFramgnet instanceof ContactsFragment) {
                mContactsFragment = (ContactsFragment)cFramgnet;
            } else {
                mContactsFragment = ContactsFragment.newInstance();
            }

            Fragment sFramgnet = getFragmentManager().getFragment(savedInstanceState,
                    SPEEDDIAL_FRAGMENT_KEY);

            if (sFramgnet != null && sFramgnet instanceof SpeedDialFragment) {
                mSpeedDialFragment = (SpeedDialFragment)sFramgnet;
            } else {
                mSpeedDialFragment = SpeedDialFragment.newInstance();
            }

            Fragment rFramgnet = getFragmentManager().getFragment(savedInstanceState,
                    RECENTDIAL_FRAGMENT_KEY);

            if (rFramgnet != null && rFramgnet instanceof RecentDialFragment) {
                mRecentDialFragment = (RecentDialFragment)rFramgnet;
            } else {
                mRecentDialFragment = RecentDialFragment.newInstance();
            }
        } else {
            mSpeedDialFragment = SpeedDialFragment.newInstance();
            mRecentDialFragment = RecentDialFragment.newInstance();
            mContactsFragment = ContactsFragment.newInstance();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ContactsPagerAdapter mAdapter = new ContactsPagerAdapter(getFragmentManager());
        mAdapter.addFragment(mSpeedDialFragment, "Speed Dial");
        mAdapter.addFragment(mRecentDialFragment, "Recent");
        mAdapter.addFragment(mContactsFragment, "Contacts");
        viewPager.setAdapter(mAdapter);
    }

}
