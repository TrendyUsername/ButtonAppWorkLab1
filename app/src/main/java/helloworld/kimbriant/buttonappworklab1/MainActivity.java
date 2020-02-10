package helloworld.kimbriant.buttonappworklab1;


import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button primeFactorizer;
    EditText textEditName;
    EditText notificationNumber;
    TextView textView;
    String mainActivity;
    TextView numRep;
    TextView primeView;
    Calendar calendar = Calendar.getInstance();
    int numRepper = 0;
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        textEditName = findViewById(R.id.responseEditTextName);
        textView = findViewById(R.id.textBox);
        notificationNumber = findViewById(R.id.notificationNumber);
        numRep = findViewById(R.id.numUp);
        primeFactorizer = findViewById(R.id.primeFactorizer);
        primeView = findViewById(R.id.primeFactorizerNum);
        mainActivity = "MainActivity";
        textEditName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String textEditInput = textEditName.getText().toString();
                if(!hasFocus && textEditInput.equals("TJ")) {
                    System.out.println("Lost focus of textEditName");
                    textView.setText("TJ Rocks!");
                    textEditName.setText("");
                    textEditName.setHint("That's a gooooood name.");
                    Log.i("textEditName", "You just edited this name bro");
                }
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Wassup");
                String currentTextEditInput = textEditName.getText().toString();
                String hi = "hi";
                String day_rep = "";
                switch(day) {
                    case Calendar.SUNDAY:
                        day_rep = "Sunday";
                        break;
                    case Calendar.MONDAY:
                        day_rep = "Monday";
                        break;
                    case Calendar.TUESDAY:
                        day_rep = "Tuesday";
                        break;
                    case Calendar.WEDNESDAY:
                        day_rep = "Wednesday";
                        break;
                    case Calendar.THURSDAY:
                        day_rep = "Thursday";
                        break;
                    case Calendar.FRIDAY:
                        day_rep = "Friday";
                        break;
                    case Calendar.SATURDAY:
                        day_rep = "Saturday";
                        break;
                }
                String button_string_mess_rep = hi + " " + currentTextEditInput + ". " + "Today's " + day_rep;
                textView.setText(button_string_mess_rep);
                String wassup = "Log wassup!";
                Log.v("ButtonClick", button_string_mess_rep);
                System.out.println("Hello mom!");
                textEditName.clearFocus();
                numRepper++;
                numRep.setText(numRepper + "");
            }
        });

        primeFactorizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> theFactors = factorizeMyNumber(Integer.parseInt(notificationNumber.getText().toString()));
                HashSet<Integer> uniqueFactors = new HashSet<>(theFactors);
                Iterator<Integer> uniqueFactorFreqIterator = uniqueFactors.iterator();
                HashMap<Integer, Integer> hashDictionary = new HashMap<>();
                String primeString = "";
                while(uniqueFactorFreqIterator.hasNext()) {
                    int currentItrFactor = uniqueFactorFreqIterator.next();
                    int factorFreq = Collections.frequency(theFactors, currentItrFactor);
                    hashDictionary.put(currentItrFactor, factorFreq);
                    Log.v("Iteration", "" + currentItrFactor);
                }
                for(Integer prime : hashDictionary.keySet()) {
                    primeString = primeString + Integer.toString(prime) + "^" + hashDictionary.get(prime) + "*";
                }
                primeFactorizer.setBackgroundColor(Color.rgb(42, 69, 140));
                primeView.setText(primeString);
            }
        });
    }

    public static ArrayList<Integer> factorizeMyNumber(int number) {
        ArrayList<Integer> alFactors = new ArrayList<>();
        while(number % 2 == 0) {
            alFactors.add(2);
            number /= 2;
        }
        for(int possibleFactor = 3; possibleFactor <= Math.sqrt(number); possibleFactor++) {
            while(number % possibleFactor == 0) {
                alFactors.add(possibleFactor);
                number /= possibleFactor;
            }
        }
        if(number > 2) {
            alFactors.add(number);
        }
        return alFactors;
    }


}
