package day2;

import ARUtils.Logg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Day2
{
    public static void main(String[] args)
    {
        Logg log = new Logg(Day2.class, Logg.Level.INFO);
        try
        {
//            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/main/java/day2/input.txt"));
            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/main/java/day2/easyInput.txt"));
            int sum = 0;
            while(sc.hasNext())
            {
                String line = sc.nextLine();
                if(line.split(" ").length!=2)
                {
                    //assumo sia arrivato alla fine
                    break;
                }
//                String s1 = line.split(" ")[0];
//                String s2 = line.split(" ")[1];
                int n1 = getNum(line.split(" ")[0]);
                int n2 = getNum(line.split(" ")[1]);
                log.info(n1+".."+n2);

                int val = n2-n1;
                if(val == 0)
                {
                    log.info(n2+"+3");
                    sum+=(n2+3);
                }
                else if(val < 0)
                {
                    log.info(n2+"+0");
                    sum+=(n2+0);
                }
                else //val > 0
                {
                    log.info(n2+"+6");
                    sum+=(n2+6);
                }
                log.info("sum: "+sum);
            }
        }
        catch (FileNotFoundException e)
        {
            log.error("FNF");
        }

    }

    public static int getNum(String s)
    {
        switch(s.toUpperCase())
        {
            case "A":
            case "X":
                return 1;
            case "B":
            case "Y":
                return 2;
            case "C":
            case "Z":
                return 3;
        }
        return -1;
    }
}
