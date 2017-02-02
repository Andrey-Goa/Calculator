import ru.calculator.model.Operation;

/**
 * Created by andrey-goa on 01.02.17.
 */
public class Minus implements Operation {
    @Override
    public double operate(Double aDouble, Double aDouble1) {
        if(aDouble == null){
            return -aDouble;
        }else{
            return aDouble - aDouble1;
        }
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public boolean isValid(Double aDouble, Double aDouble1) {
        if(aDouble1 != null){
            return true;
        }
        return false;
    }
}
