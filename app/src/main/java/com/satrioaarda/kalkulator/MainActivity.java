package com.satrioaarda.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText a, b;
    Button btnpersegi, btnsegitiga, btnlingkaran;
    TextView large, around;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent() {
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        btnpersegi = findViewById(R.id.btnpersegi);
        btnsegitiga = findViewById(R.id.btnsegitiga);
        btnlingkaran = findViewById(R.id.btnlingkaran);
        large = findViewById(R.id.large);
        around = findViewById(R.id.around);

        btnpersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.getText().toString().length() == 0) {
                    a.setError("Silahkan masukkan panjang (CM)");
                } else if (b.getText().toString().length() == 0) {
                    b.setError("Silahkan masukkan lebar (CM)");
                } else {
                    a.setError(null);
                    b.setError(null);

                    Integer length = Integer.parseInt(a.getText().toString());
                    Integer width = Integer.parseInt(b.getText().toString());
                    int large_result = length * width;
                    int around_result = 2 * (length + width);
                    String output = String.valueOf(large_result);
                    String output2 = String.valueOf(around_result);
                    large.setText(output.toString());
                    around.setText(output2.toString());
                }
            }

        });

        btnsegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.getText().toString().length() == 0) {
                    a.setError("Silahkan masukkan alas (CM)");
                } else if (b.getText().toString().length() == 0) {
                    b.setError("Silahkan masukkan tinggi (CM)");
                } else {
                    a.setError(null);
                    b.setError(null);

                    double base = Integer.parseInt(a.getText().toString());
                    double width = Integer.parseInt(b.getText().toString());
                    double large_result = (0.5 * base * width);
                    double side = Math.sqrt(Math.pow(base/2, 2) + Math.pow(width, 2));
                    double around_result = base + (side * 2);
                    String output = String.valueOf(large_result);
                    String output2 = String.valueOf(around_result);
                    large.setText(output.toString());
                    around.setText(output2.toString());
                }
            }
        });
        btnlingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.getText().toString().length() == 0) {
                    a.setError("Silahkan masukkan diameter (CM)");
                } else {
                    a.setError(null);
                    b.setError(null);

                    double phi = 3.14;
                    double diameter = Integer.parseInt(a.getText().toString());
                    double radius = diameter / 2;
                    double large_result = phi * radius * radius;
                    double around_result = phi * diameter;
                    String output = String.valueOf(large_result);
                    String output2 = String.valueOf(around_result);
                    large.setText(output.toString());
                    around.setText(output2.toString());
                }
            }
        });
    }
}
