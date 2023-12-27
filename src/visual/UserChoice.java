package visual;

import exceptions.WrongOperationNumberException;

import java.util.InputMismatchException;

public class UserChoice {
    private int choiceNum;

    public UserChoice(){
        this.choiceNum = 0;
    }

    public void setChoiceNum(String choiceNum) {
        try {
            int num = Integer.parseInt(choiceNum);
            checkUserNum(num);
            this.choiceNum = num;
        }catch (NumberFormatException e){
            System.out.println("I don't understand, what should I do");
            reset();
        } catch (WrongOperationNumberException e) {
            System.out.println(e.getMessage());
            reset();
        }
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    private void checkUserNum(int operationNumber) throws WrongOperationNumberException {
        if(operationNumber < 1 || operationNumber > 3)
            throw new WrongOperationNumberException("I don't understand, what should I do");
    }

    private void reset(){
        this.choiceNum = 0;
    }
}
