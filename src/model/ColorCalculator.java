package model;

public class ColorCalculator {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

    public ColorCalculator(ModularCounter red, ModularCounter green, ModularCounter blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value)
    {

    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value)
    {

    }

    public void changeColorViaRelativeValue(ColorCode cc, String value)
    {

    }

    public void changeColorViaRelativeValue(ColorCode cc, int value)
    {

    }

    public ModularCounter getRed() {
        return red;
    }

    public ModularCounter getGreen() {
        return green;
    }

    public ModularCounter getBlue() {
        return blue;
    }

    public String getHex()
    {

    }

    @Override
    public String toString() {
        return "ColorCalculator{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    public static void main(String[] args)
    {

    }
}
