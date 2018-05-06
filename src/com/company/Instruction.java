package com.company;

class Instruction
{



    String op;
    String src;
    String dst;
    String immediate;
    public boolean twoWord=false;
    public boolean isAddress=false;
    public Integer address=0;


    private void getImmediateBinaryString(String token)
    {
        immediate=Integer.toBinaryString(Integer.parseInt(token)); //Assume it is in decimal format
        while (immediate.length()<16)
        {
            immediate="0"+immediate;

        }
        if(immediate.length()>16)
        {
            immediate=immediate.substring(16);
        }
    }
    public Instruction(String ins)
    {
        ins=ins.toLowerCase();
        ins=ins.replace(',',' ');
        String[] tokens= ins.split("\\s+");
        op=tokens[0];

        if(tokens.length==1)
        {
            try {

                address = Integer.parseInt(op.substring(1));
                isAddress = true;
            }
            catch (NumberFormatException e)
            {
                src="r0";
                dst="r0";
            }
        }
        else if(tokens.length==2)
        {
            if(op.equals("push")||op.equals("call")||op.equals("pop")||op.equals("jmp")||op.equals("jz")||op.equals("jn")||op.equals("jc"))
            {
                src="r6";
                dst=tokens[1];
            }
            else if(op.equals("out"))
            {
                src=tokens[1];
                dst="r0";
            }
            else //rlc,rrc,in,not,neg,inc,dec
            {
                src=tokens[1];
                dst=tokens[1];
            }
        }
        else if(tokens.length==3)
        {
            if(op.equals("ldm")||op.equals("std")||op.equals("ldd"))
            {
                //Two word instructions
                twoWord=true;

                getImmediateBinaryString(tokens[2]);

                if(op.equals("std"))
                {
                    src=tokens[1];
                    dst="r0";
                }
                else //ldm or ldd
                {
                    dst=tokens[1];
                    src="r0";
                }

            }
            else //add or sub or mul or and or "or" or mov
            {
                src=tokens[1];
                dst=tokens[2];
            }
        }
        else if(tokens.length==4) //shl,shr
        {
            twoWord=true;

            src=tokens[1];
            getImmediateBinaryString(tokens[2]);
            dst=tokens[3];
        }
        else //nop,setc,clrc
        {
            src="r0";
            dst="r0";
        }


    }
    public String parseInstruction()//returns the binary format of an instruction
    {
        StringBuilder binaryIns=new StringBuilder();
        binaryIns.append(Translator.opcodes.get(op));
        binaryIns.append(Translator.registers.get(src));
        binaryIns.append(Translator.registers.get(dst));
        binaryIns.append("00");
        binaryIns.append(Translator.usesSrcOrDst.get(op));
        if(twoWord) binaryIns.append(1);
        else binaryIns.append(0);




        return binaryIns.toString();
    }


    public String getImmediate() {

        return immediate;
    }
}