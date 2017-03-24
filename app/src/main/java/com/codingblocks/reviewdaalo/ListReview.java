package com.codingblocks.reviewdaalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListReview extends AppCompatActivity {
    TextView tv;
    RecyclerView rv;
    ListAdapter la;
    ArrayList<Views> v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_review);

        la = new ListAdapter();

        v=((Main2Activity)getParent()).getarraylist();
        Intent i = getIntent();
        tv = (TextView) findViewById(R.id.tvnames);
        rv = (RecyclerView) findViewById(R.id.recycler);
        tv.setText(i.getStringExtra("name"));

        rv.setLayoutManager(new LinearLayoutManager(ListReview.this));
        rv.setAdapter(la);

    }

    class ListHolder extends RecyclerView.ViewHolder{

        TextView tv,tv2,tv3;
        public ListHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.textView);
            this.tv2 = (TextView) itemView.findViewById(R.id.textView2);
            this.tv3 = (TextView) itemView.findViewById(R.id.textView3);
        }
    }
    class ListAdapter extends RecyclerView.Adapter<ListHolder>{

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = getLayoutInflater();
            View itemview;
            if(viewType==1){
                itemview=li.inflate(R.layout.caca,parent,false);
            }
            else{
                itemview = li.inflate(R.layout.cc,parent,false);
            }

            return new ListHolder(itemview);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
            Views view = v.get(position);
            if(view.getName().equals(tv.getText().toString())) {
                holder.tv.setText(view.getMoviename());
                holder.tv2.setText(view.getReview());
                holder.tv3.setText(String.valueOf(view.getRating()));
            }

        }

        @Override
        public int getItemViewType(int position) {
            if(v.get(position).getName().equals(tv.getText().toString())){
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
