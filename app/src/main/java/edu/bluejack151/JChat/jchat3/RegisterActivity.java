package edu.bluejack151.JChat.jchat3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.shiperus.ark.jchat3.R;

import edu.bluejack151.JChat.jchat3.Helper.Validator;

public class RegisterActivity extends AppCompatActivity {
    //register components
    EditText userId;
    EditText displayName;
    EditText email;
    EditText password;
    RadioButton radioMale;
    RadioButton radioFemale;
    Button btnSubmit;
    Button btnReset;

    private void initComponent(){
        userId = (EditText)findViewById(R.id.fieldRegisUserID);
        displayName = (EditText)findViewById(R.id.fieldRegisDisplayName);
        email = (EditText)findViewById(R.id.fieldRegisEmail);
        password = (EditText)findViewById(R.id.fieldRegisPassword);
        radioMale = (RadioButton)findViewById(R.id.regisRadioMale);
        radioFemale = (RadioButton)findViewById(R.id.regisRadioFemale);

        btnSubmit = (Button)findViewById(R.id.submitRegisButton);
        btnReset = (Button)findViewById(R.id.resetRegisButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponent();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                if (!Validator.checkUserID(userId.getText().toString())) {
                    message = "User ID must be alphabet or numeric, 6-8 character";
                } else if (!Validator.checkLength(displayName.getText().toString(), 3, 20) ||
                        !Validator.isAlpha(displayName.getText().toString())) {
                    message = "Display Name must be alphabet, 3-20 character";
                } else if (!Validator.validateEmail(email.getText())) {
                    message = "Email format is wrong";
                } else if (!Validator.checkLength(password.getText().toString(), 4, 20)
                        || !Validator.isAlphaNumeric(password.getText().toString())) {
                    message = "Password must be alphanumeric, 4-20 character";
                } else {
                    message = "Register Success";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                if (message.equals("Register Success")) {
                    //insertDatabase
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId.setText("");
                displayName.setText("");
                email.setText("");
                password.setText("");
                radioMale.setChecked(true);
                //asdsasdasadsasadcjcjcjjcjc
            }
        });
    }


}
