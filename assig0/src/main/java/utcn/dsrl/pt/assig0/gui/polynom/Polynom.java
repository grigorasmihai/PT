package utcn.dsrl.pt.assig0.gui.polynom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Zuklar on 06-Mar-16.
 */
public class Polynom {
    public ArrayList<Element> elements = new ArrayList<Element>();
    private Integer polynom_grade = 0;

    public Polynom(String polynom_string){
        String[] arr;
        polynom_string = edit_string(polynom_string);
        arr = polynom_string.split("[+]");
        for (String part : arr) {
            if (part.equals(""))
            {
                continue;
            }
            elements.add(setElements(part));

        }


    }

    public Polynom(){}

    public Element setElements(String element_string) {
        float coeficent = 0;
        int exponent = 0;
        String[] arr = element_string.split("[x^|X^]");
        int i = 0;
        for (String part: arr) {
            if (part.equals("")) {
                continue;
            } else if (i == 0) {
                coeficent = Float.parseFloat(part);
                i++;
            } else {
                exponent = Integer.parseInt(part);
            }

        }
        return new Element(coeficent, exponent);
    }

    private String edit_string(String s)
    {
        String[] arr = s.split("-");
        String a = new String();
        int i = 0;
        for (String part : arr) {
            if (i == 0)
            {
                i++;
                a += "+" + part;
                continue;
            }
            a += "+-" + part;

        }
        return a;
    }


    public String toString()
    {
        String result = "";
        for (Element element: elements) {
            if (element.getCoeficent() == 0)
            {
                continue;
            }
            if (element.getCoeficent() < 0)
            {
                result += "";
            }
            else {
                result += "+";
            }
            if (element.getExponent() == 0) {
                result += Float.toString(element.getCoeficent());
            }
            else
            {
                result += Float.toString(element.getCoeficent()) + "X^" + Integer.toString(element.getExponent());

            }
        }
        if (result.equals(""))
            return "0";
        return result;
    }


    public void sort() {
        Collections.sort(elements);

    }



    public Integer getPolynom_grade() {
        return polynom_grade;
    }
}
