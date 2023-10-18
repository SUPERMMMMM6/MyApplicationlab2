package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Qiman Gao
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /** This holds the text at the center of the screens*/
    private TextView tv = null;
    /** This holds the place to enter the password at the center of the screens*/
    private EditText et = null;
    /** This holds the login at the bottom of the screens*/
    private Button btn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);



        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            /**
             * if the password does not meet the requirements, will pop up not pass message
             */
            if (checkPasswordComplexity(password)) {
                tv.setText("Your password meets the requirements");
            } else {
                tv.setText("You shall not pass!");
            }
        });
    }

    /**
     *
     * @param pw the String object that we are checking
     * @return Returns true if the password meets all the criteria, false otherwise
     */
    private boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;

        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "You are missing an upper case letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "You are missing a lower case letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "You are missing a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "You are missing a special character", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Checks if the provided character is one of the specified special characters.
     *
     * @param c Character to be checked.
     * @return true if the character is one of the special characters, false otherwise.
     */
    private boolean isSpecialCharacter(char c) {
        switch (c){
            case '#':
            case '?':
            case '*':
            case '^':
            case '&':
            case '%':
            case '!':
            case '@':
            case '$':
                return true;
            default:
                return false;
        }
    }
}