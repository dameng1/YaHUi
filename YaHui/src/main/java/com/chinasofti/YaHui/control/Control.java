package com.chinasofti.YaHui.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Control {
	private ServerSocket server;
	public static final int PORT=8520;
	//创建线程池变量
	private ExecutorService es;
	private YaHuiService ys;
	public Control() {
		try {
			System.out.println("服务器正在开启...");
			this.server=new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已经开启...");
			//创建线程池
			es=Executors.newCachedThreadPool();
			ys=new YaHuiServiceImpl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void start() {
		while(true) {
			try {
				Socket client=this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"以连接");
				//创建线程对象
				ControlThread ct=new ControlThread(client,ys);
				//需要将线程对象交给线程池管理
				es.submit(ct);
				int active=((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线活跃用户："+active);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	

}
