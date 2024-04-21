package com.amazon.ask.helloworld.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.helloworld.handlers.MyProjectIntentHandler.PROJECT_KEY;
import static com.amazon.ask.helloworld.handlers.MyEmailIsIntentHandler.EMAIL_KEY;

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

public class ModuleIntentHandler implements RequestHandler{
	
	public static final String MODULE_KEY = "MODULE";
    public static final String MODULE_SLOT = "Module";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("ModuleIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

    	Slot myModuleSlot = slots.get(MODULE_SLOT);
        String speechText;
        String projectname = (String)input.getAttributesManager().getSessionAttributes().get(PROJECT_KEY);
        String email=(String)input.getAttributesManager().getSessionAttributes().get(EMAIL_KEY);
        System.out.println("Searchmymodp="+projectname);
        System.out.println("Searchmymode="+email);
        
        String module = myModuleSlot.getValue();
        String modulearray[]=module.split(" ");
        
        Map<String,Object> mapobj=input.getAttributesManager().getSessionAttributes();
    	mapobj.put(MODULE_KEY, module);
    	input.getAttributesManager().setSessionAttributes(mapobj);
    	
        for(int i=0;i<modulearray.length;i++)
        {
        	Basemethods.Modules(email,projectname,modulearray[i].trim());
        	System.out.println("modules="+modulearray[i]);
        }
        speechText="All modules are created. Now please enter form name by saying My form name is x in module y. ";
       
        return input.getResponseBuilder()
                .withSimpleCard("SourceCodeGeneration", speechText)
                .withSpeech(speechText)    
                .withShouldEndSession(false)
                .build();

    }


}
