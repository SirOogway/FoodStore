package com.innova.foodstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbFlour, cbCandy, cbToast, cbBread;
    private TextView tvAmountFlour, tvAmountCandy, tvAmountToast, tvAmountBread, tvTotalAmount;
    private int costs[] = new int[4];
    private int amounts[] = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbFlour = (CheckBox) findViewById(R.id.cbFlour);
        cbCandy = (CheckBox) findViewById(R.id.cbCandy);
        cbToast = (CheckBox) findViewById(R.id.cbToast);
        cbBread = (CheckBox) findViewById(R.id.cbBread);

        tvAmountFlour = findViewById(R.id.tvAmountFlour);
        tvAmountCandy = findViewById(R.id.tvAmountCandy);
        tvAmountToast = findViewById(R.id.tvAmountToast);
        tvAmountBread = findViewById(R.id.tvAmountBread);

        tvTotalAmount = findViewById(R.id.tvTotalAmount);

    }

    public void defStateWhenChecked(View view) {
        Boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cbFlour:
                if (checked) {
                    amounts[0] = 1;
                    costs[0] = 2500;
                } else {
                    amounts[0] = 0;
                    costs[0] = 0;
                }
                tvAmountFlour.setText(amounts[0] + "");
                break;

            case R.id.cbCandy:
                if (checked) {
                    amounts[1] = 1;
                    costs[1] = 100;
                } else {
                    amounts[1] = 0;
                    costs[1] = 0;
                }
                tvAmountCandy.setText(amounts[1] + "");
                break;

            case R.id.cbToast:
                if (checked) {
                    amounts[2] = 1;
                    costs[2] = 3000;
                } else {
                    amounts[2] = 0;
                    costs[2] = 0;
                }
                tvAmountToast.setText(amounts[2] + "");
                break;

            case R.id.cbBread:
                if (checked) {
                    amounts[3] = 1;
                    costs[3] = 500;
                } else {
                    amounts[3] = 0;
                    costs[3] = 0;
                }
                tvAmountBread.setText(amounts[3] + "");
                break;
        }
    }

    public void addProduct(View view) {

        switch (view.getId()) {
            case R.id.btnFlourMore:
                if (amounts[0] != 0) {
                    amounts[0] += 1;
                }
                tvAmountFlour.setText(amounts[0] + "");
                break;
            case R.id.btnCandyMore:
                if (amounts[1] != 0) {
                    amounts[1] += 1;
                }
                tvAmountCandy.setText(amounts[1] + "");
                break;
            case R.id.btnToastMore:
                if (amounts[2] != 0) {
                    amounts[2] += 1;
                }
                tvAmountToast.setText(amounts[2] + "");
                break;
            case R.id.btnBreadMore:
                if (amounts[3] != 0) {
                    amounts[3] += 1;
                }
                tvAmountBread.setText(amounts[3] + "");
                break;
        }

    }

    public void substractProduct(View view) {
        switch (view.getId()) {
            case R.id.btnFlourLess:
                if (amounts[0] > 0) {
                    amounts[0] -= 1;
                }
                if (amounts[0] == 0) {
                    cbFlour.setChecked(false);
                }
                tvAmountFlour.setText(amounts[0] + "");
                break;
            case R.id.btnCandyLess:
                if (amounts[1] > 0) {
                    amounts[1] -= 1;
                }
                if (amounts[1] == 0) {
                    cbCandy.setChecked(false);
                }
                tvAmountCandy.setText(amounts[1] + "");
                break;
            case R.id.btnToastLess:
                if (amounts[2] > 0) {
                    amounts[2] -= 1;
                }
                if (amounts[2] == 0) {
                    cbToast.setChecked(false);
                }
                tvAmountToast.setText(amounts[2] + "");
                break;
            case R.id.btnBreadLess:
                if (amounts[3] > 0) {
                    amounts[3] -= 1;
                }
                if (amounts[3] == 0) {
                    cbBread.setChecked(false);
                }
                tvAmountBread.setText(amounts[3] + "");
                break;
        }

    }


    public void calculateTotalAmount(View view) {
        int valorTotal = 0;

        for (int i = 0; i < 4; i++) {
            valorTotal += costs[i] * amounts[i];
        }
        tvTotalAmount.setText(Integer.toString(valorTotal));

    }

}

