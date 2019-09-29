package persistentbean;

import java.io.File;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Persistence {
  private String file;
  private Properties props;

  public Persistence() {
    this.file = null;
    this.props = null;
  }

  public String getFile() {
    return this.file;
  }

  public void setFile(String file) throws IOException {
    this.file = file;
    this.syncProps();
  }

  public File syncFile() throws IOException {
    File file = new File(this.file);
    if (!file.exists())
      file.createNewFile();

    return file;
  }

  public void syncProps() throws IOException {
    this.syncFile();
    Properties props = new Properties();
    props.load(new FileInputStream(this.file));
    this.props = props;
  }

  public String getProperty(String key) {
    return this.props.getProperty(key);
  }

  public void setProperty(String key, String value) throws IOException {
    this.props.setProperty(key, value);
    this.saveProperties();
  }

  public void saveProperties() throws IOException {
    FileOutputStream fr = new FileOutputStream(this.file);
    this.props.store(fr, "Properties");
    fr.close();
  }
}
