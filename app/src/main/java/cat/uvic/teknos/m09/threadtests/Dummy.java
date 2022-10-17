package cat.uvic.teknos.m09.threadtests;

public class Dummy {
    public static void doImportantStuff1(){
        ImportantStuff1 is1 =new ImportantStuff1();
        is1.run();
    }

    public static void doImportantStuff2(){
        ImportantStuff2 is2 =new ImportantStuff2();
        is2.run();
    }

    public static void doImportantStuff3(){
        ImportantStuff3 is3 =new ImportantStuff3();
        is3.run();
    }

}
