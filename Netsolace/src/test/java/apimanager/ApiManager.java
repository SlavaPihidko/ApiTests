package apimanager;

public class ApiManager {

    private ApiRegHelper apiRegHelper;

    private ApiAveragePrice apiAveragePrice;

    private ApiTest2Helper apiTest2Helper;

    public void dealWithApi() {
        apiRegHelper = new ApiRegHelper();
        apiAveragePrice = new ApiAveragePrice();
        apiTest2Helper = new ApiTest2Helper();
    }

    public ApiRegHelper getApiRegHelper() {
        return apiRegHelper;
    }

    public ApiAveragePrice getApiAveragePrice() {
        return apiAveragePrice;
    }

    public ApiTest2Helper getApiTest2Helper() {
        return apiTest2Helper;
    }

}
