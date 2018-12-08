package com.gandazhi.event;

/**
 * @Auther: gandazhi
 * @Date: 2018-11-23 16:26
 */
public class EventTest {

    public static void main(String[] args) {
//        EventSource eventSource = new EventSource();
//
//        eventSource.addListener(new MyEventListener() {
//            @Override
//            public void handleEvent(MyEventObject event) {
//                event.doEvent();
//                if (event.getSource().equals("closeWindow")){
//                    System.out.println("doClose");
//                }
//            }
//        });
//
//        eventSource.notifyListenerEvents(new MyEventObject("closeWindow"));

        EventSource windowEventSource = new EventSource();
        windowEventSource.onCloseWindow(new MyEventListener() {
            @Override
            public void handleEvent(MyEventObject event) {
                event.doEvent();
                if (event.getSource().equals("window")){
                    System.out.println("window事件");
                }
            }
        });

        windowEventSource.doOnCloseWindow();
    }
}
