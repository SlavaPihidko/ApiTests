package apimanager;

import model.LatesBlock;

public class ApiManager {

    private ApiRegHelper apiRegHelper;

    private ApiAveragePrice apiAveragePrice;

    private ApiLatestUrl apiLatesUrl;

    public void dealWithApi() {
        apiRegHelper = new ApiRegHelper();
        apiAveragePrice = new ApiAveragePrice();
        apiLatesUrl = new ApiLatestUrl();
    }

    public ApiRegHelper getApiRegHelper() {
        return apiRegHelper;
    }

    public ApiAveragePrice getApiAveragePrice() {
        return apiAveragePrice;
    }

    public ApiLatestUrl getApiLatesUrl() {
        return apiLatesUrl;
    }
}
