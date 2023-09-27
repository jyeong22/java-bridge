package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static List<String> playerMap;
    private static final String upString = "U";
    private static final String downString = "D";
    private static final String retryCommand = "R";
    private static final String quitCommand = "Q";

    public Player(){
        setInitialMap();
    }

    public void setInitialMap() {
        playerMap = new ArrayList<>();
    }

    public void moveOneCompartment(){
        addPlayerMap(input());
    }

    private String input() {
        return validateDirection(InputView.readMoving());
    }

    private void addPlayerMap(String moveDirection) {
        playerMap.add(moveDirection);
    }

    private String validateDirection(String inputDirection) {
        if(isEmptyString(inputDirection)){
            throw new IllegalArgumentException("[ERROR] 이동할 칸을 입력해주세요.");
        }
        else if (!isUOrD(inputDirection)){
            throw new IllegalArgumentException("[ERROR] 이동할 칸을 U와 D중 선택해주세요.");
        }
        return inputDirection;
    }

    private boolean isEmptyString(String inputDirection) {
        return inputDirection.isBlank();
    }

    private boolean isUOrD(String inputDirection) {
        return inputDirection.equals(upString) || inputDirection.equals(downString);
    }

    public static List<String> getPlayerMap() {
        return playerMap;
    }

    public String askRetryOrQuit(){
        return validateInput(InputView.readGameCommand());
    }

    private String validateInput(String readGameCommand) {
        if(isEmptyString(readGameCommand)){
            throw new IllegalArgumentException("[ERROR] 재시도 여부를 입력해주세요.");
        }
        else if (!isROrQ(readGameCommand)){
            throw new IllegalArgumentException("[ERROR] 재시도할지 여부를 R과 Q중에 입력해주세요.");
        }
        return readGameCommand;
    }
    private boolean isROrQ(String readGameCommand) {
        return readGameCommand.equals(retryCommand) || readGameCommand.equals(quitCommand);
    }
}
