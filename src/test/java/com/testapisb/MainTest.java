package com.testapisb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.testapisb.model.ApiResponse;
import com.testapisb.model.Company;

public class MainTest {
    // soal no 2
    @Test
    public void getCompanies_objectAssertions() {
        Client client = new Client();
        int [] quantityParam = {20, 5, 1};
        for(int quantity : quantityParam){
            ApiResponse<Company> resp = client.getResponseCompanies(quantity);
            assertEquals(200, resp.getCode());
            assertTrue("Expected exactly " + quantity + " items", resp.hasSize(quantity));
        }
    }

    // soal no 3a
    @Test
    public void getCompanies_IdAssertionNotNull() {
        Client client = new Client();
        int [] quantityParam = {20, 5, 1};
        for(int quantity : quantityParam){
            ApiResponse<Company> resp = client.getResponseCompanies(quantity);
            assertEquals(200, resp.getCode());
            for(Company company : resp.getData()){
                assertFalse("Company ID must not be empty", company.getId().trim().isEmpty());
            }
        }
    }

    // soal no 3b
    @Test
    public void getCompanies_AssetJSONSchema() {
        Client client = new Client();
        int [] quantityParam = {20, 5, 1};
        for(int quantity : quantityParam){
            client.getResponseToSchema(quantity, "schema/company.json");
        }
    }
}
