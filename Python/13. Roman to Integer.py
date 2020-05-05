class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        convdict = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        number = 0
        if "IV" in s:
            number += 4
            s=s.replace("IV","")
        if "IX" in s:
            number += 9
            s=s.replace("IX","")
        if "XL" in s:
            number += 40
            s=s.replace("XL","")
        if "XC" in s:
            number += 90
            s=s.replace("XC","")
        if "CD" in s:
            number += 400
            s=s.replace("CD","")
        if "CM" in s:
            number += 900
            s=s.replace("CM","")
        for rest in s:
            number+= convdict[rest]
        return number