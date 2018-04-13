package com.example.horyon.dmshandydicemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView diceRecyclerView;
    private RecyclerView.Adapter diceAdapter;
    private RecyclerView.LayoutManager diceLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner= findViewById(R.id.diceFace_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void roll(View view)
    {
        try
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        catch (Exception e)
        {

        }

        EditText numberOfDice = findViewById(R.id.EditText_nbDice);
        int diceNbr = Integer.valueOf(numberOfDice.getText().toString());
        int total = 0;

        Spinner spinner= findViewById(R.id.diceFace_spinner);
        int spinner_pos = spinner.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.value);
        int diceFace = Integer.valueOf(size_values[spinner_pos]);
        Log.e("value",""+diceFace);

        List<Dice> listDice =new ArrayList<>();

        for(int i=0; i < diceNbr; i++)
        {
            Random r = new Random();
            int result = r.nextInt(diceFace)+1;
            total = total +result;
            listDice.add(new Dice(i+1,diceFace, result));
        }

        diceRecyclerView = findViewById(R.id.dices);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        diceRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        diceLayoutManager = new LinearLayoutManager(this);
        diceRecyclerView.setLayoutManager(diceLayoutManager);

        // specify an adapter (see also next example)
        diceAdapter = new DiceAdapter(listDice, this);
        diceRecyclerView.setAdapter(diceAdapter);

        TextView resultTW = findViewById(R.id.resultDice);
        resultTW.setText("The total for the throw is : " + total);
    }
}