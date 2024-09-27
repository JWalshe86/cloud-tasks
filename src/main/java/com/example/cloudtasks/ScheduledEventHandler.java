package com.example.cloudtasks; // Update the package declaration

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ScheduledEventHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object event, Context context) {
        context.getLogger().log("Scheduled event triggered: " + event.toString());
        return "Lambda executed successfully!";
    }
}

