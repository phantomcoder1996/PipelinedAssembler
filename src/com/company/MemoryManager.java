package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class MemoryManager {

    public static int dataAddress=0;
    public static int instrAddress=0;

    public static ArrayList<String> dataMemory=new ArrayList<>();

    public static ArrayList<String> instructionMemory=new ArrayList<>();

    public static void initMemory(int dataMemSize,int instRuctionMemSize)
    {

        for(int i=0;i<dataMemSize;i++)
        {
            dataMemory.add("0000000000000000");
        }
        for(int i=0;i<instRuctionMemSize;i++)
        {
           instructionMemory.add("0000000000000000");
        }

    }


    public static void writeToDataMemory(String data)
    {
          dataMemory.set(dataAddress,data);
          dataAddress++;
    }

    public static void writeToInstructionMemory(String ins)
    {
        instructionMemory.set(instrAddress,ins);
        instrAddress++;
    }

    public static int getInstrAddress() {
        return instrAddress;
    }

    public static void setInstrAddress(int instrAddress) {
        MemoryManager.instrAddress = instrAddress;
    }

    public static void loadInstructionMemory(Vector<Instruction>instructions)
    {
        for(int i=0;i<instructions.size();i++) {
           Instruction inst=instructions.get(i);
           if(inst.isAddress) setInstrAddress(inst.address);
           else
           {
               writeToInstructionMemory(inst.parseInstruction());
               if(inst.twoWord) writeToInstructionMemory(inst.getImmediate());

           }
        }
    }

}
