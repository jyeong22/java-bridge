package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String startGameMessage = "다리 건너기 게임을 시작합니다.\n";
    private static final String upString = "U";
    private static final String downString = "D";
    private static final String isSuccessMessage = "게임 성공 여부: ";
    private static final String failMessage = "실패";
    private static final String successMessage = "성공";
    private static final String totalCountMessage = "총 시도한 횟수: ";

    private String canGoStr;


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(Player player) {
        canGoStr = "O";
        List<String> playerMap = player.getPlayerProcess();
        List<String> bridgeMap = player.getBridge().getBridgeList();
        compare(playerMap, bridgeMap);
        return canGoStr;
    }

    private void compare(List<String> playerMap, List<String> brideMap) {
        String level = upString;
        for(int i = 0; i<2;++i){
            printCase(playerMap, brideMap, level);
            level = downString;
        }
        System.out.println();
    }

    private void printCase(List<String> playerMap, List<String> brideMap, String level) {
        StringBuilder outputString = new StringBuilder();
        outputString.append("[ ");
        for (int i = 0; i < playerMap.size(); ++i) {
            String canGo = printMessage(playerMap.get(i), brideMap.get(i), level);
            outputString.append(canGo + " ");
            if (canGo == "X") {
                canGoStr = "X";
            }
            if (i != playerMap.size() - 1) {
                outputString.append("| ");
            }
        }
        outputString.append("]");
        System.out.println(outputString);
    }

    private String printMessage(String playerComponent, String bridgeComponent, String direction) {
        if(playerComponent.equals(direction)){
            if(isSame(playerComponent, bridgeComponent)){
                return "O";
            }
            return "X";
        }
        return " ";
    }

    private boolean isSame(String playerComponent, String bridgeComponent) {
        return playerComponent.equals(bridgeComponent);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, boolean isSuccess) {
        System.out.println(isSuccessMessage+boolToString(isSuccess));
        System.out.println(totalCountMessage+count);
    }

    private String boolToString(boolean isSuccess) {
        if(isSuccess){
            return successMessage;
        }
        return failMessage;
    }

    public void printStartGameMessage(){
        System.out.println(startGameMessage);
    }
}
