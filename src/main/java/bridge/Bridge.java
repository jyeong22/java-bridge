package bridge;

import java.util.List;

public class Bridge {

    private static int length;
    private static List<String> bridgeList;
    private static final int minimumBridgeLength = 3;
    private static final int maximumBridgeLength = 20;
    private static InputView inputView = new InputView();

    Bridge(){
        String size = validate(inputView.readBridgeSize());
        length = convertStringToInt(size);
        bridgeList = makeBridge();
        System.out.println();
    }

    private String validate(String size) {
        if(isEmptyString(size)){
            throw new IllegalArgumentException("[ERROR] 다리의 길이를 입력해주세요.");
        }
        else if (!isStringNumber(size)){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자입니다.");
        }
        else if (isNotInRange(convertStringToInt(size))){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20 이하의 숫자여야 합니다.");
        }
        return size;
    }

    private boolean isEmptyString(String size) {
        return size.isBlank();
    }

    private boolean isStringNumber(String size) {
        return size.chars().allMatch(Character::isDigit);
    }

    private boolean isNotInRange(int size) {
        return size<minimumBridgeLength || size > maximumBridgeLength;
    }

    private int convertStringToInt(String size) {
        return Integer.parseInt(size);
    }

    private List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(length);
    }

    public static int getLength() {
        return length;
    }

    public static List<String> getBridgeList() {
        return bridgeList;
    }
}
