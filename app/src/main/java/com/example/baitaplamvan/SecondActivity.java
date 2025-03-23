package com.example.baitaplamvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText edtDoanVan;
    private Button btnDaSuaBai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ánh xạ các thành phần
        edtDoanVan = findViewById(R.id.edtDoanVan);
        btnDaSuaBai = findViewById(R.id.btnDaSuaBai);

        final Intent intent = getIntent();

        String doanVan = intent.getStringExtra("doanVan");

        edtDoanVan.setText(doanVan);

        // Xử lý sự kiện khi nhấn nút
        btnDaSuaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doanVanDaSua = edtDoanVan.getText().toString().trim();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("doanVanDaSua", doanVanDaSua);
                setResult(88, resultIntent);
                finish();
            }
        });
    }
}
