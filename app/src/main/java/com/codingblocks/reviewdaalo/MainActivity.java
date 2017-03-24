package com.codingblocks.reviewdaalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button login , signup;
    EditText etname,etpass;
   public ArrayList<Person> persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.editText);
        etpass = (EditText) findViewById(R.id.editText2);
        persons = new ArrayList<>();
        persons.add(new Person(20,"Aakarshak Aggarwal","India","akki.agg14@gmail.com","aakarshak14","aakarshak14"));
        persons.add(new Person(20,"Anant Bansal","India","anant.lifeguard@gmail.com","anant26","anant26"));
        persons.add(new Person(20,"Harsh Mohan Agarwal","India","nexflare@outlook.com","harsh08","harsh08"));
        persons.add(new Person(20,"Rakshita Singh","India","rakshas@gmail.com","rakshita07","rakshita07"));
        persons.add(new Person(24,"Arnav Gupta","India","arnav@codingblocks.com","arnav09","arnav09"));
        login = (Button) findViewById(R.id.btnlogin);
        signup = (Button) findViewById(R.id.btnsignup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person s = search();
                    if(s!=null){

                        Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,Main2Activity.class);
                        i.putExtra("person", s);
                        startActivity(i);

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Username or password.", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Signup.class);
                startActivityForResult(i,234);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 234) {

            if(resultCode==RESULT_OK){

                String name=data.getStringExtra("name");
                int age=data.getIntExtra("age",0);
                String country=data.getStringExtra("country");
                String emailid=data.getStringExtra("email");
                String username=data.getStringExtra("username");
                String password=data.getStringExtra("password");


                persons.add(new Person(age,name,country,emailid,username,password));
                Toast.makeText(this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    Person search(){
        for(Person p : persons){
            if(p.username.equals(etname.getText().toString())&&p.password.equals(etpass.getText().toString())){
                return p;
            }

        }
        return null;
    }
}
