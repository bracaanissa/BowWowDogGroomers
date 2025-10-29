// Anissa Braca
// Bow Wow Groomers Assignment 1

package com.example.bowwowdoggroomers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaring UI elements as private fields so they can be accessed in all methods of the class.
    private EditText weightInput;
    private CheckBox trimNailsCheckBox, fleaBathCheckBox, massageCheckBox;
    private TextView totalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the UI elements in the layout to the fields in the class.
        // So we can interact with the UI elements, like getting input from the EditText
        // or checking if a CheckBox is checked.
        weightInput = findViewById(R.id.weightInput);
        trimNailsCheckBox = findViewById(R.id.trimNailsCheckBox);
        fleaBathCheckBox = findViewById(R.id.fleaBathCheckBox);
        massageCheckBox = findViewById(R.id.massageCheckBox);
        totalCostTextView = findViewById(R.id.totalCostTextView);
    }

    // This method is triggered when the "Calculate" button is pressed.
    // Reads the user's input, calculates the cost of the services, and updates the UI.
    public void calculateCost(View view) {
        // Retrieve the text input from the EditText field and check if it's not empty.
        String weightStr = weightInput.getText().toString();
        if (!weightStr.isEmpty()) {
            // Parse the string input to an integer for weight.
            int weight = Integer.parseInt(weightStr);
            // Determine the base cost based on the weight of the dog according to the assignment rules.
            double baseCost = weight < 30 ? 35 : (weight < 50 ? 45 : 55);
            double additionalCost = 0;
            // Add costs for additional services if the respective CheckBoxes are checked.
            if (trimNailsCheckBox.isChecked()) additionalCost += 5;
            if (fleaBathCheckBox.isChecked()) additionalCost += 10;
            if (massageCheckBox.isChecked()) additionalCost += 20;

            // Display the total cost by formatting it to a string and setting the TextView's text.
            totalCostTextView.setText(String.format("$%.2f", baseCost + additionalCost));
        } else {
            // If the input field is empty, show a Toast message prompting the user to enter the dog's weight.
            Toast.makeText(this, "Please enter the weight of your dog.", Toast.LENGTH_SHORT).show();
        }
    }

    // This method resets all input fields/selections to their default state.
    // It is called when the "Reset" button is pressed.
    @SuppressLint("SetTextI18n")
    public void resetFields(View view) {
        // Clear the EditText field.
        weightInput.setText("");
        // Uncheck all CheckBoxes.
        trimNailsCheckBox.setChecked(false);
        fleaBathCheckBox.setChecked(false);
        massageCheckBox.setChecked(false);
        // Reset the total cost TextView to show the default value.
        totalCostTextView.setText("$0.00");
    }

    // This method is called when the "Order" button is pressed.
    // It displays a Toast message to confirm the order and resets the fields.
    public void placeOrder(View view) {
        // Show a confirmation Toast message.
        Toast.makeText(this, "Order placed. Thanks for your business!", Toast.LENGTH_LONG).show();
        // Call resetFields to clear the form for a new order.
        resetFields(view);
    }
}
