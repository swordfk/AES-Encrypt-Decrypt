package com.example.aesprogram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private RadioGroup status;
    private RadioButton radioEnkrip, radioDekrip;
    private EditText hasil;
    private Button proses;
    aes AES = new aes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        hasil = findViewById(R.id.textView);
        status = findViewById(R.id.radio_status1);
        proses = findViewById(R.id.btn_proses);
        radioEnkrip = findViewById(R.id.radio_encrypt);
        radioDekrip = findViewById(R.id.radio_decrypt);

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(radioEnkrip.isChecked()){
                   try {
                       hasil.setText(AES.doEncrypt(text.getText().toString()));
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }else if (radioDekrip.isChecked()){
                   try {
                       hasil.setText(AES.doDecrypt(text.getText().toString()));
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
            }
        });
    }

}
