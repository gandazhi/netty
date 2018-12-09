package com.gandazhi.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-03 20:41
 */
public class TestServerChannelHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        switch (msg.getDataType()) {
            case PersonType:
                System.out.println(msg.getPerson().getName());
                System.out.println(msg.getPerson().getAge());
                System.out.println(msg.getPerson().getAddress());
                break;
            case CatType:
                System.out.println(msg.getCat().getName());
                System.out.println(msg.getCat().getCity());
                break;
            case DogType:
                System.out.println(msg.getDog().getName());
                System.out.println(msg.getDog().getAge());
                break;
            default:
                System.out.println("传输dataType错误");
                break;
        }
    }
}
