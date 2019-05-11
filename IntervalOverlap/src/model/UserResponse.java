package model;

public class UserResponse {
	
	Object response;
	String error;
	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		if(null == this.response) {
			this.response = new Object();
		}
		this.response = response;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

}
