package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeList = new ArrayList<>();
        for(int i = 0; i<size;++i){
            makeCompartment(bridgeList);
        }
        return bridgeList;
    }

    private void makeCompartment(List<String> bridgeList) {
        int generatedNum = bridgeNumberGenerator.generate();
        addBridgeCompartment(bridgeList, generatedNum);
    }

    private void addBridgeCompartment(List<String> bridgeList, int generatedNum) {
        if(randomNumPointsDown(generatedNum)){
            bridgeList.add("D");
            return;
        }
        bridgeList.add("U");
    }

    private boolean randomNumPointsDown(int generatedNum) {
        return generatedNum == 0;
    }

}
