package model;

public class RegWithError {

    private Boolean status;
    private String message;
    private String stringCode;

    public Boolean getStatus() {
        return status;
    }

    public RegWithError withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RegWithError withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStringCode() {
        return stringCode;
    }

    public RegWithError withStringCode(String stringCode) {
        this.stringCode = stringCode;
        return this;
    }

    @Override
    public String toString() {
        return "RegWithError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", stringCode='" + stringCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegWithError)) return false;

        RegWithError that = (RegWithError) o;

        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null) return false;
        return getStringCode() != null ? getStringCode().equals(that.getStringCode()) : that.getStringCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getStatus() != null ? getStatus().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getStringCode() != null ? getStringCode().hashCode() : 0);
        return result;
    }
}
