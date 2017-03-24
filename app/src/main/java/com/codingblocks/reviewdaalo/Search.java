package com.codingblocks.reviewdaalo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    Button search,imdb;
    RequestQueue rq;
    Gson g;
    TextView t,plot;
    EditText et;
    RecyclerView rv;
    ArrayList<Views> v ;
    LinearLayout l;
    ReviewAdapter rvadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        g=new Gson();
        l= (LinearLayout) findViewById(R.id.activity_search);
        plot= (TextView) findViewById(R.id.tvplot);
        imdb = (Button) findViewById(R.id.btnimdb);
        t= (TextView) findViewById(R.id.texts);
        et  = (EditText) findViewById(R.id.etsearch);
        rq = Volley.newRequestQueue(this);
        v = ((Main2Activity)getParent()).getarraylist();
        search = (Button) findViewById(R.id.btnsearchmovie);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t.setText("");
                plot.setText("");
                rvadapter = new ReviewAdapter();

                rv.setLayoutManager(new LinearLayoutManager(Search.this));

                rv.setAdapter(rvadapter);

                //l.setBackground(R.drawable.ic_launcher1);

            }
        });

        imdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest sr = new StringRequest(
                        "http://www.omdbapi.com/?t=" + et.getText().toString() + "&y=&plot=short&r=json", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject s = null;
                        try {
                             s = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        IMDB imdb = g.fromJson(s.toString(),IMDB.class);
                        t.setText("IMDB RATING - "+imdb.getImdbRating());
                        plot.setText("PLOT - "+imdb.getPlot());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                rq.add(sr);
            }
        });
    }

    class ReviewHolder extends RecyclerView.ViewHolder{
        TextView  tvrating , tvreview , tvname;

        public ReviewHolder(View itemView) {
            super(itemView);
            if(itemView!=null) {
                this.tvrating = (TextView) itemView.findViewById(R.id.tvmovierating);
                this.tvreview = (TextView) itemView.findViewById(R.id.tvmoviereview);
                this.tvname = (TextView) itemView.findViewById(R.id.tvname);
            }
        }
    }

    class ReviewAdapter extends RecyclerView.Adapter<ReviewHolder>{

        @Override
        public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater li = getLayoutInflater();
            View itemview=null;
            if(viewType==1)
                itemview = li.inflate(R.layout.container,parent,false);
            else if(viewType==0)
                itemview=li.inflate(R.layout.cc,parent,false);

            return new ReviewHolder(itemview);

        }

        @Override
        public void onBindViewHolder(ReviewHolder holder, int position) {


            if(v.get(position).getMoviename().equals(et.getText().toString().toLowerCase())){
                Views  vs= v.get(position);
                holder.tvname.setText("- "+vs.getName());
                holder.tvreview.setText(vs.getReview());
                holder.tvrating.setText(String.valueOf(vs.getRating()));
            }


        }

        @Override
        public int getItemViewType(int position) {
            if(v.get(position).getMoviename().equals(et.getText().toString().toLowerCase())){
                return 1;
            }

            return 0;
        }

        @Override
        public int getItemCount() {
            return v.size();
        }
    }
}
