package bridge;

import java.util.List;

public class OutputView {

    private static final String startGameMessage = "다리 건너기 게임을 시작합니다.\n";
    private static final String isSuccessMessage = "게임 성공 여부: ";
    private static final String totalCountMessage = "총 시도한 횟수: ";
    private static final String upString = "U";
    private static final String downString = "D";
    private static final String failMessage = "실패";
    private static final String successMessage = "성공";
    private static final String canGo = "O";
    private static final String canMotGo = "X";
    private static final String notSelected = " ";
    private static final String seperator = "|";
    private static final String startOfBridge = "[";
    private static final String endOfBridge = "]";
    private static final String space = " ";

    public static void printStartGameMessage(){
        System.out.println(startGameMessage);
    }

    public static void printMap(List<String> playerMap, List<String> bridgeMap) {
        String level = upString;
        for (int i = 0; i < 2; ++i) {
            printEachLevelOfBridge(playerMap, bridgeMap, level);
            level = downString;
        }
        System.out.println();
    }

    private static void printEachLevelOfBridge(List<String> playerMap, List<String> bridgeMap, String level) {
        StringBuilder outputString = new StringBuilder();
        addStartOfBridge(outputString);
        for (int i = 0; i < playerMap.size(); ++i) {
            addMiddleOfBridge(outputString, playerMap.get(i), bridgeMap.get(i), level);
            if (seperaterNeeded(i, playerMap.size())) {
                addSeperator(outputString);
            }
        }
        addEndOfBridge(outputString);
        System.out.println(outputString);
    }

    private static void addStartOfBridge(StringBuilder outputString) {
        outputString.append(startOfBridge+space);
    }

    private static void addMiddleOfBridge(StringBuilder outputString, String playerComponent, String bridgeComponent, String level) {
        if(playerComponent.equals(level)){
            if (isSame(playerComponent, bridgeComponent)) {
                outputString.append(canGo+space);
                return;
            }
            outputString.append(canMotGo+space);
            return;
        }
        outputString.append(notSelected+space);
    }

    private static boolean isSame(String playerComponent, String bridgeComponent) {
        return playerComponent.equals(bridgeComponent);
    }

    private static boolean seperaterNeeded(int currentIndex, int mapSize) {
        return currentIndex != mapSize-1;
    }

    private static void addSeperator(StringBuilder outputString) {
        outputString.append(seperator+space);
    }

    private static void addEndOfBridge(StringBuilder outputString) {
        outputString.append(endOfBridge);
    }

    public static void printResult(boolean isSuccess, int count) {
        printSuccessOrFail(isSuccess);
        printTotalTryCount(count);
    }

    private static void printSuccessOrFail(boolean isSuccess) {
        System.out.println(isSuccessMessage+boolToString(isSuccess));
    }

    private static String boolToString(boolean isSuccess) {
        if(isSuccess){
            return successMessage;
        }
        return failMessage;
    }

    private static void printTotalTryCount(int count) {
        System.out.println(totalCountMessage+count);
    }

}
