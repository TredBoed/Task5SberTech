package com.school1;

import com.school2.PinValidator;
import com.school3.Controller;
import com.school4.TerminalServer;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private Controller controller = new Controller();
    private Integer userId;
    private Boolean isConnected;

    public TerminalImpl(Integer userId) {
        this.userId = userId;
        this.isConnected = false;
        //Bill creating
        //this is example without database
        this.server = new TerminalServer(45678, 2345);
        this.pinValidator = new PinValidator();
    }

    public void Start() {
        controller.SendToDisplay("Enter pin");
        Integer pin = controller.InputPin();
        if (pinValidator.checkPin(pin) && this.server.IsAccessToBill(userId, pin)) {
            this.isConnected = true;
            controller.SendToDisplay("Connected");
        }
    }

    public void WithDraw() {
        if (this.isConnected) {
            controller.SendToDisplay("Enter amount:");
            server.WithdrawCurrency(new BigDecimal(controller.InputData()));
            controller.SendToDisplay("Success");
        } else {
            controller.SendToDisplay("Invalid operation");
            System.exit(0);
        }
    }

    public void Deposit() {
        if (this.isConnected) {
            controller.SendToDisplay("Enter amount:");
            server.DepositCurrency(new BigDecimal(controller.InputData()));
            controller.SendToDisplay("Success");
        } else {
            controller.SendToDisplay("Invalid operation");
            System.exit(0);
        }
    }

    public void CheckBalance() {
        if (this.isConnected) {
            controller.SendToDisplay("Your balance: " + BigDecimalToString(server.CheckBalance()));
        } else {
            controller.SendToDisplay("Invalid operation");
            System.exit(0);
        }
    }

    public void Exit() {
        if (this.isConnected) {
            System.exit(0);
        } else {
            controller.SendToDisplay("Invalid operation");
            System.exit(0);
        }
    }

    private String BigDecimalToString(BigDecimal curr) {
        BigDecimal bd = curr.setScale(2, BigDecimal.ROUND_DOWN);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        String result = df.format(bd);
        return result;
    }
}
