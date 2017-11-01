package com.digitalplatoon.services.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.digitalplatoon.services.heartbeatsvc.GetHeartbeatRequest;
import com.digitalplatoon.services.heartbeatsvc.GetHeartbeatResponse;

@Endpoint
public class HeartbeatEndpoint {

	private static final String NAMESPACE_URI = "http://com/digitalplatoon/services/HeartBeatSvc";
	
	//Handle getHeartbeat Request
	@PayloadRoot(namespace =NAMESPACE_URI, localPart="getHeartbeatRequest")
	@ResponsePayload
	public GetHeartbeatResponse getHeatbeat(@RequestPayload GetHeartbeatRequest req){
		GetHeartbeatResponse resp = new GetHeartbeatResponse();
		resp.setResponseBody("Success");
		resp.setResponseCode(0);
		//resp.toString()
		return resp;
	}
}
