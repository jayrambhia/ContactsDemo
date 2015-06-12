package com.fenchtose.contactsdemo;

import android.support.v13.app.FragmentPagerAdapter;
import android.app.Fragment;
import android.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay Rambhia on 11/06/15.
 */
public class ContactsPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;

    public ContactsPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
