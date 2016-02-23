package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        }
    }

    public void decrement(View view) {

        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       CheckBox whippedCream = (CheckBox) findViewById(R.id.notify_me_checkbox);
        boolean haswhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_text_view);
        boolean haschocolate = chocolate.isChecked();

        EditText name = (EditText) findViewById(R.id.name_description_view);
        String addname = name.getText().toString();

       // String body =  displayMessage(createAOrderSummary(haswhippedCream, haschocolate, addname));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:eduolioli@hotmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "eduolioli@hotmail.com");
        intent.putExtra(Intent.EXTRA_TEXT,
               createAOrderSummary(haswhippedCream, haschocolate, addname));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    private String createAOrderSummary(boolean addwhippedCream, boolean addhaschocolate, String addName) {
        String priceMessage = addName;
        priceMessage = priceMessage + "\nAdd whipped cream? " + addwhippedCream;
        priceMessage = priceMessage + "\nAdd whipped cream? " + addhaschocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal:"
                + NumberFormat.getCurrencyInstance().format(calculatePrice(addwhippedCream, addhaschocolate));
        priceMessage = priceMessage + "\nThank you";

        return priceMessage;
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int base = 5;

        if (addWhippedCream) {
            base = base + 1;
        }

        if (addChocolate) {
            base = base + 2;
        }

        return quantity * base;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private String displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_Summary_text_view);
        priceTextView.setText(message);
        return message;
    }


}