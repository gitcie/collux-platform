/******************************************************************************
 * Copyright (C) 2017 ShenZhen Powerdata Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳博安达开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.collux.platform.util

import java.io.*

/**
 * IO处理工具类
 * @author Siyi Lu
 * @since 2019/12/20
 */
class IOUtil {

    companion object {

        /**
         * 将流存储为文件
         * @param inputStream 输入流
         * @param target 输入流存入的目标文件路径
         */
        @JvmStatic
        fun storeStreamToFile(inputStream: InputStream, target: String) {
            storeStreamToFile(inputStream, File(target))
        }

        /**
         * 将流存储为文件
         * @param inputStream 输入流
         * @param target 输入流存入的目标文件
         */
        @JvmStatic
        fun storeStreamToFile(inputStream: InputStream, target: File) {
            if (!target.exists()) {
                if (target.mkdirs()) {
                    val bufferedInputStream: BufferedInputStream?
                    var bufferedOutputStream: BufferedOutputStream? = null
                    try {
                        bufferedInputStream = BufferedInputStream(inputStream)
                        bufferedOutputStream = BufferedOutputStream(FileOutputStream(target))
                        val buffer = ByteArray(4096)
                        var readCount = bufferedInputStream.read(buffer)
                        while (readCount > 0) {
                            bufferedOutputStream.write(buffer, 0, readCount)
                            readCount = bufferedInputStream.read(buffer)
                        }
                        bufferedOutputStream.flush()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        bufferedOutputStream?.close()
                    }
                } else {
                    throw Exception("保存文件[${target.path}]出错，创建文件失败")
                }
            }

        }
    }
}