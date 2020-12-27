package eu.pyralia.pyrapi.net;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PermissionAbout {
  private String by = "";
  
  private String byUUID = "";
  
  private String date = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(new Date());
  
  public String getBy() {
    return this.by;
  }
  
  public void setBy(String by) {
    this.by = by;
  }
  
  public String getDate() {
    return this.date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public String getByUUID() {
    return this.byUUID;
  }
  
  public void setByUUID(String byUUID) {
    this.byUUID = byUUID;
  }
}
