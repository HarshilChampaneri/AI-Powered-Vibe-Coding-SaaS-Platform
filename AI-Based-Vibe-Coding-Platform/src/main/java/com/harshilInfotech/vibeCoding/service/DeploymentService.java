package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.deploy.DeployResponse;

public interface DeploymentService {

    DeployResponse deploy(Long projectId);

}
