package com.gandazhi.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: gandazhi
 * @Date: 2018/11/12 21:02
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "：" + msg);
        ctx.channel().writeAndFlush("来自服务端" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush("客户端连接到服务端了" + LocalDate.now());
        System.out.println(LocalDate.now() + "客户端连接到服务端");
    }
}
