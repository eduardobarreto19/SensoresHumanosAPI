package com.smartuj.sensoresHumanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@SpringBootApplication
public class SensoresHumanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensoresHumanosApplication.class, args);
	}

}
