package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    int oneM = 1024 * 1024;
    int twoM = 20 * oneM;
    int fourM = 40 * oneM;

    int oneK = 3500 * 1024;
    int fourK = 2500 * 1024;
    @Test
    public void testGC(){

        int a = 0;
        a++;
        System.out.println(a);
        System.out.println("=-=-=-==-=-=-=-=-");


        int no = 1;

        printMemory();
        gc(no++);

        printMemory();
        byte[] tyte2 = new byte[3*oneM];
        for (int i = 0; i < 80; i++) {
            tyte2 = new byte[oneM];
        }
        tyte2 = null;
//        if (true) return;// 1245
        gc(no++);
//        if (true) return;
//        System.gc();
        printMemory();
        byte[] tytek = new byte[3*oneM];
        byte[] tyte4 = new byte[fourM];
        tyte4 = null;
//        printMemory();
        gc(no++);
        if (true) return;
//        printMemory();
        byte[] tyte2k = new byte[fourK];
        tyte4 = new byte[fourM];
        tyte4 = null;
        printMemory();
        gc(no++);
        printMemory();
        byte[] tyte44 = new byte[fourM];
//        System.gc();
    }

    public void printMemory(){
        System.out.println("=================");
        System.out.println(""+Runtime.getRuntime().maxMemory()/1024);
        System.out.println(Runtime.getRuntime().freeMemory()/1024);
    }

    public void gc(int no){
        System.out.println("第" + no + "次GC");
        System.gc();
    }

}
