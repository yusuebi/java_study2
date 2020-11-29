public class Outer {
    int outerMember;
    void outerMethod() {
        int a = 10;
        class Inner {
            public void innerMethod() {
                System.out.println("innerMethodです");
                System.out.println(outerMember);
            }
        }
        Inner ic = new Inner();
        ic.innerMethod();
    }
}
