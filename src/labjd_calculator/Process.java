
package labjd_calculator;

import java.text.DecimalFormat;

public class Process {
    private Cal cal;
    private double First;
    private double Second;
    private int operator;
    private String text;
    private double M;

    public Process() {}

    public Process(Cal cal) {
        this.cal = cal;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public double getFirst() {
        return First;
    }

    public void setFirst(double First) {
        this.First = First;
    }

    public double getSecond() {
        return Second;
    }

    public void setSecond(double Second) {
        this.Second = Second;
    }

    public double getM() {
        return M;
    }

    public void setM(double M) {
        this.M = M;
    }
    
    public void ClearAll(){
        M=0;
        First=0;
        text="";
        operator=1;
        cal.setTxt("");
    }
    
    //add text of number
    public void addNumText(String num){
        text=text+num;
        cal.setTxt(text);
    }
    //add dot
    public void addDotText(){
        //if text is - or empty then add 0.
        if(text.equals("-") | text.equals("")){
            text+="0.";
            cal.setTxt(text);
            return;
        }
        //if text have no dot then add dot
        if(!text.contains("."))
            text=text+".";
        cal.setTxt(text);
    }
    //add negative
    public void addNegativeText(){
        //if text is empty
        if(text.equals("")){
            text="-"+text;
            cal.setTxt(text);
            return;
        }
        //if text already have negative then remove it
        if(text.charAt(0)=='-')
            text=text.substring(1, text.length());
        else//else add negative to text
            text="-"+text;
        cal.setTxt(text);
    }
    
    public void addM(){
        M+=NumOfText();
    }
    
    public void subM(){
        M-=NumOfText();
    }
    
    public void calculate(){
        switch(operator){
            case 0: break;
            case 1: 
                First=First + NumOfText();
                break;
            case 2:
                First=First - NumOfText();
                break;
            case 3:
                First=First * NumOfText();
                break;
            case 4:
                if(NumOfText()==0)
                    break;
                else
                    First=First / NumOfText();
                break;
        }
        cal.setTxt(formatNum(First));
        operator=0;
        text="";
    }
    
    public void Sqrt(){
        if(text.equals("")){
            if(First>0){
                First=Math.sqrt(First);
                text=formatNum(First);
                cal.setTxt(text);
            }else
                cal.setTxt("Error");
        }else{
            double x=NumOfText();
            //if x>0 then square it
            if(x>0){
                x=Math.sqrt(x);
                text=formatNum(x);
                cal.setTxt(text);
            }else
                cal.setTxt("Error");
        }
    }
    
    public void Sqrt2(){
        if(text.equals("")){
            if(First>0){
                First=Math.sqrt(First);
                text=formatNum(First);
                cal.setTxt(text);
            }else
                cal.setTxt("Error");
        }else{
            double x=NumOfText();
            //if x>0 then square it
            if(x>0){
                x=Math.sqrt(x);
                text=formatNum(x);
                cal.setTxt(text);
            }else
                cal.setTxt("Error");
        }
    }
    
    public void Percent(){
        double x=NumOfText();
        x=x/100;
        text=formatNum(x);
        cal.setTxt(text);
    }
    
    public void OneDiv(){
        double x=NumOfText();
        //if x>0 then 1 div it
        if(x!=0){
            x=1/x;
            text=Double.toString(x);
            cal.setTxt(formatNum(x));
        }else
            cal.setTxt("Error");
    }
    
    double NumOfText(){
        try {
            double x=Double.parseDouble(text);
            return x;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    String formatNum(double x){
        DecimalFormat df = new DecimalFormat("#.####################");
        return df.format(x);
    }
}//Process
