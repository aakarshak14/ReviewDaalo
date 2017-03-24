package com.codingblocks.reviewdaalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button signup,reset;
    EditText name,age,country,email,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        reset= (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.etname);
        age = (EditText) findViewById(R.id.etage);
        country = (EditText) findViewById(R.id.etcountry);
        email= (EditText) findViewById(R.id.etemail);
        username = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);
        signup = (Button) findViewById(R.id.btnsign);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                age.setText("");
                country.setText("");
                email.setText("");
                username.setText("");
                password.setText("");
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().length()!=0&&email.getText().toString().length()!=0 && username.getText().toString().length()!=0 && password.getText().toString().length()!=0 &&age.getText().toString().length()!=0) {
                    Intent i = new Intent();
                    i.putExtra("name", name.getText().toString());
                    i.putExtra("age", Integer.valueOf(age.getText().toString()));
                    i.putExtra("country", country.getText().toString());
                    i.putExtra("email", email.getText().toString());
                    i.putExtra("username", username.getText().toString());
                    i.putExtra("password", password.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                else{
                    Toast.makeText(Signup.this, "Please fill up the details.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
