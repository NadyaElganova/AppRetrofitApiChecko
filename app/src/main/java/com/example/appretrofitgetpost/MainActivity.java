package com.example.appretrofitgetpost;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText innInput;
    private TextView resultText;
    private Button searchButton;

    private final String API_KEY = "qEU8F2ba7rt2BBQ6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        innInput = findViewById(R.id.inn_input);
        resultText = findViewById(R.id.result_text);
        searchButton = findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inn = innInput.getText().toString().trim();
                if (!inn.isEmpty()) {
                    fetchCompanyInfo(inn);
                } else {
                    Toast.makeText(MainActivity.this, "Введите ИНН", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void fetchCompanyInfo(String inn) {
        CheckoApiService apiService = RetrofitClient.getApiService();
        Call<CompanyInfo> call = apiService.getCompanyInfo(API_KEY, inn);

        call.enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CompanyInfo companyInfo = response.body();
                    Data companyData = companyInfo.getData();
                    Meta companyMeta = companyInfo.getMeta();

                    String result = "Название: " + companyData.getName() + "\n" +
                            "ОГРН: " + companyData.getOGRN() + "\n" +
                            "КПП: " + companyData.getKPP() + "\n\n" +
                            "Статус: " + companyMeta.getStatus() + "\n";
                    resultText.setText(result);
                } else {
                    resultText.setText("Компания не найдена");
                }
            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {
                resultText.setText("Ошибка: " + t.getMessage());
            }
        });
    }

}