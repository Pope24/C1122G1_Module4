package com.save_email_configuration.repository;

import com.save_email_configuration.model.EmailConfiguration;

public interface IEmailConfigurationRepository {
    void saveEmailConfiguration(EmailConfiguration emailConfiguration);
    EmailConfiguration getVersionEmailConfiguration();
}
