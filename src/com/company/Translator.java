package com.company;

import java.util.HashMap;
import java.util.Map;

public class Translator {


   public static Map<String,String> opcodes=new HashMap<>();
   public static Map<String,String> registers=new HashMap<>();
   public static Map<String,String> usesSrcOrDst=new HashMap<>();





   public static void initializeOpcodes()
    {

        opcodes.put("nop" ,"00000");
        opcodes.put("mov" ,"00001");
        opcodes.put("add" ,"00010");
        opcodes.put("mul" ,"00011");
        opcodes.put("sub" ,"00100");
        opcodes.put("and" ,"00101");
        opcodes.put("or"  ,"00110");
        opcodes.put("rlc" ,"00111");
        opcodes.put("rrc" ,"01000");
        opcodes.put("shl" ,"01001");
        opcodes.put("shr" ,"01010");
        opcodes.put("setc","01011");
        opcodes.put("clrc","01100");
        opcodes.put("push","01101");
        opcodes.put("pop" ,"01110");
        opcodes.put("out" ,"01111");
        opcodes.put("in"  ,"10000");
        opcodes.put("not" ,"10001");
        opcodes.put("neg" ,"10010");
        opcodes.put("inc" ,"10011");
        opcodes.put("dec" ,"10100");
        opcodes.put("jz"  ,"10101");
        opcodes.put("jn"  ,"10110");
        opcodes.put("jc"  ,"10111");
        opcodes.put("jmp" ,"11000");
        opcodes.put("call","11001");
        opcodes.put("ret" ,"11010");
        opcodes.put("rti" ,"11011");
        opcodes.put("ldm" ,"11100");
        opcodes.put("ldd" ,"11101");
        opcodes.put("std" ,"11110");
    }

    public static void initializeRegisters()
    {
        registers.put("r0","000");
        registers.put("r1","001");
        registers.put("r2","010");
        registers.put("r3","011");
        registers.put("r4","100");
        registers.put("r5","101");
        registers.put("r6","110");
        registers.put("r7","111");
    }


    public static void initUsesSrcorDst()
    {

        opcodes.put("nop" ,"00000");
        opcodes.put("mov" ,"00001");
        opcodes.put("add" ,"00010");
        opcodes.put("mul" ,"00011");
        opcodes.put("sub" ,"00100");
        opcodes.put("and" ,"00101");
        opcodes.put("or"  ,"00110");
        opcodes.put("rlc" ,"00111");
        opcodes.put("rrc" ,"01000");
        opcodes.put("shl" ,"01001");
        opcodes.put("shr" ,"01010");
        opcodes.put("setc","01011");
        opcodes.put("clrc","01100");
        opcodes.put("push","01101");
        opcodes.put("pop" ,"01110");
        opcodes.put("out" ,"01111");
        opcodes.put("in"  ,"10000");
        opcodes.put("not" ,"10001");
        opcodes.put("neg" ,"10010");
        opcodes.put("inc" ,"10011");
        opcodes.put("dec" ,"10100");
        opcodes.put("jz"  ,"10101");
        opcodes.put("jn"  ,"10110");
        opcodes.put("jc"  ,"10111");
        opcodes.put("jmp" ,"11000");
        opcodes.put("call","11001");
        opcodes.put("ret" ,"11010");
        opcodes.put("rti" ,"11011");
        opcodes.put("ldm" ,"11100");
        opcodes.put("ldd" ,"11101");
        opcodes.put("std" ,"11110");
    }


    public static void initUsesDst()
    {

        usesSrcOrDst.put("nop" ,"00");
        usesSrcOrDst.put("mov" ,"01");
        usesSrcOrDst.put("add" ,"11");
        usesSrcOrDst.put("mul" ,"11");
        usesSrcOrDst.put("sub" ,"11");
        usesSrcOrDst.put("and" ,"11");
        usesSrcOrDst.put("or"  ,"11");
        usesSrcOrDst.put("rlc" ,"11");
        usesSrcOrDst.put("rrc" ,"11");
        usesSrcOrDst.put("shl" ,"01");
        usesSrcOrDst.put("shr" ,"01");
        usesSrcOrDst.put("setc","00");
        usesSrcOrDst.put("clrc","00");
        usesSrcOrDst.put("push","11");
        usesSrcOrDst.put("pop" ,"01");
        usesSrcOrDst.put("out" ,"01");
        usesSrcOrDst.put("in"  ,"00");
        usesSrcOrDst.put("not" ,"11");
        usesSrcOrDst.put("neg" ,"11");
        usesSrcOrDst.put("inc" ,"11");
        usesSrcOrDst.put("dec" ,"11");
        usesSrcOrDst.put("jz"  ,"11"); //uses src because it reads the stack pointer
        usesSrcOrDst.put("jn"  ,"11");
        usesSrcOrDst.put("jc"  ,"11");
        usesSrcOrDst.put("jmp" ,"11");
        usesSrcOrDst.put("call","11");
        usesSrcOrDst.put("ret" ,"00");
        usesSrcOrDst.put("rti" ,"00");
        usesSrcOrDst.put("ldm" ,"00");
        usesSrcOrDst.put("ldd" ,"00");
        usesSrcOrDst.put("std" ,"01");
    }

        //useDst => 2
        //useSrc=>  1


}
