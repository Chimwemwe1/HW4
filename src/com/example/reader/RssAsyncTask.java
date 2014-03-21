package com.example.reader;
import android.os.AsyncTask;


public class RssAsyncTask extends AsyncTask<Void,Void,Void>
{
	
	public interface OnFinishedListener
         {
           public void onFinished();
         }

    private OnFinishedListener listener;

    public RssAsyncTask ( OnFinishedListener listener )
        {
          this.listener = listener;
         }

    protected Void doInBackground(Void... params)
        {
         new RssPullParser();

          return null;
         }

    protected void onPostExecute()
        {
           listener.onFinished();
          }



}
