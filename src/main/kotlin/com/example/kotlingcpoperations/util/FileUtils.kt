package com.example.kotlingcpoperations.util

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * @param fileName full name of the file (e.g., my-beautiful-file.pdf)
 * @return extension of the file (e.g., .pdf)
 */
fun getFileExtension(fileName: String): String = "." + fileName.split(".").last()

/**
 * @param fileName full name of the file (e.g., my-beautiful-file.pdf)
 * @return base name of the file (e.g., my-beautiful-file)
 */
fun getFileName(fileName: String): String = fileName.split(".").first()

/**
 * @param fileContent base64 of a file
 * @return ByteArray of the decoded base64
 */
fun decodeFileContent(fileContent: String): ByteArray = Base64.getDecoder().decode(fileContent)

/**
 * @param filePath path of the file in the system (e.g., /home/dev/file.pdf)
 * @return ByteArray of the file
 */
fun getFileByteArray(filePath: String): ByteArray = Files.readAllBytes(Paths.get(filePath))