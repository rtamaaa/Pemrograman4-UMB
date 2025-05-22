package com.rtamaaa.aplikasiku.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rtamaaa.aplikasiku.R;
import com.rtamaaa.aplikasiku.activities.Dashboard;
import com.rtamaaa.aplikasiku.models.ResponseMessage;
import com.rtamaaa.aplikasiku.models.User;
import com.rtamaaa.aplikasiku.network.ApiService;
import com.rtamaaa.aplikasiku.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvToRegister = findViewById(R.id.tvToRegister);

        btnLogin.setOnClickListener(v -> loginUser());

        tvToRegister.setOnClickListener(v -> {
            //Redirect ke Register
            startActivity(new Intent(Login.this, Register.class));
        });
    }

    private void loginUser() {

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan Password wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<ResponseMessage> call = apiService.login(new User(username, password));

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    if (response.body().isSuccess()) {
                        String name = response.body().getData().getName(); // ambil name dari response

                        Intent intent = new Intent(Login.this, Dashboard.class);
                        intent.putExtra("name", name); // kirim ke Dashboard
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(Login.this, "Login gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Toast.makeText(Login.this, "Terjadi kesalahan jaringan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
