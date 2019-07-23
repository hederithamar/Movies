package briix.com.data.mvp.model.base;

import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;
import briix.com.domain.entities.home.MoviesEntity;

public class Error {

    private int serviceId;

    private int httpCode;

    private String exception;

    private String message;

    private String cveDiagnostic;

    public Error(int service, int httpCode, String exception, String message, String cveDiagnostic) {
        this.serviceId = service;
        this.httpCode = httpCode;
        this.exception = exception;
        this.message = message;
        this.cveDiagnostic = cveDiagnostic;
    }

    public Error() {

    }

    public Error(TokenEntity response, int service) {
        this.serviceId = service;
        this.httpCode = response.getStatusCode();
        this.exception = response.getStatusMessage();
        this.message = response.getStatusMessage();
        this.cveDiagnostic = response.getStatusMessage();
    }

    public Error(CreateAccessTokenEntity response, int service) {
        this.serviceId = service;
        this.httpCode = response.getStatusCode();
        this.exception = response.getStatusMessage();
        this.message = response.getStatusMessage();
        this.cveDiagnostic = response.getStatusMessage();
    }

    public Error(MoviesEntity response, int service) {
        this.serviceId = service;
        this.httpCode = response.getPage();
        this.exception = "Error";
        this.message = "Error";
        this.cveDiagnostic = "001";
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCveDiagnostic() {
        return cveDiagnostic;
    }

    public void setCveDiagnostic(String cveDiagnostic) {
        this.cveDiagnostic = cveDiagnostic;
    }

    @Override
    public String toString() {
        return "HttpCode-> " + httpCode + "\n Exception-> " + exception + "\n Diagnostic-> "
                + cveDiagnostic + "\n Message-> " + message;
    }
}
