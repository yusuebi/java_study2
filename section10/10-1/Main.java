import java.io.*;
public class Main {
    public void saveHeroToFile(Hero h) throws IOException {
        Writer w = new BufferedWriter(new FileWriter("rpgsave.dat"));
        w.write(h.name + "\n");
        w.write(h.hp + "\n");
        w.write(h.mp + "\n");
        w.flush();
        w.close();
    }
}
