package model;

public class RegModelErrors {
    private String message;
    private String stringCode;

    public String getMessage() {
        return message;
    }

    public RegModelErrors withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStringCode() {
        return stringCode;
    }

    public RegModelErrors withStringCode(String stringCode) {
        this.stringCode = stringCode;
        return this;
    }

    @Override
    public String toString() {
        return "RegModelErrors{" +
                "message='" + message + '\'' +
                ", stringCode='" + stringCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegModelErrors)) return false;

        RegModelErrors that = (RegModelErrors) o;

        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null) return false;
        return getStringCode() != null ? getStringCode().equals(that.getStringCode()) : that.getStringCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getMessage() != null ? getMessage().hashCode() : 0;
        result = 31 * result + (getStringCode() != null ? getStringCode().hashCode() : 0);
        return result;
    }
}
