package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.DatasetRequestBuilder;
import ru.csu.iit.backend.models.CaptionModel;
import ru.csu.iit.backend.models.DatasetModel;

import java.util.Properties;

public class DatasetsService extends BaseService {
    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder request() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetModel[] execute(RequestSpecification requestSpecification) {
        return requestSpecification.post().then()
                .extract()
                .body().as(DatasetModel[].class);
    }

    public Response executeRow(RequestSpecification requestSpecification) {
        return requestSpecification.post();
    }

    public CaptionModel executeWithId(RequestSpecification requestSpecification, int datasetId) {
        String request = datasetId + "/";
        return requestSpecification.post(request).then().extract().body().as(CaptionModel.class);
    }

    public Response executeCountWithId(RequestSpecification requestSpecification , int datasetId) {
        String request =  datasetId + "/count";
        return requestSpecification.get(request);
    }

}
