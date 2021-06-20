package com.example.a23_18079261_phungkhanhtoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    TextView plemail, plpassword;
    Button btnlogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        plemail = findViewById(R.id.plemail);
        plpassword = findViewById(R.id.plpassword);
        btnlogin = findViewById(R.id.btnlogin);

        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = plemail.getText().toString();
                String password = plpassword.getText().toString();
                DangNhap(email, password);

            }
        });

    }

    private void DangNhap(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(login.this, MainActivity.class);
                            intent.putExtra("authen",email);
                            startActivity(intent);
                            Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
