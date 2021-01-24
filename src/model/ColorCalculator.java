package model;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class ColorCalculator {

    private  static ModularCounter red = new ModularCounter(0,256);
    private  static ModularCounter green = new ModularCounter(0,256);
    private  static ModularCounter blue = new ModularCounter(0,256);

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        String operator;
        String color;
        int value;
        boolean run = true;

        while (run)
        {
        menu();
        option = sc.nextInt();
        switch (option) {
            case 0:
                option = sc.nextInt();
                break;

            case 1:
                System.out.println("Geben Sie eine Farbe ein (red,green,blue):");
                color = sc.next();
                System.out.println("Geben Sie den Wert für " + color + " ein:");
                value = sc.nextInt();
                changeColorViaAbsoluteValue(color, value);
                break;

            case 2:
                System.out.println("Geben Sie eine Farbe ein (red,green,blue):");
                color = sc.next();
                System.out.println("Wollen Sie addieren oder subtrahieren (+/-):");
                operator = sc.next();
                System.out.println("Geben Sie den Wert um den Sie " + color + " ändern wollen:");
                value = sc.nextInt();
                changeColorViaRelativeValue(color, value,operator);
                break;

            case 3:
                System.out.println(print());
                break;

            default:
                run = false;
            }
        }
    }

    public static void menu()
    {
        System.out.println("Menu");
        System.out.println("1 - Neuen Farbwert setzen");
        System.out.println("2 - Farbwert ändern");
        System.out.println("3 - Aktuelle Farbwerte betrachten");
        System.out.println("4 - Beenden");
    }

    public ColorCalculator(ModularCounter red, ModularCounter green, ModularCounter blue) {
        ColorCalculator.red = red;
        ColorCalculator.green = green;
        ColorCalculator.blue = blue;
    }

    public void changeColorViaAbsoluteValue(String color, String value)
    {
        if(color.equals("red"))
        {
            if(Integer.parseInt(value) <= red.getModulus())
            {
                red.reset();
                red.inc(Integer.parseInt(value));
            }
        }
        else if(color.equals("green"))
        {
            if(Integer.parseInt(value) <= green.getModulus())
            {
                green.reset();
                green.inc(Integer.parseInt(value));
            }
        }
        else if(color.equals("blue"))
        {
            if(Integer.parseInt(value) <= blue.getModulus())
            {
                blue.reset();
                blue.inc(Integer.parseInt(value));
            }
        }
    }

    public static void changeColorViaAbsoluteValue(String color, int value)
    {
        if(color.equals("red"))
        {
            if(value <= red.getModulus())
            {
                red.reset();
                red.inc(value);
            }
        }
        else if(color.equals("green"))
        {
            if(value <= green.getModulus())
            {
                green.reset();
                green.inc(value);
            }
        }
        else if(color.equals("blue"))
        {
            if(value <= blue.getModulus())
            {
                blue.reset();
                blue.inc(value);
            }
        }
    }


    public void changeColorViaRelativeValue(String color, String value,String op)
    {
        if(color.equals("red"))
        {
            if(Integer.parseInt(value) <= red.getModulus())
            {
                if(op.equals("+"))
                red.inc(Integer.parseInt(value));
                else if (op.equals("-"))
                red.dec(Integer.parseInt(value));
            }
        }
        else if(color.equals("green"))
        {
            if(Integer.parseInt(value) <= green.getModulus())
            {
                if(op.equals("+"))
                    green.inc(Integer.parseInt(value));
                else if (op.equals("-"))
                    green.dec(Integer.parseInt(value));
            }
        }
        else if(color.equals("blue"))
        {
            if(Integer.parseInt(value) <= blue.getModulus())
            {
                if(op.equals("+"))
                    blue.inc(Integer.parseInt(value));
                else if (op.equals("-"))
                    blue.dec(Integer.parseInt(value));
            }
        }
    }


    public static void changeColorViaRelativeValue(String color, int value, String op)
    {
        if(color.equals("red"))
        {
            if(value <= red.getModulus())
            {
                if(op.equals("+"))
                    red.inc(value);
                else if (op.equals("-"))
                    red.dec(value);
            }
        }
        else if(color.equals("green"))
        {
            if(value <= green.getModulus())
            {
                if(op.equals("+"))
                    green.inc(value);
                else if (op.equals("-"))
                    green.dec(value);
            }
        }
        else if(color.equals("blue"))
        {
            if(value <= blue.getModulus())
            {
                if(op.equals("+"))
                    blue.inc(value);
                else if (op.equals("-"))
                    blue.dec(value);
            }
        }
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

    public static String getHex()
    {
        String hex = "#";

        String redValue = Integer.toHexString(red.getValue());
        String greenValue = Integer.toHexString(green.getValue());
        String blueValue = Integer.toHexString(blue.getValue());

        if (redValue.length() == 1)
            redValue = "0" + redValue;
        if (greenValue.length() == 1)
            greenValue = "0" + greenValue;
        if (blueValue.length() == 1)
            blueValue="0" + blueValue;
        hex += redValue;
        hex += greenValue;
        hex += blueValue;

        return hex;
    }

    public String getHex1()
    {
        String hex = "#";

        String redValue = Integer.toHexString(red.getValue());
        String greenValue = Integer.toHexString(green.getValue());
        String blueValue = Integer.toHexString(blue.getValue());

        if (redValue.length() == 1)
            redValue = "0" + redValue;
        if (greenValue.length() == 1)
            greenValue = "0" + greenValue;
        if (blueValue.length() == 1)
            blueValue="0" + blueValue;
        hex += redValue;
        hex += greenValue;
        hex += blueValue;

        return hex;
    }

    @Override
    public String toString() {
        return "Red = " + red.getValue() + "\n" +
                "Green = " + green.getValue() + "\n" +
                "Blue = " + blue.getValue() + "\n" +
                "Hex = " + getHex();
    }

    public static String print() {
        return "Red = " + red.getValue() + "\n" +
                "Green = " + green.getValue() + "\n" +
                "Blue = " + blue.getValue() + "\n" +
                "Hex = " + getHex();
    }
}
