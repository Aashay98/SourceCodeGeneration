package com.amazon.ask.helloworld.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class OtpIntentHandler implements RequestHandler{
	
		public static final String OTP_KEY = "OTP";
	    public static final String OTP_SLOT = "otp";

	    @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("OtpIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	    	Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        Map<String, Slot> slots = intent.getSlots();

	    	Slot myOtpSlot = slots.get(OTP_SLOT);
	        String speechText;
	        String oldotp = (String)input.getAttributesManager().getSessionAttributes().get(OTP_KEY);
	        System.out.println("Searchkey="+oldotp);
	        
	        String rates="<prosody rate=\"80%\">";
		    String ratee="</prosody>";
		    String sayass="<say-as interpret-as=\"spell-out\">";
		    String sayase="</say-as>";
		    
	        String newotp = myOtpSlot.getValue();
            System.out.println("newotp="+newotp);
	     	
	        	if(oldotp.equals(newotp))
	        	{
	        		speechText = String.format(" %s Thank you, now you are a verified user.<break time=\"5s\"/> Please enter your project name, by saying My Project Name is x.%s",rates,ratee);
	        	}
	        	else
	        	{
	        		speechText = String.format("Please enter correct otp");
	        	}

	        return input.getResponseBuilder()
	                .withSimpleCard("SourceCodeGeneration", speechText)
	                .withSpeech(speechText)    
	                .withShouldEndSession(false)
	                .build();

	    }

}
