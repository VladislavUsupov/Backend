package ru.csu.iit.backend.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.services.DatasetsService;


import static org.testng.AssertJUnit.assertEquals;

public class GetCountTest extends BaseTest {

    private DatasetsService datasetsService = new DatasetsService(properties);

    @Test(groups = "models")
    public void getCountOfRows() {

        RequestSpecification requestSpecification = datasetsService.request()
                .build();

        Response count = datasetsService.executeCountWithId(requestSpecification, getDatasetId());

        assertEquals(count.body().print(), "10343");
    }
}
