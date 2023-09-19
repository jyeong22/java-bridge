package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static Player player;
    private static Bridge bridge;
    private static int count = 0;
    private static boolean isSuccess = true;

    public void process(){
        bridge = new Bridge();
        player = new Player(bridge);
        move();
        printTotalResult();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        ++count;
        int startIndex = 0;
        while(startIndex != bridge.getLength() && isSuccess){
            String canGo = player.playerMove();
            if(canGo.equals("X")){
                isSuccess = false;
            }
            ++startIndex;
        }
        if(!isSuccess){
            askRetryOrQuit();
        }
    }


    private void askRetryOrQuit() {
        if(player.askRetryOrQuit().equals("R")){
            retry();
            move();
        }
    }

    private void printTotalResult() {
        player.printTotalResult(count, isSuccess);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        resetPlayerMap();
        resetSuccess();
    }

    private void resetSuccess() {
        isSuccess = true;
    }

    private void resetPlayerMap() {
        player.reset();
    }
}
