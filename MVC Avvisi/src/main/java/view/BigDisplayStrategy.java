package view;

public enum BigDisplayStrategy implements ShowStrategy {

    INSTANCE;

    @Override
    public String getOutputText(String s) {
        return s;
    }
}
