/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;




/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    public static final int PRICE_PER_COFFEE = 5;
    int numberOfCoffees = 0;
    CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
    boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
    CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
    boolean hasChocolate = chocolateCheckBox.isChecked();
    EditText edit = (EditText) findViewById(R.id.name_text_input);
    String clientName = edit.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked. Shows the total price of the order and a message
     */
    public void submitOrder(View view) {


        displayMessage(createOrderSummary());


    }

    /**
     * hides the keyboard
     */


    /**
     * Calculates the total price of the order and shows a summary of the order
     *
     * @return price and order summary
     */
    private String createOrderSummary() {

        int amountDue = calculatePrice();
        String summaryMessage = "Name: " + clientName;
        summaryMessage += "\nAdd whipped cream? " + hasWhippedCream;
        summaryMessage += "\nAdd chocolate? " + hasChocolate;
        summaryMessage += "\nQuantity: " + numberOfCoffees + "\nTotal: " + amountDue + "лв.";
        summaryMessage += "\nThank You!";
        return summaryMessage;
    }


    /**
     * Calculates the total price of the order.
     *
     * @return price
     */
    private int calculatePrice() {

        int basePrice = PRICE_PER_COFFEE;

        if (whippedCreamCheckBox.isChecked()) {
            basePrice = (PRICE_PER_COFFEE + 1);
        }
        if (chocolateCheckBox.isChecked()) {
            basePrice = (PRICE_PER_COFFEE + 2);
        }

        return numberOfCoffees * basePrice;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);


    }
}




