package com.hackhome.legendassistant.data;


import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.bean.DataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public interface ApiService {

    public static final String BASE_URL = "http://newsapp.5054399.com/cdn/android/";

    @GET("{home}.htm")
    Observable<BaseBean<BaseResultBean>> getHomeResult(@Path("home") String home);

    /**
     * 首页---->推荐
     * @param home
     * @return
     */
    @GET("{home_recommend}.htm")
    Observable<BaseBean<BaseResultBean>> getRecommendResult(@Path("home_recommend") String home);

    //
    @GET("{home_ranking_list}.htm")
    Observable<BaseBean<BaseResultBean>> getGameInfoResult(@Path("home_ranking_list") String ranking);
//    @GET("{home_ranking_new_list}.htm")
//    Observable<BaseBean<DataBean>> getRankingNewResult(@Path("home_ranking_new_list") String rankingNew);
//    @GET("{home_ranking_new_list}.htm")
//    Observable<BaseBean<DataBean>> getRankingNewResult(@Path("home_ranking_new_list") String rankingNew);


}
