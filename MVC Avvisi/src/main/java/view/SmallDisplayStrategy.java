package view;

public enum  SmallDisplayStrategy implements ShowStrategy {
    INSTANCE;

    @Override
    public String getOutputText(String s) {
        return s.split("\n")[0];
    }
}
