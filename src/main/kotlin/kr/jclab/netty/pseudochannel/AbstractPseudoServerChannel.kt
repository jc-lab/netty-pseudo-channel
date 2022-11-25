package kr.jclab.netty.pseudochannel

import io.netty.channel.*
import java.net.SocketAddress

abstract class AbstractPseudoServerChannel : AbstractServerChannel() {
    protected var closed: Boolean = false

    override fun isCompatible(loop: EventLoop): Boolean = true
    override fun doBind(localAddress: SocketAddress) {}
    override fun doBeginRead() {}

    override fun isOpen(): Boolean {
        return !closed
    }

    override fun isActive(): Boolean {
        return this.isOpen
    }

    override fun doClose() {
        closed = true
    }
}