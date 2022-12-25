package exception;

public class IncorredTaskParametorException extends  Exception{
    private  String parameter;

    public IncorredTaskParametorException(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getMessage() {
        return "Параметр "+parameter+" задан неверно!!!";
    }
}
