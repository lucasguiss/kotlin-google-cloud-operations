package com.example.kotlingcpoperations.util

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo

/**
 * @param bucketName name of the Google Cloud Storage bucket.
 * @param fileName name of the file
 * @return BlobId of the params combination
 */
fun getBlobId(bucketName: String, fileName: String): BlobId = BlobId.of(bucketName, fileName)

/**
 * @param blobId BlobId of the bucket + fileName
 * @return BlobInfo of the given BlobId
 */
fun getBlobInfo(blobId: BlobId): BlobInfo = BlobInfo.newBuilder(blobId).build()

/**
 * @param bucketName name of the Google Cloud Storage bucket.
 * @param fileName name of the file
 * @return BlobInfo of the given bucket + file
 */
fun buildBlobInfo(bucketName: String, fileName: String): BlobInfo {
    val blobId = getBlobId(bucketName, fileName)
    return getBlobInfo(blobId)
}