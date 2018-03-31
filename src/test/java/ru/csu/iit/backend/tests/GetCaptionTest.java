package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.CaptionModel;
import ru.csu.iit.backend.services.DatasetsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;


public class GetCaptionTest extends BaseTest {

    private DatasetsService datasetsService = new DatasetsService(properties);

    @Test(groups = "models")
    public void getCaptionQuery() {

        RequestSpecification requestSpecification = datasetsService.request()
                .getFields("Caption", "Description")
                .build();

        CaptionModel dataset = datasetsService.executeWithId(requestSpecification, getDatasetId());

            assertThat(dataset.getDescription(), notNullValue());
            assertThat(dataset.getCaption(),  notNullValue());



    }
}
