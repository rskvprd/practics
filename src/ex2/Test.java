package ex2;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        ChairFactory chairFactory= new ChairFactory();
        client.setChair(chairFactory.createFunctionalChair());
        client.sit();
        client.setChair(chairFactory.createMagicChair());
        client.sit();
    }
}
