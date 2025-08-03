package com.theodore.provider;

import com.ikh.generated.models.CreateUserRequest;
import com.ikh.generated.models.UserCreatedResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
public class UserManagementEndpoint {

    private static final String NAMESPACE_URI = "http://ikh.com";

    private final UserManagementService userManagementService;

    public UserManagementEndpoint(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateUserRequest")
    @ResponsePayload
    public UserCreatedResponse createUser(@RequestPayload CreateUserRequest request) {
        return userManagementService.greet(request);
    }

}