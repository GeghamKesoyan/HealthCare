package io.project.app.unicorn;

import io.project.app.patient.api.response.PatientApiResponse;
import io.project.app.patientcare.models.Patient;
import io.project.app.util.GsonConverter;
import java.io.IOException;
import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


@ViewScoped
public class PatientClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(PatientClient.class);
    /// private final String BASE_URL = getBundle().getString("gateway");

    public PatientClient() {

    }

    @PostConstruct
    public void init() {
        LOG.debug("PatientClient called");
    }

    @SuppressWarnings("unchecked")
    public Patient registration(Patient model) {
        LOG.info("Start!!!!");
        Patient returnedModel = new Patient();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOG.info("PatientDTO Registration ");
            HttpPost request = new HttpPost("http://localhost:5550/api/v2/join/creation");

            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("User Registration status code " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Patient.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("User Registration request/response time in milliseconds: " + elapsedTime);
        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return returnedModel;
    }

    
    public PatientApiResponse getPatients() {
        PatientApiResponse model = new PatientApiResponse();
        long startTime = System.currentTimeMillis();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:5550/api/v2/join/creation/patient");
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");          
            CloseableHttpResponse response = httpClient.execute(request);
           
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                model = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), PatientApiResponse.class);
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            
        } catch (IOException e) {
            
        }
        return model;
    }

    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{i18n}", PropertyResourceBundle.class);
    }
}

// http://aspects.jcabi.com/annotation-cacheable.html
// http://aspects.jcabi.com/example-weaving.html