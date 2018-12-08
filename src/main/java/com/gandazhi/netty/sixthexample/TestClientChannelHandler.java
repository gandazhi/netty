package com.gandazhi.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-03 20:52
 */
public class TestClientChannelHandler extends SimpleChannelInboundHandler<MyDataInfo.MyPerson> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyPerson msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyPerson myPerson = MyDataInfo.MyPerson.newBuilder().setName("gandazhi").setAge(20).setAddress("chengdu").build();

        ctx.channel().writeAndFlush(myPerson);
    }
}
