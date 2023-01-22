package com.zaze.kotlin.example

import java.io.*
import java.nio.charset.Charset

object FileUtils {
    fun exists(file: File?): Boolean {
        return file?.exists() ?: false
    }

    /**
     * 递归删除文件和文件夹
     * [destFile] 目标文件或文件夹
     */
    @JvmStatic
    fun deleteFile(destFile: File): Boolean {
        if (destFile.isFile) {
            return destFile.delete()
        }
        if (destFile.isDirectory) {
            val childFile = destFile.listFiles()
            if (childFile != null && !childFile.isEmpty()) {
                for (file in childFile) {
                    deleteFile(file)
                }
            }
        }
        return destFile.delete()
    }

    /**
     * 强制重新创建文件(如果存在则删除创建)
     *
     * [file] 需要创建的文件
     */
    fun reCreateFile(file: File): Boolean {
        if (exists(file)) {
            deleteFile(file)
        }
        return createFileNotExists(file)
    }

    fun writeToFile(content: String, outFile: File, append: Boolean = false) {
        writeToFile(content.toByteArray(), outFile, append)
    }

    fun writeToFile(srcFile: File, outFile: File, append: Boolean = false) {
        writeToFile(srcFile.inputStream(), outFile, append)
    }

    fun writeToFile(bytes: ByteArray, outFile: File, append: Boolean = false) {
        writeToFile(ByteArrayInputStream(bytes), outFile, append)
    }

    fun writeToFile(input: InputStream, outFile: File, append: Boolean = false) {
        var output: OutputStream? = null
        try {
            createFileNotExists(outFile)
            output = FileOutputStream(outFile, append)
            val buffer = ByteArray(4 * 1024)
            var flag = input.read(buffer)
            while (flag >= 0) {
                output.write(buffer, 0, flag)
                flag = input.read(buffer)
            }
            output.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                output?.close()
                input.close()
            } catch (e: Exception) {
                // ignore
            }
        }
    }

    //
    fun readFromFile(file: File, charset: Charset = Charset.defaultCharset()): StringBuffer {
        var inputStream :InputStream? = null
        val results = StringBuffer()
        try {
            inputStream = FileInputStream(file)
            val bytes = ByteArray(4096)
            var byteLength = inputStream.read(bytes)
            while (byteLength != -1) {
                results.append(String(bytes, 0, byteLength, charset))
                byteLength = inputStream.read(bytes)
            }
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                inputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return results
    }

    fun createDirNotExists(path: String): Boolean {
        val file = File(path)
        return if (file.exists()) {
            file.isDirectory
        } else {
            file.mkdirs()
        }
    }

    fun createFileNotExists(file: File): Boolean {
        var result = false
        if (!file.exists()) {
            if (createParentDir(file)) {
                result = try {
                    file.createNewFile()
                } catch (e: Exception) {
                    false
                }
            }
        } else {
            result = true
        }
        return result
    }

    fun createParentDir(file: File): Boolean {
        val parentFile = file.parentFile
        return if (parentFile != null && parentFile.exists()) {
            true
        } else {
            parentFile.mkdirs()
        }
    }
}