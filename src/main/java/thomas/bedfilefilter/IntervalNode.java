package thomas.bedfilefilter;

import java.util.*;


public class IntervalNode{
        private int start;
        private int end;
        private int maxEnd;
        private Set<String> filenames=new HashSet<>();
        private IntervalNode left; 
        private IntervalNode right;

        public IntervalNode(int start, int end, String filename) {
            this.start = start;
            this.end = end;
            this.maxEnd = end;
            this.filenames.add(filename);
            this.left = this.right = null;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
        this.end = end;
        }

        public int getMaxEnd() {
        return maxEnd;
        }

        public void setMaxEnd(int maxEnd) {
        this.maxEnd = maxEnd;
        }

        public Set<String> getFilenames() {
            return filenames;
        }

        public void addFilename (String filename){
            this.filenames.add(filename);
        }

        public IntervalNode getLeft() {
            return left;
        }

        public void setLeft(IntervalNode left) {
            this.left = left;
        }

        public IntervalNode getRight() {
            return right;
        }

        public void setRight(IntervalNode right) {
            this.right = right;
        }

         public String fileNamesList (){
            List<String> list = new ArrayList<>();
            for (String s: filenames)
            {
                list.add("[ "+s+" ]");
            }
            return String.join(" - ",list);
        }


}