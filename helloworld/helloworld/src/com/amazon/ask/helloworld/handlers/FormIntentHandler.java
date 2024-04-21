package com.amazon.ask.helloworld.handlers;

import static com.amazon.ask.helloworld.handlers.MyEmailIsIntentHandler.EMAIL_KEY;
import static com.amazon.ask.helloworld.handlers.MyProjectIntentHandler.PROJECT_KEY;
import static com.amazon.ask.helloworld.handlers.ModuleIntentHandler.MODULE_KEY;
import static com.amazon.ask.request.Predicates.intentName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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


public class FormIntentHandler implements RequestHandler {
	

	public static final String FORM_KEY = "FORM";
    public static final String FORM_SLOT = "Form";
    
    public static final String MODULE2_KEY = "MODULES";
    public static final String MODULE2_SLOT = "Modules";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("FormIntent"));
    }
    List list=new ArrayList();
    @Override
    public Optional<Response> handle(HandlerInput input) {
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        System.out.println("Form page");
    	Slot myFormSlot = slots.get(FORM_SLOT);
    	Slot myModule2Slot = slots.get(MODULE2_SLOT);
        String speechText="";        
        String fname = myFormSlot.getValue();
        System.out.println("form_name="+fname);
        String modulename = myModule2Slot.getValue();
        System.out.println("module2_name="+modulename);
        
        String projectname = (String)input.getAttributesManager().getSessionAttributes().get(PROJECT_KEY);
        String email=(String)input.getAttributesManager().getSessionAttributes().get(EMAIL_KEY);
        System.out.println("S="+projectname);
        System.out.println("S="+email);
        
        String rates="<prosody rate=\"80%\">";
	    String ratee="</prosody>";
	    String sayass="<say-as interpret-as=\"spell-out\">";
	    String sayase="</say-as>";
	    
	    
        
        String module=(String)input.getAttributesManager().getSessionAttributes().get(MODULE_KEY);
        String modulearr[]=module.split(" ");
        
        Map<String,Object> mapobj=input.getAttributesManager().getSessionAttributes();
    	mapobj.put(FORM_KEY, fname);
    	input.getAttributesManager().setSessionAttributes(mapobj);
    	mapobj.put(MODULE2_KEY, modulename);
    	input.getAttributesManager().setSessionAttributes(mapobj);
        
        for(int i=0;i<modulearr.length;i++)
        {
        	if(modulearr[i].equals(modulename))
        	{
        			speechText=String.format("%s Form %s is created.Now say My field name is f and type is a. %s",rates,fname,ratee);
				
        	}
        }
        
        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)    
                .withShouldEndSession(false)
                .build();

    }


}
