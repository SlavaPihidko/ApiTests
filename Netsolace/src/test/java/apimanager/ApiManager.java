package apimanager;

public class ApiManager {

    private ApiRegHelper apiRegHelper;

    private ApiAveragePrice apiAveragePrice;

    public void dealWithApi() {
        apiRegHelper = new ApiRegHelper();
        apiAveragePrice = new ApiAveragePrice();
    }

    public ApiRegHelper getApiRegHelper() {
        return apiRegHelper;
    }

    public ApiAveragePrice getApiAveragePrice() {
        return apiAveragePrice;
    }
}
