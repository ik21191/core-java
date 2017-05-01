package com.httpclient;
import java.util.Arrays;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.ArrayUtils;

public class ServiceGatewayRequestInfo {
    private String requestUri;
    private String mediaType;
    private String charset;
    private String requestBody;
    private NameValuePair[] queryStringParameters;
    private NameValuePair[] requestBodyParameters;
    private Header[] requestHeaders;

    public NameValuePair[] getRequestBodyParameters() {
        return requestBodyParameters;
    }

    public void setRequestBodyParameters(NameValuePair[] requestBodyParameters) {
        NameValuePair[] requestBodyParametersCopy = Arrays.copyOf(requestBodyParameters, requestBodyParameters.length);
        this.requestBodyParameters = requestBodyParametersCopy;
    }

    public Header[] getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Header[] requestHeaders) {
        Header[] requestHeadersCopy = Arrays.copyOf(requestHeaders, requestHeaders.length);
        this.requestHeaders = requestHeadersCopy;
    }

    public NameValuePair[] getQueryStringParameters() {
        return queryStringParameters;
    }

    public void setQueryStringParameters(NameValuePair[] queryStringParameters) {
        NameValuePair[] queryStringParametersCopy = Arrays.copyOf(queryStringParameters, queryStringParameters.length);
        this.queryStringParameters = queryStringParametersCopy;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    private String methodType;

    public String getMediaType() {
        return mediaType;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public String getCharset() {
        return charset;
    }

    @Override
    public String toString() {
        StringBuffer message = new StringBuffer();
        message.append("Request URI :").append(requestUri).append(", Request Body :").append(requestBody);

        if (ArrayUtils.isNotEmpty(requestHeaders)) {
            message.append(", Request Headers :");
            for (Header header : requestHeaders) {
                message.append(header.toString());
            }
        }

        if (ArrayUtils.isNotEmpty(queryStringParameters)) {
            message.append(", QueryParameters :");
            for (NameValuePair nvp : queryStringParameters) {
                message.append(nvp.toString());
            }
        }

        if (ArrayUtils.isNotEmpty(requestBodyParameters)) {
            message.append(", Request Body Parameters:");
            for (NameValuePair nameValuePair : requestBodyParameters) {
                message.append(nameValuePair.toString());
            }
        }

        return message.toString();
    }
}