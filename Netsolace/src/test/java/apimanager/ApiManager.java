package apimanager;

public class ApiManager {

    private ApiRegistrationHelper apiRegistrationHelper;

    public void dealWithApi() {
        apiRegistrationHelper = new ApiRegistrationHelper();
    }

    public ApiRegistrationHelper getApiRegistrationHelper() {
        return apiRegistrationHelper;
    }
}
