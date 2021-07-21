package com.zaze.kotlin.example

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry
import org.apache.commons.compress.archivers.sevenz.SevenZFile
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile
import java.io.*

object SevenZipUtils {

    fun compress(input: File, out: File) {
        try {
            FileUtils.deleteFile(out)
            FileUtils.createParentDir(out)
            val sevenZOutputFile = SevenZOutputFile(out)
            //
            if (input.isDirectory) {
                input.listFiles()?.forEach {
                    compress(it, sevenZOutputFile)
                }
            } else {
                compress(input, sevenZOutputFile)
            }
            sevenZOutputFile.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun compress(input: File, out: SevenZOutputFile, name: String = input.name) {
        if (input.isDirectory) {
            val flist = input.listFiles()
            if (flist.isNullOrEmpty()) {
                val entry = out.createArchiveEntry(input, "$name/")
                out.putArchiveEntry(entry)
                out.closeArchiveEntry()
                return
            }
            flist.forEach {
                compress(it, out, "$name/${it.name}")
            }
            return
        }
        // file
        val bis = BufferedInputStream(FileInputStream(input))
        val entry = out.createArchiveEntry(input, name)
        out.putArchiveEntry(entry)
        //
        val buf = ByteArray(1024)
        var len = bis.read(buf)
        while (len != -1) {
            out.write(buf, 0, len)
            len = bis.read(buf)
        }
        out.closeArchiveEntry()
        bis.close()
    }

    fun unCompress(sevenZFile: File, destDirPath: String) {
        val zIn = SevenZFile(sevenZFile)
        var entry: SevenZArchiveEntry?
        var file: File?
        entry = zIn.nextEntry
        while (entry != null) {
            if (!entry.isDirectory) {
                file = File(destDirPath, entry.name)
                FileUtils.createParentDir(file)
                val out = FileOutputStream(file)
                val bos = BufferedOutputStream(out)
                val buf = ByteArray(1024)
                var len = zIn.read(buf)
                while (len != -1) {
                    bos.write(buf, 0, len)
                    len = zIn.read(buf)
                }
                bos.close()
                out.close()
            }
            entry = zIn.nextEntry
        }
    }
}