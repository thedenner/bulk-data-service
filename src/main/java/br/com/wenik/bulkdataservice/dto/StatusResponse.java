package br.com.wenik.bulkdataservice.dto;

public class StatusResponse {

    private final String status;
    private final String service;

    public StatusResponse(String status, String service) {
        this.status = status;
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public String getService() {
        return service;
    }
}
