import com.example.httppostrequest.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("countries")
    fun getCountryList(token:String) : Call<MutableList<Country>>

}