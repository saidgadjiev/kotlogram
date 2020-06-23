package com.github.badoualy.telegram.mtproto.transport;

import com.github.badoualy.telegram.mtproto.model.DataCenter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.proxy.Socks5ProxyHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class JMTProtoTcpClient implements MTProtoConnection {

    private static final int CONNECTION_TIMEOUT = 30000;

    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);

    private AtomicReference<Channel> channelReference = new AtomicReference<>();

    private AtomicBoolean disconnected = new AtomicBoolean(false);

    public JMTProtoTcpClient(String ip, final int port) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) {
                        ChannelPipeline channelPipeline = channel.pipeline();
                        Socks5ProxyHandler proxyHandler = new Socks5ProxyHandler(new InetSocketAddress("ss5.id-mt.ru", 1080), "GadzhievSA", "MFmkf3^h");
                        proxyHandler.setConnectTimeoutMillis(CONNECTION_TIMEOUT);
                        channelPipeline.addFirst(proxyHandler);
                        channelPipeline.addLast(new ByteArrayDecoder());
                        channelPipeline.addLast(new SimpleChannelInboundHandler<byte[]>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, byte[] bytes) throws Exception {
                            }

                            @Override
                            public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                                super.channelRegistered(ctx);
                                channelReference.set(ctx.channel());
                            }

                            @Override
                            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                super.channelInactive(ctx);
                                disconnected.set(true);
                            }

                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
                                disconnected.set(false);
                            }

                            @Override
                            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                super.exceptionCaught(ctx, cause);
                            }
                        });
                        channelPipeline.addLast(new ByteArrayEncoder());
                    }
                });
        try {
            bootstrap.connect(new InetSocketAddress(ip, port)).sync().addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("Successfully connected to " + ip + ":" + port);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public byte[] readMessage() throws IOException {
        return new byte[0];
    }

    @Override
    public void writeMessage(@NotNull byte[] request) throws IOException {

    }

    @NotNull
    @Override
    public byte[] executeMethod(@NotNull byte[] request) throws IOException {
        return new byte[0];
    }

    @NotNull
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public void setTag(@NotNull String tag) {

    }

    @NotNull
    @Override
    public Marker getMarker() {
        return null;
    }

    @NotNull
    @Override
    public String getIp() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @NotNull
    @Override
    public SelectionKey register(@NotNull Selector selector) {
        return null;
    }

    @Nullable
    @Override
    public SelectionKey unregister() {
        return null;
    }

    @Nullable
    @Override
    public SelectableChannel setBlocking(boolean blocking) {
        return null;
    }

    @NotNull
    @Override
    public DataCenter getDataCenter() {
        return null;
    }

    @Override
    public void close() {
        try {
            channelReference.get().close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
