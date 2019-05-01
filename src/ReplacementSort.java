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
           while (i <= 5 ) {
               int ins = Integer.parseInt(Buffy.readLine());
               System.out.println("inserting "+ ins);
               Heapy.insert(ins);
               System.out.println("Worked inserting "+ ins);
               i++;
               System.out.println(i);

               //Array_Z[i] = Integer.parseInt(Buffy.readLine());
           }
           int[] out_array;
           int TEMP = 0;
           // Heapy.sort(Array_Z);
           ArrayList<Integer> listNON = new ArrayList<Integer>();
           int RunNum = 1;
           while(Buffy.readLine() != null ) {

              Heapy.printMe();
               System.out.println("Start of WHile");
               if (Heapy.isEmpty()== true)
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
                    if(NextElementy != null) {
                        int NextElement = Integer.parseInt(NextElementy);
                        if (NextElement > TEMP) {
                            System.out.println("Insert into HEAP");
                            Heapy.insert(NextElement);
                        } else {
                            System.out.println("Insert into LIST");
                            listNON.add(NextElement);
                        }
                    }
                   else
                   {System.out.println("Found error");}
                    //catch (IOException e){System.out.println("caught an null");}
               }
               System.out.println("Out of WHile");
               System.out.println("list: " + listNON);
               ArrayList<Integer> TEMPLIST = new ArrayList<>();
                while(listNON.isEmpty()==false)
                {TEMPLIST.add(listNON.get(0));
                listNON.remove(0) ;
                }
               Heapy.MinHeap(TEMPLIST);
               Heapy.printMe();
                listNON.clear();
               RunNum++;
               Heapy.printMe();
           }

       }
       catch (IOException e)
       {System.out.println("File Not found?");}
    }

    public static void MultVerseTest(String FileName)
    {
        try {
            int MergeNum = 1;
            int i = 1;
            int j = 2;
            File FileMeI = new File("E:\\230\\Project_2_ReplacementSort\\" + FileName + i + ".txt");
            File FileMeJ = new File("E:\\230\\Project_2_ReplacementSort\\" + FileName + j + ".txt");
            while (FileMeI.exists() && FileMeJ.exists()) {

                FileReader FileRep = new FileReader(FileName + i);

                BufferedReader Buffys = new BufferedReader(FileRep);

                FileReader FilePer = new FileReader(FileName + j);
                BufferedReader Buffyz = new BufferedReader(FilePer);


                int OUTFILES = 1;
                int File1 = Integer.parseInt(Buffys.readLine());
                int File2 = Integer.parseInt(Buffyz.readLine());

                FileWriter WriteIt = new FileWriter(FileName + 0);
                PrintWriter pw = new PrintWriter(WriteIt);

                String IfNull1 = Buffys.readLine();
                String IfNull2 = Buffyz.readLine();
                if (IfNull1 != null && IfNull2 != null) {
                    if (File1 < File2)
                        pw.println(File1);
                    if (IfNull1 != null) {
                        File1 = Integer.parseInt(IfNull1);
                    } else if (File1 > File2)
                        pw.println(File2);
                    if (IfNull1 != null) {
                        File2 = Integer.parseInt(IfNull2);
                    }
                } else if (IfNull1 != null && IfNull2 == null) {
                    String IfNull1_2 = Buffys.readLine();
                    while (IfNull1_2 != null) {
                        pw.println(IfNull1_2);
                    }
                } else if (IfNull1 == null && IfNull2 != null) {
                    String IfNull2_2 = Buffyz.readLine();
                    while (IfNull2_2 != null) {
                        pw.println(IfNull2_2);
                    }
                }
            }


            if (FileMeI.exists() == false && FileMeJ.exists() == true) {
                FileReader FileRep4 = new FileReader(FileName + j);
                BufferedReader Buffys4 = new BufferedReader(FileRep4);

                FileWriter WriteIt4 = new FileWriter(FileName + j);
                PrintWriter pw4 = new PrintWriter(WriteIt4);

                String IfNull4 = Buffys4.readLine();
                while (IfNull4 != null) {
                    pw4.println(Integer.parseInt(IfNull4));
                }
            }

            if (FileMeI.exists() == true && FileMeJ.exists() == false) {
                FileReader FileRep5 = new FileReader(FileName + i);
                BufferedReader Buffys5 = new BufferedReader(FileRep5);
                FileWriter WriteIt5 = new FileWriter(FileName + i);
                PrintWriter pw5 = new PrintWriter(WriteIt5);

                String IfNull5 = Buffys5.readLine();
                while (IfNull5 != null) {
                    pw5.println(Integer.parseInt(IfNull5));
                }
            }
        }
            catch(IOException e){System.out.println("file not found");}
    }



    public static void main(String args[])
    {

        System.out.println("instantiate heapy");
        FileOut(100);
        Replacement("Test.txt");
        System.out.println("instantiate heapy DONE");


    }


}
