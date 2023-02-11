import com.example.httppostrequest.model.City
import com.example.httppostrequest.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("countries")
    fun getCountryList(@Header("Authorization")token:String) : Call<MutableList<Country>>

    @GET("states/{con}")
    fun getStateList(@Header("Authorization") token: String,@Path("con") country:String) : Call<MutableList<State>>

    @GET("cities/{city}")
    fun getCityList(@Header("Authorization") token: String, @Path("city") state:String) : Call<MutableList<City>>

}