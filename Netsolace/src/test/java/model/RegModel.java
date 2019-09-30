package model;

import java.util.List;

public class RegModel {
    private Boolean status;
    private List<RegModelErrors> errors;

    public Boolean getStatus() {
        return status;
    }

    public RegModel withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public List<RegModelErrors> getErrors() {
        return errors;
    }

    public RegModel withErrors(List<RegModelErrors> errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return "RegModel{" +
                "status=" + status +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegModel)) return false;

        RegModel regModel = (RegModel) o;

        if (getStatus() != null ? !getStatus().equals(regModel.getStatus()) : regModel.getStatus() != null)
            return false;
        return getErrors() != null ? getErrors().equals(regModel.getErrors()) : regModel.getErrors() == null;
    }

    @Override
    public int hashCode() {
        int result = getStatus() != null ? getStatus().hashCode() : 0;
        result = 31 * result + (getErrors() != null ? getErrors().hashCode() : 0);
        return result;
    }
}


