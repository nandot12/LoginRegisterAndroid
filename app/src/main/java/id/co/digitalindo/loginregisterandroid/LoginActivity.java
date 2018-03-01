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

public class LoginActivity extends AppCompatActivity {

    Button nando;
    @BindView(R.id.loginEmail)
    EditText loginEmail;
    @BindView(R.id.loginPassword)
    EditText loginPassword;
    @BindView(R.id.buttonSiin)
    Button buttonSiin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSiin)
    public void onViewClicked() {

        if(loginEmail.getText().toString().isEmpty() && loginPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "hei tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else{
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://ima.jambikota.go.id/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubService service = retrofit.create(GitHubService.class);
            service.request_login(loginEmail.getText().toString(),loginPassword.getText().toString())
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
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            }
                            else{

                                startActivity(new Intent(LoginActivity.this,MainActivity.class));

                                //tmpilin toast isi pesannya dari  msg server
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseRegister> call, Throwable t) {

                        }
                    });

        }
    }
}
