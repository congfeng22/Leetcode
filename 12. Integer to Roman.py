class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        num = str(num).zfill(4)
        roman = ""
        ones = int(num[3])
        if ones < 4:
            roman += "I"*ones
        elif ones == 4:
            roman += "VI"
        elif ones == 9:
            roman += "XI"
        else:
            roman += "I"*(ones-5)
            roman += "V"
        tens = int(num[2])
        if tens < 4:
            roman += "X"*tens
        elif tens == 4:
            roman += "LX"
        elif tens == 9:
            roman += "CX"
        else:
            roman += "X"*(tens-5)
            roman += "L"
        hund = int(num[1])
        if hund < 4:
            roman += "C"*hund
        elif hund == 4:
            roman += "DC"
        elif hund == 9:
            roman += "MC"
        else:
            roman += "C"*(hund-5)
            roman += "D"
        thou = int(num[0])
        roman += "M"*thou
        return roman[::-1]
test = Solution()
print(test.intToRoman(1994))