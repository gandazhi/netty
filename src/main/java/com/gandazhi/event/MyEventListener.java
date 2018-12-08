package com.gandazhi.event;

import java.util.EventListener;

/**
 * @Auther: gandazhi
 * @Date: 2018-11-23 16:12
 */
public interface MyEventListener extends EventListener {

    public void handleEvent(MyEventObject event);
}
