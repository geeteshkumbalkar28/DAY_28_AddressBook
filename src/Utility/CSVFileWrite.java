package Utility;

import Model.Contacts;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class CSVFileWrite {
    public void write(String fileName, Contacts contacts)
    {
        StringBuilder stringBuilder = new StringBuilder();
       // JSONObject jsonObject = new JSONObject(contacts);
        stringBuilder.append(contacts);
        try{
            File file = new File(fileName);
            if (file.exists())
            {

                FileOutputStream fileWriter = new FileOutputStream(fileName,true);
                // byte contactCount[]=(Integer.toString(count)).getBytes();
                byte dataWrite[] = (" "+stringBuilder.toString()+"\n").getBytes();
                //fileWriter.write(contactCount);
                fileWriter.write(dataWrite);
                fileWriter.close();
                //count++;
            }
            else {
                file.createNewFile();
                FileOutputStream fileWriter = new FileOutputStream(fileName, true);

                byte dataWrite[] = (stringBuilder.toString() + "\n").getBytes();
                fileWriter.write(dataWrite);
                fileWriter.close();
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
