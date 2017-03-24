package com.codingblocks.reviewdaalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Review extends AppCompatActivity {

    EditText etmovie , etreview , etrating ;
    TextView etname;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Intent i = getIntent();
        etmovie = (EditText) findViewById(R.id.etmoviename);
        etreview = (EditText) findViewById(R.id.etreview);
        etrating = (EditText) findViewById(R.id.editText3);
        etname = (TextView) findViewById(R.id.etyname);

        etname.setText(i.getStringExtra("persons"));
        add = (Button) findViewById(R.id.btnreview);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("name",etmovie.getText().toString().toLowerCase());
                i.putExtra("review",etreview.getText().toString());
                i.putExtra("rating",Float.valueOf(etrating.getText().toString()));
                i.putExtra("pname",etname.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
