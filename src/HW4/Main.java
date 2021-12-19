package HW4;

public class Main {
    public static void main(String[] args) {
        String s = "White Russian winter";
        byte[] bytes = s.getBytes();
        StringProvider sProvider = new StringProvider(s);
        StringConsumer sConsumer = new StringConsumer();
        ByteProvider bProvider = new ByteProvider(bytes);
        ByteAdapter bAdapter = new ByteAdapter(bProvider);

        sConsumer.printString(sProvider.getData());
        sConsumer.printString(bAdapter.getData());
    }
}
