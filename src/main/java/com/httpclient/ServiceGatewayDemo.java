package com.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class ServiceGatewayDemo {
	static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
    static HttpClient httpClient = new HttpClient(connectionManager);
	
    public static void main(String[] args) {
    	ServiceGatewayRequestInfo requestInfo = creatDataForServiceGateway();
    	
		String responseMessage = callService(requestInfo);
		System.out.println(responseMessage);

	}
	
	
	public static String callService(ServiceGatewayRequestInfo requestInfo)
     {
		
String url = requestInfo.getRequestUri();
String httpClientResponse = null;
HttpMethod httpMethod = null;
try {
    httpMethod = prepareMethod(requestInfo);

    httpMethod.getParams().setSoTimeout(3000);
    Header[] requestHeaders = requestInfo.getRequestHeaders();
     if (requestHeaders != null) {
        for (Header header : requestHeaders) {
            if (header.getName().equals("Host")) {
                httpClient.getHttpConnectionManager().getParams()
                        .setConnectionTimeout(3000);
            }
            if (header.getName().equals("Connection")) {
                httpMethod.getParams().setSoTimeout(Integer.parseInt(header.getValue()));
            }
        }
    }
    if (ArrayUtils.isNotEmpty(requestInfo.getQueryStringParameters())) {
        httpMethod.setQueryString(requestInfo.getQueryStringParameters());
    }

    if (StringUtils.isNotBlank(requestInfo.getCharset())) {
        httpMethod.getParams().setContentCharset(requestInfo.getCharset());
    }

    if (ArrayUtils.isNotEmpty(requestInfo.getRequestHeaders())) {
        for (Header header : requestInfo.getRequestHeaders()) {
            httpMethod.addRequestHeader(header);
        }
    }

    int statusCode = httpClient.executeMethod(httpMethod);
    httpClientResponse = httpMethod.getResponseBodyAsString();


} catch (HttpException httpe) {
} catch (IOException ioe) {
} finally {
    if (httpMethod != null) {
        httpMethod.releaseConnection();
    }
}
return httpClientResponse;
}


private boolean isSuccessStatusCode(int statusCode) {
return (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) ? true : false;
}

protected static HttpMethod prepareMethod(ServiceGatewayRequestInfo requestInfo) throws UnsupportedEncodingException {
HttpMethod httpMethod = null;
if ("POST".equalsIgnoreCase(requestInfo.getMethodType())) {
    httpMethod = prepareHttpPostMethod(requestInfo);
} else if ("PUT".equalsIgnoreCase(requestInfo.getMethodType())) {
    httpMethod = prepareHttpPutMethod(requestInfo);
} else if (("DELETE".equalsIgnoreCase(requestInfo.getMethodType()))) {
    httpMethod = prepareHttpDeleteMethod(requestInfo);
} else if (("GET".equalsIgnoreCase(requestInfo.getMethodType()))) {
    httpMethod = prepareHttpGetMethod(requestInfo);
}
return httpMethod;
}

protected static PostMethod prepareHttpPostMethod(ServiceGatewayRequestInfo requestInfo)
    throws UnsupportedEncodingException {
PostMethod postMethod = new PostMethod(requestInfo.getRequestUri());
if (StringUtils.isNotEmpty(requestInfo.getRequestBody())) {
    postMethod.setRequestEntity(createRequestEntity(requestInfo));
}

if (ArrayUtils.isNotEmpty(requestInfo.getRequestBodyParameters())) {
    postMethod.setRequestBody(requestInfo.getRequestBodyParameters());
}

return postMethod;
}

protected static PutMethod prepareHttpPutMethod(ServiceGatewayRequestInfo requestInfo) throws UnsupportedEncodingException {
PutMethod putMethod = new PutMethod(requestInfo.getRequestUri());
if (StringUtils.isNotEmpty(requestInfo.getRequestBody())) {
    putMethod.setRequestEntity(createRequestEntity(requestInfo));
}
return putMethod;
}

protected static DeleteMethod prepareHttpDeleteMethod(ServiceGatewayRequestInfo requestInfo) {
return new DeleteMethod(requestInfo.getRequestUri());
}

private static StringRequestEntity createRequestEntity(ServiceGatewayRequestInfo requestInfo)
    throws UnsupportedEncodingException {
return new StringRequestEntity(requestInfo.getRequestBody(), requestInfo.getMediaType(),
        requestInfo.getCharset());
}

protected static GetMethod prepareHttpGetMethod(ServiceGatewayRequestInfo requestInfo) throws UnsupportedEncodingException {
return new GetMethod(requestInfo.getRequestUri());

}

protected static ServiceGatewayRequestInfo creatDataForServiceGateway(){
	ServiceGatewayRequestInfo serviceGatewayRequestInfo = new ServiceGatewayRequestInfo();
	NameValuePair[] nameValuePairs = new NameValuePair[] { new NameValuePair("grant-type", "alhambara"),
            new NameValuePair("grant-code", "grant"),
            new NameValuePair("request-uri", "test-www.nature.com")};
	
	Header [] requestHeaders = new Header []{new Header("Host", "test-www.nature.com"),
			new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0"),
			new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),new Header("Accept-Encoding", "gzip, deflate")};
	
	serviceGatewayRequestInfo.setQueryStringParameters(nameValuePairs);
	serviceGatewayRequestInfo.setCharset("UTF-8");
	serviceGatewayRequestInfo.setMediaType("text/plain");
	serviceGatewayRequestInfo.setMethodType("POST");
	serviceGatewayRequestInfo.setRequestBody("testing");
	serviceGatewayRequestInfo.setRequestBodyParameters(nameValuePairs);
	serviceGatewayRequestInfo.setRequestHeaders(requestHeaders);
	serviceGatewayRequestInfo.setRequestUri("http://test-www.nature.com");
	return serviceGatewayRequestInfo;
}
}



