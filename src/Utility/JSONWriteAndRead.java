package Utility;

import Model.Contacts;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class JSONWriteAndRead {
  //  static int count = 1;
    public void write(String fileName, Contacts contacts)
    {
        JSONObject jsonObject = new JSONObject(contacts);

        try{
            File file = new File(fileName);
            if (file.exists())
            {

                FileOutputStream fileWriter = new FileOutputStream(fileName,true);
               // byte contactCount[]=(Integer.toString(count)).getBytes();
                byte dataWrite[] = (" "+jsonObject.toString()+"\n").getBytes();
                //fileWriter.write(contactCount);
                fileWriter.write(dataWrite);
                fileWriter.close();
                //count++;
            }
            else
            {
                file.createNewFile();
                FileOutputStream fileWriter = new FileOutputStream(fileName,true);
                //byte contactCount[]=(Integer.toString(count)).getBytes();
                byte dataWrite[] = (jsonObject.toString()+"\n").getBytes();
                //fileWriter.write(contactCount);
                fileWriter.write(dataWrite);
                fileWriter.close();
                //count++;
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception !!!!!!!!! "+e);
        }

    }
    public void read(String fileName)
    {
        try {
            File file = new File(fileName);

            Scanner scanner = new Scanner(file);
            if (file.exists())
            {
                while(scanner.hasNext())
                {
                    String fileData = scanner.nextLine();
                    System.out.println(fileData);
                }

            }
            else
            {
                System.out.println("File not exist !!!!");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

    }
}
