package com.example.reader;

public class RssItem 
 {
	
	private String title;
    private String description;
    public RssItem() {}

    public RssItem(String title, String description)
      {
       this.title = title;
       this.description = description;
      }

   public void setTitle(String title)
      {
         this.title = title;
      }

   public void setDescription(String description)
      {
        this.description = description;
      }

   public String getDescription()
     {
       return description;
     }

  public String getTitle()
     {
      return title;
     }



}
