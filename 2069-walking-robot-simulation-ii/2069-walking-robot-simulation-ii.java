class Robot {
    int x,y;
    int width,height;
    int d;
    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x= 0;
        y=0;
        d=0;
        perimeter = 2*(width + height) - 4;
    }
    
    public void step(int num) {
        num = num % perimeter;
        int step;

        if(num ==0 && x==0 && y==0){
            d = 3;
            return;
        }
        while(num>0){
            if(d==0){
                step=Math.min(num,width-1-x);
                x+=step;
                num-=step;
            }
            else if(d==1){
                step=Math.min(num,height-1-y);
                y+=step;
                num-=step;
            }else if(d==2){
                step=Math.min(num,x);
                x-=step;
                num-=step;
            }else{
                step=Math.min(num,y);
                y-=step;
                num-=step;
            }

            if(num>0){
                d= (d+1)%4;
            }

        }
    }
    
    public int[] getPos() {
        return new int[] {x,y};
    }
    
    public String getDir() {
        if(d==0)return "East";
        else if(d==1)return "North";
        else if(d==2)return "West";
        else return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */