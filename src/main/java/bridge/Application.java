package bridge;

public class Application {
    private static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        outputView.printStartGameMessage();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.process();
    }
}
