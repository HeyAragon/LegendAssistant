package com.hackhome.legendassistant.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.ui.base.BaseActivity;
import com.hackhome.legendassistant.ui.fragment.CategoryFragment;
import com.hackhome.legendassistant.ui.fragment.DiscoveryFragment;
import com.hackhome.legendassistant.ui.fragment.HomeFragment;
import com.hackhome.legendassistant.ui.fragment.HotFragment;
import com.hackhome.legendassistant.ui.fragment.MineFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_container)
    FrameLayout mContainer;
    @BindView(R.id.main_bottom_bar)
    BottomBar mBottomBar;
    @BindView(R.id.main_tool_bar)
    Toolbar mToolbar;

    private HomeFragment mHomeFragment;
    private HotFragment mHotFragment;
    private CategoryFragment mCategoryFragment;
    private DiscoveryFragment mDiscoveryFragment;
    private MineFragment mMineFragment;

    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//        setSupportActionBar(mToolbar);
    }

    @Override
    public void initData() {
        mHomeFragment = HomeFragment.newInstance();
        mHotFragment = HotFragment.newInstance();
        mCategoryFragment = CategoryFragment.newInstance();
        mDiscoveryFragment = DiscoveryFragment.newInstance();
        mMineFragment = MineFragment.newInstance();

        mFragmentManager = getSupportFragmentManager();

        test();
    }

    @Override
    public void initListener() {

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override

            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        switchFragment(mHomeFragment);
                        Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_hot:
                        switchFragment(mHotFragment);
                        Toast.makeText(MainActivity.this,"hot",Toast.LENGTH_SHORT).show();
                        test();
                        break;
                    case R.id.tab_category:
                        switchFragment(mCategoryFragment);
                        Toast.makeText(MainActivity.this,"category",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_discovery:
                        switchFragment(mDiscoveryFragment);
                        Toast.makeText(MainActivity.this,"discovery",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_mine:
                        switchFragment(mMineFragment);
                        Toast.makeText(MainActivity.this,"mine",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void switchFragment(Fragment fragment) {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }

        if (!fragment.isAdded()) {
            transaction.add(R.id.main_container, fragment);
        } else {
            transaction.show(fragment);
        }

        transaction.commit();

        mCurrentFragment = fragment;

    }

    public void test() {
        String test = "\\u65b9\\u4fbf\\u597d";


        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

            while((i=test.indexOf("\\u", pos)) != -1){
            Log.i("aragon", "test: i=" + i);
            sb.append(test.substring(pos, i));
            if(i+5 < test.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(test.substring(i+2, i+6), 16));
            }
        }
        String s = sb.toString();
        Log.i("aragon", "test:s=" + s);
    }
}
