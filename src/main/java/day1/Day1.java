package day1;

import ARUtils.Logg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1
{
    public static Logg log = new Logg(Day1.class, Logg.Level.INFO);

    public static final int LISTSIZE = 3;

    public static void main(String[] args) {
        try {
            log.info(System.getProperty("user.dir"));
            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/main/java/day1/input.txt"));

//            int s = 0;
            int max = 0;
            int sum = 0;
            List<Integer> list = new ArrayList<>(); //1 for the 1st part
            while(sc.hasNext())
            {
                String val = sc.nextLine();
                log.info(val);
//                if("".equals(val))
                if(val==null || "".equals(val))
                {
                    if(list.size()<LISTSIZE)
                    {
                        list.add(sum);
                    }
                    else
                    {
                        for(Integer i : list)
                        {
                            if(sum > i)
                            {
                                list.add(sum);
                                break;
                            }
                        }
                        if(list.size()>LISTSIZE)
                        {
                            Collections.sort(list);
                            list.remove(0);
                        }
                    }
                    sum=0;
                }
                else
                {
                    sum+=Integer.parseInt(val);
                }
            }
            int res=0;
            for(Integer i : list)
            {
                res+=i;
            }
            log.info("res: "+res);
        } catch (FileNotFoundException e) {
           log.info("FNF");
        }
    }
}
