package com.company;

import java.io.*;
import java.nio.BufferOverflowException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Vector;

public class AssemblyFManager {

    Vector<Instruction> instructions=new Vector<>();
    Vector<Integer> data=new Vector<>();


    private String getBinaryString(Integer val)
    {
        String immediate="";
        immediate=Integer.toBinaryString(val); //Assume it is in decimal format
        while (immediate.length()<16)
        {
            immediate="0"+immediate;

        }
        if(immediate.length()>16)
        {
            immediate=immediate.substring(16);
        }
        return immediate;
    }


    public void readFile(String fileName)
    {
        BufferedReader reader = null;
        boolean state=false; //0 reading data 1 reading ins
        try {
            reader= new BufferedReader(new FileReader(fileName));
            String ins="";

            while((ins=reader.readLine())!=null)
            {
               if(!ins.equals("")) {
                   String[] tokens =ins.split(";"); //remove comments
                   ins=tokens[0].trim();
                   try {
                       if (!state&&!ins.equals("")) {
                           Integer val = Integer.parseInt(ins);
                         //  String binaryInt=Integer.toBinaryString(val);
                          // System.out.println(Integer.toBinaryString(val));
                           MemoryManager.writeToDataMemory(getBinaryString(val));
                       }
                   } catch (NumberFormatException e) {

                       state = true;
                   }
                   if (state) {

                       System.out.println(ins);
                       if (!ins.equals(""))
                       {
                           Instruction instrObj=new Instruction(ins);
                           instructions.add(instrObj);
                           System.out.println(instrObj.op+" "+instrObj.src+" "+instrObj.dst+" "+instrObj.immediate);
                          if(!instrObj.isAddress) System.out.println(instrObj.parseInstruction());
                          else
                              System.out.println("address="+instrObj.address);
                       }
                   }

               }
            }

            reader.close();

            Integer beginProg=Integer.parseInt(MemoryManager.dataMemory.get(0),2);

            MemoryManager.setInstrAddress(beginProg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeFile(String fileName)
    {
        int counter=0;
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
            for(int i=0;i<instructions.size();i++)
            {
                writer.write(counter+": "+instructions.get(i).parseInstruction());
                writer.newLine();
                counter++;
                if(instructions.get(i).twoWord) {
                    writer.write(instructions.get(i).getImmediate());
                    writer.newLine();
                    counter++;
                }

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMemory(String fileName)
    {
        int counter=0;
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
            writer.write("// memory data file (do not edit the following line - required for mem load use)\n" +
                    "// instance=/processor/MemoryStage/MyRam/ram\n" +
                    "// format=mti addressradix=d dataradix=b version=1.0 wordsperline=1");
            writer.newLine();
            for(int i=0;i<MemoryManager.dataMemory.size();i++)
            {
                writer.write(counter+": "+MemoryManager.dataMemory.get(i));
                writer.newLine();
                counter++;

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInstructionMemory(String fileName)
    {
        int counter=0;
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));

            writer.write("// memory data file (do not edit the following line - required for mem load use)\n" +
                    "// instance=/processor/FetchStage/IM/mem\n" +
                    "// format=mti addressradix=d dataradix=b version=1.0 wordsperline=1");
            writer.newLine();
            for(int i=0;i<MemoryManager.instructionMemory.size();i++)
            {
                writer.write(counter+": "+MemoryManager.instructionMemory.get(i));
                writer.newLine();
                counter++;

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
