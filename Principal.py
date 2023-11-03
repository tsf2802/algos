"""
Five passengers are being seated on a plane with five open seats. There are four columns of seats and five rows.
The columns are labelled 'a' through 'd' left to right and the rows are labelled 1-5 front to back.
The following seats are open (represented as green in visualExample.svg)
- (c, 2)
- (a, 3)
- (c, 4)
- (d, 4)
- (d, 5)
The five passengers have the following preferences
- Greg prefers to be seated in the front, next to a window.
- Madison prefers to be seated in the back, and in an aisle seat.
- Nathan prefers to be seated in the back, next to a window.
- Natalie prefers to be seated in the back, away from a window.
- Rebecca prefers to be in an aisle seat.

Please write the necessary data structures to describe the passengers and the open seats. Next, write a program to assign each person to a seat based on their preferences.
"""
def main():
    dictt = {"a": 0, "b": 1, "c": 2, "d": 3}
    arr = [("c",2), ("a",3), ("c",4), ("d",4), ("d,5")]
    prefdictt = []
    #Name, Preferance (back(0),1(front),  None (2)), window (T/F)
    prefdictt.append(["Greg",1,True])
    prefdictt.append(["Madison",0,False])
    prefdictt.append(["Nathan",0,False])
    prefdictt.append(["Natalie",0,False])
    prefdictt.append(["Rebecca",2,True])
    sorted_prefdictt = sorted(prefdictt, key=lambda x: x[1]) # sorted now from back to front to no pref
    for name, 


if __name__ == "__main__":
    main()