package kr.jclab.netty.pseudochannel

import java.net.SocketAddress
import java.util.*

class DefaultPseudoSocketAddress : SocketAddress() {
    val uniqueId = UUID.randomUUID().toString()
}