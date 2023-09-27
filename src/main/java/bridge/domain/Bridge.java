package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Bridge {

    private static int size;
    private static List<String> bridgeList;
    private static final int minimumSize = 3;
    private static final int maximumSize = 20;

     public Bridge(){
        setSize(validate(InputView.readBridgeSize()));
        setBridgeList();
        System.out.println();
    }

    private void setSize(String size) {
        this.size = convertStringToInt(size);
    }

    private String validate(String size) {
        if(isEmptyString(size) || !isNumber(size)){
            throw new IllegalArgumentException("[ERROR] 다리의 길이를 입력해주세요.");
        }
        else if (isNotInRange(convertStringToInt(size))){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20 이하의 숫자여야 합니다.");
        }
        return size;
    }

    private boolean isEmptyString(String size) {
        return size.isBlank();
    }

    private boolean isNumber(String size) {
        return size.chars().allMatch(Character::isDigit);
    }

    private boolean isNotInRange(int size) {
        return size < minimumSize || size > maximumSize;
    }

    private int convertStringToInt(String size) {
        return Integer.parseInt(size);
    }

    private void setBridgeList() {
        bridgeList = makeBridgeList();
    }

    private List<String> makeBridgeList() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    public static int getSize() {
        return size;
    }

    public static List<String> getBridgeList() {
        return bridgeList;
    }

}
