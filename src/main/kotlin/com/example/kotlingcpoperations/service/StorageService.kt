package com.example.kotlingcpoperations.service

import com.example.kotlingcpoperations.dto.UploadFileDTO
import com.example.kotlingcpoperations.infrastructure.GCPConnector
import com.example.kotlingcpoperations.util.GCP_BUCKET_NAME
import com.example.kotlingcpoperations.util.GCP_STORAGE_PROJECTID
import com.example.kotlingcpoperations.util.buildBlobInfo
import com.example.kotlingcpoperations.util.getFileByteArray
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class StorageService(
    private val gcpConnector: GCPConnector,
    private val fileService: FileService,
    @Value(GCP_STORAGE_PROJECTID) private val projectId: String,
    @Value(GCP_BUCKET_NAME) private val bucketName: String
) {

    fun uploadObject(dto: UploadFileDTO) {
        val storage = gcpConnector.getStorage(projectId)
        val (fileName, fileContent) = dto
        val filePath = fileService.createFile(fileName, fileContent)
        val blobInfo = buildBlobInfo(bucketName, fileName)
        val fileByteArray = getFileByteArray(filePath)
        storage.create(blobInfo, fileByteArray)
    }

}