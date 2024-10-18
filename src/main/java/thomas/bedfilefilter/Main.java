package thomas.bedfilefilter;

import java.io.IOException;
import java.util.*;




public class Main{

    public static void main (String[] args) throws IOException {

        System.out.println(args[0]+" "+args[1]);

        BedFileFilter bed = new BedFileFilter();
        bed.generateMap();
        
        Set<String> res = bed.getBedFilesPerChromAndPos(args[0],Integer.parseInt(args[1]));

        for(String name : res)
        {
            System.out.println(name);
        }
            System.out.println("done");
    }
}