package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.view.OutputView;

public class BridgeGame {

    private static int tryCount = 0;
    private static boolean isSuccess = true;
    private static Bridge bridge;
    private static Player player;

    public void gameProcess(){
        printStartMessage();
        initializeBridgeAndPlayer();
        move();
        printResult();
    }

    public void printStartMessage() {
        OutputView.printStartGameMessage();
    }

    public void initializeBridgeAndPlayer(){
        bridge = new Bridge();
        player = new Player();
    }

    public void printResult() {
        OutputView.printResult(player.getPlayerMap(), bridge.getBridgeList(), isSuccess, tryCount);

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
            chooseMoveDirection();
            if(!canGo()){
                isSuccess = false;
                return;
            }
            ++currentLocation;
        }
    }

    public void chooseMoveDirection(){
        player.moveOneCompartment();
        OutputView.printMap(player.getPlayerMap(), bridge.getBridgeList());
    }

    public boolean canGo(){
        int index = player.getPlayerMap().size()-1;
        return player.getPlayerMap().get(index).equals(bridge.getBridgeList().get(index));
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
        player.setInitialMap();
    }

    private void resetSuccessValue() {
        isSuccess = true;
    }

}
