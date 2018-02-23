package com.csx.springtest.example12.executor;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class ExecutorExample {
    private TaskExecutor executor;
    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }
    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i));
        }
    }
    public static void main(String[] args) {
        ExecutorExample ee = new ExecutorExample();
        ee.setExecutor(new SimpleAsyncTaskExecutor());
        ee.executeTasks();
    }
}
class SimpleTask implements Runnable {
    private String taskName;
    public SimpleTask(String taskName) {
        this.taskName = taskName;
    }
    public void run() {
        System.out.println("do " + taskName + "... in Thread:"
                + Thread.currentThread().getId());
    }
}
