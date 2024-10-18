package thomas.bedfilefilter;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BedFileFilter{

    private Map<String,IntervalTree> chromosomes;

    public BedFileFilter(){
        this.chromosomes=new HashMap<String,IntervalTree>();
    }

    public Map<String,IntervalTree> getBedFileFilter ()
    {
        return this.chromosomes;
    }

    public Map<String,IntervalTree> generateMap () throws IOException
    {
        String directoryPath = "C:\\Users\\thoma\\OneDrive\\Bureau\\java\\chu-lille\\algo_interval_tree\\tree\\data";
        File folder = new File(directoryPath);
        if (folder.isDirectory()){
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null)
        {
                for (File file : listOfFiles)
            {
                try(BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String line;
                    while((line=br.readLine())!=null)
                    {
                        if (line.substring(0,1).equals("#")) continue;
                        if (line.substring(0,5).equals("track")) continue;
                        if (line.substring(0,7).equals("browser")) continue;
                        String[] lineDetails = line.split("\t");
                        String chr = lineDetails[0];
                        int posStart = Integer.parseInt(lineDetails[1]);
                        int posEnd = Integer.parseInt(lineDetails[2]);
                        if (!this.chromosomes.containsKey(chr))
                        {
                            this.chromosomes.put(chr,new IntervalTree());
                        }
                        this.chromosomes.get(chr).insert(posStart,posEnd,file.getName());
                        
                    }
                }
            }
        }
        }
        return this.chromosomes;
    }

    public Set<String> getBedFilesPerChromAndPos (String chrom , int pos)
    {
        if (!this.chromosomes.containsKey(chrom))
        {
            return new HashSet<>();
        }
        else
        {
            IntervalTree chromTree = this.chromosomes.get(chrom);
            return chromTree.search(pos);
        }
    }


}