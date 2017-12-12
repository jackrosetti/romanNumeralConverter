

import java.util.*;
 
public class RomanNumerals
{
    //used to look for individual characters and store their values
    int value(char r)
    {
        if (r == 'I')
        {
            return 1;
        }
        if (r == 'V')
        {
            return 5;
        }
        if (r == 'X')
        {
            return 10;
        }
        if (r == 'L')
        {
            return 50;
        }
        if (r == 'C')
        {
            return 100;
        }
        if (r == 'D')
        {
            return 500;
        }
        if (r == 'M')
        {
            return 1000;
        }
        return -1;
    }
 
    // Finds decimal value of a given romal numeral
    int romanToDecimal(String roman)
    {
        // Initialize result
        int converted = 0;
        for (int i = 0; i < roman.length(); i++)
        {
            // Getting value of symbol s[i]
            int s1 = value(roman.charAt(i));
 
            // Getting value of symbol s[i+1]
            if (i + 1 < roman.length())
            {
                int s2 = value(roman.charAt(i+1));
 
                // Comparing both values
                if (s1 >= s2)
                {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    converted += s1;
                }
                else
                {
                    converted = converted + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            }
            else
            {
                converted += s1;
                i++;
            }
        }
 
        return converted;
    }
 
    public static void main(String args[])
    {
        RomanNumerals rn = new RomanNumerals();
        Scanner sc = new Scanner(System.in);
        String roman = "";
        System.out.println("Give me a Roman Numeral less than 5000");
        roman = sc.next();
        int converted = 0;
        System.out.println(roman + " to decimal is " + rn.romanToDecimal(roman));
 
    }
}
