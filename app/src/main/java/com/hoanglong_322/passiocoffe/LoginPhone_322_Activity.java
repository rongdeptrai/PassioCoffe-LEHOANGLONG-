package com.hoanglong_322.passiocoffe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginPhone_322_Activity extends AppCompatActivity {
Button btn_OTP_322;
EditText edt_sdt_322;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_322_);
    btn_OTP_322=findViewById(R.id.btn_OTP);
    edt_sdt_322=findViewById(R.id.txt_phoneNub);
    btn_OTP_322.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (edt_sdt_322.getText().toString().trim().isEmpty()){
                Toast.makeText(LoginPhone_322_Activity.this,"Nhập số điện thoại",Toast.LENGTH_SHORT).show();
                return;
            }
            senOTP();
        }
    });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void senOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+84" + edt_sdt_322.getText().toString().trim(),
                60,
                TimeUnit.SECONDS,
                LoginPhone_322_Activity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(LoginPhone_322_Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String vertificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        Intent intent= new Intent(LoginPhone_322_Activity.this,OTP_Activity_322.class);
                        intent.putExtra("phone_number",edt_sdt_322.getText().toString());
                        intent.putExtra("vertificationId",vertificationId);
                        startActivity(intent);
                    }
                }
        );
    }

}