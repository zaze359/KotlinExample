package com.zaze.kotlin.example.test

class BlackDesert {
}

//
fun main() {
    createPazUrl(2079, 1100, 8419)
//    createPazUrl(2079, 1100, 8419)
}

private fun createPazUrl(version: Int, from: Int, to: Int) {
    for (i in from..to) {
        println(String.format("http://dn.blackdesert.com.tw/UploadData/client/$version/Paz/PAD%05d.PAZ", i))
    }
}

private fun createPatchUrl( from: Int, to: Int) {
    for (i in from..to) {
        println("https://dn.blackdesert.com.tw/UploadData/patch//$i.PAP")
    }
}
