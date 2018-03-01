package id.co.digitalindo.loginregisterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.registerName)
    EditText registerName;
    @BindView(R.id.registerEmail)
    EditText registerEmail;
    @BindView(R.id.registerMobile)
    EditText registerMobile;
    @BindView(R.id.registerPassword)
    EditText registerPassword;
    @BindView(R.id.registerConfirmasi)
    EditText registerConfirmasi;
    @BindView(R.id.buttonSignup)
    Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 1 inject butterknife
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.buttonSignup)
    public void onViewClicked() {

        //TODO 2 ambil inputan user
        String getnama = registerName.getText().toString();
        String getemail = registerEmail.getText().toString();
        String getpassword = registerPassword.getText().toString();
        String confir = registerConfirmasi.getText().toString();
        String mobile = registerMobile.getText().toString();

        //TODO 3 KERJAKAN DI RUMAH UNTUK VALID KOSONG APA ENGGAK

        //TODO 4 INSERT TO SERVER USE RETROFIT LIBRARY


        //TODO 6 configurasi retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ima.jambikota.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        //TODO 13 eksekusi inputan user dengan retrofit
        service.request_regiter(getnama,getemail,getpassword,mobile)
                .enqueue(new Callback<ResponseRegister>() {
                    @Override
                    public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                        Log.d("response : ", response.body().toString());

                        //TODO 14 ambil response json
                        Boolean error = response.body().getError();
                      //  String msg = response.body().getError_msg();
                        //TODO 15
                        if(error){

                            //pindah halaman k login
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else{

                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                            //tmpilin toast isi pesannya dari  msg server
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRegister> call, Throwable t) {

                    }
                });

    }
}
