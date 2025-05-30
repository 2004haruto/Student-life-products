public class OldAircon {
    protected final int OFF = 0;
    protected final int COOL = 1;
    protected final int HEAT = 2;
    protected final int BLOW = 3;
    private final String[] strKnob = {"切","冷房", "暖房", "送風"};
    private int knob;                   // つまみ（切、冷房、暖房、送風）
    public OldAircon() { knob = OFF;}
    public int getKnob() { return knob; }

    public void showData() {
        System.out.println("ただいま[" + strKnob[knob] + "]です。");
    }
    public void turnRight() {
        if (knob == strKnob.length - 1) {
            System.out.println("これ以上つまみを回すことはできません！");
        } else {
            knob++;
            System.out.println("つまみを右に回した！");
        }
    }
    public void turnLeft() {
        if (knob == 0) {
            System.out.println("これ以上つまみを回すことはできません！");
        } else {
            knob--;
            System.out.println("つまみを左に回した！");
        }
    }
}
