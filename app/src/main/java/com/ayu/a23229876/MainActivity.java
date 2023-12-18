package com.ayu.a23229876;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private EditText edtWidth, edtHeight, edtLength;
    private TextView tvResult;

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    edtHeight = findViewById(R.id.edt_height);
    edtLength = findViewById(R.id.edt_length);
    edtWidth = findViewById(R.id.edt_width);
    Button btnCalculate = findViewById(R.id.btn_calculate);
    tvResult = findViewById(R.id.tv_result);
    btnCalculate.setOnClickListener(this);
}
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputLength) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }

        }
    }
}

