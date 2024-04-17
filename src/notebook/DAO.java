package notebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAO {
  private static Log log = LogFactory.getFactory().getInstance(DAO.class);
  private Connection conn;
  
  public void connect(String host, String database, String username, String password) throws Exception {
    Class.forName("org.postgresql.Driver");
    String url = "jdbc:postgresql://" + host + "/" + database + "?user=" + username;
    log.info("connecting to database using " + url);
    if (password != null) {
      url = url + "&password=" + password;
    }
    conn = DriverManager.getConnection(url);  
  }
  
  public void close() throws Exception {
    if (conn != null) {
      conn.close();
    }
  }
  
  public List<Note> search(String filter) throws Exception {
    List<Note> list = new ArrayList<>();
    PreparedStatement ps;
    if ("".equals(filter)) {
      ps = conn.prepareStatement("select * from notebook order by id desc");
    } else {
      ps = conn.prepareStatement("select * from notebook where upper(title) like upper(?) or upper(note) like upper(?) order by id desc");
      ps.setString(1, filter);
      ps.setString(2, filter);
    }
    ResultSet resultSet = ps.executeQuery();
    while (resultSet.next()) {
      Note note = new Note();
      note.setId(resultSet.getInt(1));
      note.setTimestamp(resultSet.getTimestamp(2));
      note.setTitle(resultSet.getString(3));
      note.setText(resultSet.getString(4));
      list.add(note);
    }
    return list;
    // select * from notebook where UPPER(note) like UPPER('%myx%') or UPPER(title) like UPPER('%my%');
  }
  
  public void addNote(String title, String note) throws Exception {
    PreparedStatement ps = conn.prepareStatement("insert into notebook(ts, title, note) values(NOW(), ?, ?)");
    ps.setString(1, title);
    ps.setString(2, note);
    ps.executeUpdate();
  }

  public Note getLast() throws Exception {
    PreparedStatement ps = conn.prepareStatement("select id, ts, title, note from notebook where id = (select MAX(id) from notebook)");
    ResultSet resultSet = ps.executeQuery();
    if (!resultSet.next()) {
      return null;
    }
    Note note = new Note();
    note.setId(resultSet.getInt(1));
    note.setTimestamp(resultSet.getTimestamp(2));
    note.setTitle(resultSet.getString(3));
    note.setText(resultSet.getString(4));
    return note;
  }
}
