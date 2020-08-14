package com.smartuj.sensoresHumanos.service.impl;

import com.smartuj.sensoresHumanos.dto.Persona;
import com.smartuj.sensoresHumanos.dto.PersonasWrapper;
import com.smartuj.sensoresHumanos.service.DTIService;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@Service
public class DTIServiceImpl implements DTIService {

    private final RestTemplate restTemplate;

    public DTIServiceImpl() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.restTemplate = getRestTemplate();
    }

    public String getPersonasToken() {
        String url = "https://apitst.javeriana.edu.co/api/v1/seguridad/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("servicio", "personas");

        Map<String, String> parametersMap = new HashMap<String, String>();
        parametersMap.put("nombre", "cs-smartuj");
        parametersMap.put("password", "XLyhYj4Bpe");

        HttpEntity<String> request = new HttpEntity(parametersMap, headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, request, String.class);
       return response.getBody();
    }

    public String getEstudiantesToken() {
        String url = "https://apitst.javeriana.edu.co/api/v1/seguridad/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("servicio", "estudiantes");

        Map<String, String> parametersMap = new HashMap<String, String>();
        parametersMap.put("nombre", "cs-smartuj");
        parametersMap.put("password", "XLyhYj4Bpe");
        
        HttpEntity<String> request = new HttpEntity(parametersMap, headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    public Persona getUserData(String usuario){
        String url = "https://apitst.javeriana.edu.co/api/v1/personas?usuario=" + usuario;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getPersonasToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<PersonasWrapper> response = this.restTemplate.exchange(url, HttpMethod.GET, request, PersonasWrapper.class);
        return response.getBody().getPersonas()[0];
    }

    public String getDatosContacto(String usuario){
        String url = "https://apitst.javeriana.edu.co/api/v1/personas/" + getUserData(usuario).getIdPersona() + "/datos-contacto";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getPersonasToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();

    }
    public String getEstadosPrograma(String usuario){
        String url = "https://apitst.javeriana.edu.co/api/v1/estudiantes/" + getUserData(usuario).getIdPersona() + "/estados-programas?estadoEfectivo=Y";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getEstudiantesToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }


    public String getClasesActivas(String usuario) {
        String url = "https://apitst.javeriana.edu.co/api/v1/estudiantes/" + getUserData(usuario).getIdPersona() + "/clases-inscritas?estadoClase=H";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getEstudiantesToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    public String getClasesActivasHorario(String usuario){
        String url = "https://apitst.javeriana.edu.co/api/v1/estudiantes/" + getUserData(usuario).getIdPersona() + "/clases-inscritas?estadoClase=I&horario=Si";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getEstudiantesToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }
    public String getNotas(String usuario){
        String url = "https://apitst.javeriana.edu.co/api/v1/estudiantes/" + getUserData(usuario).getIdPersona() + "/clases-inscritas?estadoClase=H";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setCacheControl("no-cache");
        headers.set("Authorization", getEstudiantesToken());

        HttpEntity<String> request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();

    }

    private RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        };
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }
}
