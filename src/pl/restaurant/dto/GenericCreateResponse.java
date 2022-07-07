package pl.restaurant.dto;

import javax.ws.rs.core.Response;

public class GenericCreateResponse<T> {
	private T objectToReturn;
	private Response responseCode;
	
	public GenericCreateResponse(Response responseCode){
		this.responseCode = responseCode;
	}
	
	public GenericCreateResponse(T objectToReturn, Response responseCode){
		this.objectToReturn = objectToReturn;
		this.responseCode = responseCode;
	}
	
	public T getObjectToReturn() {
		return objectToReturn;
	}
	public void setId(T objectToWrite) {
		this.objectToReturn = objectToWrite;
	}
	
	public Response getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Response response) {
		this.responseCode = response;
	}
}
