package id.co.digitalindo.loginregisterandroid;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by nandoseptianhusni on 3/1/18.
 */

//TODO 7 untuk request ke server
interface GitHubService {

    //TODO 8 kirim parameter
    @FormUrlEncoded
    @POST("register.php")
    //TODO 11 get response yang di bkin todo 10
    Call<ResponseRegister> request_regiter(
            //TODO 12 mengirim parameter untuk register ke server
            //note harus sesuai dengan phpnya
            @Field("name")String name ,
            //karena method dia post untuk parameter harus @Field
            @Field("email") String email ,
            @Field("password") String password,
            @Field("mobile") String mobile



    );


    @FormUrlEncoded
    @POST("login.php")

    Call<ResponseRegister> request_login(


            @Field("email") String email ,
            @Field("password") String password



    );
}
