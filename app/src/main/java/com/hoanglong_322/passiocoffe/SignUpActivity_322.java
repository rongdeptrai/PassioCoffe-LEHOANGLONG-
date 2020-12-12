package com.hoanglong_322.passiocoffe;


import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity_322 extends AppCompatActivity {
    private Button btn_signup_322;
    private EditText edt_fname_322, edt_sdt_322, edt_email_322;
    SQLiteDatabase sqLiteDatabase;
    private static final String USERS = "users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_322);
        btn_signup_322 = findViewById(R.id.btnRegister);
        edt_email_322 = findViewById(R.id.edt_email);
        edt_fname_322 = findViewById(R.id.edt_full_name);
        edt_sdt_322 = findViewById(R.id.edt_phone);
        edt_sdt_322.setText(getIntent().getStringExtra("phone_number"));
        btn_signup_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            insert();

            }
        });

    }
private void insert(){
    final String fullName = edt_fname_322.getText().toString();
    final String email = edt_email_322.getText().toString().trim();
    final String phoneNum = edt_sdt_322.getText().toString();
    ContentValues contentValues=new ContentValues();
    contentValues.put("UserName",fullName);
    contentValues.put("Email",email);
    contentValues.put("Phone",phoneNum);
    sqLiteDatabase=Database.initDatabase(this,Database.DBNAME);
    sqLiteDatabase.insert("User",null, contentValues);
    Toast.makeText(SignUpActivity_322.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(SignUpActivity_322.this,Home_322_Activity.class);
    intent.putExtra("phone_number",edt_sdt_322.toString().trim());
    startActivity(intent);
}
    private void registerUser() {
        final String fullName = edt_fname_322.getText().toString();
        final String email = edt_email_322.getText().toString().trim();
        final String phoneNum = edt_sdt_322.getText().toString();

        if (fullName.isEmpty()) {
            edt_fname_322.setError("Nhập họ tên");
            edt_fname_322.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            edt_sdt_322.setError("Nhập vào số điện thoại");
            edt_sdt_322.requestFocus();
            return;
        }

        if (phoneNum.isEmpty()) {
            edt_sdt_322.setError("Nhập vào số điện thoại");
            edt_sdt_322.requestFocus();
            return;
        }
    }
}