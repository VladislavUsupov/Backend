package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.DatasetModel;
import ru.csu.iit.backend.services.DatasetsService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {
    Properties properties;
    protected final Logger logger = Logger.getLogger(BaseTest.class);

    public BaseTest() {
        properties = new Properties();
        String propertiesFileName = System.getProperty("PROPERTIES_FILE");
        if (propertiesFileName == null) {
            propertiesFileName = "ru.csu.iit.backend/app.properties";
//            throw new AssertionError("Test run blocked. Env variable PROPERTIES_FILE is not defined");
        }
        try (InputStream in = BaseTest.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            properties.load(in);
        } catch (IOException e) {
            throw new AssertionError("Test run blocked. Cannot read properties", e);
        }
    }

    public Integer getDatasetId() {
        DatasetsService datasetsService = new DatasetsService(properties);
        RequestSpecification requestSpecification = datasetsService.request()
                .top(1)
                .contains("Caption", "Нестационарные торговые объекты")
                .getFields("Id")
                .build();
        DatasetModel[] datasets = datasetsService.execute(requestSpecification);

        return datasets[0].getId();
    }

    @Test(groups = "id")
    public void gettingDatasetId()
    {
        assertEquals(getDatasetId().toString(),String.valueOf(619));
    }
}
