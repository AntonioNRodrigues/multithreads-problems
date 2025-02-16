# Multithreading in Java

### 1. What is multithreading in Java?

Multithreading in Java is a process of executing multiple threads simultaneously. A thread is a lightweight sub-process,
the smallest unit of processing. Multithreading is used to perform multiple tasks concurrently, which helps to maximize
CPU utilization.

### 2. What is the difference between a process and a thread?

- **Process**: A process is a self-contained execution environment with its own memory space. Processes are independent
  and do not share data with other processes.
- **Thread**: A thread is a smaller unit of a process that shares the same memory space and resources. Threads within a
  process can communicate with each other more easily than processes can.

### 3. How do you create a thread in Java?

There are two main ways to create a thread in Java:

1. By extending the `Thread` class.
2. By implementing the `Runnable` interface.

#### Example 1: Extending the `Thread` class

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running.");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
```

### 4. What is the synchronized keyword in Java?

The synchronized keyword is used to ensure that only one thread can access a block of code or an object at a time. It is
used to prevent thread interference and memory consistency errors.

### 5. What is a deadlock in multithreading?

A deadlock is a situation where two or more threads are blocked forever, waiting for each other to release a resource.
This happens when two threads hold locks on different resources and try to acquire each other's lock.

### 6. What is the volatile keyword in Java?

The volatile keyword is used to mark a variable as "modified" so that changes to that variable are always visible to
other threads. It ensures that the value of the variable is read from the main memory and not from the thread's local
cache.

### 7. What is the difference between wait() and sleep() methods in Java?

wait(): This method is used to make the current thread release the lock and go to the waiting state until another thread
invokes the notify() or notifyAll() method on the same object.

sleep(): This method is used to pause the execution of the current thread for a specified period without releasing the
lock.

### 8. What is a thread pool in Java?

A thread pool is a collection of pre-instantiated reusable threads that can be used to execute tasks. Thread pools help
manage a pool of worker threads, reducing the overhead of creating new threads and improving performance.

### 9. What is a Callable interface in Java?

The Callable interface is similar to the Runnable interface, but it can return a result and throw a checked exception.
The call() method of a Callable returns a result.

### 10. LiveLock !

A livelock situation occurs when two or more threads keep changing their state in response to each other without making
any progress
Thread t1 and Thread t2 attempt to acquire two resources.
When one thread realizes that the resource it needs is locked by the other thread,
it releases its own lock to help the other thread proceed.
However, this results in both threads continuously releasing and acquiring locks without
making any real progress, thus causing a livelock.

### 11. Starvation !

Thread starvation occurs when a thread is perpetually denied access to resources, usually due to other higher-priority
threads taking precedence.
we have a high-priority thread and a low-priority thread that both require access to the same lock object.
The high-priority thread is continuously running in an infinite loop, which means it consistently holds the lock.
As a result, the low-priority thread is starved and never gets a chance to acquire the lock and run.
Starvation can be a tricky problem to solve, especially in complex systems, so it's essential to design your
synchronization mechanisms carefully to avoid it.

### 12. What is the Future interface in Java?

The Future interface represents the result of an asynchronous computation. It provides methods to check if the
computation is complete, to wait for its completion, and to retrieve the result.

### 13. What is the CountDownLatch class in Java?

The CountDownLatch class is used to synchronize one or more threads, forcing them to wait until a set of operations
being performed by other threads completes.****

### 14. What is the CyclicBarrier class in Java?

The CyclicBarrier class is used to synchronize threads by allowing them to wait for each other to reach a common barrier
point. The barrier can be reused after the waiting threads are released.

### 15. What is the Semaphore class in Java?

The Semaphore class is used to control the number of threads that can access a resource simultaneously. It maintains a
set of permits, and threads can acquire or release permits.

### 16. What is the ExecutorService framework in Java?

The ExecutorService framework is part of the java.util.concurrent package and provides a higher-level replacement for
working with threads directly. It allows you to manage a pool of threads and execute tasks asynchronously.

