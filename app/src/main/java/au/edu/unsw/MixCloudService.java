package au.edu.unsw;


import retrofit2.Call;
import retrofit2.http.GET;
// the api endpoint
public interface MixCloudService {
    @GET("search/?q=coding+podcast&amp;type=cloudcast")
    Call<CloudResponse> getCloud();
}
