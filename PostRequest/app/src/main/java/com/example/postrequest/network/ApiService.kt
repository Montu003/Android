import com.example.postrequest.model.User
import com.example.postrequest.network.callback.RegisterResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("customers/customers")
    fun register(@Body user:User) : Call<RegisterResponse>

    @POST("verify-email")
    fun verifyEmail(@Body json:JsonObject):Call<RegisterResponse>

}