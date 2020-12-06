import org.apache.commons.lang3.builder.*;

public class Bank {
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
