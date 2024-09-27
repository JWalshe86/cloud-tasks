package com.example.cloudtasks.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEventHandler implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {
        // Add your logic here, e.g., process the scheduled task
        context.getLogger().log("Input: " + input);
        return "Task executed successfully!";
    }
}


