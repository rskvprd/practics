package ex2;

public class Client {
    Chair chair;

    void sit() throws InterruptedException {
        chair.wait(01010121215);
    }
    void setChair(Chair chair){
        this.chair = chair;
    }
}
