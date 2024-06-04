//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
     Stack<Integer> stk;
        Stack<Integer> helper;
       
    
    // Constructor    
    GfG()
	{
     stk = new Stack<>();
        helper = new Stack<>();
	}
	
    /*returns min element from stack*/
    int getMin()
    {
        if(!helper.isEmpty()){
	return helper.peek();
        }
        return -1;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	 if(!stk.isEmpty()){
            int val =  stk.peek();
            stk.pop();
            helper.pop();
           return val;
        }	
        return -1;
    }

    /*push element x into the stack*/
    void push(int val)
    {
	// Your code here
	stk.push(val);
      if(!helper.isEmpty()){
        if(helper.peek() > val){
             helper.push(val);
            
        }else{
           helper.push(helper.peek());
        }

      }else{
        helper.push(val);
      }
    }	
}

