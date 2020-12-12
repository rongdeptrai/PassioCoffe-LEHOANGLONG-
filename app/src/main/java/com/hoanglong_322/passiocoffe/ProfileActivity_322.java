package com.hoanglong_322.passiocoffe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileActivity_322 extends AppCompatActivity {
 private TextView txtfname_322,txtphone_322,txtLogOut_322;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_322);
        txtfname_322=findViewById(R.id.txtFullName);
        txtphone_322=findViewById(R.id.txt_phoneNub);
        txtLogOut_322=findViewById(R.id.txtLogOut);
        txtphone_322.setText(getIntent().getStringExtra("phone_number"));
        txtfname_322.setText(getIntent().getStringExtra("user_name"));
        txtLogOut_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity_322.this, LoginPhone_322_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Toast.makeText(ProfileActivity_322.this, "Đã đăng xuất", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}