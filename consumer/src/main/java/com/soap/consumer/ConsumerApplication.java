package com.soap.consumer;

import com.soap.consumer.wsdl.Add;
import com.soap.consumer.wsdl.CalElements;
import com.soap.consumer.wsdl.Response;
import com.soap.consumer.wsdl.Subtract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);

		try {
			WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
			Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

			Add request = new Add();
			CalElements calElements=new CalElements();
			calElements.setFirstNumber(5);
			calElements.setSecondNumber(10);
			request.setRequest(calElements);
			jaxb2Marshaller.setContextPath("com.soap.consumer.wsdl");
			webServiceTemplate.setMarshaller(jaxb2Marshaller);
			webServiceTemplate.afterPropertiesSet();
			webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
			webServiceTemplate.afterPropertiesSet();
			Response responseObj = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:8090/ws/calculator.wsdl", request, new SoapActionCallback("http://www.soap.com/calculator/gen"));
			System.out.println("add "+responseObj.getResult());

			Subtract subtractRequest = new Subtract();
			calElements.setFirstNumber(5);
			calElements.setSecondNumber(10);
			subtractRequest.setRequest(calElements);
			responseObj = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:8090/ws/calculator.wsdl", subtractRequest, new SoapActionCallback("http://www.soap.com/calculator/gen"));
			System.out.println("subtract "+responseObj.getResult());
		} catch (WebServiceClientException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
