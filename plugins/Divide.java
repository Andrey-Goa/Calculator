import ru.calculator.model.Operation;

public class Divide implements Operation {
    @Override
    public double operate(Double aDouble, Double aDouble1) {
        return aDouble/aDouble1;
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public boolean isValid(Double aDouble, Double aDouble1) {
        if((aDouble != null)&&(aDouble1 != null)){
            return true;
        }
        return false;
    }
}
