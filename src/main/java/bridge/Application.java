package bridge;

public class Application {
    public static void main(String[] args) {
        OutputView.printStartGameMessage();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.process();
        OutputView.printResult(bridgeGame.getSuccessValue(), bridgeGame.getTryCount());
    }
}
