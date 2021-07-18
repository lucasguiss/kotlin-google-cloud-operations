package com.example.kotlingcpoperations.infrastructure

import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.stereotype.Component


@Component
class GCPConnector {

    /**
     * @param projectId identifier of the Google Cloud Platform project.
     * @return Google Cloud Storage instance
     */
    fun getStorage(projectId: String): Storage = StorageOptions.getDefaultInstance().service

}