package io.cherrytechnologies.photoappapiusers.utils

import java.util.logging.Logger

fun <T> T.logInfo(log: Logger,msg: String = this.toString()): T {
    log.info(msg)
    return this
}

fun <T> T.logWarn(log:Logger,msg: String):T {
    log.warning(msg)
    return this
}

fun <T> T.globalLogInfo(msg: String):T {
    Logger.getGlobal().info(msg)
    return this
}