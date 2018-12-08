package com.gandazhi.event;

import java.util.Vector;

/**
 * @Auther: gandazhi
 * @Date: 2018-11-23 16:19
 */
public class EventSource {

    private Vector<MyEventListener> listerVector = new Vector<MyEventListener>();

    //注册事件
    public void addListener(MyEventListener myEventListener){
        listerVector.add(myEventListener);
    }

    //撤销事件
    public void removeListener(MyEventListener myEventListener){
        listerVector.remove(myEventListener);
    }

    //接受外部事件
    public void notifyListenerEvents(MyEventObject eventObject){
        listerVector.forEach(myEventListener -> {
            myEventListener.handleEvent(eventObject);
        });
    }

    public void onCloseWindow(MyEventListener myEventListener){
        System.out.println("关注关闭窗口事件");
        listerVector.add(myEventListener);
    }

    public void doOnCloseWindow(){
        this.notifyListenerEvents(new MyEventObject("window"));
    }
}
