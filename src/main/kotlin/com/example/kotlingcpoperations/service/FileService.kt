package com.example.kotlingcpoperations.service

import com.example.kotlingcpoperations.util.decodeFileContent
import com.example.kotlingcpoperations.util.getFileExtension
import com.example.kotlingcpoperations.util.getFileName
import com.google.common.io.Files
import org.springframework.stereotype.Service
import java.io.File

@Service
class FileService {

    /**
     * Creates a temporary file
     * @param fileName Name of the file
     * @param fileContent File in the format of a base64 string
     * @return file path of the temporary file created
     */
    fun createFile(fileName: String, fileContent: String): String {
        val prefix = getFileName(fileName)
        val suffix = getFileExtension(fileName)
        val file = File.createTempFile(prefix, suffix)
        val decodedContent = decodeFileContent(fileContent)
        Files.write(decodedContent, file)
        return file.absolutePath
    }
}