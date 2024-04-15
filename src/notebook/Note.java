package notebook;

import java.util.Date;

public class Note {
  private Integer id;
  private Date timestamp;
  private String title;
  private String note;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Date getTimestamp() {
    return timestamp;
  }
  
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
