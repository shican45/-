package xiernaichalei;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
class HelloWorld {
    private int n;
    public HelloWorld( int n){
    	this.n = n;
    }
    int t=2;
    public static final Object lock=new Object();
    public synchronized void hello() throws InterruptedException{
	    for (int i = 0; i < n; i++) {
    		while(t%2!=0)
    		{
    			this.wait();
    		}
		    System.out.print("Hello");
		    t++;
		    this.notifyAll();
		}
    }
    public synchronized void world() throws InterruptedException{
    	for (int i = 0; i < n; i++) {
	    		while(t%2!=1)
	    		{
	    			this.wait();
	    		}
	    		System.out.println("World!");
			    t++;
			    this.notifyAll();
	    }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}
