package io.cherrytechnologies.photoappapiusers.utils

import java.util.logging.Logger

fun <T> T.logInfo(log: Logger,msg: String): T {
    log.info(msg)
    return this
}

fun <T> T.logWarn(log:Logger,msg: String):T {
    log.warning(msg)
    return this
}