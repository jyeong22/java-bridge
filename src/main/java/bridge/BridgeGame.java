package bridge;

public class BridgeGame {

    private static Bridge bridge;
    private static Player player;
    private static int tryCount = 0;
    private static boolean isSuccess = true;

    public void process(){
        bridge = setBridge();
        player = setPlayer();
        move();
        printFinalResult();
    }

    private Bridge setBridge() {
        return new Bridge();
    }

    private Player setPlayer() {
        return new Player(bridge);
    }

    public void move() {
        boolean quitGameValue = false;
        while(!quitGameValue){
            addTryCount();
            goAhead();
            quitGameValue = checkSuccessOrFail();
        }
    }

    private void addTryCount() {
        ++tryCount;
    }

    private void goAhead() {
        int currentLocation = 0;
        while(isNotEndOfBridge(currentLocation)){
            player.moveOneCompartment();
            if(!player.canGo()){
                isSuccess = false;
                return;
            }
            ++currentLocation;
        }
    }

    private boolean isNotEndOfBridge(int currentLocation) {
        return currentLocation != bridge.getSize();
    }

    private boolean checkSuccessOrFail() {
        if(fail()){
            return askPlayerToQuit();
        }
        return true;
    }

    private boolean fail() {
        return !isSuccess;
    }

    private boolean askPlayerToQuit() {
        if(quit()){
            return true;
        }
        retry();
        return false;
    }

    private boolean quit() {
        return player.askRetryOrQuit().equals("Q");
    }

    public void retry() {
        resetPlayerMap();
        resetSuccessValue();
    }

    private void resetPlayerMap() {
        player.setInitialState();
    }

    private void resetSuccessValue() {
        isSuccess = true;
    }

    private void printFinalResult() {
        player.printTotalResult(isSuccess, tryCount);
    }

}
