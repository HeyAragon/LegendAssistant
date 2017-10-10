package com.hackhome.legendassistant.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.bean.NavBean;
import com.hackhome.legendassistant.bean.SlideBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerRecommendComponent;
import com.hackhome.legendassistant.dagger.module.RecommendModule;
import com.hackhome.legendassistant.presenter.RecommendPresenter;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;
import com.hackhome.legendassistant.ui.adapter.RecommendChannelAdapter;
import com.hackhome.legendassistant.ui.adapter.RecommendMultiRecyAdapter;
import com.hackhome.legendassistant.ui.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.IRecommendView {

    @BindView(R.id.recommend_recycler_view)
    RecyclerView mRecommendRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    private RecommendMultiRecyAdapter mRecommendMultiRecyAdapter;

    private View mBannerView, mChannelView;

    private RecyclerView mChannelRecyclerView;

    private LayoutInflater mLayoutInflater;


    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    protected void initData() {
        mPresenter.getRecommendResult("recommend-home-144-page-1");
        mLayoutInflater = LayoutInflater.from(getContext());

        initListener();
    }

    private void initListener() {
//        mRefreshLayout.setO
        //
        //second
    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void showHomeResultBean(HomeResultBean homeResultBean) {
        mRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecommendMultiRecyAdapter = new RecommendMultiRecyAdapter(homeResultBean.getData(), getContext());
        mRecommendRecyclerView.setAdapter(mRecommendMultiRecyAdapter);
        mRecommendMultiRecyAdapter.addHeaderView(loadBannerView(homeResultBean.getSlide()), 0);
        mRecommendMultiRecyAdapter.addHeaderView(loadChannelView(homeResultBean.getNav()), 1);

    }

    public View loadBannerView(List<SlideBean> slideBeans) {

        ArrayList<String> imgUrls = new ArrayList<>();
        for (SlideBean slideBean : slideBeans) {
            imgUrls.add(slideBean.getIcon());
        }
        mBannerView = mLayoutInflater.inflate(R.layout.home_item_banner, null);
        Banner banner = mBannerView.findViewById(R.id.home_item_banner);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImageLoader(new FrescoImageLoader());
        banner.setImages(imgUrls);
        banner.start();
        return mBannerView;
    }

    public View loadChannelView(List<NavBean> navBeans) {
        mChannelView = mLayoutInflater.inflate(R.layout.home_item_channel, null);
        mChannelRecyclerView = mChannelView.findViewById(R.id.home_item_channel_recycler_view);
        mChannelRecyclerView.setNestedScrollingEnabled(false);
        mChannelRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mChannelRecyclerView.setAdapter(new RecommendChannelAdapter(navBeans));
        return mChannelView;
    }

    public class FrescoImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Uri uri = Uri.parse((String) path);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;
            simpleDraweeView.setImageURI(uri);

        }

        @Override
        public ImageView createImageView(Context context) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }

    }

}
