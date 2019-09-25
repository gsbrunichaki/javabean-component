package persistentbean;
 //Feijão Persistente

 import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistence {
  private String file;

  public Persistence() {
    this.file = null;
  }

  public String getFile() {
    return this.file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public boolean fileExists() {
    File file = new File(this.file);
    return file.exists();
  }

  public void createFile() {
    File file = new File(this.file);

    if (!fileExists()) {
      file.createNewFile();
    }
  }

  public ArrayList<String> readFile() {
    try {
      FileReader textFile = new FileReader(this.file);
      BufferedReader readFile = new BufferedReader(textFile);

      ArrayList<String> lines = new ArrayList<String>();

      while (readFile.ready()) {
        lines.add(readFile.readLine());
      }

      textFile.close();

      return lines;
    } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
    }

  }

  public void writeFile() {

    FileWriter arq = new FileWriter("d:\\tabuada.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
  }

}
