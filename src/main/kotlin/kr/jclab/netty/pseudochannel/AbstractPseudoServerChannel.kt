package kr.jclab.netty.pseudochannel

import io.netty.channel.*
import java.net.SocketAddress

abstract class AbstractPseudoServerChannel : AbstractServerChannel() {
    protected var closed: Boolean = false
    protected var localAddress: SocketAddress? = null

    override fun isCompatible(loop: EventLoop): Boolean = true

    override fun isOpen(): Boolean {
        return !closed
    }

    override fun isActive(): Boolean {
        return this.isOpen
    }

    override fun localAddress0(): SocketAddress? {
        return localAddress
    }

    override fun doBind(localAddress: SocketAddress) {
        this.localAddress = localAddress
    }

    override fun doBeginRead() {}

    override fun doClose() {
        closed = true
    }
}