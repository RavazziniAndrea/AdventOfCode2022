package day4;

import ARUtils.Logg;
import day3.Day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4
{
    static Logg log = new Logg(Day4.class, Logg.Level.INFO);
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
//        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/day4/easyInput.txt")))
        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/day4/input.txt")))
        {
            int sum=0;
            while(sc.hasNext())
            {
                String str = sc.nextLine();
                String[] sarr = str.split(",");
                if(sarr.length != 2)
                {
                    log.error("WFT");
                    break;
                }

                int n00 = Integer.parseInt(sarr[0].split("-")[0]);
                int n01 = Integer.parseInt(sarr[0].split("-")[1]);
                int n10 = Integer.parseInt(sarr[1].split("-")[0]);
                int n11 = Integer.parseInt(sarr[1].split("-")[1]);

                //I know its trash. But I'm on a hurry....
                List<Integer> li1 = new ArrayList<>();
                for(int i=n10;i<=n11;i++)
                {
                    li1.add(i);
                }
                for(int i=n00;i<=n01;i++)
                {
                    if(li1.contains(i))
                    {
                        log.info(str);
                        sum++;
                        break;
                    }
                }

                //First Part
//                if((n00 <= n10 && n01 >= n11) || (n00 >= n10 && n01 <= n11))
//                {
//                    log.info(sarr[0]);
//                    sum++;
//                }
            }
            log.info("sum: "+sum);
            log.info("Durata: "+ (System.currentTimeMillis()-start)+"ms");
        }
        catch(IOException ex)
        {
            log.error("FNF");
        }
    }
}
