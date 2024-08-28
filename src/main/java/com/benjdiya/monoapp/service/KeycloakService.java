package com.benjdiya.monoapp.service;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

    private Keycloak key;

    public KeycloakService() {
        this.key = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080/")
                .realm("master")
                .clientId("admin-cli")
                .username("admin")
                .password("admin")
                .grantType(OAuth2Constants.PASSWORD)
                .build();

    }

    public void getUser(String userId) {
        try {
           TokenManager tokenManager= key.tokenManager();
            String accessToken= tokenManager.getAccessTokenString();

            UsersResource usersResource = key.realm("cpa-app").users();
            UserResource userResource = usersResource.get(userId);
            UserRepresentation user = userResource.toRepresentation();

            System.out.println("User details: " + user);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to get user: " + e.getMessage());
        }
    }
}

