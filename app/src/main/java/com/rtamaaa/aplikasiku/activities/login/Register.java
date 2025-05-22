package com.rtamaaa.aplikasiku.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rtamaaa.aplikasiku.R;
import com.rtamaaa.aplikasiku.activities.login.Login;
import com.rtamaaa.aplikasiku.models.ResponseMessage;
import com.rtamaaa.aplikasiku.models.User;
import com.rtamaaa.aplikasiku.network.ApiService;
import com.rtamaaa.aplikasiku.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private EditText etName, etUsername, etPassword, etConfirmPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cardForm), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Nama lengkap wajib diisi");
            etName.requestFocus();
            return;
        }

        if (username.isEmpty()) {
            etUsername.setError("Username wajib diisi");
            etUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password wajib diisi");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password minimal 6 karakter");
            etPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password tidak cocok");
            etConfirmPassword.requestFocus();
            return;
        }

        // Lanjutkan panggil API
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<ResponseMessage> call = apiService.register(new User(name, username, password));

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    if (response.body().isSuccess()) {
                        startActivity(new Intent(Register.this, Login.class));
                        finish();
                    }
                } else {
                    Toast.makeText(Register.this, "Register gagal! " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Toast.makeText(Register.this, "Terjadi kesalahan jaringan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
