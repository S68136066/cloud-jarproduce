package com.cloud.common.ThreadFactory;

/**
 * @author：xing1
 * @Date：2021/3/3
 * @Time：17:29
 * @Desc：
 **/
public class TestThread  {

     public static void main(String[] args){
         /**
          * 采用匿名内部类启动一个线程
          */
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i<100;i++){
                        System.out.println("线程---->"+i);
                    }
                }
            });
            t.start();

     }

}
