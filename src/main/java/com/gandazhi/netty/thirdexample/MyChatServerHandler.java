package com.gandazhi.netty.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Auther: gandazhi
 * @Date: 2018/11/19 21:57
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE); //用于保存所有与服务端建立好连接的channel

    //服务端收到任意客户端发送的消息后会调用该方法
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (ch == channel){
                ch.writeAndFlush("自己发送的消息" + msg + "\n");
            }else {
                ch.writeAndFlush(channel.remoteAddress() + "发送的消息" + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().closeFuture();
    }

    //服务器端与客户端建立好连接,会回调该方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("【服务端】- " + channel.remoteAddress() + "加入\n"); //向所有与服务端建立好连接的客户端发送消息

        channelGroup.add(channel); //将channel保存到channelGroup中
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线");
    }

    //客户端与服务器端断开连接的时候，会回调该方法  会自动将断开的channel从channelGroup中移除 channelGroup.remove(channel)
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务端】- " + channel.remoteAddress() + "离开\n");
    }


}
