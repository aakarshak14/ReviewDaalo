package com.codingblocks.reviewdaalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Button add,list,search,logout;
    TextView tv;
    static ArrayList<Views> View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();

        final Person s=(Person) i.getSerializableExtra("person");

        tv = (TextView) findViewById(R.id.textv);
        list = (Button) findViewById(R.id.btnlist);
        search = (Button) findViewById(R.id.btnsearch);
        logout= (Button) findViewById(R.id.btnlogout);
        View = new ArrayList<>();
        add = (Button) findViewById(R.id.btnadd);

        tv.setText("Welcome "+s.getName() +" from "+s.getCountry());
        View.add(new Views("rustom","Aakarshak Aggarwal", (float) 9.5,"Awesome Moview. A Must watch For Everyone. Thrilling and entertaining"));
        View.add(new Views("airlift","Anant Bansal", (float) 10.0,"Awesome Moview. A Must watch For Everyone. Thrilling and entertaining.Akshay Kumar dwells into the character amazingly."));
        View.add(new Views("zindagi na milegi dobara","Harsh Mohan Agarwal", (float) 9.0,"A must watch with a bunch of great friends. Helps a lot in viewing life in a different way."));
        View.add(new Views("airlift","Aakarshak Aggarwal", (float) 10,"The best patriotic film ever."));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main2Activity.this,Review.class);
                i.putExtra("persons",s.getName());
                startActivityForResult(i,235);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(Main2Activity.this,Search.class);
                    startActivity(i);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,ListReview.class);
                i.putExtra("name",s.getName());
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 235 && resultCode == RESULT_OK)
        {
            View.add(new Views(data.getStringExtra("name"),
                    data.getStringExtra("pname"),
                    data.getFloatExtra("rating",0)
                    ,data.getStringExtra("review")));

            Toast.makeText(this, "Review Added Successfully.", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
   public static ArrayList<Views> getarraylist(){
        return View;
    }
}
