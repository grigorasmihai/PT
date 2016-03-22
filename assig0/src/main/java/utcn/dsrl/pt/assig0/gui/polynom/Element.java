package utcn.dsrl.pt.assig0.gui.polynom;

/**
 * Created by Zuklar on 06-Mar-16.
 */
public class Element implements Comparable<Element>{
    private float coeficent;
    private int exponent = 0;



    public Element(float coeficent, int exponent) {
        this.coeficent = coeficent;
        this.exponent = exponent;

    }

    public float getCoeficent() {
        return coeficent;
    }

    public int getExponent() {
        return exponent;
    }


    public int compareTo(Element exponent1) {
        if (exponent1.exponent < this.exponent)
            return -1;
        else if (exponent1.exponent > this.exponent)
            return 1;
        return 0;
    }

}
