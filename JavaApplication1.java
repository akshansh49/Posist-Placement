package javaapplication1;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
class LinkedList
{
    static Node genesisNode;
    static class Node
    {
        Date timeStamp;
        String data;
        int nodeNumber;
        String nodeId;
        String referenceNodeId;
        String childReferenceNodeId[];
        String genesisReferenceNodeId;
        String hashValue;
        Node right;
        Node down;
        Node(int num)
        {
            timeStamp=new Date();
            data="";
            nodeNumber=num;
            nodeId="";
            referenceNodeId="";
            genesisReferenceNodeId="";
            hashValue="";
            right=null;
            down=null;
        }
        public String toHashCode()
        {
            return ""+timeStamp+"@"+data+"@"+nodeNumber+"@"+nodeId+"@"+referenceNodeId+"@"+Arrays.toString(childReferenceNodeId)+"@"+genesisReferenceNodeId;
        }
    }
    public void add(int num)
    {   
        Scanner scan=new Scanner(System.in);
        Node node=new Node(num);
       /* System.out.println("Enter the id of the owner: ");
        int id=scan.nextInt();
        System.out.println("Enter the name of the owner: ");
        String name=scan.nextLine();
        System.out.println("Enter the value: ");
        float value=scan.nextFloat();*/
        if(genesisNode==null)
        {
            genesisNode=node;
            genesisNode.right=null;
            genesisNode.down=null;
        }
        else
        {
           Node temp=genesisNode;
           int parentSum=genesisNode.nodeNumber;
           int siblingSum=0;
           if(temp.right!=null)
           {
                while(temp.right!=null)
                {
                     while(temp.down!=null)
                     {
                         temp=temp.down;
                         siblingSum+=temp.nodeNumber;
                     }
                     if(siblingSum<parentSum)
                     {
                         temp.down=node;
                         temp.right=null;
                         temp.down=null;
                     }
                     else
                     {
                        temp=temp.right;
                     }
                }
           }
           else
           {
                while(temp.down!=null)
                {
                    temp=temp.down;
                    siblingSum+=temp.nodeNumber;
                }
                if(parentSum-siblingSum>node.nodeNumber)
                {
                    temp.down=node;
                    node.right=null;
                    node.down=null;
                }
                else
                {
                    Node nextGreater=genesisNode;
                    while(nextGreater.down.nodeNumber>node.nodeNumber)
                    {
                        nextGreater=nextGreater.down;
                    }
                    temp.right=new Node(nextGreater.nodeNumber);
                    temp.right.down=node;
                }
           }
        }
    }

    public static Node getGenesisNode() {
        return genesisNode;
    }

    public static void setGenesisNode(Node genesisNode) {
        LinkedList.genesisNode = genesisNode;
    }
    public void printList()
    {
        Node top=genesisNode;
        if(top.right==null&&top.down==null)
        {
            System.out.println("List is empty");
        }
        else if(top.right!=null&&top.down!=null)
        {
            System.out.println("Here");
            while(top.right!=null)
            {
                while(top.down!=null)
                {   
                    System.out.print(top.nodeNumber+" ");
                    top=top.down;
                }
                top=top.right;
                System.out.println();
            }
        }
        else if(top.right==null&&top.down!=null)
        {   
            System.out.println("Inside Here");
            while(top.down!=null)
            {   
                System.out.print(top.nodeNumber+" ");
                top=top.down;
            }
        }
    }
}
public class JavaApplication1 {
    public static void main(String[] args)
    {
        LinkedList list=new LinkedList();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of nodes to be entered: ");
        int num=scan.nextInt();
        while(num>0)
        {   
            System.out.println("Enter the nodeId: ");
            int nodeId=scan.nextInt();
            try
            {
                list.add(nodeId);
            }
            catch(Exception ie)
            {
                list.printList();
            }
            num--;
        } 
         list.printList();
    }
}
