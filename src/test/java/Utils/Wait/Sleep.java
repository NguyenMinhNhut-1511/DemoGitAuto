package Utils.Wait;

public class Sleep {

    public static void sleepInSecond(double time) {
        try {
            Thread.sleep((long) (time * 1000));
        } catch (Exception ex) {
            System.out.println("[ERR]" + ex);
        }
    }
}


