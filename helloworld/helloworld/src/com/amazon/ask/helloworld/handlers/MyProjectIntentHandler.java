package com.amazon.ask.helloworld.handlers;

import static com.amazon.ask.helloworld.handlers.MyEmailIsIntentHandler.EMAIL_KEY;
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
import com.amazon.ask.utils.Basemethods;

public class MyProjectIntentHandler implements RequestHandler {

	 public static final String PROJECT_SLOT ="Project" ;
	 public static final String PROJECT_KEY ="PROJECT" ;
	
	public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("ProjectIntent"));
	    }

	    public Optional<Response> handle(HandlerInput input) {
	    	Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        Map<String, Slot> slots = intent.getSlots();
	        String speechText;
	    	Slot myprojectSlot = slots.get(PROJECT_SLOT);
	       
	        String email = (String)input.getAttributesManager().getSessionAttributes().get(EMAIL_KEY);
	        System.out.println("Searchemailkey="+email);
	        String projectname = myprojectSlot.getValue();
	        System.out.println("projectname="+projectname);
	        
	        Map<String,Object> mapobj=input.getAttributesManager().getSessionAttributes();
        	mapobj.put(PROJECT_KEY, projectname);
        	input.getAttributesManager().setSessionAttributes(mapobj);
         
	        Basemethods.project(email,projectname);
	        speechText=String.format("Now I know your project name is %s. Please Enter the module name by saying my modules are x y.",projectname);

	        return input.getResponseBuilder()
	                .withSimpleCard("ColorSession", speechText)
	                .withSpeech(speechText)    
	                .withShouldEndSession(false)
	                .build();

	    }
	    
	
	    
}
