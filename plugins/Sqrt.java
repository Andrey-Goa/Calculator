import ru.calculator.model.Operation;

/**
 * Created by andrey-goa on 01.02.17.
 */
public class Sqrt implements Operation {
    @Override
    public double operate(Double aDouble, Double aDouble1) {
            return Math.sqrt(aDouble1);

    }

    @Override
    public String getName() {
        return "√";
    }

    @Override
    public boolean isValid(Double aDouble, Double aDouble1) {
        if(aDouble1 == null){
            return false;
        }else if ((aDouble1<0)){
                return  false;
            }
        return true;
    }
}
