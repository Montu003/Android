package  com.example.vegiapp.api

import com.app.share.model.HomePage
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST(Const.HOME_PAGE)
    fun homePage(
        @Header(Const.APIKEY) apiKey: String?,
    ): Single<HomePage?>?

//    @POST(Const.GET_CATEGORY)
//    fun getCategoryList(
//        @Header(Const.APIKEY) apiKey: String?,
//    ): Single<CategoryPage?>?
//
//    @FormUrlEncoded
//    @POST(Const.SEARCH_PRODUCT)
//    fun searchProduct(
//        @Header(Const.APIKEY) apiKey: String?,
//        @Field("count") count: Int?
//    ): Single<SearchPage?>?
//
//    @FormUrlEncoded
//    @POST(Const.GET_PRODUCT)
//    fun getProductById(
//        @Header(Const.APIKEY) apiKey: String?,
//        @Field("product_id") product_id: Int?
//    ): Single<GetProduct?>?
//
//    @Multipart
//    @POST(Const.REGISTER)
//    fun registration(
//        @Header(Const.APIKEY) apiKey: String?,
//        @PartMap hashMap : HashMap<String, RequestBody> ): Single<Register?>?
}