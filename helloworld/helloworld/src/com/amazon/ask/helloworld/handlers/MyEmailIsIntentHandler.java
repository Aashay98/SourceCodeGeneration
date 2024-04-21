package com.amazon.ask.helloworld.handlers;
import static com.amazon.ask.helloworld.handlers.OtpIntentHandler.OTP_KEY;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.jdbc.Db;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.utils.Basemethods;

public class MyEmailIsIntentHandler implements RequestHandler{
	
	  public static final String EMAIL_KEY = "EMAIL";
	  public static final String EMAIL_SLOT = "Email";
	
	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("MyEmailIsIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	        Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        Map<String, Slot> slots = intent.getSlots();

	       
	        // Get the color slot from user input.
	        Slot myEmailSlot = slots.get(EMAIL_SLOT);
	        String speechText, repromptText="";
	        Db db=new Db();
	        // Check for favorite color and create output to user.
	       String rates="<prosody rate=\"80%\">";
	       String ratee="</prosody>";
	       String sayass="<say-as interpret-as=\"spell-out\">";
	       String sayase="</say-as>";
	            String Email = myEmailSlot.getValue().toLowerCase().trim().replace(" ", "@");
	            System.out.println("Emailslot="+Email);
	            List emaillist=db.search(Email);
	            System.out.println("emaillist="+emaillist.size());
	            if(emaillist!=null && !emaillist.isEmpty())
	            {
	            	String otp=Basemethods.generatePassword();
	            	System.out.println("otp="+otp);
	            	Map<String,Object> mapobj=input.getAttributesManager().getSessionAttributes();
	            	mapobj.put(OTP_KEY, otp);
	            	input.getAttributesManager().setSessionAttributes(mapobj);
	            	mapobj.put(EMAIL_KEY, Email);
	            	input.getAttributesManager().setSessionAttributes(mapobj);
	            	
	    			Basemethods.sendMail(Email, otp);
	    			Basemethods.EmailFolder(Email);
	    			
	    			 speechText =
	 	                    String.format("%s I now know that your email is %s %s %s. You can now enter otp from your email.%s",rates, sayass, Email, sayase,ratee);
	 	            repromptText =
	 	                    "Please enter your otp.";
	            }
	            else
	            {
	            	speechText =String.format("Please enter a valid E-mail");
	            }
	        
	       
	          
	        return input.getResponseBuilder()
	                .withSimpleCard("SourceCodeGeneration", speechText)
	                .withSpeech(speechText)
	                .withReprompt(repromptText)
	                .withShouldEndSession(false)
	                .build();
	    }


}
 