package com.gluonapplication;

import java.util.Stack;
import java.util.StringTokenizer;
 
public class stack
{ 
    public double solvePostfix(String postfix)
    {
        Stack<Double> stack = new Stack<Double>();
        StringTokenizer scan = new StringTokenizer(postfix);
        while (scan.hasMoreTokens())
        { 
                    String element = scan.nextToken();
  
            if (element.equals("+"))
            {  
                double firstN = stack.pop();
                double secondN = stack.pop();
                stack.push(secondN+firstN);
  
            }
            else if (element.equals("-"))
            {
                       	double firstN = stack.pop();
            	double secondN = stack.pop();
                stack.push(secondN-firstN);
              }
            else if (element.equals("*"))
            {
            	double firstN = stack.pop();
            	double secondN = stack.pop();
                stack.push(secondN*firstN);
              }
            else if (element.equals("/"))
            {
  
            	double firstN = stack.pop();
            	double secondN = stack.pop();
                stack.push(secondN/firstN);
  
            }
            else if (element.equals("%"))
            {
  
            	double firstN = stack.pop();
            	double secondN = stack.pop();
                stack.push(secondN%firstN);
  
            }
            else
            {
            	try {
                stack.push(Double.parseDouble(element));}
            	catch(Exception e)
            	{
            		GluonApplication calc = new GluonApplication();
            		calc.l.setText("enter a valid character");
            	}
            }
        }
        try {
            
        return stack.pop();}
        catch(Exception e)
    	{
        	GluonApplication calc = new GluonApplication();
    		calc.l.setText("enter a valid character");
    		return 0;
    	}
    }
 
     
    public String convertToPostfix4(String infix) 
    {
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";
        for (int i = 0; i < infix.length(); i++)
        {
            char character = infix.charAt(i);
            //check if the character is an operation
            if (character=='+' || character=='-' || character=='*' || character=='/'||character=='%')
            {
                postfix += " ";
                if(stack.isEmpty())
                    stack.push(character);
                else
                {
                    char top = stack.peek();
                    if(topIsLess(top,character))
                    {
                        stack.push(character);
                    }
                    else
                    {
                        while(!topIsLess(top,character))
                        {
                             
                            postfix += " "+ stack.pop()+ " ";
                            if(stack.isEmpty())
                                break;
                            top = stack.peek();
                        }
                        stack.push(character);
                    }
                }
            }
            //start of inner equation
            else if(character=='(')
            {
                int end = getInnerEquationEnd(i,infix); // find end of inner equation
                postfix+=convertToPostfix4(infix.substring(i+1,end));
                i=end;
            }
            else // character is a number
            {
                postfix += character;
            }
 
        }   
        while (!stack.isEmpty())
            postfix += " "+stack.pop() + " ";
        return postfix;
     
    }
 
    private int getInnerEquationEnd(int start, String infix)
    {
        int count=1;
        for(int i =start+1;i<infix.length();i++)
        {
            if(infix.charAt(i)=='(')
                count++;
            if(infix.charAt(i)==')')
            {
                count--;
                if(count==0)
                {
                    return i;
                }
            }
        }
        return 0;
    }
private boolean topIsLess(char top, char character)
{
     
    if(top=='-' || top =='+')
    {
        if (character == '*' || character == '/'||character=='%')
            return true;
    }
    else if(top=='%' )
    {
    	if (character == '*' || character == '/')
            return true;
    }
    return false;
}
     
}