package br.com.nce.neoescola.commons;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ExceptionData {
	
	public static final String EXCEPTION = "exception";
    public static final String REQUEST_URI = "javax.servlet.forward.request_uri";
	
	private Throwable throwable;
	private String uri;
	private Object user;
	private String stackTrace;
	private String queryString;
	public static final String CURRENT_USER = "currentUser";
	private String headers;

	public ExceptionData(Throwable throwable, String uri, String stackTrace, Object user, 
			String queryString, String headers) {
		this.throwable = throwable;
		this.uri = uri;
		this.stackTrace = stackTrace;
		this.user = user;
		this.queryString = queryString;
		this.headers = headers;
	}
	
	public static ExceptionData fromRequest(HttpServletRequest req) {
		Throwable throwable = (Throwable) req.getAttribute(EXCEPTION);
		String uri = (String) req.getRequestURI();
		String stackTrace = convertStackToString(throwable);
		Object user = req.getAttribute(CURRENT_USER);
		String queryString = "";
		if ("GET".equals(req.getMethod())) {
			queryString = req.getQueryString();
		}
		return new ExceptionData(throwable, uri, stackTrace, user, queryString, buildHeadersMap(req));
	}
	
	public static String convertStackToString(Throwable t){
		if(t == null) return "";
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		pw.flush();
		return sw.getBuffer().toString();
	}

	private static String buildHeadersMap(HttpServletRequest req) {
		Enumeration<String> headerNames = req.getHeaderNames();
		StringBuilder headers = new StringBuilder("");
		
		while (headerNames != null && headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			headers.append("    " + name + ": ");
			headers.append(req.getHeader(name) + "\n");
		}
		return headers.toString();

	}

	public Throwable getException() {
		return throwable;
	}
	
	public String getUri() {
		return uri;
	}
	
	public Object getUser() {
		return user;
	}
	
	public String getStackTrace() {
		return stackTrace;
	}
	
	public String getStackTraceComBr() {
		if(stackTrace != null)
			return getStackTrace().replace(System.getProperty("line.separator"), "<br/>\n");
		
		return "";
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getQueryString() {
		return queryString;
	}
	
	public String getHeaders() {
		return headers;
	}

}
