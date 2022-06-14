package es.incidenceapp.ms.domain.dtos;

import java.io.Serializable;

public class ActionResponse implements Serializable {


	private static final long serialVersionUID = -744100210963022195L;
	
	private String code;
	private String message;
	private Object data;

	public ActionResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ActionResponse(String code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public ActionResponse(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

}
