package com.save_email_configuration.service.impl;

import com.save_email_configuration.model.EmailConfiguration;
import com.save_email_configuration.repository.impl.EmailConfigurationRepository;
import com.save_email_configuration.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigurationService implements IEmailConfigurationService {
    @Autowired
    private EmailConfigurationRepository emailConfigurationRepository;

    @Override
    public void saveEmailConfiguration(EmailConfiguration emailConfiguration) {
        emailConfigurationRepository.saveEmailConfiguration(emailConfiguration);
    }

    @Override
    public EmailConfiguration getVersionEmailConfiguration() {
        return emailConfigurationRepository.getVersionEmailConfiguration();
    }
}
