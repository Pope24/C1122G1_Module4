package com.save_email_configuration.repository.impl;

import com.save_email_configuration.model.EmailConfiguration;
import com.save_email_configuration.repository.IEmailConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigurationRepository implements IEmailConfigurationRepository {
    @Autowired
    private EmailConfiguration emailConfiguration;

    @Override
    public void saveEmailConfiguration(EmailConfiguration newEmailConfiguration) {
        emailConfiguration.setLanguage(newEmailConfiguration.getLanguage());
        emailConfiguration.setPageSize(newEmailConfiguration.getPageSize());
        emailConfiguration.setSignature(newEmailConfiguration.getSignature());
        emailConfiguration.setSpamsFilter(newEmailConfiguration.isSpamsFilter());
    }

    @Override
    public EmailConfiguration getVersionEmailConfiguration() {
        return emailConfiguration;
    }
}
