package zhimingzhang.deakin.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView userInput, placeholder1, placeholder2, placeholder3, output1, output2, output3;
    ImageButton tapeButton, temperatureButton, weightButton;
    int spinnerPosition = -1;
    NumberFormat nf = new DecimalFormat(",###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        userInput = findViewById(R.id.userEntry);

        placeholder1 = findViewById(R.id.placeholder1);
        placeholder2 = findViewById(R.id.placeholer2);
        placeholder3 = findViewById(R.id.placeholder3);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);

        tapeButton = findViewById(R.id.tapeButton);
        temperatureButton = findViewById(R.id.temperatureButton);
        weightButton = findViewById(R.id.weightButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerLabels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
        spinnerPosition = position;
        System.out.println("New spinner position is " + spinnerPosition);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void lengthConversion(View view){
        boolean noException = false;
        if(spinnerPosition!=0){
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
        }
        else{
            try{
                double inputValue = Double.parseDouble(userInput.getText().toString());
                noException = true;
            }

            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Invalid Entry!", Toast.LENGTH_SHORT).show();
            }
            if(noException){
                double inputValue = Double.parseDouble(userInput.getText().toString());
                System.out.println(inputValue);

                double cm = inputValue*100;
                double ft = inputValue*3.28084;
                double inches = inputValue*3.28084*12;

                output1.setText(nf.format(cm));
                placeholder1.setText("Centimetre");

                output2.setText(nf.format(ft));
                placeholder2.setText("Foot");

                output3.setText(nf.format(inches));
                placeholder3.setText("Inch");
            }
        }
    }
    public void temperatureConversion(View view) {
        if (spinnerPosition != 1) {
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
        }

        else {
            boolean noException = false;
            try{
                double inputValue = Double.parseDouble(userInput.getText().toString());
                noException = true;
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Invalid Entry!", Toast.LENGTH_SHORT).show();
            }
            if(noException){
                double inputValue = Double.parseDouble(userInput.getText().toString());
                System.out.println(inputValue);

                double kelvin = inputValue + 273.15;
                double fahrenheit = (inputValue*9/5)+32;

                output1.setText(nf.format(fahrenheit));
                placeholder1.setText("Fahrenheit");

                output2.setText(nf.format(kelvin));
                placeholder2.setText("Kelvin");

                output3.setText("");
                placeholder3.setText("");
            }
        }
    }
    public void weightConversion(View view) {

        if (spinnerPosition != 2) {
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
        }

        else {
            boolean noException = false;
            try{
                double inputValue = Double.parseDouble(userInput.getText().toString());
                noException = true;
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Invalid Entry!", Toast.LENGTH_SHORT).show();
            }
            if(noException){
                double inputValue = Double.parseDouble(userInput.getText().toString());
                System.out.println(inputValue);


                double gram = inputValue*1000;
                double ounce = inputValue*35.274;
                double pound = inputValue*2.205;

                output1.setText(nf.format(gram));
                placeholder1.setText("Gram");

                output2.setText(nf.format(ounce));
                placeholder2.setText("Ounce(Oz)");

                output3.setText(nf.format(pound));
                placeholder3.setText("Pound(lb)");
            }
        }
    }
}