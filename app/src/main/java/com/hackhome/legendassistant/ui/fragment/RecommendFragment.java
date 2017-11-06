package com.hackhome.legendassistant.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.bean.NavBean;
import com.hackhome.legendassistant.bean.SlideBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerRecommendComponent;
import com.hackhome.legendassistant.dagger.module.RecommendModule;
import com.hackhome.legendassistant.presenter.RecommendPresenter;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;
import com.hackhome.legendassistant.ui.adapter.RecommendChannelAdapter;
import com.hackhome.legendassistant.ui.adapter.RecommendMultiRecyAdapter;
import com.hackhome.legendassistant.ui.base.BaseRefreshFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendFragment extends BaseRefreshFragment<RecommendPresenter> implements RecommendContract.IRecommendView{

    private boolean mIsHasMore;
    private int mCurrentPage = 1;
    private View mBannerView, mChannelView;
    private SmartRefreshLayout mRefreshLayout;
    private RecommendMultiRecyAdapter mRecommendMultiRecyAdapter;
    private RecyclerView mChannelRecyclerView,mRecommendRecyclerView;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public void loadData() {
        Log.i("aragon", "RecommendFragment--loadData: ");
        mPresenter.getRecommendResult(mCurrentPage);
    }

    @Override
    protected void initView() {
        mRecommendRecyclerView = getBaseRecyclerView();
        mRefreshLayout = getBaseRefreshLayout();
    }

    @Override
    protected void setListener() {
        mRecommendMultiRecyAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            //如果点击的是刷新icon，则旋转图标，如果为“换一换”，取“换一换”的tag进行旋转，即刷新icon
            if (view.getId() == R.id.home_item_game_from) {
                View refreshIcon = (View) view.getTag();
                refreshIcon.animate().rotation(360).setDuration(500).start();
            } else {
                view.animate().rotation(360).setDuration(500).start();
            }
            mRecommendMultiRecyAdapter.refreshTempItem(new Random().nextInt(10));
            mRecommendMultiRecyAdapter.notifyItemChanged(position+adapter.getHeaderLayoutCount());
        });
    }

    @Override
    public void onRefreshDada() {
        mCurrentPage = 1;
        mPresenter.getRecommendResult(mCurrentPage);
    }

    @Override
    public void onLoadMoreData() {
        if (mIsHasMore) {
            mPresenter.getRecommendResult(mCurrentPage);
        }
    }

    @Override
    public BaseQuickAdapter buildAdapter() {
        mRecommendMultiRecyAdapter = new RecommendMultiRecyAdapter(mContext);
        return mRecommendMultiRecyAdapter;
    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
        Log.i("aragon", "Recommend--setAppComponent: ");
    }


    @Override
    public void showHomeResultBean(BaseResultBean baseResultBean, boolean isFromRefresh) {
//        Log.i("huck", "showHomeResultBean: ");

        if (isFromRefresh) {
            mRecommendMultiRecyAdapter.removeAllHeaderView();
            mRecommendMultiRecyAdapter.addHeaderView(loadBannerView(baseResultBean.getSlide()), 0);
            mRecommendMultiRecyAdapter.addHeaderView(loadChannelView(baseResultBean.getNav()), 1);
            mRecommendMultiRecyAdapter.setNewData(baseResultBean.getData());
        } else {
            mRecommendMultiRecyAdapter.addData(baseResultBean.getData());
        }

        if (getBaseRefreshLayout().isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }

        if (baseResultBean.getNextpage() == 1) {
            ++mCurrentPage;
            mRecommendMultiRecyAdapter.setEnableLoadMore(true);
            mIsHasMore = true;
        } else {
            mIsHasMore = false;
        }

        Log.i("huck", "showHomeResultBean: dataSize="+mRecommendMultiRecyAdapter.getItemCount());
    }


    @Override
    public void loadMoreComplete() {

        mRecommendMultiRecyAdapter.loadMoreComplete();

        if (!mIsHasMore) {
            mRecommendMultiRecyAdapter.loadMoreEnd(false);
        }
    }

    public View loadBannerView(List<SlideBean> slideBeans) {

        ArrayList<String> imgUrls = new ArrayList<>();
        for (SlideBean slideBean : slideBeans) {
            imgUrls.add(slideBean.getIcon());
        }
        mBannerView = mInflater.inflate(R.layout.home_item_banner, null);
        Banner banner = mBannerView.findViewById(R.id.home_item_banner);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImageLoader(new FrescoImageLoader());
        banner.setImages(imgUrls);
        banner.start();
        return mBannerView;
    }

    public View loadChannelView(List<NavBean> navBeans) {
        mChannelView = mInflater.inflate(R.layout.home_item_channel, null);
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
