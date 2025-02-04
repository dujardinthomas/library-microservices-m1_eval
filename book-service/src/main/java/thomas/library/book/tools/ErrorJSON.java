package thomas.library.book.tools;

public class ErrorJSON{
    private int code;
    private String message;

    public ErrorJSON(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
