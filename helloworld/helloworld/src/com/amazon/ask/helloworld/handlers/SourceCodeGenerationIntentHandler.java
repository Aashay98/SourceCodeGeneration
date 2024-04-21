package com.amazon.ask.helloworld.handlers;

import static com.amazon.ask.helloworld.handlers.ModuleIntentHandler.MODULE_KEY;
import static com.amazon.ask.helloworld.handlers.MyEmailIsIntentHandler.EMAIL_KEY;
import static com.amazon.ask.helloworld.handlers.MyProjectIntentHandler.PROJECT_KEY;
import static com.amazon.ask.helloworld.handlers.FormIntentHandler.FORM_KEY;
import static com.amazon.ask.helloworld.handlers.FieldInputHandler.FORMFIELD_KEY;
import static com.amazon.ask.helloworld.handlers.FieldInputHandler.FIELDTYPE_KEY;
import static com.amazon.ask.request.Predicates.intentName;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.VO.FieldVO;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.jdbc.Db;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.utils.Basemethods;

public class SourceCodeGenerationIntentHandler implements RequestHandler{
	
	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("SourceCodeGenerationIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	    	Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        Map<String, Slot> slots = intent.getSlots();
	        
	        String speechText;
	        
	        String projectname = (String)input.getAttributesManager().getSessionAttributes().get(PROJECT_KEY);
	        String email=(String)input.getAttributesManager().getSessionAttributes().get(EMAIL_KEY);
	        String modulename = (String)input.getAttributesManager().getSessionAttributes().get(MODULE_KEY);
	        String module=modulename.trim().replace(" ",",");
	        String formname=(String)input.getAttributesManager().getSessionAttributes().get(FORM_KEY);
	        List fieldlist = (List)input.getAttributesManager().getSessionAttributes().get(FORMFIELD_KEY);
	        StringBuffer sb=new StringBuffer();
	        StringBuffer sb1=new StringBuffer();
	        for(Object object:fieldlist)
	        {
	        	 Map fieldmap=(Map)object;
		    	 String fname=(String)fieldmap.get("fieldName");
		    	 String ftype=(String)fieldmap.get("fieldType");
	        	 sb.append(fname);
	        	 sb.append(" ");
	        	 sb1.append(ftype);
	        	 sb1.append(" ");

	        	 
	        }
	        String fieldName=sb.toString().trim().replace(" ", ",");
	        String fieldType=sb1.toString().trim().replace(" ", ",");
	        
	        System.out.println("Sf="+email);
	        System.out.println("Sf="+projectname);
	        System.out.println("Sf="+module);
	        System.out.println("Sf="+formname);
	        System.out.println("Sf="+fieldName);

	          
	        try {
	        	Db database=new Db();
	        	database.insert(email, projectname, module, fieldName, fieldType, formname);
	        	
				Basemethods.GenrateCode(email,projectname,modulename,formname,fieldlist);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       speechText = "Your code is been generated. Do you wish to to generate another form please repeat the process. ";
	        
	        return input.getResponseBuilder()
	                .withSimpleCard("SourceCodeGeneration", speechText)
	                .withSpeech(speechText)    
	                .withShouldEndSession(false)
	                .build();

	    }

}
