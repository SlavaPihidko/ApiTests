package model;

public class UserRegistration {

    private String lastName;
    private String firstName;
    private int refStoreId;
    private String email;
    private String phone;
    private String password;

    public String getLastName() {
        return lastName;
    }

    public UserRegistration withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistration withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getRefStoreId() {
        return refStoreId;
    }

    public UserRegistration withRefStoreId(int refStoreId) {
        this.refStoreId = refStoreId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistration withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserRegistration withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistration withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", refStoreId=" + refStoreId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRegistration)) return false;

        UserRegistration that = (UserRegistration) o;

        if (getRefStoreId() != that.getRefStoreId()) return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        return getPassword() != null ? getPassword().equals(that.getPassword()) : that.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getLastName() != null ? getLastName().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + getRefStoreId();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
