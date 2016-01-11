package test1;
public class Loop1
{
    public static void callLoop(int i)
    {
        int j=i%3;
        if(j==0)
        {
            System.out.println("Three row");
            int k=i/3;//No of Record
            int print=0;
            for(int l=1;l<=k;l++)
            {
                for(int m=1;m<=3;m++)//No of columns
                {print++;
                    System.out.print("m"+print);
                }
                System.out.println();
            }
        }
        else
        {
            int k=i/3; //Nos of columns
            int n=i%3;//for rest of the elements
            int print=0;
            for(int l=1;l<=k;l++)
            {
                for(int m=1;m<=3;m++)
                {print++;
                    System.out.print("m"+print);
                }
                System.out.println();
            }
            for(int l=1;l<=n;l++)
            {
                print++;
                System.out.print("m"+print);
            }
            System.out.println();
        }
        //for(int t=1;t<=i;t++)
        {
            
        }
    }
    public static void main(String arr[])
    {
        callLoop(9);
        System.out.println("----------------------");
        int a=101;
        int j=5;
        int t=a/j;
        int v=a%j;
        int i,l;l=1;int z=5;
        int k=1;
        for(i=1;i<=t;i++)
        {
            for(k=l;k<=z;k++)
            System.out.print(k+"\t");
            System.out.println();
            l=z+1;
            z=(k+5)-1;
        }
        if(v!=0)
        {
            for(v=z-4;v<=a;v++)
            System.out.print(v+"\t");
        }
            
            
    }
}

