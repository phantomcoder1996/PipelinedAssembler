package com.company;












public class Main {

    public static void main(String[] args) {
	// write your code here

        Translator.initializeOpcodes();
        Translator.initializeRegisters();
        Translator.initUsesDst();
        MemoryManager.initMemory(1024,1024);
        AssemblyFManager fManager=new AssemblyFManager();
        fManager.readFile("sampletestcase.asm");
       // fManager.readFile("TestCases/testcase3.txt");
        //fManager.writeFile("TestCasesResults/TestCase2.mem");

        MemoryManager.loadInstructionMemory(fManager.instructions);

        fManager.writeMemory("TestCasesResults/TestCase3Ram.mem");
        fManager.writeInstructionMemory("TestCasesResults/TestCase3.mem");
    }
}
