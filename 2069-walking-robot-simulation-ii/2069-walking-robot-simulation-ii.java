// class Robot {
//     int width;
//     int height; 
//     int x;
//     int y;
//     int d;  
//     public Robot(int width, int height) {
//         this.width = width;
//         this.height = height;
//         d = 0;
//         x=0;
//         y=0;
        
//     }
    
    

//     public void step(int num) {
//         for (int i = 0; i < num; i++) {

//             if (d == 0) { // East
//                 if (x + 1 < width) {
//                     x++;
//                 } else {
//                     d = 1;
//                     i--; // retry same step
//                 }
//             } 
//             else if (d == 1) { // North
//                 if (y + 1 < height) {
//                     y++;
//                 } else {
//                     d = 2;
//                     i--;
//                 }
//             } 
//             else if (d == 2) { // West
//                 if (x - 1 >= 0) {
//                     x--;
//                 } else {
//                     d = 3;
//                     i--;
//                 }
//             } 
//             else { // South
//                 if (y - 1 >= 0) {
//                     y--;
//                 } else {
//                     d = 0;
//                     i--;
//                 }
//             }
//         }
//     }
    
//     public int[] getPos() {
//         return new int[]{x,y};
//     }
    
//     public String getDir() {
//         if(d == 0)return "East";
//         else if(d == 1) return "North";
//         else if(d == 2) return "West";
//         else return "South";
//     }
// }

// /**
//  * Your Robot object will be instantiated and called as such:
//  * Robot obj = new Robot(width, height);
//  * obj.step(num);
//  * int[] param_2 = obj.getPos();
//  * String param_3 = obj.getDir();
//  */



class Robot {
    int width, height;
    int x, y;
    int d; // 0=East, 1=North, 2=West, 3=South
    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        d = 0;
        perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        if (perimeter == 0) return;

        num = num % perimeter;

        // Special case: full cycle
        if (num == 0) {
            //
                d = 3; // South
            //}
            return;
        }

        while (num > 0) {

            if (d == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
                if (num > 0) d = 1;
            } 
            else if (d == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
                if (num > 0) d = 2;
            } 
            else if (d == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) d = 3;
            } 
            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) d = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (d == 0) return "East";
        else if (d == 1) return "North";
        else if (d == 2) return "West";
        else return "South";
    }
}