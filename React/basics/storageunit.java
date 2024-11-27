public class storageunit {
    int length , wid , hei;
    storageunit(int len , int width , int  h)
    {
        length = len;
        wid = width;
        hei = h;
    }
    storageunit(int len)
    {
        length = len;
        wid = len;
        hei = len;
    }
    void area()
    {
        int area = length * wid * hei ;
        System.out.println("Area of storage unit is " + area);
    }
    public static void main(String[] args) {
        storageunit s1 = new storageunit(22, 23 , 21);
        storageunit s2 = new storageunit(22);
        s1.area();
        s2.area();
    }
}
