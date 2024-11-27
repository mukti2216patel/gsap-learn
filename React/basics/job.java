abstract class i {
    String name;
    int id;

    abstract public void calcsal();

}

class fulltime extends i {
    int sal;

    fulltime(String n, int i) {
        name = n;
        id = i;
        sal = 0;
    }

    public void calcsal()
    {
       sal = 12*30000;
       System.out.println(sal);
    }

    public void annual() {
        System.out.println(sal/12);
    }
}

class parttime extends i {
    int hr;
    int hw;
    int sal;
    parttime(String n, int i, int h, int w) {
        name = n;
        id = i;
        hr = h;
        hw = w;
    }
    public void calcsal() {
        sal = hr*30000;
        System.out.println(sal);
    }
}
class job{
    public static void main(String args[])
    {
        fulltime f1 = new fulltime("mukti" , 10);
        f1.annual();
        f1.calcsal();
        parttime t1 = new parttime("mukti1", 10, 30, 30);
        t1.calcsal();
    }
}
