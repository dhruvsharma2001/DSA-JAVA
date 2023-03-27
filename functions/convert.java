public class convert {
    public static void bintidec(int binum){
        int mynum = binum;
        int pow=0;
        int decnum = 0;
        while(binum>0){
            int lastdig = binum%10;
            decnum = decnum + (lastdig* (int)Math.pow(2,pow));
            pow++;
            binum = binum/10;
        }
          System.out.println("decimal of " + mynum +"="+ decnum);
    }
    public static void main(String args[]){
        bintidec(101);
    }
}
