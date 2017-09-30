package com.hackhome.legendassistant.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerRecommendComponent;
import com.hackhome.legendassistant.dagger.module.RecommendModule;
import com.hackhome.legendassistant.presenter.RecommendPresenter;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;
import com.hackhome.legendassistant.ui.adapter.RecommendMultipleItem;
import com.hackhome.legendassistant.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;


/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.IRecommendView {

    @BindView(R.id.recommend_recycler_view)
    RecyclerView mRecommendRecyclerView;

//    private List<HomeResultBean.DataBean> mData;

    private List<RecommendMultipleItem> mMultiDatas;


    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    protected void initData() {
        mPresenter.getRecommendResult("recommend-home-144-page-1");
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
        Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();

    }



}
