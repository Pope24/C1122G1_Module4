package com.save_email_configuration.service;

import com.save_email_configuration.model.EmailConfiguration;

public interface IEmailConfigurationService {
    void saveEmailConfiguration(EmailConfiguration emailConfiguration);
    EmailConfiguration getVersionEmailConfiguration();
}
