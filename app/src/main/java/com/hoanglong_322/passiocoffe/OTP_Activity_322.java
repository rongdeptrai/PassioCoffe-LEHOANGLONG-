package com.hoanglong_322.passiocoffe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


public class OTP_Activity_322 extends AppCompatActivity {
EditText edt_OTP_322;
TextView txt_sdt_322;
Button btn_otp_322;
String otp_322;
SQLiteDatabase sqLiteDatabase;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p__322);



        edt_OTP_322=findViewById(R.id.txt_OTP);
        mAuth=FirebaseAuth.getInstance();
        txt_sdt_322=findViewById(R.id.txt_phoneNub);
        txt_sdt_322.setText(getIntent().getStringExtra("phone_number"));



        otp_322=getIntent().getStringExtra("vertificationId");
        btn_otp_322=findViewById(R.id.btn_Verify);
        btn_otp_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_OTP_322.getText().toString().isEmpty()) {
                    Toast.makeText(OTP_Activity_322.this,"Nhập mã OTP",Toast.LENGTH_SHORT).show();
                }else if (edt_OTP_322.getText().toString().trim().length()!=6)
                    Toast.makeText(OTP_Activity_322.this,"Mã OTP không đúng",Toast.LENGTH_SHORT).show();
                else {
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otp_322,edt_OTP_322.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (mAuth != null) {
                                try {
                                    sqLiteDatabase=Database.initDatabase(OTP_Activity_322.this,Database.DBNAME);
                                    Cursor cursor=sqLiteDatabase.rawQuery("Select * from User where Phone= ? ", new String[]{txt_sdt_322.getText().toString()+""});
                                    cursor.moveToFirst();
                                    String tmpPhone=cursor.getColumnName(3);
                                    if (tmpPhone.isEmpty()){
                                        Toast.makeText(OTP_Activity_322.this,"Chưa có tài khoản mời đăng ký",Toast.LENGTH_SHORT).show();
                                    }
                                      else {
                                        Toast.makeText(OTP_Activity_322.this,"Xin Chào "+cursor.getString(1),Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(OTP_Activity_322.this, Home_322_Activity.class);
                                        intent.putExtra("phone_number",txt_sdt_322.getText().toString());
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                                catch (Exception e){
                                   Toast.makeText(OTP_Activity_322.this,"chua co tai khoan moi dang ky",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(OTP_Activity_322.this, SignUpActivity_322.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                       else {
                           Toast.makeText(getApplicationContext(),"Đăng Nhập sai",Toast.LENGTH_SHORT).show();
                            }
                        }

                });
    }

}