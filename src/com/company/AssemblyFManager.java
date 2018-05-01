package com.company;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.Scanner;
import java.util.Vector;

public class AssemblyFManager {

    Vector<Instruction> instructions=new Vector<>();


    public void readFile(String fileName)
    {
        BufferedReader reader = null;
        try {
            reader= new BufferedReader(new FileReader(fileName));
            String ins="";

            while((ins=reader.readLine())!=null)
            {
                System.out.println(ins);
                if(!ins.equals(""))
                instructions.add(new Instruction(ins));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeFile(String fileName)
    {
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
            for(int i=0;i<instructions.size();i++)
            {
                writer.write(instructions.get(i).parseInstruction());
                writer.newLine();
                if(instructions.get(i).twoWord) {
                    writer.write(instructions.get(i).getImmediate());
                    writer.newLine();
                }

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
