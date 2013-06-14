import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 * 
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 * 
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {

	private enum Status {
		started, stopped, init;
	}

	private Status st;
	private BlockingQueue taskQueue;
	private List<PoolThread> threadPool = new ArrayList<PoolThread>();

	/**
	 * Constructs ThreadPool.
	 * 
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 * 
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize > 0 && numberOfThreads > 0) {
			taskQueue = new BlockingQueue(queueSize);
			for (int i = 0; i < numberOfThreads; i++)
				this.threadPool.add(new PoolThread(taskQueue));
			this.st = Status.init;
		} else
			throw new IllegalArgumentException();
	}

	/**
	 * Starts threads.
	 * 
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public synchronized void start() {
		if (st != Status.init)
			throw new IllegalStateException();
		for (PoolThread th : threadPool) {
			th.start();
		}
		st = Status.started;
	}

	/**
	 * Stop all threads and wait for their terminations.
	 * 
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public synchronized void stop() {
		if (st != Status.started)
			throw new IllegalStateException();
		for (PoolThread th : threadPool) {
			while (th.getState() != Thread.State.WAITING) {
			}
			th.stopThread();
			while (th.getState() != Thread.State.TERMINATED) {
			}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 * @throws InterruptedException
	 * 
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (runnable == null)
			throw new NullPointerException();
		if (st != Status.started)
			throw new IllegalStateException();
		taskQueue.enqueue(runnable);
	}

	public synchronized void display() {
		for (PoolThread th : threadPool)
			System.out.println(th.getState());
	}

	private class PoolThread extends Thread {
		private BlockingQueue taskQueue = null;
		private boolean isStopped = false;
		private Runnable task;

		public PoolThread(BlockingQueue queue) {
			taskQueue = queue;
		}

		public void run() {
			while (!isStopped()) {
				try {
					task = (Runnable) taskQueue.dequeue();
					task.run();
				} catch (Exception e) {

				}
			}
		}

		public synchronized void stopThread() {
			isStopped = true;
			this.interrupt();
		}

		public synchronized boolean isStopped() {
			return isStopped;
		}
	}

	private class BlockingQueue {
		private List<Object> queue = new LinkedList<Object>();
		private int limit;

		public BlockingQueue(int limit) {
			this.limit = limit;
		}

		public synchronized void enqueue(Runnable item) {
			while (this.queue.size() == this.limit) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			if (this.queue.size() == 0) {
				notifyAll();
			}
			this.queue.add(item);
		}

		public synchronized Object dequeue() {
			while (this.queue.size() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					return null;
				}
			}
			if (this.queue.size() == this.limit) {
				notifyAll();
			}
			return this.queue.remove(0);
		}
	}
}
