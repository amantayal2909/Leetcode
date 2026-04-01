import java.util.*;
class Solution {
    public class Data {
    int num;
    char ch;

    public Data(int num, char ch) {
        this.num = num;
        this.ch = ch;
    }
}
    public List<Integer> survivedRobotsHealths(int[] pos, int[] hlth, String dir) {
        TreeMap<Integer, Integer> indexes = new TreeMap<>();

        HashMap <Integer,Data> map = new HashMap<>();
        for(int i = 0 ;i< pos.length; i++){
            map.put(pos[i],new Data(hlth[i],dir.charAt(i)));
            indexes.put(i,pos[i]);
        }
        Arrays.sort(pos);

        //ll rr lr skip focus on rl

        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i< pos.length; i++)
        {
            int x = pos[i];
            Data d = map.get(x);
            int h = d.num;
            char mov = d.ch; 

            //System.out.println(st);
            if(mov == 'R')
            {
                st.push(x);
            }
            else 
            {   

                while(!st.empty())
                {
                    //System.out.println("A");
                    //System.out.println(st);
                    int x_stack = st.peek();

                    Data d_stack = map.get(x_stack);
                    int h_stack = d_stack.num;
                    char mov_stack = d_stack.ch;
                    //System.out.println(x_stack + " "+h_stack + " " +mov_stack);


                    if(mov_stack == 'R')
                    {
                        if(h_stack == h)
                        {
                        st.pop();
                        map.remove(x_stack);
                        map.remove(x);
                        break;
                        }
                        else if(h_stack > h){
                        map.put(x_stack,new Data(h_stack-1,'R'));
                        map.remove(x);
                        break;
                        }
                        else if(h_stack < h){
                        st.pop();
                        Data d1 = map.get(x);
                        int health1 = d1.num;
                        map.put(x,new Data(health1-1,'L'));
                        h=h-1;
                        map.remove(x_stack);

                        }    

                    }
                    else if( mov_stack == 'L'){
                        break;
                    }
                        

                }
                if(map.containsKey(x)){
                    st.push(x);
                }
            }
                
           
        }
        
        for (Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(map.containsKey(value)){
                Data d1 = map.get(value);
                int health1 = d1.num;
                ans.add(health1);
            }



            //System.out.println(key + " -> " + value);
        }
        
        return ans;
    }
}