package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputBridgeLengthMessage = "다리의 길이를 입력해주세요.";
    private static final String inputMoveDirect = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String inputRetryOrQuit = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public String readBridgeSize() {
        System.out.println(inputBridgeLengthMessage);
        return Console.readLine();
    }
    public String readMoving() {
        System.out.println(inputMoveDirect);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(inputRetryOrQuit);
        return Console.readLine();
    }
}
