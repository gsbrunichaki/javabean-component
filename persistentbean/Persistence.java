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

  
  /** 
   * Construtor
   * @return 
   */
  public Persistence() {
    this.file = null;
    this.props = null;
  }

  /** 
   * @return String - caminho do arquivo
   */
  public String getFile() {
    return this.file;
  }

  
  /** 
   * Altera o arquivo onde os dados serão persistidos
   * @param file String - Caminho ou nome do arquivo
   * @throws IOException
   */
  public void setFile(String file) throws IOException {
    this.file = file;
    this.syncProps();
  }

  private File syncFile() throws IOException {
    File file = new File(this.file);
    if (!file.exists())
      file.createNewFile();

    return file;
  }

  private void syncProps() throws IOException {
    this.syncFile();
    Properties props = new Properties();
    props.load(new FileInputStream(this.file));
    this.props = props;
  }

  
  /** 
   * Busca o valor associado à determinada chave
   * @param key String - chave
   * @return String - valor
   */
  public String getProperty(String key) {
    return this.props.getProperty(key);
  }

  
  /** 
   * Associa um valor a uma determinada chave.
   * @param key String chave
   * @param value String valor
   * @throws IOException
   */
  public void setProperty(String key, String value) throws IOException {
    this.props.setProperty(key, value);
    this.saveProperties();
  }

  private void saveProperties() throws IOException {
    FileOutputStream fr = new FileOutputStream(this.file);
    this.props.store(fr, "Properties");
    fr.close();
  }
}
