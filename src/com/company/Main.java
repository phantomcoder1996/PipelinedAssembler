package com.company;












public class Main {

    public static void main(String[] args) {
	// write your code here

        Translator.initializeOpcodes();
        Translator.initializeRegisters();
        Translator.initUsesDst();
        AssemblyFManager fManager=new AssemblyFManager();
        fManager.readFile("TestCases/TestCase1.txt");
        fManager.writeFile("TestCasesResults/TestCase1.mem");
    }
}
