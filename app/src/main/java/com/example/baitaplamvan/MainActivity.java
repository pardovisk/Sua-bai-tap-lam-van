package com.example.baitaplamvan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtHocSinhViet;
    private EditText edtCoGiaoSua;
    private Button btnNopBai;

    private static final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần
        edtHocSinhViet = findViewById(R.id.edtHocSinhViet);
        edtCoGiaoSua = findViewById(R.id.edtCoGiaoSua);
        btnNopBai = findViewById(R.id.btnNopBai);

        // Xử lý sự kiện khi nhấn nút
        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doanVan = edtHocSinhViet.getText().toString().trim();

                if (!doanVan.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("doanVan", doanVan);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đoạn văn", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Xử lý kết quả trả về từ SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == 88 && data != null) {
                String doanVanDaSua = data.getStringExtra("doanVanDaSua");
                edtCoGiaoSua.setText(doanVanDaSua);
            }
        }
    }
}
