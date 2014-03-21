package com.example.reader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;



import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;



public class MainActivity extends Activity
 {

    protected void onCreate(Bundle savedInstanceState)
       {
           super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final ListView lv = (ListView) findViewById(R.id.rss_list);

            final Activity memRefThis = this;

            (new Thread(new Runnable(){
	
	        ArrayList<RssItem> RssItems;

       @Override
  public void run() {
         try {
                 this.RssItems = RssPullParser.parse("http://feeds.pcworld.com/pcworld/latestnews");

             }   catch (MalformedURLException e)
                    { e.printStackTrace();}
              
                 catch (XmlPullParserException e)
                    { e.printStackTrace(); }
     
                 catch (IOException e)
                    {e.printStackTrace();}
          MainActivity.this.runOnUiThread(new Runnable(){
      @Override
   public void run()
     {

	lv.setAdapter( new RssItemAdapter( memRefThis , RssItems ) );

   }
        });



       }
       
   })).start();






}


}

