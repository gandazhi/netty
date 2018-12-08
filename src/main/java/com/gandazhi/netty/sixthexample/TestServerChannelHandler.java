package com.gandazhi.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-03 20:41
 */
public class TestServerChannelHandler extends SimpleChannelInboundHandler<MyDataInfo.MyPerson> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyPerson msg) throws Exception {
        System.out.println(msg.getAddress());
        System.out.println(msg.getAge());
        System.out.println(msg.getName());
    }
}
