package com.zaze.kotlin.example.test

import com.google.gson.JsonObject
import com.zaze.kotlin.example.FileUtils
import com.zaze.kotlin.example.SevenZipUtils
import java.io.*
import java.util.*
import kotlin.collections.ArrayList


fun main() {
//    System.getProperties().forEach {
//        println("${it.key}=${it.value}")
//    }
//    println("${File("").absolutePath}/res")

    val list = listOf(File("testRes/src/split1.txt"), File("testRes/src/split2.txt"))
    list.forEach {
        TestFile.createData(it)
    }
    //
    val mergedFile = File("testRes/splitFile/merged.txt")
    FileUtils.reCreateFile(mergedFile)
    TestFile.mergeFile(list, mergedFile)
//    list.forEach {
//        FileUtils.deleteFile(it)
//    }
    //
    TestFile.splitFile(mergedFile, 1L shl 20)
//    FileUtils.deleteFile(mergedFile)

    SevenZipUtils.compress(File("testRes/splitFile"), File("testRes/zip/zip.7z"))
    SevenZipUtils.unCompress(File("testRes/zip/zip.7z"), "testRes/unzip")


}

object TestFile {

    fun createData(file: File) {
        log("createData start: ${file.absolutePath} ..")
        FileUtils.deleteFile(file)
        repeat(20000) {
            val dataJson = JsonObject()
            dataJson.addProperty("position", it)
            val jsonObject = JsonObject()
            jsonObject.addProperty("fileName", file.name)
            jsonObject.addProperty("time", System.currentTimeMillis())
            jsonObject.add("data", dataJson)
            FileUtils.writeToFile("${jsonObject}\n", file, true)
        }
        log("createData end: ${file.absolutePath}")
    }

    fun splitFile(sourceFile: File, limitSize: Long): List<File> {
        if (sourceFile.isDirectory) {
            log("文件夹不处理")
            return emptyList()
        }
        if (sourceFile.length() < limitSize) {
            log("文件 < limitSize($limitSize), 不必分割")
            return listOf(sourceFile)
        }
        log("file split start.... ")
        log("sourceFile: ${sourceFile.absolutePath}(${sourceFile.length()}/$limitSize)")
        val fileList = ArrayList<File>()
//        var page = 0
        val destFilePath = "${sourceFile.parent}/${sourceFile.nameWithoutExtension}.patch"
        var destFile = File("$destFilePath${fileList.size}")
        FileUtils.reCreateFile(destFile)
//        log("firstPage: ${destFile.absolutePath}")
        var reader: BufferedReader? = null
        val stacks = Stack<String>()
        var currentSize = 0
        try {
            reader = BufferedReader(FileReader(sourceFile))
            var line = reader.readLine()
            while (line != null) {
                // 超出一份的限制大小
                line = "${line}\n"
                if ((currentSize + line.length >= limitSize)) {
                    // 写入当前一份
                    writeLines(stacks, destFile)
                    fileList.add(destFile)
                    // 切换到下一份
                    stacks.push(line)
                    currentSize = line.length
                    destFile = File("$destFilePath${fileList.size}")
                    FileUtils.reCreateFile(destFile)
//                    log("nextPage: ${destFile.absolutePath}")
                } else {
                    stacks.push(line)
                    currentSize += line.length
                }
                line = reader.readLine()
            }
            writeLines(stacks, destFile)
            fileList.add(destFile)
        } catch (e: Exception) {
            // ignore
        } finally {
            try {
                reader?.close()
            } catch (e: Exception) {
                // ignore
            }
        }
        val outFiles = ArrayList<File>()
        fileList.forEach {
            val renameFile = File("${it.parent}/${it.nameWithoutExtension}_${it.extension}.${sourceFile.extension}")
            it.renameTo(renameFile)
            outFiles.add(renameFile)
            log("${renameFile.absolutePath}>> ${renameFile.length()}")
        }
        log("file split end.")
        return outFiles
    }

    private fun writeLines(lines: Stack<String>, destFile: File) {
        var writer: FileWriter? = null
        try {
            writer = FileWriter(destFile)
            while (lines.isNotEmpty()) {
                writer.write(lines.pop())
            }
            writer.flush()
        } catch (e: Exception) {
            // ignore
        } finally {
            try {
                writer?.close()
            } catch (e: Exception) {
                // ignore
            }
        }
    }

    /**
     * 合并文件
     */
    fun mergeFile(fileList: List<File>, outFile: File) {
        FileUtils.createFileNotExists(outFile)
        fileList.forEach {
            FileUtils.writeToFile(it.inputStream(), outFile, true)
        }
    }

    private fun log(msg: String) {
        println(msg)
    }

}
