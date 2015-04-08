class T3 {
    public static void main(String[] argv){
        int a;
        Point j;
        int a1;
        j = new Point();
        a1 = 6;
        /*INLINE*/
        j.setX(a1);
        a1 = 7;
        /*INLINE*/
        j.setY(a1);
        /*INLINE*/
        a = j.getX();
        System.out.println(a);
        /*INLINE*/
        a = j.getY();
        System.out.println(a);
    }
}

class Point {
    int x;
    int y;
    public int setX(int x1) {
        x = x1;
        return x;
    }

    public int setY(int y1) {
        y = y1;
        return y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
