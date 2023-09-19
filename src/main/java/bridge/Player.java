package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static List<String> playerProcess;
    private static Bridge bridge;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static final String upString = "U";
    private static final String downString = "D";
    private static final String retryCommand = "R";
    private static final String quitCommand = "Q";

    Player(Bridge bridge){
        this.bridge = bridge;
        playerProcess = new ArrayList<>();
    }

    public String playerMove(){
        String direction = validateDirection(inputDirection());
        playerProcess.add(direction);
        return printPlayerProcess();
    }

    public String askRetryOrQuit(){
        return validateInput(inputView.readGameCommand());
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

    public static Bridge getBridge() {
        return bridge;
    }

    public static List<String> getPlayerProcess() {
        return playerProcess;
    }

    private String inputDirection() {
        return inputView.readMoving();
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

    public String printPlayerProcess() {
        return outputView.printMap(this);
    }

    public void reset() {
        playerProcess = new ArrayList<>();

    }

    public void printTotalResult(int count, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        outputView.printMap(this);
        outputView.printResult(count, isSuccess);
    }
}
