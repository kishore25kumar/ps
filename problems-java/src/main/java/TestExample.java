import java.nio.*;

public class TestExample {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(Integer.bitCount(10));
        byte[] bytes = ByteBuffer.allocate(4).putInt(10).array();
    }
}
