INSERT INTO `account`(`username`, `password`, `enabled`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`)
VALUES ('user1', '$2a$10$fHIJoDXfP/Rp3uneU2.TnudiCYAi2fCRtbYQp5zTPzXVihCgg8Pdu', 1, 1, 1, 1);

INSERT INTO `oauth_client_details`(client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                   web_server_redirect_uri, authorities, access_token_validity,
                                   refresh_token_validity, additional_information, autoapprove)
VALUES ('client', null, '$2a$10$iP9ejueOGXO29.Yio7rqeuW9.yOC4YaV8fJp3eIWbP45eZSHFEwMG', 'read',
        'password,refresh_token', 'http://localhost:9000/callback', 'USER', 3000, 6000, null, 'false');