package com.gandazhi.event;

import java.util.EventObject;

/**
 * @Auther: gandazhi
 * @Date: 2018-11-23 16:13
 */
public class MyEventObject extends EventObject {

    public MyEventObject(Object source) {
        super(source);
    }

    public void doEvent() {
        System.out.println("通知一个事件源 source:" + this.getSource());
    }
}
