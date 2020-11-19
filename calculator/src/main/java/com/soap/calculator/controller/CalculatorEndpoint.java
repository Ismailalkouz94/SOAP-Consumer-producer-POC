package com.soap.calculator.controller;


import com.soap.calculator.gen.Add;
import com.soap.calculator.gen.Response;
import com.soap.calculator.gen.Subtract;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {
 
    private static final String NAMESPACE_URI = "http://www.soap.com/calculator/gen";

 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "add")
    @ResponsePayload
    public Response getAddResponse(@RequestPayload Add request) {
        Response response = new Response();
        response.setResult(request.getRequest().getFirstNumber() + request.getRequest().getSecondNumber());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "subtract")
    @ResponsePayload
    public Response getSubtractResponse(@RequestPayload Subtract request) {
        Response response = new Response();
        response.setResult(request.getRequest().getFirstNumber() - request.getRequest().getSecondNumber());
        return response;
    }
}