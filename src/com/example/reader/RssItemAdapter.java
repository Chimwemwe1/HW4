package com.example.reader;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public  class RssItemAdapter extends BaseAdapter 
   {
	       private ArrayList<RssItem> items;
           private Activity act;

    public RssItemAdapter(Activity act, ArrayList<RssItem> items)
       {
           this.items = items;
           this.act = act;
       }
    public int getCount()
       {
           return items.size();
       }

    public RssItem getItem(int position) 
       {
           return items.get(position);
       }


    public long getItemId(int position) 
        {
           return 0;
        }


    public View getView(int position, View convertView, ViewGroup parent) 
        {
	
	           View view = null;
           if(convertView != null){
              view = convertView;
        }
           else{

               view = act.getLayoutInflater().inflate(R.layout.list_item, null);

               }

   final RssItem item = getItem(position);

         TextView tv = (TextView) view.findViewById(R.id.item_title);
         tv.setText(item.getTitle());


         Button btn = (Button) view.findViewById(R.id.item_btn);
         btn.setOnClickListener(new View.OnClickListener(){
         @Override
   public void onClick(View v) 
      {

        Intent intent = new Intent(act,DescriptionActivity.class);
        intent.putExtra("title", item.getTitle());
        intent.putExtra("description", item.getDescription());
        act.startActivity(intent);
      }
    });
      return view;
      }

}
