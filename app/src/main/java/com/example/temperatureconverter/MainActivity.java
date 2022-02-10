package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.temperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private final float fZero = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fahrenheit = String.valueOf(binding.Fahrenheit.getText());
                String celsius = String.valueOf(binding.Celcius.getText());
                float conversionFahrenheit;
                float conversionCelsius;
                if(fahrenheit.isEmpty() && !celsius.isEmpty()){
                    conversionFahrenheit = cToF(Float.parseFloat(celsius));
                    binding.Fahrenheit.setText(String.valueOf(conversionFahrenheit));
                }
                else if (celsius.isEmpty() && !fahrenheit.isEmpty()){
                    conversionCelsius = fToC(Float.parseFloat(fahrenheit));
                    binding.Celcius.setText(String.valueOf(conversionCelsius));
                }
                else if (!fahrenheit.isEmpty() && !celsius.isEmpty()) {
                    conversionCelsius = fToC(Float.parseFloat(fahrenheit));
                    binding.Celcius.setText(String.valueOf(conversionCelsius));
                }

            }
        });
    }

    private float fToC(float fahrenheit){
        float cConverted = (5 * (fahrenheit - fZero) / 9);
        return cConverted;
    }
    private float cToF(float celsius){
        float fConverted = ((9 * celsius) + (5 * fZero)) / 5;
        return fConverted;
    }

}