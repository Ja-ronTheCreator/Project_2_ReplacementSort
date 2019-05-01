/*
Name: Jaron Ethan Tamayo,Jimmy _____ , Alex ____
Class: CSCI 230
Date: 4/24/19
File: Replacement sort that reads files with ints separated by line, NOT by a Space ie. " ".
 */
import java.io.*;
import java.util.*;
import java.lang.System;
public class ReplacementSort {

   /* public int[] Sorty()
    {
        Scanner ScanMe = new Scanner();

    }
    */


    public static void FileOut(int x)
    {
        try {
            FileWriter fwes = new FileWriter("Test.txt");

            PrintWriter pw = new PrintWriter(fwes);
            Random ran = new Random();
            int i = 0;
            while (i < x) {

                int pp = ran.nextInt(98)+1;
                //System.out.println("added " + pp );
                pw.println(pp);
                i++;
            }
            pw.close();
        }
        catch (IOException e){
            System.out.println("File Error?");}
    }
   public static void Replacement(String FileName)
    {
        /*FileInputStream fstream_school = new FileInputStream("text1.txt");
        DataInputStream data_input = new DataInputStream(fstream_school);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
        */

        // reader objects
       try {
           //FileInputStream FileStreamy = new FileInputStream(FileName);
           //DataInputStream DataPoint = new DataInputStream(FileStreamy);
           FileReader FileReadMe = new FileReader(FileName);
           BufferedReader Buffy = new BufferedReader(FileReadMe);

          Scanner Scany = new Scanner(System.in);
           //Writer Objects

           int MSIZE = 10; //size of the HEAP/Memory flow

           Heap Heapy = new Heap();
           Heapy.MinHeap();
           int i = 1;
           int[] Array_Z = new int[8192];
           while (i <= MSIZE ) {
               int ins = Integer.parseInt(Buffy.readLine());
               System.out.println("inserting "+ ins);
               Heapy.insert(ins);
               System.out.println("Worked inserting "+ ins);
               i++;

               //Array_Z[i] = Integer.parseInt(Buffy.readLine());
           }
           int[] out_array;
           int TEMP = 0;
           // Heapy.sort(Array_Z);
           ArrayList<Integer> list = new ArrayList<Integer>();
           int RunNum = 1;
           while(Scany.hasNextLine() == true) {

               System.out.println("Start of WHile");
               if (Heapy.isEmpty()== false)
               {System.out.println("flippin empty");}
               while (Heapy.isEmpty()== false) {
                   System.out.println("Start of SECOND WHile");
                   String TempFile = "TempFile" + RunNum + ".txt";
                   //System.out.Println()
                   FileWriter fw = new FileWriter(TempFile,true);
                   PrintWriter pw = new PrintWriter(fw);
                   TEMP = Heapy.extractMin();
                   System.out.println("Run " + RunNum + " #: " + TEMP);
                   pw.println(TEMP);
                   pw.close();

                   /*if (Buffy.readLine()== null)
                   {System.out.println(" NULL VALUE WHAT THE");}*/
                   String NextElementy = Buffy.readLine();
                    //if(Scany.hasNextLine() == true) {
                        int NextElement = Integer.parseInt(Buffy.readLine());
                        if (NextElement > TEMP) {
                            System.out.println("Insert into HEAP");
                            Heapy.insert(NextElement);
                        } else {
                            System.out.println("Insert into LIST");
                            list.add(NextElement);
                        }
                   // }
                   /*else
                   {System.out.println("Found error");}*/
                    //catch (IOException e){System.out.println("caught an null");}
               }
               System.out.println("Out of WHile");
               Heapy.MinHeap(list);
               list.clear();
               RunNum++;
           }

       }
       catch (IOException e)
       {System.out.println("File Not found?");}
    }


    public static void main(String args[])
    {

        System.out.println("instantiate heapy");
        FileOut(100);
        Replacement("Test.txt");



    }


}
