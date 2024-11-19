package logic;

public class Timer {
    private int minute;
    private int seconds;
    private int ms;

    private boolean isStop;

    public Timer(int m, int s, int ms) {
        minute = m;
        seconds = s;
        this.ms = ms;

        this.isStop = true;
    }

    public void decrementTimer(int amount) { //Decrease the timer by specified amount (milliseconds)

        if(isTimerEmpty()) {return;}

        ms -= amount;

        while(ms < 0) {
            if(isTimerEmpty()) {ms = 0; return;}
            ms+=100;
            seconds -= 1;
            while(seconds < 0) {
                seconds+=60;
                minute -=1;
            }
        }

    }

    public boolean isTimerEmpty() {
        return minute<=0 && seconds<=0 && ms<=0;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d",minute, seconds, ms);
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean isStop) {
        this.isStop = isStop;
    }
}
