package thomas.bedfilefilter;

import java.util.*;


public class IntervalTree{

    private IntervalNode root = new IntervalNode(-1, -1, "");

    public void insert(int start, int end,String fileName)
    {
        insert(this.root, start,end,fileName);
    }

        private void insert(IntervalNode node, int start, int end, String fileName) {
    if (node.getStart() == -1) 
    {
        node.setStart(start);
        node.setEnd(end);
        node.addFilename(fileName);
        node.setMaxEnd(end);
    }
    else
    {
        while (true) 
        {

            if (start == node.getStart() && end == node.getEnd()) 
            {
                node.addFilename(fileName);
                break;
            }

            node.setMaxEnd(Math.max(node.getMaxEnd(), end));

            if (start < node.getStart()) 
            {
                if (node.getLeft() != null) 
                {
                    node = node.getLeft();
                } 
                else 
                {
                    node.setLeft(new IntervalNode(start, end, fileName));
                    break;
                }
            } 
            else 
            {     
                if (node.getRight() != null) 
                {
                    node = node.getRight();
                } 
                else 
                {
                    node.setRight(new IntervalNode(start, end, fileName));
                    break;
                }
            }  
        }
    }
    }

    public Set<String> search(int position) 
    {
        Set<String> result = new HashSet<>();
        search(root, position, result);
        return result;
    }

    
    private Set<String> search(IntervalNode node, int position, Set<String> result) 
    {
        if (node == null) 
        {
            return result;
        }

        if (position >= node.getStart() && position <= node.getEnd()) 
        {
            result.addAll(node.getFilenames());
            System.out.println("Ajout de : " + node.fileNamesList());
        }

        if (node.getLeft() != null && position <= node.getLeft().getMaxEnd()) 
        {
            search(node.getLeft(), position, result);
        }

        if (node.getRight() != null && position >= node.getStart()) 
        {
            search(node.getRight(), position, result);
        }

        return result;
}


    public void inspect(IntervalNode node)
    {
        if(node == null)
        {
            node = root;
        }
        if(node.getLeft() != null)
        {
            inspect(node.getLeft());    
        }
        if(node.getRight() != null)
        {
            inspect(node.getRight());
        }
    }

}