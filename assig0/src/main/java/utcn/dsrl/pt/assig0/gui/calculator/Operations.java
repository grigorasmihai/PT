package utcn.dsrl.pt.assig0.gui.calculator;

import utcn.dsrl.pt.assig0.gui.polynom.Element;
import utcn.dsrl.pt.assig0.gui.polynom.Polynom;

import java.util.ArrayList;

/**
 * Created by Zuklar on 06-Mar-16.
 */
public class Operations {

    public Polynom sum(Polynom p1, Polynom p2){
        Polynom result = new Polynom();
        ArrayList<Element> new_p2 = (ArrayList<Element>) p2.elements.clone();
        for (Element e1: p1.elements) {
            for (Element e2: new_p2){
                if (e1.getExponent() == e2.getExponent())
                {
                    result.elements.add(new Element(e1.getCoeficent() + e2.getCoeficent(), e2.getExponent()));
                    p2.elements.remove(e2);
                    break;
                }
                else if (e1.getExponent() > e2.getExponent()) {
                    result.elements.add(new Element(e1.getCoeficent(), e1.getExponent()));
                    break;
                }

            }
            new_p2 = (ArrayList<Element>) p2.elements.clone();

        }


        for (Element e: p2.elements)
        {
            result.elements.add(new Element(e.getCoeficent(), e.getExponent()));
        }
        result.sort();

        return result;
    }

    public Polynom dif(Polynom p1, Polynom p2){
        Polynom result = new Polynom();
        ArrayList<Element> new_p2 = (ArrayList<Element>) p2.elements.clone();
        for (Element e1: p1.elements) {
            for (Element e2: new_p2){
                if (e1.getExponent() == e2.getExponent())
                {
                    result.elements.add(new Element(e1.getCoeficent() - e2.getCoeficent(), e1.getExponent()));
                    p2.elements.remove(e2);
                    break;
                }
                else if (e1.getExponent() > e2.getExponent()) {
                    result.elements.add(new Element(e1.getCoeficent(), e1.getExponent()));
                    break;
                }

            }
            new_p2 = (ArrayList<Element>) p2.elements.clone();

        }


        for (Element e: p2.elements)
        {
            result.elements.add(new Element(-(e.getCoeficent()), e.getExponent()));
        }
        result.sort();

        return result;
    }

    public Polynom mul1(Polynom p1, Polynom p2) {
        Polynom p3 = new Polynom();
        Element e;
        for (Element e1: p1.elements) {
            for (Element e2: p2.elements) {
                e = new Element(e1.getCoeficent() * e2.getCoeficent(), e1.getExponent() + e2.getExponent());
                for (Element res: p3.elements)
                {
                    if (res.getExponent() == e.getExponent())
                    {
                        e = new Element(e.getCoeficent() + res.getCoeficent(), e.getExponent());
                        p3.elements.remove(res);
                        break;
                    }
                }

                p3.elements.add(e);
            }
        }
        p3.sort();
        return p3;
    }


    public Polynom integrate(Polynom p){
        Polynom p3 = new Polynom();

        for (Element e: p.elements)
        {
            p3.elements.add(new Element(e.getCoeficent() / (e.getExponent() + 1), e.getExponent() + 1));
        }

        return p3;
    }

    public Polynom diferenciate(Polynom p){
        Polynom p3 = new Polynom();

        for (Element e: p.elements)
        {
            p3.elements.add(new Element(e.getCoeficent() * e.getExponent(),e.getExponent() - 1 ));
        }
        return p3;
    }

}
