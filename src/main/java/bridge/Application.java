package bridge;

import bridge.controller.BridgeGame;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameProcess();
    }
}
