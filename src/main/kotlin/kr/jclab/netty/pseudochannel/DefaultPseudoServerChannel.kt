package kr.jclab.netty.pseudochannel

import io.netty.channel.ChannelConfig
import io.netty.channel.ChannelFuture
import io.netty.channel.DefaultChannelConfig
import java.net.SocketAddress

open class DefaultPseudoServerChannel : AbstractPseudoServerChannel() {
    private val config = DefaultChannelConfig(this)
    private val localAddress = DefaultPseudoSocketAddress()

    override fun config(): ChannelConfig = config

    override fun localAddress0(): SocketAddress = localAddress

    fun registerChildChannel(child: AbstractPseudoChannel): ChannelFuture =
        this.eventLoop().register(child)
}