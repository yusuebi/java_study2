public class Main {
  public static void main(String[] args) {
    Pocket<String> p = new Pocket<String>();
    p.put("1192");
    String s = p.get();
    System.out.println(s);
  }
}
