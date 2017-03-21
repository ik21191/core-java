package com.httpclient;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;

public class ValidateCertificate {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	ValidateCertificate tester = new ValidateCertificate();
        try {
            tester.testConnectionTo("https://test-secure.palgrave-journals.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ValidateCertificate() {
        super();
    }

    public void testConnectionTo(String aURL) throws Exception {
        URL destinationURL = new URL(aURL);
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();
        for (Certificate cert : certs) {
            System.out.println("Certificate is: " + cert);
            if(cert instanceof X509Certificate) {
                try {
                    ( (X509Certificate) cert).checkValidity();
                    System.out.println("Certificate is active for current date");
                } catch(CertificateExpiredException cee) {
                    System.out.println("Certificate is expired");
                }
            }
        }
    }
}