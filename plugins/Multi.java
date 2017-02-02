import ru.calculator.model.Operation;

/**
 * Created by andrey-goa on 01.02.17.
 */
public class Multi implements Operation {
    @Override
    public double operate(Double aDouble, Double aDouble1) {
        return 0;
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public boolean isValid(Double aDouble, Double aDouble1) {
        if((aDouble!= null)&&(aDouble1!= null)){
            return true;
        }
        return false;
    }
}
