package com.heitian.ssm.TestPackage;

/**
 * Created by Administrator on 2017/11/6.
 */
public class DutyChain {
}

class Request {
    private int day;
    private String reason;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

abstract class Boss {
    String name;

    public Boss(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getSuccessor() {
        return successor;
    }

    public void setSuccessor(Boss successor) {
        this.successor = successor;
    }

    public Boss Successor;

    private Boss successor;//Boss成员变量

    public abstract boolean PassRequest(Request request);
}

class PM extends Boss {
    public PM(String name) {
        super(name);
    }

    public boolean PassRequest(Request request) {
        int day = request.getDay();
        String reason = request.getReason();
        if (day <= 0.5) {
            return true;
        }
        return Successor.PassRequest(request);
    }
}
class HR extends Boss{
    public HR(String name) {
        super(name);
    }

    public boolean PassRequest(Request request) {
        int day = request.getDay();
        String reason = request.getReason();
        if (day > 0.5&&day<=2)
        {
            return true;
        }
        return Successor.PassRequest(request);
    }
}