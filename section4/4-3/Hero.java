class Hero {
    String name;
    int hp;
    public int hashCode() {
        int result = 37;
        result = result * 31 + name.hashCode();
        result = result * 31 + hp;
        return result;
    }
}
