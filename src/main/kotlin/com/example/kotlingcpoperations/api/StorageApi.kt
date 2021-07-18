package com.example.kotlingcpoperations.api

import com.example.kotlingcpoperations.dto.UploadFileDTO
import com.example.kotlingcpoperations.service.StorageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/storage")
class StorageApi(
    private val storageService: StorageService
) {

    @PostMapping("upload-object")
    fun uploadObjectToStorage(@RequestBody dto: UploadFileDTO) {
        storageService.uploadObject(dto)
    }

}