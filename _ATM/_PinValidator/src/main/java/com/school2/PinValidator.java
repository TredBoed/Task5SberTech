package com.school2;

import com.school3.Controller;
import com.school4.TerminalServer;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class AccountIsLockedException extends Exception {
    public AccountIsLockedException() {

    }

    public AccountIsLockedException(String message) {
        super(message);
    }

    public AccountIsLockedException(Throwable cause) {
        super(cause);
    }

    public AccountIsLockedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIsLockedException(String message, long startTime, ExecutorService executor, Controller controller) {
        super(message);
        try {
            executor.awaitTermination(0, TimeUnit.SECONDS);
            long delta = System.currentTimeMillis() - startTime;
            controller.SendToDisplay("Try again after " + Long.toString(10 - delta / 1000) + " sec");
        } catch (InterruptedException e) {
        }
    }
}


public class PinValidator {
    private Integer numOfTries = 0;
    private Controller controller = new Controller();
    private Boolean flag = false;
    private long startTime = 0;


    public boolean checkPin(TerminalServer server, String userId, String pin) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        if (!flag) {
            if (!server.IsAccessToBill(userId, pin)) {
                this.numOfTries++;
                controller.SendToDisplay("Wrong PIN!");
                if (this.numOfTries >= 3) {
                    controller.SendToDisplay("Too much PIN tries");
                    this.startTime = System.currentTimeMillis();
                    Runnable target;
                    executor.execute(() -> PinLock());
                }
            }
        } else {
            try {
                throw new AccountIsLockedException("PinBlock_10sec", this.startTime, executor, controller);
            } catch (AccountIsLockedException e) {
            }
        }
        return server.IsAccessToBill(userId, pin);
    }

    private void PinLock() {
        try {
            controller.SendToDisplay("---------------------------");
            controller.SendToDisplay("Pin Locked for 10sec...");

            flag = true;
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            controller.SendToDisplay("Pin unlocked!");
            this.numOfTries = 0;
            flag = false;
        }
    }

}


