package com.shixun.model.api;


import com.shixun.model.bean.AddressBean;
import com.shixun.model.bean.AdressSaveBean;
import com.shixun.model.bean.BrandBean;
import com.shixun.model.bean.BrandGoodsBean;
import com.shixun.model.bean.CartBean;
import com.shixun.model.bean.CartGoodsCheckBean;
import com.shixun.model.bean.CartGoodsDeleteBean;
import com.shixun.model.bean.CartGoodsUpdateBean;
import com.shixun.model.bean.IndexBean;
import com.shixun.model.bean.OrderInfoBean;
import com.shixun.model.bean.RegionBean;
import com.shixun.model.bean.RelatedBean;
import com.shixun.model.bean.SortBean;
import com.shixun.model.bean.SortDetailGoodsBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.model.bean.SortGoodsBean;
import com.shixun.model.bean.UserBean;
import com.shixun.model.bean.VerifyBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ShopApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();

    //品牌直供的详情页数据接口
    @GET("brand/detail")
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);

    //品牌直供详情的商品列表数据接口
    @GET("goods/list")
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);

    //获取分类的接口
    @GET("catalog/index")
    Flowable<SortBean> getSort();

    //获取分类页面的商品数据
    @GET("catalog/current")
    Flowable<SortGoodsBean> getCurrentSortData(@Query("id") int id);

    //获取分类详情页的tab数据
    @GET("goods/category")
    Flowable<SortDetailTabBean> getSortDetailTab(@Query("id") int id);

    //获取分类详情页的商品列表数据
    @GET("goods/list")
    Flowable<SortDetailGoodsBean> getSortDetailGoods(@Query("categoryId") int id,@Query("page") int page,@Query("size") int size);

    //商品购买页面的数据接口
    @GET("goods/detail")
    Flowable<RelatedBean> getRelatedData(@Query("id") int id);

    //验证码
    @GET("auth/verify")
    Flowable<VerifyBean> getVerify();

    //登录
    @POST("auth/login")
    @FormUrlEncoded
    Flowable<UserBean> login(@Field("nickname") String nickname,@Field("password") String password);


    //获取购物车的数据
    @GET("cart/index")
    Flowable<CartBean> getCartIndex();

    //购物车商品数据的选中或取消
    @POST("cart/checked")
    @FormUrlEncoded
    Flowable<CartGoodsCheckBean> setCartGoodsCheck(@Field("productIds") String pids,@Field("isChecked") int isChecked);

    //更新商品的数据
    @POST("cart/update")
    @FormUrlEncoded
    Flowable<CartGoodsUpdateBean> updateCartGoods(@Field("productId") String pids,@Field("goodsId") String goodsId, @Field("number") int number,@Field("id") int id);


    //删除商品
    @POST("cart/delete")
    @FormUrlEncoded
    Flowable<CartGoodsDeleteBean> deleteCartGoods(@Field("productIds") String pids);

    //地址列表
    @GET("address/list")
    Flowable<AddressBean> getAddress();

    //保存地址
    @POST("address/save")
    @FormUrlEncoded
    Flowable<AdressSaveBean> saveAdress(@FieldMap Map adressMap);

    //获取省市区的数据
    @GET("region/list")
    Flowable<RegionBean> getRegion(@Query("parentId") int parentId);


    //下单前的订单确认  地址ID+优惠券ID
    @GET("cart/checkout")
    Flowable<OrderInfoBean> getOrderInfo(@Query("addressId") int addressId, @Query("couponId") int couponId);


    //测试传递json数据
    @POST("auth/applogin")
    Call<ResponseBody> applogin(@Body RequestBody body);

    //文件上传 基础地址http://yun918.cn/study/public/html/
    @Multipart
    @POST("file_upload.php")
    Call<ResponseBody> uploadImg(@Part("key") RequestBody param, @Part MultipartBody.Part part);

}
