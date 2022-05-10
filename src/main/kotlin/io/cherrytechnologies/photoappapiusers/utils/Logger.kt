package io.cherrytechnologies.photoappapiusers.utils

import org.slf4j.Logger


fun <T> T.logInfo(log: Logger, msg: String = this.toString()): T {
    log.info(msg)
    return this
}

fun <T> T.logWarn(log:Logger,msg: String):T {
    log.warn(msg)
    return this
}

fun <T> T.logError(log:Logger,msg: String):T {
    log.error(msg)
    return this
}

//fun <T> T.globalLogInfo(msg: String):T {
//    Logger.getGlobal().info(msg)
//    return this
//}