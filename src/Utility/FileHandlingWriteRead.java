package Utility;

import Model.Contacts;

import java.io.*;
import java.util.Scanner;

public class FileHandlingWriteRead {
//    public static void main(String[] args) {
//        FileHandlingWriteRead fileHandlingWriteRead = new FileHandlingWriteRead();
//        Contacts contacts = new Contacts();
//        contacts.setFirstName("Geetesh");
//        contacts.setLastnames("Kumbalkar");
//        fileHandlingWriteRead.write("Address.txt",contacts);
//        Contacts contacts2 = new Contacts();
//        contacts2.setFirstName("lokesh");
//
//        contacts2.setLastnames("Kuccc");
//        fileHandlingWriteRead.write("Address.txt",contacts2);
//
//        fileHandlingWriteRead.read("Address.txt");
//    }
    static int count = 1;
    public void write(String fileName, Contacts contacts)
    {
        try{
            File file = new File(fileName);
            if (file.exists())
            {

                FileOutputStream fileWriter = new FileOutputStream(fileName,true);
                byte contactCount[]=(Integer.toString(count)).getBytes();
                byte dataWrite[] = (" "+contacts.toString()+"\n").getBytes();
                fileWriter.write(contactCount);
                fileWriter.write(dataWrite);
                fileWriter.close();
                count++;
            }
            else
            {
                file.createNewFile();
                FileOutputStream fileWriter = new FileOutputStream(fileName,true);
                byte contactCount[]=(Integer.toString(count)).getBytes();
                byte dataWrite[] = (contacts.toString()+"\n").getBytes();
                fileWriter.write(contactCount);
                fileWriter.write(dataWrite);
                fileWriter.close();
                count++;
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
