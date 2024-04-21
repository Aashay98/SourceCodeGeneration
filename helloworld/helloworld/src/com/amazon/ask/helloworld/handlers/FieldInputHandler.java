package com.amazon.ask.helloworld.handlers;


import static com.amazon.ask.helloworld.handlers.MyEmailIsIntentHandler.EMAIL_KEY;
import static com.amazon.ask.helloworld.handlers.FormIntentHandler.FORM_KEY;
import static com.amazon.ask.helloworld.handlers.FormIntentHandler.MODULE2_KEY;
import static com.amazon.ask.helloworld.handlers.MyProjectIntentHandler.PROJECT_KEY;
import static com.amazon.ask.request.Predicates.intentName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.VO.FieldVO;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.utils.Basemethods;

public class FieldInputHandler implements RequestHandler {
	

	public static final String FORMFIELD_KEY = "FORMFIELD";
    public static final String FORMFIELD_SLOT = "Formfield";
    
    public static final String FIELDTYPE_KEY = "FIELDTYPE";
    public static final String FIELDTYPE_SLOT = "Fieldtype";
	
    List list=new ArrayList();
	   @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("FieldInputIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	    	Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        Map<String, Slot> slots = intent.getSlots();

	        System.out.println("Form page");
	    	Slot myFieldNameSlot = slots.get(FORMFIELD_SLOT);
	    	Slot myFieldTypeSlot = slots.get(FIELDTYPE_SLOT);
	        String speechText;        
	        String fname = myFieldNameSlot.getValue();
	        System.out.println("field_name="+fname);
	        String ftype = myFieldTypeSlot.getValue();
	        System.out.println("field_type="+ftype);
	        
	       
	        
	        String projectname = (String)input.getAttributesManager().getSessionAttributes().get(PROJECT_KEY);
	        String email=(String)input.getAttributesManager().getSessionAttributes().get(EMAIL_KEY);
	        System.out.println("pname="+projectname);       
	        
	        String module=(String)input.getAttributesManager().getSessionAttributes().get(MODULE2_KEY);
	        System.out.println("module="+module);
	        
	        String form=(String)input.getAttributesManager().getSessionAttributes().get(FORM_KEY);
	        speechText=String.format("Form %s is created.", fname);
	        
	        FieldVO fieldvo=new FieldVO();
	        fieldvo.setFieldName(fname);
	        fieldvo.setFieldType(ftype);
	       
	        list.add((FieldVO)fieldvo);
	              
	       for(int i=0;i<list.size();i++)
	       {
	    	  FieldVO field=(FieldVO)list.get(i);
	    	    System.out.println(field.getFieldName());
	    	    System.out.println(field.getFieldType());
	    	    		
	       }
	        /* 
	        Iterator itr2=typename.iterator();  
	        while(itr2.hasNext()){  
	         System.out.println(itr2.next());  
	        }  */
	        
	        Map<String,Object> mapobj=input.getAttributesManager().getSessionAttributes();
	    	mapobj.put(FORMFIELD_KEY, list);
	    	input.getAttributesManager().setSessionAttributes(mapobj);
	    	
	        
	        speechText="Do you wish to generate the code for this?.";
	        
	       
	        
	        return input.getResponseBuilder()
	                .withSimpleCard("ColorSession", speechText)
	                .withSpeech(speechText)    
	                .withShouldEndSession(false)
	                .build();

	    }



}
