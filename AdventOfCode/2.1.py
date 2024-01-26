import re

input ="Game 1: 3 blue, 17 red; 1 red, 2 green, 6 blue; 2 green"
array = input.split('\n')



total = 0
for i in range(len(array)):
    checker = True

    red_allowed = 12
    green_allowed = 13
    blue_allowed = 14

    blue_pattern = re.compile(r"(\d+)\s+blue")
    red_pattern = re.compile(r"(\d+)\s+red")
    green_pattern = re.compile(r"(\d+)\s+green")

    red_matcher = red_pattern.match(array[i])
    green_matcher = green_pattern.match(array[i])
    blue_matcher = blue_pattern.match(array[i])

    if red_matcher:
        red_value = int(red_matcher.group(1))
        print(red_value)
        if red_value > red_allowed:
            checker = False

    if green_matcher:
        green_value = int(green_matcher.group(1))
        if green_value > green_allowed:
            checker = False

    if blue_matcher:
        blue_value = int(blue_matcher.group(1))
        if blue_value > blue_allowed:
            checker = False
    if(checker):
        iD = array[i][array[i].index('e') + 2 : array[i].index(':')]
        total += int(iD)



print(total)





