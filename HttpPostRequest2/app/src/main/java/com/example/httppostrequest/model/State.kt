
import com.google.gson.annotations.SerializedName

data class State(

    @SerializedName("state_name")
    var name:String
){
    override fun toString(): String {
        return name
    }
}
